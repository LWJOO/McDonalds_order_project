package kr.ac.kopo.UI;

import kr.ac.kopo.UI.ManagerUI.MasterRoginUI;
import kr.ac.kopo.UI.UserUI.UserMenuUI;
import kr.ac.kopo.exception.ChoiceOutOfBoundException;

public class StartUI extends BaseUI {

	private String menu() {
		for (int i = 0; i < 50; i++) System.out.println();
		System.out.println("\t<< 맥도날드 주문 시스템 시작 >>");
		System.out.println("-----------------------------------");
		System.out.println("\t1. 유저 페이지 스타트");
		System.out.println("\t2. 관리자 페이지 스타트");
		System.out.println("\t0. 시스템 종료");
		System.out.println("-----------------------------------");
		String type = scanStr("\t항목을 선택하세요 : ");
		for (int i = 0; i < 50; i++)System.out.println();

		return type;
	}

	@Override
	public void execute() throws Exception {

		while (true) {
			try {
				String choice = menu();
				IUI ui = null;
				switch (choice) {
				case "1":
					ui = new UserMenuUI();
					break;
				case "2":
					ui = new MasterRoginUI();
					break;
				case "0":
					ui = new ExitUI();
					break;
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
