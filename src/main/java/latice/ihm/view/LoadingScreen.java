package latice.ihm.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;

public class LoadingScreen extends BorderPane{

	private ImageView image; 
	private AudioClip song; 
	
	public LoadingScreen() {
		this.image = new ImageView(new Image(getClass().getResourceAsStream("/Logo.png")));
		this.song = new AudioClip(getClass().getResource("/song/Loading.mp3").toExternalForm());
		song.play();
	}
}
