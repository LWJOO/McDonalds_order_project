package kr.ac.kopo.UI.ManagerUI;

import java.util.List;

import kr.ac.kopo.UI.BaseUI;
import kr.ac.kopo.service.MenuService;
import kr.ac.kopo.vo.SalesVO;

public class SalesMonthUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		for (int i = 0; i < 50; i++) System.out.println();
		String row = scanStr("조회 개월수를 입력하세요 : ");

		List<SalesVO> menus = new MenuService().checkMonthSales(row);

		if (menus == null) {
			System.out.println("입력된 날짜에 데이터가 없습니다.");
			return;
		} else {

			System.out.println("-----------------------------------");
			System.out.println("날짜\t\t매출");
			System.out.println("-----------------------------------");
			for (SalesVO list : menus) {
				System.out.println(list.getDate() + "\t\t" + list.getSeles());
			}
			System.out.println("-----------------------------------");

		}

	}
}
