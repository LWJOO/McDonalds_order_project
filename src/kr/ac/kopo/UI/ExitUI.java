package kr.ac.kopo.UI;

public class ExitUI extends BaseUI {
	
	@Override
	public void execute() throws Exception {
		for (int i = 0; i < 50; i++) System.out.println();
		System.out.println("\n\n========================================");
		System.out.println("\t프로그램을 종료합니다.");
		System.out.println("========================================");
		System.exit(0);
	}

}
