package kr.ac.kopo.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;

public class MRogDAO {
	
	public int selectMRog(String id, String pw){

		int master_no = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			
			// 쿼리 작성
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT MASTER_NO     ");
			sql.append("  FROM MASTER_MEMBER ");
			sql.append(" WHERE MASTER_ID = ? ");
			sql.append("   AND MASTER_PW = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				master_no  = rs.getInt("MASTER_NO");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		
		return master_no;
	}

}
