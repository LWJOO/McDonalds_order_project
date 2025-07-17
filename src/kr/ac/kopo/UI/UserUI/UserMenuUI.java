package kr.ac.kopo.UI.UserUI;

import kr.ac.kopo.UI.BaseUI;
import kr.ac.kopo.UI.ExitUI;
import kr.ac.kopo.UI.IUI;
import kr.ac.kopo.exception.ChoiceOutOfBoundException;

public class UserMenuUI extends BaseUI{
	
	private String menu() {
		System.out.println("\t<< 맥도날드 >>");
		System.out.println("-----------------------------------");
		System.out.println("\t<< 비회원 메뉴 >>");
		System.out.println("-----------------------------------");
		System.out.println("\t1. 메뉴 보기\n");
		System.out.println("\t<< 회원 메뉴 >>");
		System.out.println("-----------------------------------");
		System.out.println("\t2. 로그인");
		System.out.println("\t3. 회원가입");
		System.out.println("\t4. 아이디 찾기");
		System.out.println("\t5. 비밀번호 찾기");
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
					ui = new URoginUI();
					break;
				case "3":
					ui = new JoinMacUI();
					break;
				case "4":
					ui = new FindIDUI();
					break;
				case "5":
					ui = new FindPWUI();
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
