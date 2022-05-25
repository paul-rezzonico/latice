package latice.ihm.controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import latice.ihm.view.MenuFX;

public class ReturnController implements EventHandler<MouseEvent>{
	
	private MenuFX menu;
	
	public ReturnController(MenuFX menu) {
		this.menu = menu;
	}

	@Override
	public void handle(MouseEvent event) {
		this.menu.setCenter(menu.getvBCenter());
		
	}

}
