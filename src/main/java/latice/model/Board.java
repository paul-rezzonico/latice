package latice.model;

import java.util.HashMap;
import java.util.Map;

public class Board {

	private final Map<Position, Box> gameBoard;
	private static final int ROWS = 9;
	private static final int COLUMNS = 9;

	public Board() {
		this.gameBoard = new HashMap<>();

		for (int i = 1; i <= ROWS; i++) {
			for (int j = 1; j <= COLUMNS; j++) {

				if ((i == j || i + j == 10) && i != 4 && i != 5 && i != 6) {

					this.gameBoard.put(new Position(i, j), new Box(Shape.PENTACLE, null));

				} else if ((i == 5 && j == 1) || (i == 1 && j == 5) || (i == 5 && j == 9) || (i == 9 && j == 5)) {

					this.gameBoard.put(new Position(i, j), new Box(Shape.PENTACLE, null));

				} else if (i == 5 && j == 5) {

					this.gameBoard.put(new Position(i, j), new Box(Shape.LOGO, null));

				} else {

					this.gameBoard.put(new Position(i, j), new Box(Shape.EMPTY, null));

				}
			}

		}
	}

	// Guetters
	public Map<Position, Box> getGameBoard() {
		return gameBoard;
	}

	// Méthode de jeu
	public boolean isTileAt(Position position) {
		return (this.gameBoard.get(position).getTile() != null);
	}

	public boolean isEmpty() {
		for (Map.Entry<Position, Box> mapentry : this.gameBoard.entrySet()) {
			if (mapentry.getValue().getTile() != null)
				return false;
		}
		
		return true;
	}

	public boolean put(Position position, Tile tile, Board board) {
		if (!this.isTileAt(position) && verifTilesAround(position, tile, board)) {
			this.gameBoard.get(position).setTile(tile);
			return true;
		}
		return false;
	}

	public boolean verifTilesAround(Position position, Tile tile, Board board) {
		boolean isTileNear = false;

		if(board.isEmpty() && position.equals(new Position(5, 5))) {
			return true; 
		}
		
		Position pos = new Position(position.getRow() - 1, position.getColumn());
		if (gameBoard.containsKey(pos)) {
			if (isTileAt(pos)) {
				isTileNear = true;
				if (!verificationForTheEmplacemetOfTheTile(pos, tile)) {
					return false;
				}
			}
		}
		pos = new Position(position.getRow() + 1, position.getColumn());
		if (gameBoard.containsKey(pos)) {
			if (isTileAt(pos)) {
				isTileNear = true;
				if (!verificationForTheEmplacemetOfTheTile(pos, tile)) {
					return false;
				}
			}
		}
		pos = new Position(position.getRow(), position.getColumn() + 1);
		if (gameBoard.containsKey(pos)) {
			if (isTileAt(pos)) {

				isTileNear = true;
				if (!verificationForTheEmplacemetOfTheTile(pos, tile)) {
					return false;
				}
			}
		}
		pos = new Position(position.getRow(), position.getColumn() - 1);
		if (gameBoard.containsKey(pos)) {
			if (isTileAt(pos)) {
				isTileNear = true;
				if (!verificationForTheEmplacemetOfTheTile(pos, tile)) {
					return false;
				}
			}
		}
		return isTileNear;

	}
	
	public int sumpoint(Position position ,int point) {
		Position pos = new Position(position.getRow() - 1, position.getColumn());
		if (isTileAt(pos)) {
			point++;
		}
		pos = new Position(position.getRow() + 1, position.getColumn());
		if (isTileAt(pos)) {
			point++;
		}
		pos = new Position(position.getRow(), position.getColumn() + 1);
		if (isTileAt(pos)) {
			point++;
		}
		pos = new Position(position.getRow(), position.getColumn() - 1);
		if (isTileAt(pos)) {
			point++;
		}
		
		if (this.gameBoard.get(position).getShape() == Shape.PENTAGON) {
			point++;
			point++;
		}
		if (point>0) {
			return point-1;
		}else {
			return 0;
		}
	}


	private boolean verificationForTheEmplacemetOfTheTile(Position position, Tile tile) {
		return (this.tileAt(position).getColor().equals(tile.getColor())
				|| this.tileAt(position).getSymbol().equals(tile.getSymbol()));
	}

	public Tile tileAt(Position position) {
		return (this.gameBoard.get(position).getTile());
	}

	public Box boxAt(Position position) {
		return (this.gameBoard.get(position));
	}

}
