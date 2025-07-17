package kr.ac.kopo.UI.ManagerUI;

import kr.ac.kopo.UI.BaseUI;
import kr.ac.kopo.dao.MRogDAO;

public class MRoginUI extends BaseUI {

	private String[] master_rogin() {
		String ID = scanStr("관리자 ID : ");
		String PW = scanStr("관리자 PW : ");
		String[] idpw = { ID, PW };
		
		return idpw;
	}

	@Override
	public void execute() throws Exception {
		while (true) {
			for (int i = 0; i < 50; i++) System.out.println();
			String[] master = master_rogin();
			for (int i = 0; i < 50; i++) System.out.println();
			int master_no = new MRogDAO().selectMRog(master[0], master[1]);

			if (master_no == 0) {
				System.out.println("로그인 실패" + master_no);
				
				return;
			} else {
				System.out.println("-----------------------------------");
				System.out.println("\t관리자님 환영합니다.");
				System.out.println("-----------------------------------");
				
				new MasterMenuUI().execute();
				break;
			}
		}

	}

}
