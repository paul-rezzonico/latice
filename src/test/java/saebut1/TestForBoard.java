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
	
	@Test
	void shouldVerifyIfATileIsAtAPosition() {
		Board board = new Board();
		Tile tile = new Tile(Symbol.RIAS, Color.RED);
		board.put(new Position(5, 5), tile);
		
		Boolean tileAt = board.isTileAt(new Position(5, 5));
		Boolean otherTileAt = board.isTileAt(new Position(8, 4));
		
		assertTrue(tileAt);
		assertFalse(otherTileAt);
		
	} 
	
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
	
	@Test
	void shouldPutAtileIfThereAreOneOrMoreColorMatching() {
		Board board = new Board();
		board.put(new Position(5, 5), new Tile(Symbol.RIAS, Color.RED));
		
		Boolean firstTileWellPut = board.put(new Position(5, 6), new Tile(Symbol.AKENO, Color.RED));
		Boolean secondTileWellPut = board.put(new Position(6, 6), new Tile(Symbol.ASIA, Color.RED));
		Boolean thirdTileWellPut = board.put(new Position(5, 4), new Tile(Symbol.KONEKO, Color.RED));
		Boolean lastTileWellPut = board.put(new Position(6, 5), new Tile(Symbol.KONEKO, Color.RED));
		Boolean wellPut = true;
		
		assertThat(wellPut).isEqualTo(firstTileWellPut)
		.isEqualTo(secondTileWellPut)
		.isEqualTo(thirdTileWellPut)
		.isEqualTo(lastTileWellPut);
	}
	
	@Test
	void shouldPutAtileIfThereAreOneOrMoreShapeMatching() {
		
		Board board = new Board();
		board.put(new Position(5, 5), new Tile(Symbol.RIAS, Color.GREEN));
		board.put(new Position(5, 6), new Tile(Symbol.RIAS, Color.RED));
		board.put(new Position(6, 6), new Tile(Symbol.RIAS, Color.YELLOW));
		Tile tile = new Tile(Symbol.RIAS, Color.GREY);
		Position pos = new Position(6, 5);
		
		Boolean wellPut = board.put(pos, tile);
		
		assertTrue(wellPut);
	}
	
	@Test
	void shouldPutAtileIfThereAreOneOrMoreShapeAndColorMatching() {
		
		Board board = createABoardWithThreeTileOneIt();
		Tile tile = new Tile(Symbol.AKENO, Color.GREEN);
		Position pos = new Position(6, 5);
		
		Boolean wellPut = board.put(pos, tile);
		
		assertTrue(wellPut);
	}
	
	@Test
	void shouldNotPutAtileIfThereAreOneOrMoreShapeNotMatching() {
		
		Board board = createABoardWithThreeTileOneIt();
		Tile tileOne = new Tile(Symbol.XENOVIA, Color.GREEN);
		Position posOne = new Position(6, 5);
		Tile tileTwo = new Tile(Symbol.XENOVIA, Color.GREEN);
		Position posTwo = new Position(6, 7);
		
		Boolean wellPutTileOne = board.put(posOne, tileOne);
		Boolean wellPutTileTwo = board.put(posTwo, tileTwo);
		
		assertFalse(wellPutTileOne);
		assertFalse(wellPutTileTwo);
	}
	
	@Test
	void shouldPutAtileIfAllTheTileAroundMatch() {
		
		Board board = createABoardWithAEmptyEmplacementWhereATileCanBePut();
		Tile tile = new Tile(Symbol.RIAS, Color.RED);
		Position pos = new Position(6, 5);
		Boolean wellPut = board.put(pos, tile);
		
		assertTrue(wellPut);
	}
	
	@Test
	void shouldHaveFourPointAfterMatchingATileWithFourOtherTile() {
		
		Board board = createABoardWithAEmptyEmplacementWhereATileCanBePut();
		Tile tile = new Tile(Symbol.RIAS, Color.RED);
		Position pos = new Position(6, 5);
		board.put(pos, tile);
		
		Integer pts = board.sumpoint(pos, 0);
		
		assertThat(pts).isEqualTo(4);
		
	}
	
	//TODO other test for 1, 2, 3 pts
	
	private Board createABoardWithThreeTileOneIt() {
		Board board = new Board();
		board.put(new Position(5, 5), new Tile(Symbol.RIAS, Color.GREEN));
		board.put(new Position(5, 6), new Tile(Symbol.RIAS, Color.GREY));
		board.put(new Position(6, 6), new Tile(Symbol.AKENO, Color.GREY));
		return board;
	}
	
	private Board createABoardWithAEmptyEmplacementWhereATileCanBePut() {
		
		Board board = new Board();
		board.put(new Position(5, 5), new Tile(Symbol.RIAS, Color.RED));
		board.put(new Position(5, 6), new Tile(Symbol.AKENO, Color.RED));
		board.put(new Position(6, 6), new Tile(Symbol.ASIA, Color.RED));
		board.put(new Position(7, 6), new Tile(Symbol.KONEKO, Color.RED));
		board.put(new Position(5, 4), new Tile(Symbol.RIAS, Color.RED));
		board.put(new Position(6, 4), new Tile(Symbol.IRINA, Color.RED));
		board.put(new Position(7, 4), new Tile(Symbol.XENOVIA, Color.RED));
		board.put(new Position(7, 5), new Tile(Symbol.AKENO, Color.RED));
		return board;
		
	}
}
