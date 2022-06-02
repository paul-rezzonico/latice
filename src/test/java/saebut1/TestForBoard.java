package saebut1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import latice.model.Board;
import latice.model.Color;
import latice.model.Player;
import latice.model.Position;
import latice.model.Symbol;
import latice.model.Tile;


class TestForBoard {
	
	@Test
	void shouldTakeATileInTheBoard() {
		Board board = new Board();
		Tile tile = new Tile(Symbol.RIAS, Color.RED);
		Tile otherTile = new Tile(Symbol.RIAS, Color.RED);
		board.put(new Position(5, 5), tile);
		
		Tile ti = board.tileAt(new Position(5, 5));
		
		assertThat(otherTile)
			.usingRecursiveComparison().isEqualTo(ti);
	}
	
	@Test
	void shouldCreateAGameBoardWithThePosition() {
		Board board = new Board();
		Position pos = new Position(1, 5);
		
		boolean var = board.getGameBoard().containsKey(pos);
		
		assertTrue(var);
	}
	
	@Test
	void ShouldSeeIfTheBoardIsEmpty() {
		Board board = new Board();
		
		assertTrue(board.isEmpty());
	}
	
	//TODO test sur le rack 
	
	@Test
	void shouldPlaceATileInALine() {
		Board board = new Board();
		Tile tt = new Tile(Symbol.RIAS, Color.RED);
		board.put(new Position(5, 5), tt);
		board.put(new Position(6, 5), tt);
		board.put(new Position(7, 5), tt);
		board.put(new Position(8, 5), tt);
		board.put(new Position(9, 5), tt);
		assertTrue(board.isTileAt(new Position(9, 5)));
	}
		
	private ArrayList<Tile> rackCreation() {
		ArrayList<Tile> rack = new ArrayList<>();
		rack.add(null);
		rack.add(null);
		rack.add(null);
		rack.add(null);
		rack.add(null);
		return rack;
	}
}
