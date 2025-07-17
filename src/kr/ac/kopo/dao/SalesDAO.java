package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;
import kr.ac.kopo.vo.SalesVO;

public class SalesDAO {
	
	public List<SalesVO> daySales(String row){
		
		List<SalesVO> selesList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			
			// 쿼리 작성
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT TO_CHAR(M1.ORDER_TIME, 'YYYY-MM-DD') AS DATES  ");
			sql.append("      ,SUM(C2.MENU_PRICE * C1.ORDER_QTY)    AS SELES  ");
			sql.append("  FROM M_ORDER_M M1                                   ");
			sql.append("       JOIN M_ORDER_D C1 ON C1.ORDER_NO = M1.ORDER_NO ");
			sql.append("       JOIN M_MENU    C2 ON C2.MENU_NO  = C1.MENU_NO  ");
			sql.append(" GROUP BY TO_CHAR(M1.ORDER_TIME, 'YYYY-MM-DD')        ");
			sql.append(" ORDER BY DATES DESC                                  ");
			sql.append(" FETCH FIRST TO_NUMBER(?) ROWS ONLY                   ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, row);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String date  = rs.getString("DATES");
				int    seles = rs.getInt("SELES");
				
				SalesVO sell = new SalesVO();
				sell.setDate(date);
				sell.setSeles(seles);
				
				selesList.add(sell);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		
		return selesList;
	}
	
public List<SalesVO> monthSales(String row){
		
		List<SalesVO> selesList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			
			// 쿼리 작성
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT TO_CHAR(M1.ORDER_TIME, 'YYYY-MM') AS DATES     ");
			sql.append("      ,SUM(C2.MENU_PRICE * C1.ORDER_QTY) AS SELES     ");
			sql.append("  FROM M_ORDER_M M1                                   ");
			sql.append("       JOIN M_ORDER_D C1 ON C1.ORDER_NO = M1.ORDER_NO ");
			sql.append("       JOIN M_MENU    C2 ON C2.MENU_NO  = C1.MENU_NO  ");
			sql.append(" GROUP BY TO_CHAR(M1.ORDER_TIME, 'YYYY-MM')           ");
			sql.append(" ORDER BY DATES DESC                                  ");
			sql.append(" FETCH FIRST TO_NUMBER(?) ROWS ONLY                   ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, row);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String date  = rs.getString("DATES");
				int    seles = rs.getInt("SELES");
				
				SalesVO sell = new SalesVO();
				sell.setDate(date);
				sell.setSeles(seles);
				
				selesList.add(sell);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		
		return selesList;
	}

}
