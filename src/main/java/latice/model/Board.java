package latice.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Board {

	private final Map<Position, Box> board;
	private static final int ROWS = 9;
	private static final int COLUMNS = 9;
	public Board() {
		this.board = new HashMap<>();
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				//TODO placement des soleils 
				this.board.put(new Position(i, j), new Box(null, null));
			}
			
		}
	}

	//Guetters
	public Map<Position, Box> getBoxs() {
		return board;
	}

	//Méthode de jeu 
	public boolean isTileAt(Position position) {
		return (this.board.get(position)!=null);
	}

	public boolean isEmpty() {
		return (this.board.isEmpty());
	}

	public boolean put(Position position, Box tile) {
		if (!this.isTileAt(position)) {
			this.board.put(position, tile);
			return true;
		}
		return false;
	}

	public void clear() {
		this.board.clear();
	}

	public int howManyDiscsOnBoard() {
		return (this.board.size());
	}

	public Box tileAt(Position position) {
		return (this.board.get(position));
	}

	public Box removeTileAt(Position position) {
		return (this.board.get(position).getTile.setTile(null));
	}

	public String toAscii() {
		String str="";
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				Position pos = new Position(i, j);
				if(this.BoxAt(pos).get) {
					str = str + (this.discAt(new Position(i, j)).ascii());
				} else {
					str = str +(" ");
				}
			}
			str = str + ("\n");
		}
		return str.toString();
	}

}
