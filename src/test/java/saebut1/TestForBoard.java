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
	void ShouldVerifyIfTheBoardIsEmpty() {
		Board board = new Board();

		assertTrue(board.isEmpty());
	}
	
	@Test 
	void ShouldVerifyIfTheBoardIsNotEmpty() {
		Board board = new Board();
		board.put(new Position(5, 5), new Tile(Symbol.RIAS, Color.RED));
		
		assertFalse(board.isEmpty());
	
	}

	@Test
	void shouldTakeATileInTheBoard() {
		Board board = new Board();
		Tile tile = new Tile(Symbol.RIAS, Color.RED);
		board.put(new Position(5, 5), tile);

		Tile ti = board.tileAt(new Position(5, 5));

		assertThat(tile).usingRecursiveComparison().isEqualTo(ti);
	}
	
	//TODO test is tiles at and tile at method 
	
	@Test
	void shouldNotTakeATileInTheBoardIfPositionAlreadyOccuped() {
		
		Board board = new Board();
		Tile tile = new Tile(Symbol.RIAS, Color.RED);
		Tile tileTwo = new Tile(Symbol.IRINA, Color.GREEN);
		
		Boolean firstTileWellPut = board.put(new Position(5, 5), tile);
		Boolean secondTileWellPut = board.put(new Position(5, 5), tileTwo);

		assertTrue(firstTileWellPut);
		assertFalse(secondTileWellPut);
		
	}
	
	@Test
	void shouldNotPutATileIfNotPutInTheCenterAtFirst() {
		
		Board board = new Board();
		Tile tile = new Tile(Symbol.RIAS, Color.RED);
		
		Boolean tilePutNotCenter = board.put(new Position(4, 5), tile);
		Boolean tilePutCenter = board.put(new Position(5, 5), tile);
		
		assertFalse(tilePutNotCenter);
		assertTrue(tilePutCenter);
		
	}
	
	
	//TODO faire tout les test avec tuiles a cotée 
	//@Test
	//void should
	
	//TODO faire tout les test pour calcul des points
}
