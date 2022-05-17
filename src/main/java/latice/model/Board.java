package latice.model;

import java.util.HashMap;
import java.util.Map;

public class Board {

	private final Map<Position, Box> board;
	private static final int ROWS = 9;
	private static final int COLUMNS = 9;

	public Board() {
		this.board = new HashMap<>();
		for (int i = 1; i <= ROWS; i++) {
			for (int j = 1; j <= COLUMNS; j++) {
				if ((i == j || i + j == 10) && i != 4 && i != 5 && i != 6) {
					this.board.put(new Position(i, j), new Box(Shape.PENTAGON, null));
				} else if ((i == 5 && j == 1) || (i == 1 && j == 5) || (i == 5 && j == 9) || (i == 9 && j == 5)) {
					this.board.put(new Position(i, j), new Box(Shape.PENTAGON, null));
				} else if (i == 5 && j == 5) {
					this.board.put(new Position(i, j), new Box(Shape.LOGO, null));
				} else {
					this.board.put(new Position(i, j), new Box(null, null));
				}
			}

		}
	}

	// Guetters
	public Map<Position, Box> getBoxs() {
		return board;
	}

	// Méthode de jeu
	public boolean isTileAt(Position position) {
		return (this.board.get(position).getTile() != null);
	}

	public boolean isEmpty() {
		for (Map.Entry<Position, Box> mapentry : this.board.entrySet()) {
			if (mapentry.getValue().getTile() != null)
				return false;
		}
		return true;
	}

	public boolean put(Position position, Tile tile) {
		if (!this.isTileAt(position) && verifTilesAround(position, tile)) {
			this.board.get(position).setTile(tile);
			return true;
		}
		return false;
	}

	public boolean verifTilesAround(Position position, Tile tile) {

		boolean isTileNear = false;
		Position pos = new Position(position.getRow() - 1, position.getColumn());
		if (isTileAt(pos)) {
			isTileNear = true;
			if (!verificationForTheEmplacemetOfTheTile(pos,tile)) {
				return false;
			} 
		}
		
		pos = new Position(position.getRow() + 1, position.getColumn());
		if (isTileAt(pos)) {
			isTileNear = true;
			if (!verificationForTheEmplacemetOfTheTile(pos,tile)) {
				return false;
			} 
		}

		pos = new Position(position.getRow(), position.getColumn() + 1);
		if (isTileAt(pos)) {
			isTileNear = true;
			if (!verificationForTheEmplacemetOfTheTile(pos,tile)) {
				return false;
			} 
		}
		
		pos = new Position(position.getRow() + 1, position.getColumn() - 1);
		if (isTileAt(pos)) {
			isTileNear = true;
			if (!verificationForTheEmplacemetOfTheTile(pos,tile)) {
				return false;
			} 
		}
		return isTileNear;
	}

	private boolean verificationForTheEmplacemetOfTheTile(Position position, Tile tile) {	
		
		return (this.tileAt(position).getColor().equals(tile.getColor())
					|| this.tileAt(position).getSymbol().equals(tile.getSymbol()));
	}

	public Tile tileAt(Position position) {
		return (this.board.get(position).getTile());
	}

	public Box boxAt(Position position) {
		return (this.board.get(position));
	}


}
