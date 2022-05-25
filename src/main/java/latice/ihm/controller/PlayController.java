package latice.ihm.controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import latice.ihm.view.MenuFX;
import latice.ihm.view.PlayFX;
import latice.model.Player;

public class PlayController implements EventHandler<MouseEvent>{

	private Stage primaryStage;
	private MenuFX menu;
	private AudioClip song;
	private Player player;
	
	public PlayController(MenuFX menu, Player player) {
		this.menu = menu;
		this.song = new AudioClip(getClass().getResource("/song/Loading.mp3").toExternalForm());
	}
	
	@Override
	public void handle(MouseEvent event) {
		this.menu.getSong().stop();
		this.song.play();
		this.primaryStage.getScene().setRoot(new PlayFX(this.player));
		
	}
}
