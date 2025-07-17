package kr.ac.kopo.UI.UserUI;

import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.UI.BaseUI;
import kr.ac.kopo.dao.MenuDAO;
import kr.ac.kopo.dao.OrderDAO;
import kr.ac.kopo.service.MenuService;
import kr.ac.kopo.vo.MenuVO;

public class MenuOrderUI extends BaseUI {

	@Override
	public void execute() throws Exception {

		List<Integer> menu_no = new ArrayList<>();
		List<String> menu_name = new ArrayList<>();
		List<Integer> order_qty = new ArrayList<>();
		List<MenuVO> menus = new MenuService().searchAll();
		System.out.println("-----------------------------------");
		for (MenuVO list : menus) {
			System.out.println(list.getMenu_no() + "\t" + list.getMenu_name() + "\t" + list.getMenu_price());
		}
		System.out.println("-----------------------------------");
		while (true) {
			int num = scanInt("메뉴 번호를 입력하세요 : ");
			String name = new MenuDAO().MenuName(num);
			if (name == null) {
				System.out.println("잘못된 메뉴 번호");
				continue;
			}
			String set = "n";
			if (new MenuDAO().MenuType(num).equals("BURGER")) {
				set = scanStr("세트로 하시겠습니까?(y/n) : ");
				if (set.equals("y") || set.equals("Y")) {
					String basic = scanStr("기본세트로 하시겠습니까?(y/n) : ");
					if (basic.equals("n") || basic.equals("N")) {
						List<MenuVO> side = new MenuService().orderMenuByType(2);
						System.out.println("-----------------------------------");
						for (MenuVO list : side) {
							System.out.println(
									list.getMenu_no() + "\t" + list.getMenu_name() + "\t" + list.getMenu_price());
						}
						System.out.println("-----------------------------------");
						while (true) {
							int sides = scanInt("사이드 번호를 입력하세요 :");
							String type = new MenuDAO().MenuType(sides);
							if (type.equals("SIDE")) {
								menu_no.add(sides);
								String sname = new MenuDAO().MenuName(sides);
								menu_name.add(sname);
								break;
							} else {
								System.out.println("잘못된 메뉴 번호");
								continue;
							}
						}

						List<MenuVO> drink = new MenuService().orderMenuByType(3);
						System.out.println("-----------------------------------");
						for (MenuVO list : drink) {
							System.out.println(
									list.getMenu_no() + "\t" + list.getMenu_name() + "\t" + list.getMenu_price());
						}
						System.out.println("-----------------------------------");
						while (true) {
							int drinks = scanInt("음료 번호를 입력하세요 :");
							String type = new MenuDAO().MenuType(drinks);
							if (type.equals("DRINK")) {
								menu_no.add(drinks);
								String dname = new MenuDAO().MenuName(drinks);
								menu_name.add(dname);
								break;
							} else {
								System.out.println("잘못된 메뉴 번호");
								continue;
							}
						}
					} else {
						menu_no.add(1038);
						menu_name.add(new MenuDAO().MenuName(1038));
						menu_no.add(1053);
						menu_name.add(new MenuDAO().MenuName(1053));
					}
				}
			}
			menu_name.add(name);
			int qty = scanInt(name + " 주문 개수를 입력하세요 : ");
			String ans = scanStr("더 주문하시겠습니까?(y/n) : ");
			menu_no.add(num);
			if (set.equals("y") || set.equals("Y")) {
				order_qty.add(qty);
				order_qty.add(qty);
				order_qty.add(qty);
			} else {
				order_qty.add(qty);
			}
			if (ans.equals("n") || ans.equals("N"))
				break;
		}
		for (int i = 0; i < 50; i++)
			System.out.println();
		int monny = new OrderDAO().orderMenu(BaseUI.member_no, menu_no, order_qty);

		System.out.println("-----------------------------------");
		for (int i = 0; i < menu_name.size(); i++) {
			System.out.println(menu_name.get(i) + "\t" + order_qty.get(i) + "개");
		}
		System.out.println("총액 : " + monny + "원");
		System.out.println("\t<<주문이 완료되었습니다.>>");
		System.out.println("-----------------------------------");

	}

}
