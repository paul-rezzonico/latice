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
	
	public boolean isTileAt(Position position) {
		return (this.gameBoard.get(position).getTile() != null);
	}

	public boolean isEmpty() {
		for (Map.Entry<Position, Box> mapentry : this.gameBoard.entrySet()) {
			if (isTileAt(mapentry.getKey()))
				return false;
		}
		
		return true;
	}

	public boolean put(Position position, Tile tile) {
		if (gameBoard.containsKey(position)) {
			if (!this.isTileAt(position) && verifTilesAround(position, tile)) {
				this.gameBoard.get(position).setTile(tile);
				return true;
			}
		}
		return false;
	}

	public boolean verifTilesAround(Position position, Tile tile) {
		boolean isTileNear = false;

		if(this.isEmpty() && position.equals(new Position(5, 5))) {
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
	
	
	public int sumpoint(Position position , int point) {
		
		Position pos = new Position(position.getRow() - 1, position.getColumn());
		point = points(pos, point);
		
		pos = new Position(position.getRow() + 1, position.getColumn());
		point = points(pos, point);
		
		pos = new Position(position.getRow(), position.getColumn() + 1);
		point = points(pos, point);
		
		pos = new Position(position.getRow(), position.getColumn() - 1);
		point = points(pos, point);
		
		if (point>0 && point!=4) {
			point = point-1;
			
		}
		
		if (this.gameBoard.get(position).getShape() == Shape.PENTACLE) {
			point++;
			point++;
		}
		
		return point;
	}
	
	public int points(Position pos, int point) {
		if (gameBoard.containsKey(pos)) {
			if (isTileAt(pos)) {
				point++;
			}
		}
		return point;
	}

	private boolean verificationForTheEmplacemetOfTheTile(Position position, Tile tile) {
		return (this.tileAt(position).getColor().equals(tile.getColor())
				|| this.tileAt(position).getSymbol().equals(tile.getSymbol()));
	}

	public Tile tileAt(Position position) {
		return (this.gameBoard.get(position).getTile());
	}
	
	public Map<Position, Box> getGameBoard() {
		return this.gameBoard;
	}

}
