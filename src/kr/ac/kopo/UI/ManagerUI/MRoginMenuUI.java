package kr.ac.kopo.UI.ManagerUI;

import kr.ac.kopo.UI.BaseUI;
import kr.ac.kopo.UI.IUI;
import kr.ac.kopo.UI.UserUI.UserMenuUI;
import kr.ac.kopo.UI.UserUI.ViewMenuUI;
import kr.ac.kopo.exception.ChoiceOutOfBoundException;

public class MRoginMenuUI extends BaseUI{
	
	private String menu() {
		for (int i = 0; i < 50; i++) System.out.println();
		System.out.println("\t<< 맥도날드 프로그램 시작 >>");
		System.out.println("-----------------------------------");
		System.out.println("\t1. 관리자 로그인");
		System.out.println("\t2. 회원 메인페이지");
		System.out.println("\t0. 시스템 종료");
		System.out.println("-----------------------------------");
		String type = scanStr("\t항목을 선택하세요 : ");
		
		return type;
		
	}

	@Override
	public void execute() throws Exception {
		
		while(true) {
			try {
				String choice = menu();
				IUI ui = null;
				
				switch (choice) {
				case "1":
					ui = new ViewMenuUI();
					break;
				case "2":
					ui = new UserMenuUI();
					break;
				case "0":
					ui = new MRoginMenuUI();
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
