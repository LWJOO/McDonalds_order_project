package kr.ac.kopo.UI.ManagerUI;

import kr.ac.kopo.UI.BaseUI;
import kr.ac.kopo.UI.IUI;
import kr.ac.kopo.exception.ChoiceOutOfBoundException;

public class MasterMenuUI extends BaseUI {
	
	private String menu() {
		System.out.println("\t<< 관리자 페이지 >>");
		System.out.println("-----------------------------------");
		System.out.println("\t1. 일별 매출 조회");
		System.out.println("\t2. 월별 매출 조회");
		System.out.println("\t3. 일간 판매량 조회");
		System.out.println("\t4. 월간 판매량 조회");
		System.out.println("\t5. 회원 조회");
		System.out.println("\t6. 메뉴 추가");
		System.out.println("\t7. 메뉴 삭제");
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
					ui = new SalesDayUI();
					break;
				case "2":
					ui = new SalesMonthUI();
					break;
				case "3":
					ui = new SalesDayVolumeUI();
					break;
				case "4":
					ui = new SalesMonthVolumeUI();
					break;
				case "5":
					ui = new MemberCheckUI();
					break;
				case "6":
					ui = new MenuInsertUI();
					break;
				case "7":
					ui = new MenuDeleteUI();
					break;
				case "0":
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
