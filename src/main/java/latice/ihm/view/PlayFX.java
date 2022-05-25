package latice.ihm.view;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import latice.application.Game;
import latice.model.Board;
import latice.model.Player;

public class PlayFX extends BorderPane {

	private BoardFX boardfx;
	private Button btnSkip; 
	private Button btnShowPoint;
	private RackFX rack1;
	private GridPane rack2;
	private Game game;
	
	public PlayFX(Game game) {
		
		this.game = game;
		this.setCenter(new BoardFX(game.getBoard()));
		this.rack1 = new RackFX(game.getPlayer1().getRack());
		this.setBottom(rack1);
		
	}
}
