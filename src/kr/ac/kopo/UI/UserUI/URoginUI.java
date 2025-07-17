package kr.ac.kopo.UI.UserUI;

import kr.ac.kopo.UI.BaseUI;
import kr.ac.kopo.dao.URogDAO;

public class URoginUI extends BaseUI {
	
	public static int member_no = 0;
	
	private String[] user_rogin() {
		System.out.println("-------------------------------");
		System.out.println("\t<<유저 로그인>>");
		System.out.println("-------------------------------");
		String ID = scanStr("ID : ");
		String PW = scanStr("PW : ");
		String[] idpw = { ID, PW };
		;
		return idpw;
	}

	@Override
	public void execute() throws Exception {
		
		while (true) {
			for (int i = 0; i < 50; i++) System.out.println();
			String[] member = user_rogin();
			member_no = new URogDAO().RoginMac(member[0], member[1]);

			if (member_no == 0) {
				System.out.println("로그인 실패");
				
			} else {
				for (int i = 0; i < 50; i++) System.out.println();
				String member_name = new URogDAO().RoginMac(member_no);
				BaseUI.member_no = member_no;
				System.out.println("-----------------------------------");
				System.out.println("\t"+ member_name +"님 환영합니다.");
				System.out.println("-----------------------------------\n");
				
				new UserUI().execute();
				break;

			}
		}
		
	}

	

}
