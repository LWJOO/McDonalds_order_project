package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.MRogDAO;
import kr.ac.kopo.dao.MemberDAO;
import kr.ac.kopo.dao.MenuDAO;
import kr.ac.kopo.dao.SalesDAO;
import kr.ac.kopo.dao.SalesVolumeDAO;
import kr.ac.kopo.vo.MRogVO;
import kr.ac.kopo.vo.MemberVO;
import kr.ac.kopo.vo.MenuVO;
import kr.ac.kopo.vo.SalesVO;
import kr.ac.kopo.vo.SalesVolumeVO;

public class MenuService {
	
	private MenuDAO MenuDao;
	private MRogDAO MRogDao;
	private SalesDAO SalesDao;
	private SalesVolumeDAO SalesVolumeDao;
	private MemberDAO MemberDao;

	public MenuService() {
		MenuDao        = new MenuDAO();
		MRogDao        = new MRogDAO();
		SalesDao       = new SalesDAO();
		SalesVolumeDao = new SalesVolumeDAO();
		MemberDao      = new MemberDAO();
	}
	
	public List<MenuVO> searchMenuByType(int menu_type) {
		List<MenuVO> menus = MenuDao.selectMenu(menu_type);
		return menus;
	}
	
	public List<MenuVO> orderMenuByType(int menu_type) {
		List<MenuVO> menus = MenuDao.selectMenutype(menu_type);
		return menus;
	}
	
	public List<MenuVO> searchAll() {
		List<MenuVO> menus = MenuDao.selectAll();
		return menus;
	}
	
	public List<MenuVO> searchMenu(String menu_type) {
		List<MenuVO> menus = MenuDao.checkMenu(menu_type);
		return menus;
	}
	
	public List<SalesVO> checkDaySales(String row) {
		List<SalesVO> sales = SalesDao.daySales(row);
		return sales;
	}
	
	public List<SalesVO> checkMonthSales(String row) {
		List<SalesVO> sales = SalesDao.monthSales(row);
		return sales;
	}
	
	public List<SalesVolumeVO> checkDaySalesVolume(String row) {
		List<SalesVolumeVO> salesvo = SalesVolumeDao.daySales(row);
		return salesvo;
	}
	
	public List<SalesVolumeVO> checkMonthSalesVolume(String row) {
		List<SalesVolumeVO> salesvo = SalesVolumeDao.monthSales(row);
		return salesvo;
	}
	
	public List<MemberVO> checkMember(int row) {
		List<MemberVO> member = MemberDao.member(row);
		return member;
	}
	
}