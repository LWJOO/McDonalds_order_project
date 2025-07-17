package kr.ac.kopo.UI.UserUI;

import java.util.List;

import kr.ac.kopo.UI.BaseUI;
import kr.ac.kopo.dao.MemberDAO;
import kr.ac.kopo.dao.OrderDAO;
import kr.ac.kopo.vo.MemberVO;
import kr.ac.kopo.vo.MyPageVO;
import kr.ac.kopo.vo.SalesVolumeVO;

public class MyPageUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		for (int i = 0; i < 50; i++)System.out.println();
		List<MemberVO> myInfoList = new MemberDAO().myInfo(BaseUI.member_no);
		System.out.println("-----------------------------------");
		System.out.println("\t<<" + myInfoList.get(0).getMember_name() + "님의 페이지>>");
		System.out.println("-----------------------------------");
		System.out.println("아이디 : " + myInfoList.get(0).getMember_id());
		System.out.println("전화번호 : " + myInfoList.get(0).getMember_phone());
		
		List<MyPageVO> myOrder = new OrderDAO().mylist(BaseUI.member_no);
		System.out.println("\n\n\t<<나의 주문 기록>>");
		System.out.println("-----------------------------------");
		System.out.printf("%-10s %-20s\n", "개수", "메뉴명");
		System.out.println("-----------------------------------");
		for (MyPageVO list : myOrder) {
			System.out.printf("%-10d %-20s\n", list.getTotal_qty(), list.getMenu_name());
		}
		System.out.println("-----------------------------------");
		System.out.println("총 결제 금액 :" + new OrderDAO().total(BaseUI.member_no));
		System.out.println("-----------------------------------");
		scanStr("돌아가시려면 하려면 아무키나 입력하세요 : ");
		
		for (int i = 0; i < 50; i++) System.out.println();
	}

}
