package kr.ac.kopo.UI.UserUI;

import kr.ac.kopo.UI.BaseUI;
import kr.ac.kopo.dao.URogDAO;

public class FindIDUI extends BaseUI {
	
	private String[] checkNP() {
		System.out.println("-------------------------------");
		System.out.println("\t<<아이디 찾기>>");
		System.out.println("-------------------------------");
		
		String name = scanStr("가입한 이름을 입력하세요 : ");
		String phone = scanStr("가입한 전화번호를 입력하세요  : ");
		String[] np = { name, phone };
		return np;
	}
	
	@Override
	public void execute() throws Exception {
		for (int i = 0; i < 50; i++) System.out.println();
		String[] master = checkNP();
		String id = new URogDAO().FindID(master[0], master[1]);

		if (id != null) {
			for (int i = 0; i < 50; i++) System.out.println();
			System.out.println("-------------------------------");
			System.out.println(master[0] + "님의 아이디는 \"" + id + "\"입니다.");
			System.out.println("-------------------------------");
			
		} else {
			for (int i = 0; i < 50; i++) System.out.println();
			System.out.println("-------------------------------");
			System.out.println("가입된 회원이 아닙니다.");
			System.out.println("-------------------------------");
			
		}
		
	}
		
}
