package latice.application;

import latice.model.Board;
import latice.model.Position;
import latice.model.Tile;

public class Console {

	final int ROWS = 9;
	final int COLUMNS = 9;

	public void showBoard(Board board) {
		StringBuilder str = new StringBuilder();
		for (int i = 1; i <= ROWS; i++) {
			for (int j = 1; j <= COLUMNS; j++) {
				Position pos = new Position(i, j);
				Tile tile = board.tileAt(pos);
				if (tile != null) {
					str.append(tile.toString());
				} else if (board.boxAt(pos).getShape() != null) {
					str.append(board.boxAt(pos).toString());
				} else {
					str.append("         ");
				}
				str.append('|');
			}
			str.append("\n");
		}
		System.out.println(str.toString());
	}
}
