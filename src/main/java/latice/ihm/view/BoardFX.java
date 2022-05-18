package latice.ihm.view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javafx.scene.layout.GridPane;
import latice.model.Board;
import latice.model.Box;
import latice.model.Position;

public class BoardFX extends GridPane{
	
	public BoardFX(Board board) {
		for (Map.Entry<Position, Box> entry : board.getGameBoard().entrySet()) {
			//TODO création du plateau en fx, en parcourant le hashmap.
			
		}
	}
	
}
