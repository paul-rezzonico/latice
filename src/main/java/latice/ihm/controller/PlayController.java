package latice.ihm.controller;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import latice.ihm.view.PlayFX;

public class PlayController implements EventHandler<MouseEvent>{

	private Stage primaryStage;
	private Scene gameScene;
	
	public PlayController(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.gameScene = new Scene(new PlayFX());
	}
	
	@Override
	public void handle(MouseEvent event) {
		this.primaryStage.setScene(gameScene);
	}
}
