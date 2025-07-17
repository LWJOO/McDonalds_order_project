package kr.ac.kopo.UI.ManagerUI;

import kr.ac.kopo.UI.BaseUI;
import kr.ac.kopo.UI.ExitUI;
import kr.ac.kopo.UI.IUI;
import kr.ac.kopo.exception.ChoiceOutOfBoundException;

public class MasterRoginUI extends BaseUI {
	
	private String menu() {
		for (int i = 0; i < 50; i++) System.out.println();
		System.out.println("\t<< 관리자 로그인 페이지 >>");
		System.out.println("-----------------------------------");
		System.out.println("\t1. 로그인");
		System.out.println("\t2. 돌아가기");
		System.out.println("\t0. 시스템 종료");
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
					ui = new MRoginUI();
					break;
				case "2":
					break stop;
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
