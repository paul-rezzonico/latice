package latice.ihm.controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;

public class ObjectionController implements EventHandler<MouseEvent>{

	@Override
	public void handle(MouseEvent event) {
		AudioClip objection = new AudioClip(getClass().getResource("/music/Objection.mp3").toExternalForm());
		objection.play();
	}

}
