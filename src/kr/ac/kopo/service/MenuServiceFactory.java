package kr.ac.kopo.service;

public class MenuServiceFactory {
	
	private static MenuService menuService;

	public MenuService getInstance() {
		if(menuService == null)
			menuService = new MenuService();
		return menuService;
	}

}
