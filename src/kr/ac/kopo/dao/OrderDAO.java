package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;
import kr.ac.kopo.vo.MyPageVO;

public class OrderDAO {

	public int orderMenu(int member_no, List<Integer> menu_no, List<Integer> order_qty) {

		int monny = 0;
		Connection conn = null;
		PreparedStatement pstmtM = null;
		PreparedStatement pstmtD = null;
		PreparedStatement pstmtW = null;
		try {

			conn = new ConnectionFactory().getConnection();

			// 쿼리 작성
			StringBuilder sqlM = new StringBuilder();
			sqlM.append("INSERT INTO M_ORDER_M(ORDER_NO, MEMBER_NO) ");
			sqlM.append("       VALUES(MEM_IN_NO.NEXTVAL, ?)        ");

			pstmtM = conn.prepareStatement(sqlM.toString());
			pstmtM.setInt(1, member_no);
			pstmtM.executeUpdate();

			StringBuilder sqlD = new StringBuilder();
			sqlD.append("INSERT INTO M_ORDER_D(ORDER_NO, MENU_NO, ORDER_QTY) ");
			sqlD.append("            VALUES(MEM_IN_NO.CURRVAL, ?, ?)         ");
			pstmtD = conn.prepareStatement(sqlD.toString());
			for (int i = 0; i < menu_no.size(); i++) {
				pstmtD.setInt(1, menu_no.get(i));
				pstmtD.setInt(2, order_qty.get(i));
				pstmtD.executeUpdate();

			}

			StringBuilder sqlW = new StringBuilder();
			sqlW.append("SELECT MENU_PRICE  ");
			sqlW.append("  FROM M_MENU      ");
			sqlW.append(" WHERE MENU_NO = ? ");
			pstmtW = conn.prepareStatement(sqlW.toString());
			for (int i = 0; i < menu_no.size(); i++) {
				pstmtW.setInt(1, menu_no.get(i));
				ResultSet rs = pstmtW.executeQuery();
				while (rs.next()) {
					monny += rs.getInt("MENU_PRICE") * order_qty.get(i);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmtD);
			JDBCClose.close(conn, pstmtM);
		}
		return monny;

	}
	
	public List<MyPageVO> mylist(int member_no) {

		List<MyPageVO> myList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();

			// 쿼리 작성
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT C2.MENU_NAME, SUM(C1.ORDER_QTY) AS QTY          ");
			sql.append("  FROM M_ORDER_M M1                                    ");
			sql.append("       JOIN M_ORDER_D C1 ON C1.ORDER_NO  = M1.ORDER_NO ");
			sql.append("       JOIN M_MENU    C2 ON C2.MENU_NO   = C1.MENU_NO  ");
			sql.append(" WHERE M1.MEMBER_NO = ?                                ");
			sql.append(" GROUP BY C2.MENU_NAME                                 ");
			sql.append(" ORDER BY QTY DESC                                     ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, member_no);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String menu_name = rs.getString("MENU_NAME");
				int    total_qty = rs.getInt("QTY");

				MyPageVO sell = new MyPageVO();
				sell.setMenu_name(menu_name);
				sell.setTotal_qty(total_qty);

				myList.add(sell);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}

		return myList;
	}
	
	public int total(int member_no) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int total = 0;

		try {
			conn = new ConnectionFactory().getConnection();

			// 쿼리 작성
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT SUM(C1.ORDER_QTY * C2.MENU_PRICE) AS MONEY      ");
			sql.append("  FROM M_ORDER_M M1                                    ");
			sql.append("       JOIN M_ORDER_D C1 ON C1.ORDER_NO  = M1.ORDER_NO ");
			sql.append("       JOIN M_MENU    C2 ON C2.MENU_NO   = C1.MENU_NO  ");
			sql.append(" WHERE M1.MEMBER_NO = ?                                ");
			sql.append(" GROUP BY M1.MEMBER_NO                                 ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, member_no);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				total = rs.getInt("MONEY");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}

		return total;
	}

}
