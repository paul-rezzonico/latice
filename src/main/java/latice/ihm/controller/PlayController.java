package latice.ihm.controller;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import latice.ihm.view.LoadingScreen;
import latice.ihm.view.MenuFX;
import latice.ihm.view.PlayFX;

public class PlayController implements EventHandler<MouseEvent>{

	private Stage primaryStage;
	private MenuFX menu;
	
	public PlayController(Stage primaryStage, MenuFX menu) {
		this.primaryStage = primaryStage;
		this.menu = menu;
	}
	
	@Override
	public void handle(MouseEvent event) {
		this.menu.getSong().stop();
		this.primaryStage.getScene().setRoot(new LoadingScreen());
		this.primaryStage.getScene().setRoot(new PlayFX());
		
	}
}
