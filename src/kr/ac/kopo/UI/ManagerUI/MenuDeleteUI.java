package kr.ac.kopo.UI.ManagerUI;

import java.util.List;

import kr.ac.kopo.UI.BaseUI;
import kr.ac.kopo.dao.MenuDAO;
import kr.ac.kopo.service.MenuService;
import kr.ac.kopo.vo.MenuVO;

public class MenuDeleteUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		while (true) {

			String no = scanStr("1.버거 메뉴  2.사이드  3.드링크  4.디저트 0.조회종료 :");
			if(no.equals("0"))break;
			List<MenuVO> menus = new MenuService().searchMenu(no);

			if (menus == null) {
				System.out.println("입력된 번호가 틀렸습니다.");
				return;
			} else {

				System.out.println("-------------------------------");
				for (MenuVO list : menus) {
					System.out.println(list.getMenu_no() + "\t" + list.getMenu_name());
				}
				System.out.println("-------------------------------");
			}
		}
		int num = scanInt("삭제할 제품넘버를 선택하세요 : ");
		String ans = scanStr("정말 삭제하시겠습니까?(y/n) : ");
		if(ans.equals("y") || ans.equals("Y")) {
			
			for (int i = 0; i < 50; i++) System.out.println();
			if(!new MenuDAO().InMenu(num).isEmpty()) {
				new MenuDAO().DeleteMenu(num);
				System.out.println("삭제 완료");
			} else {
				System.out.println("입력된 제품번호가 없습니다.");
			}
		} else {
			for (int i = 0; i < 50; i++)System.out.println();
			System.out.println("삭제 취소");
		}
		
		

	}

}
