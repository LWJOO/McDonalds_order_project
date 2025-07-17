package kr.ac.kopo.UI.ManagerUI;

import java.util.List;

import kr.ac.kopo.UI.BaseUI;
import kr.ac.kopo.service.MenuService;
import kr.ac.kopo.vo.SalesVolumeVO;

public class SalesDayVolumeUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		for (int i = 0; i < 50; i++) System.out.println();
		String row = scanStr("원하는 조회 일수를 입력하세요(YYYY-MM-DD 형식) : ");

		List<SalesVolumeVO> menus = new MenuService().checkDaySalesVolume(row);

		if (menus == null) {
			System.out.println("입력된 날짜에 데이터가 없습니다.");
			return;
		} else {

			System.out.println("-----------------------------------");
			System.out.printf("%-10s%-10s %-20s\n", "판매량", "타입", "메뉴명");
			System.out.println("-----------------------------------");
			for (SalesVolumeVO list : menus) {
				System.out.printf("%-10d %-10s %-20s\n", list.getSum_sales(), list.getMenu_type(), list.getMenu_name());
			}
			System.out.println("-----------------------------------");
		}
		
	}
	
}
