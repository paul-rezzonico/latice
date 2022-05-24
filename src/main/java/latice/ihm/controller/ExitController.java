package latice.ihm.controller;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ExitController implements EventHandler<MouseEvent>{

	@Override
	public void handle(MouseEvent event) {
		Platform.exit();
	}

}
