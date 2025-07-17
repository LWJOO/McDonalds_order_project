package kr.ac.kopo.UI.ManagerUI;

import java.util.List;

import kr.ac.kopo.UI.BaseUI;
import kr.ac.kopo.service.MenuService;
import kr.ac.kopo.vo.MemberVO;

public class MemberCheckUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		int page = 1;
		
		while (true) {
			for (int i = 0; i < 50; i++) System.out.println();
			
			List<MemberVO> menus = new MenuService().checkMember(page);

			if (menus.isEmpty()) {
				System.out.println("더 조회할 정보가 없습니다.");
			} else {

				System.out.println("-----------------------------------");
				System.out.println("회원번호\t회원아이디\t회원이름\t회원전화번호");
				System.out.println("-----------------------------------");
				for (MemberVO list : menus) {
					System.out.println(list.getMember_no() + "\t" + list.getMember_id() + "\t" + list.getMember_name()
							+ "\t" + list.getMember_phone());
				}
				System.out.println("-----------------------------------");
			}
			page = scanInt("페이지 선택(0 = 나가기) : ");
			if (page == 0) {
				for (int i = 0; i < 50; i++)System.out.println();
				return;
			}
		}
	}

}
