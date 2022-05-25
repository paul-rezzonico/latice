package latice.ihm.view;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import latice.model.Board;
import latice.model.Player;

public class PlayFX extends BorderPane {

	private BoardFX boardfx;
	private Button btnSkip; 
	private Button btnShowPoint;
	private RackFX rack1;
	private GridPane rack2;
	
	public PlayFX(Player player) {
		Board board = new Board();
		this.boardfx = new BoardFX(board);
		this.setCenter(boardfx);
		rack1 = new RackFX(player.getRack());
		this.setBottom(rack1);
		
	}
}
