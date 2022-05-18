package saebut1;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import latice.model.Board;
import latice.model.Color;
import latice.model.Position;
import latice.model.Symbol;
import latice.model.Tile;

class TestForBoard {

	

	@Test
	void shouldTakeATileInTheBoard() {
		Board board = new Board();
		Tile tile = new Tile(Symbol.RIAS, Color.RED);
		Tile otherTile = new Tile(Symbol.RIAS, Color.RED);
		board.put(new Position(5, 5), tile, board);
		
		Tile ti = board.tileAt(new Position(5, 5));
		
		assertThat(otherTile)
			.usingRecursiveComparison().isEqualTo(ti);
	}
	
	@Test
	void shouldtest() {
		Board board = new Board();
		Position pos = new Position(1, 5);
		boolean var = board.getGameBoard().containsKey(pos);
		assertTrue(var);
	}

}
