package latice.ihm.view;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class PlayFX extends BorderPane {

	private BoardFX boardfx;
	private Button btnSkip; 
	private Button btnShowPoint;
	private GridPane Rack1;
	private GridPane Rack2;
	
	public PlayFX() {
		
		this.boardfx = new BoardFX(null);
		//TODO création de ce layout qui va etre la layout de jeu. 
		
	}
}
