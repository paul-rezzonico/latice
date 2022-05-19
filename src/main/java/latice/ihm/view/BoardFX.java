package latice.ihm.view;

import java.util.Map;

import javafx.scene.layout.GridPane;
import latice.model.Board;
import latice.model.Box;
import latice.model.Position;

public class BoardFX extends GridPane{
	
	private String tileType ; 
	
	public BoardFX(Board board) {
		for (Map.Entry<Position, Box> entry : board.getGameBoard().entrySet()) {
			
			if(entry.getValue().getTile() != null) {
				tileType = entry.getValue().getTile().toString()+".png";
			} else if(true) {
				//TODO
			}
			
			
		}
	}
	
}
