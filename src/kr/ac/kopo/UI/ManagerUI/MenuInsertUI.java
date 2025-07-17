package kr.ac.kopo.UI.ManagerUI;

import kr.ac.kopo.UI.BaseUI;
import kr.ac.kopo.dao.MenuDAO;

public class MenuInsertUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		String menu_type = null;
		String menu_name  = scanStr("메뉴 이름을 입력하세요 : ");
		end : while(true) {
			int type  = scanInt("메뉴 타입을 입력하세요(버거 1, 사이드 2, 디저트 3, 드링크 4) : ");
			switch(type) {
			case 1:
				menu_type = "BURGER";
				break end;
			case 2:
				menu_type = "SIDE";
				break end;
			case 3:
				menu_type = "DESSERT";
				break end;
			case 4:
				menu_type = "DRINK";
				break end;
			default:
				System.out.println("\n\t메뉴번호를 잘못 선택하셨습니다.");
			}
		}
		int    menu_price = scanInt("메뉴 가격을 입력하세요 : ");
		
		new MenuDAO().InsertMenu(menu_name, menu_type, menu_price);
		for (int i = 0; i < 50; i++) System.out.println();
		System.out.println("입력 완료!!");
		
		
		
		
	}

}
