package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;

public class URogDAO {

	public String checkID(String id) {

		String mid = null;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();

			// 쿼리 작성
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT MEMBER_ID     ");
			sql.append("  FROM M_MEMBER      ");
			sql.append(" WHERE MEMBER_ID = ? ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				mid = rs.getString("MEMBER_ID");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return mid;
	}

	public void JoinMac(String id, String pw, String name, String phone) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();

			// 쿼리 작성
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO M_MEMBER (MEMBER_NO, MEMBER_ID, MEMBER_PW, MEMBER_NAME, MEMBER_PHONE) ");
			sql.append("              VALUES (MEM_ID_NO.NEXTVAL, ?, ?, ?, ?) ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, phone);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
	}

	public int RoginMac(String id, String pw) {
		
		int member_no = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();

			// 쿼리 작성
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT MEMBER_NO     ");
			sql.append("  FROM M_MEMBER      ");
			sql.append(" WHERE MEMBER_ID = ? ");
			sql.append("   AND MEMBER_PW = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				member_no = rs.getInt("member_no");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		
		return member_no;
	}
	
	public String RoginMac(int member_no) {
		
		String member_name = null;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();

			// 쿼리 작성
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT MEMBER_NAME     ");
			sql.append("  FROM M_MEMBER      ");
			sql.append(" WHERE MEMBER_NO = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, member_no);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				member_name = rs.getString("member_name");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		
		return member_name;
	}
	
	public String CheckID(String member_id) {
		
		String this_id = null;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();

			// 쿼리 작성
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT MEMBER_ID     ");
			sql.append("  FROM M_MEMBER      ");
			sql.append(" WHERE MEMBER_ID = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, member_id);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				this_id = rs.getString("MEMBER_ID");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		
		return this_id;
	}
	
	public String CheckPhone(String member_phone) {
		
		String this_phone = null;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();

			// 쿼리 작성
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT MEMBER_PHONE     ");
			sql.append("  FROM M_MEMBER      ");
			sql.append(" WHERE MEMBER_PHONE = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, member_phone);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				this_phone = rs.getString("MEMBER_PHONE");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		
		return this_phone;
	}
	
	public String FindID(String member_name, String member_phone) {
		
		String member_id = null;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();

			// 쿼리 작성
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT MEMBER_ID        ");
			sql.append("  FROM M_MEMBER         ");
			sql.append(" WHERE MEMBER_NAME  = ? ");
			sql.append("   AND MEMBER_PHONE = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, member_name);
			pstmt.setString(2, member_phone);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				member_id = rs.getString("MEMBER_ID");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		
		return member_id;
	}
	
	public int FindPW(String member_id, String member_phone) {
		
		int member_no = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();

			// 쿼리 작성
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT MEMBER_NO        ");
			sql.append("  FROM M_MEMBER         ");
			sql.append(" WHERE MEMBER_ID    = ? ");
			sql.append("   AND MEMBER_PHONE = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, member_id);
			pstmt.setString(2, member_phone);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				member_no = rs.getInt("MEMBER_NO");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		
		return member_no;
	}
	
	public void NewPW(String member_pw, int member_no) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();

			// 쿼리 작성
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE M_MEMBER      ");
			sql.append("   SET MEMBER_PW = ? ");
			sql.append(" WHERE MEMBER_NO = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, member_pw);
			pstmt.setInt(2, member_no);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		
	}
	

}
