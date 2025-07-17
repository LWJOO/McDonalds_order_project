package kr.ac.kopo.main;

import kr.ac.kopo.UI.StartUI;

public class StartMain {
	
	public static void main(String[] args) {
		StartUI ui = new StartUI();
		try{
			ui.execute();
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
}
