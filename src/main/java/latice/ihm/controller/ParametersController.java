package latice.ihm.controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import latice.ihm.view.MenuFX;
import latice.ihm.view.Parameters;

public class ParametersController implements EventHandler<MouseEvent>{
	
	private MenuFX menu;
	
	public ParametersController(MenuFX menu) {
		this.menu = menu;
	}

	@Override
	public void handle(MouseEvent event) {
		
		this.menu.setCenter(new Parameters(menu));
		
	}

}
