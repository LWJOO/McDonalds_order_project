package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;
import kr.ac.kopo.vo.MenuVO;

public class MenuDAO {

	public List<MenuVO> selectMenu(int num) {

		List<MenuVO> menuList = new ArrayList<MenuVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();

			// 쿼리 작성
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT MENU_NAME, MENU_PRICE                    ");
			sql.append("  FROM M_MENU                                   ");
			sql.append(" WHERE MENU_TYPE = CASE ? WHEN 1 THEN 'BURGER'  ");
			sql.append("                          WHEN 2 THEN 'SIDE'    ");
			sql.append("                          WHEN 3 THEN 'DRINK'   ");
			sql.append("                          WHEN 4 THEN 'DESSERT' ");
			sql.append("                   END                          ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString("menu_name");
				int price = rs.getInt("menu_price");

				MenuVO menus = new MenuVO();
				menus.setMenu_name(name);
				menus.setMenu_price(price);

				menuList.add(menus);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}

		return menuList;
	}
	
	public List<MenuVO> selectMenutype(int num) {

		List<MenuVO> menuList = new ArrayList<MenuVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();

			// 쿼리 작성
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT MENU_NO, MENU_NAME, MENU_PRICE           ");
			sql.append("  FROM M_MENU                                   ");
			sql.append(" WHERE MENU_TYPE = CASE ? WHEN 1 THEN 'BURGER'  ");
			sql.append("                          WHEN 2 THEN 'SIDE'    ");
			sql.append("                          WHEN 3 THEN 'DRINK'   ");
			sql.append("                          WHEN 4 THEN 'DESSERT' ");
			sql.append("                   END                          ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt("menu_no");
				String name = rs.getString("menu_name");
				int price = rs.getInt("menu_price");

				MenuVO menus = new MenuVO();
				menus.setMenu_no(no);
				menus.setMenu_name(name);
				menus.setMenu_price(price);

				menuList.add(menus);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}

		return menuList;
	}
	
	
	public List<MenuVO> selectAll() {

		List<MenuVO> menuList = new ArrayList<MenuVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();

			// 쿼리 작성
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT MENU_NO, MENU_NAME, MENU_PRICE ");
			sql.append("  FROM M_MENU ");
			sql.append(" ORDER BY MENU_TYPE, MENU_NO ");
			
			pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int menu_no = rs.getInt("menu_no");
				String name = rs.getString("menu_name");
				int price = rs.getInt("menu_price");

				MenuVO menus = new MenuVO();
				menus.setMenu_no(menu_no);
				menus.setMenu_name(name);
				menus.setMenu_price(price);

				menuList.add(menus);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}

		return menuList;
	}
	
	public List<MenuVO> checkMenu(String num) {

		List<MenuVO> menuList = new ArrayList<MenuVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();

			// 쿼리 작성
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT MENU_NO, MENU_NAME ");
			sql.append("  FROM M_MENU ");
			sql.append(" WHERE MENU_TYPE = CASE TO_NUMBER(?) WHEN 1 THEN 'BURGER'  ");
			sql.append("                                     WHEN 2 THEN 'SIDE'    ");
			sql.append("                                     WHEN 3 THEN 'DRINK'   ");
			sql.append("                                     WHEN 4 THEN 'DESSERT' ");
			sql.append("                   END ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, num + "");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt("menu_no");
				String name = rs.getString("menu_name");

				MenuVO menus = new MenuVO();
				menus.setMenu_no(no);	
				menus.setMenu_name(name);

				menuList.add(menus);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}

		return menuList;
	}

	public void InsertMenu(String menu_name, String menu_type, int menu_price) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();

			// 쿼리 작성
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO M_MENU(MENU_NO, MENU_NAME, MENU_TYPE, MENU_PRICE) ");
			sql.append("            VALUES(MEM_MENU_NO.NEXTVAL, ?, ?, ?)              ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, menu_name);
			pstmt.setString(2, menu_type);
			pstmt.setInt(3, menu_price);
			pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}

	}

	public void DeleteMenu(int menu_no) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();

			// 쿼리 작성
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM M_MENU   ");
			sql.append(" WHERE MENU_NO = ? ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, menu_no);
			pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}

	}
	
	public List<MenuVO> InMenu(int menu_no) {
		
		List<MenuVO> menuList = new ArrayList<MenuVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();

			// 쿼리 작성
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM M_MENU ");
			sql.append(" WHERE MENU_NO = TO_NUMBER(?) ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, menu_no);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int no = rs.getInt("menu_no");
				String name = rs.getString("menu_name");

				MenuVO menus = new MenuVO();
				menus.setMenu_no(no);	
				menus.setMenu_name(name);

				menuList.add(menus);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return menuList;

	}
	
	public String MenuName(int menu_no) {
		
		String name = null;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {		
			conn = new ConnectionFactory().getConnection();

			// 쿼리 작성
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT MENU_NAME FROM M_MENU  ");
			sql.append(" WHERE MENU_NO = TO_NUMBER(?) ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, menu_no);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				name = rs.getString("MENU_NAME");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return name;

	}
	
	public String MenuType(int menu_no) {
		
		String type = null;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {		
			conn = new ConnectionFactory().getConnection();

			// 쿼리 작성
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT MENU_TYPE FROM M_MENU ");
			sql.append(" WHERE MENU_NO = TO_NUMBER(?) ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, menu_no);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				type = rs.getString("MENU_TYPE");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return type;

	}
	
	

}
