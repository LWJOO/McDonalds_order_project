package kr.ac.kopo.UI.UserUI;

import kr.ac.kopo.UI.BaseUI;
import kr.ac.kopo.UI.IUI;
import kr.ac.kopo.exception.ChoiceOutOfBoundException;

public class UserUI extends BaseUI {
	
	private String menu() {
		System.out.println("\t<< 유저 페이지 >>");
		System.out.println("-----------------------------------");
		System.out.println("\t1. 메뉴 보기");
		System.out.println("\t2. 메뉴 주문");
		System.out.println("\t3. 마이페이지");
		System.out.println("\t0. 로그아웃");
		System.out.println("-----------------------------------");
		String type = scanStr("\t항목을 선택하세요 : ");

		return type;
	}

	@Override
	public void execute() throws Exception {

		stop : while (true) {
			try {
				String choice = menu();
				IUI ui = null;
				switch (choice) {
				case "1":
					ui = new ViewMenuUI();
					break;
				case "2":
					ui = new MenuOrderUI();
					break;
				case "3":
					ui = new MyPageUI();
					break;
				case "0":
					BaseUI.member_no = 0;
					break stop;
				}
				if (ui != null)
					ui.execute();
				else {
					System.out.println("\n\t메뉴번호를 잘못 선택하셨습니다.");
					}
			} catch (ChoiceOutOfBoundException e) {
				System.out.println(e.getMessage());
			}

		}
	}

}
