package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;
import kr.ac.kopo.vo.MemberVO;

public class MemberDAO {

	public List<MemberVO> member(int row) {

		List<MemberVO> selesList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();

			// 쿼리 작성
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT MEMBER_NO, MEMBER_ID, MEMBER_NAME, MEMBER_PHONE ");
			sql.append("  FROM M_MEMBER                                        ");
			sql.append(" ORDER BY MEMBER_NO                                    ");
			sql.append("OFFSET ? * 2 - 2 ROWS                                  ");
			sql.append(" FETCH NEXT 2 ROWS ONLY                                ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, row);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int member_no = rs.getInt("MEMBER_NO");
				String member_id = rs.getString("MEMBER_ID");
				String member_name = rs.getString("MEMBER_NAME");
				String member_phone = rs.getString("MEMBER_PHONE");

				MemberVO sell = new MemberVO();
				sell.setMember_no(member_no);
				sell.setMember_id(member_id);
				sell.setMember_name(member_name);
				sell.setMember_phone(member_phone);

				selesList.add(sell);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}

		return selesList;
	}
	
	public List<MemberVO> myInfo(int member_no) {

		List<MemberVO> selesList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();

			// 쿼리 작성
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT MEMBER_ID, MEMBER_NAME, MEMBER_PHONE ");
			sql.append("  FROM M_MEMBER                                        ");
			sql.append(" WHERE MEMBER_NO = ?                                   ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, member_no);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String member_id = rs.getString("MEMBER_ID");
				String member_name = rs.getString("MEMBER_NAME");
				String member_phone = rs.getString("MEMBER_PHONE");

				MemberVO sell = new MemberVO();
				sell.setMember_no(member_no);
				sell.setMember_id(member_id);
				sell.setMember_name(member_name);
				sell.setMember_phone(member_phone);

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
