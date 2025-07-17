package kr.ac.kopo.UI.UserUI;

import kr.ac.kopo.UI.BaseUI;
import kr.ac.kopo.dao.URogDAO;

public class JoinMacUI extends BaseUI {

	@Override
	public void execute() throws Exception {

		String user_id = null;
		while (true) {
			user_id = scanStr("아이디 입력 : ");
			String this_id = new URogDAO().checkID(user_id);
			if (this_id != null) {
				System.out.println("아이디 중복! 다른 아이디를 입력하세요");
			} else {
				break;
			}
		}
		String user_pw = scanStr("비밀번호 입력 : ");
		String user_name = scanStr("이름 입력 : ");
		String user_phone = null;
		while (true) {
			user_phone = scanStr("전화번호 입력 : ");
			String this_phone = new URogDAO().CheckPhone(user_phone);
			if (this_phone != null) {
				System.out.println("전화번호 중복! 다른 전화번호를 입력하세요");
			} else {
				break;
			}

		}
		for (int i = 0; i < 50; i++)System.out.println();
		new URogDAO().JoinMac(user_id, user_pw, user_name, user_phone);
		System.out.println("-------------------------------");
		System.out.println("\t" + user_name + "님의 회원가입이 완료 되었습니다.");
		System.out.println("-------------------------------");

	}

}
