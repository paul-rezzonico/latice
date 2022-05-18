package latice.ihm.controller;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PlayController implements EventHandler<MouseEvent>{

	private Stage primaryStage;
	private Scene gameScene;
	
	public PlayController(Stage primStage) {
		this.primaryStage = primStage;
	}
	
	@Override
	public void handle(MouseEvent event) {
		this.primaryStage.setScene(gameScene);
		
	}
}
