package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;
import kr.ac.kopo.vo.SalesVolumeVO;

public class SalesVolumeDAO {

	public List<SalesVolumeVO> daySales(String row) {

		List<SalesVolumeVO> selesVolumeList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();

			// 쿼리 작성
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT C2.MENU_NAME, C2.MENU_TYPE, SUM(C1.ORDER_QTY) AS SALES  ");
			sql.append("  FROM M_ORDER_M M1                                            ");
			sql.append("       JOIN M_ORDER_D C1 ON C1.ORDER_NO = M1.ORDER_NO          ");
			sql.append("       JOIN M_MENU    C2 ON C2.MENU_NO  = C1.MENU_NO           ");
			sql.append(" WHERE M1.ORDER_TIME BETWEEN TO_DATE(?, 'YYYY-MM-DD') AND TO_DATE(?, 'YYYY-MM-DD') + 1 ");
			sql.append(" GROUP BY C2.MENU_NAME, C2.MENU_TYPE                                         ");
			sql.append(" ORDER BY C2.MENU_TYPE, SALES DESC, C2.MENU_NAME               ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, row);
			pstmt.setString(2, row);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("MENU_NAME");
				String type = rs.getString("MENU_TYPE");
				int seles = rs.getInt("SALES");

				SalesVolumeVO sell = new SalesVolumeVO();
				sell.setMenu_name(name);
				sell.setMenu_type(type);
				sell.setSum_sales(seles);

				selesVolumeList.add(sell);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}

		return selesVolumeList;
	}

	public List<SalesVolumeVO> monthSales(String row) {

		List<SalesVolumeVO> selesVolumeList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();

			// 쿼리 작성
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT C2.MENU_NAME, C2.MENU_TYPE, SUM(C1.ORDER_QTY) AS SALES ");
			sql.append("  FROM M_ORDER_M M1                                           ");
			sql.append("       JOIN M_ORDER_D C1 ON C1.ORDER_NO = M1.ORDER_NO         ");
			sql.append("       JOIN M_MENU    C2 ON C2.MENU_NO  = C1.MENU_NO          ");
			sql.append(" WHERE M1.ORDER_TIME BETWEEN TO_DATE(?, 'YYYY-MM') AND ADD_MONTHS(TO_DATE(?, 'YYYY-MM'), 1) ");
			sql.append(" GROUP BY C2.MENU_NAME, C2.MENU_TYPE                          ");
			sql.append(" ORDER BY C2.MENU_TYPE, SALES DESC, C2.MENU_NAME              ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, row);
			pstmt.setString(2, row);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("MENU_NAME");
				String type = rs.getString("MENU_TYPE");
				int seles = rs.getInt("SALES");

				SalesVolumeVO sell = new SalesVolumeVO();
				sell.setMenu_name(name);
				sell.setMenu_type(type);
				sell.setSum_sales(seles);

				selesVolumeList.add(sell);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}

		return selesVolumeList;
	}

}
