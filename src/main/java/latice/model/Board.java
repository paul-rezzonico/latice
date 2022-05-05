package latice.model;

import java.util.List;

public class Board {
	private List<Box> board;

	public Board(List<Box> board) {
		super();
		this.board = board;
	}

	public List<Box> getBoard() {
		return board;
	}

	public void setBoard(List<Box> board) {
		this.board = board;
	}
	
}
