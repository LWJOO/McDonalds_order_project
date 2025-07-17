package kr.ac.kopo.UI;

import java.util.Scanner;

public abstract class BaseUI implements IUI {
	private Scanner sc;
	public static int member_no = 0;
	
	public BaseUI() {
		sc = new Scanner(System.in);
	}
	
	protected String scanStr(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}
	
	protected int scanInt(String msg) {
		System.out.print(msg);
		int no = Integer.parseInt(sc.nextLine());
		return no;
	}
	
}
