package kr.ac.kopo.UI.UserUI;

import kr.ac.kopo.UI.BaseUI;
import kr.ac.kopo.dao.URogDAO;

public class FindPWUI extends BaseUI{

	private String[] checkIP() {
		System.out.println("-------------------------------");
		System.out.println("\t<<비밀번호 찾기>>");
		System.out.println("-------------------------------");
		
		String id = scanStr("가입한 아이디을 입력하세요 : ");
		String phone = scanStr("가입한 전화번호를 입력하세요  : ");
		String[] np = { id, phone };
		return np;
	}
	
	
	
	@Override
	public void execute() throws Exception {
		for (int i = 0; i < 50; i++) System.out.println();
		String[] master = checkIP();
		int no = new URogDAO().FindPW(master[0], master[1]);

		if (no != 0) {
			String pw = scanStr("새로운 비밀번호를 입력하세요 : ");
			new URogDAO().NewPW(pw, no);
			for (int i = 0; i < 50; i++) System.out.println();
			System.out.println("-----------------------------------");
			System.out.println("비밀번호 변경 완료");
			System.out.println("-----------------------------------");
			
		} else {
			for (int i = 0; i < 50; i++) System.out.println();
			System.out.println("-----------------------------------");
			System.out.println("가입된 회원이 아닙니다.");
			System.out.println("-----------------------------------");
			
		}
		
	}
}
