package kr.ac.kopo.UI.UserUI;

import java.util.List;

import kr.ac.kopo.UI.BaseUI;
import kr.ac.kopo.service.MenuService;
import kr.ac.kopo.vo.MenuVO;

public class ViewMenuUI extends BaseUI {

	@Override
	public void execute() throws Exception {

		while(true) {

			int no = scanInt("1.버거 메뉴\n2.사이드\n3.드링크\n4.디저트\n0.나가기\n번호 입력 : ");
			for (int i = 0; i < 50; i++)System.out.println();
			if (no == 0)break;
			List<MenuVO> menus = new MenuService().searchMenuByType(no);

			if (menus == null) {
				System.out.println("입력된 번호가 틀렸습니다.");
				return;
			} else {
				
				System.out.println("-----------------------------------");
				System.out.printf("%-10s %-20s\n", "가격", "메뉴명");
				System.out.println("-----------------------------------");
				for (MenuVO list : menus) {
					System.out.printf("%-10d %-20s\n", list.getMenu_price(), list.getMenu_name());
				}
				System.out.println("-----------------------------------");
			}
		}
	}
}
