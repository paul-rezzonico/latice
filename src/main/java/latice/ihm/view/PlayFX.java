package latice.ihm.view;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import latice.model.Board;

public class PlayFX extends BorderPane {

	private BoardFX boardfx;
	private Button btnSkip; 
	private Button btnShowPoint;
	private GridPane Rack1;
	private GridPane Rack2;
	
	public PlayFX() {
		
		this.boardfx = new BoardFX(new Board());
		
	}
}
