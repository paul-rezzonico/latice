package latice;

import latice.model.tile.Color;
import latice.model.tile.Position;
import latice.model.tile.Symbol;
import latice.model.tile.Tile;
import latice.model.board.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class TestForBoard {
	private Board board;
	private static final Tile RIAS_RED = new Tile(Symbol.RIAS, Color.RED);
	private static final Position CENTER= new Position(5, 5);

	@Test
	void boardShouldBeEmptyWhenCreated() {
		assertTrue(board.isEmpty());
	}
	
	@Test 
	void BoardShouldNotBeEmptyAfterPuttingATile() {
		board.put(CENTER, RIAS_RED);
		
		assertFalse(board.isEmpty());
	}

	@Test
	void itShouldTakeATileInTheBoard() {
		board.put(CENTER, RIAS_RED);

		Tile tile = board.tileAt(CENTER);

		assertThat(RIAS_RED).usingRecursiveComparison().isEqualTo(tile);
	}
	
	@Test
	void shouldVerifyIfATileIsAtAPosition() {
		Position emptyPosition = new Position(8, 4);

		board.put(CENTER, RIAS_RED);
		boolean tileAtCenter = board.isTileAt(CENTER);
		boolean otherTileNotInCenter = board.isTileAt(emptyPosition);

		assertThat(tileAtCenter).isTrue();
		assertThat(otherTileNotInCenter).isFalse();
	} 
	
	@Test
	void shouldNotTakeATileInTheBoardIfPositionAlreadyOccupied() {

		Tile tile = new Tile(Symbol.RIAS, Color.RED);
		Tile tileTwo = new Tile(Symbol.IRINA, Color.GREEN);
		
		boolean firstTileWellPut = board.put(CENTER, tile);
		boolean secondTileWellPut = board.put(CENTER, tileTwo);

		assertTrue(firstTileWellPut);
		assertFalse(secondTileWellPut);
	}
	
	@Test
	void shouldNotPutATileIfNotPutInTheCenterAtFirst() {

		Tile tile = new Tile(Symbol.RIAS, Color.RED);
		
		boolean tilePutNotCenter = board.put(new Position(4, 5), tile);
		boolean tilePutCenter = board.put(CENTER, tile);
		
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
		
		boolean wellPut = board.put(pos, tile);
		
		assertTrue(wellPut);
	}
	
	@Test
	void shouldPutATileIfThereAreOneOrMoreShapeAndColorMatching() {
		
		Board board = createABoardWithThreeTileOneIt();
		Tile tile = new Tile(Symbol.AKENO, Color.GREEN);
		Position pos = new Position(6, 5);
		
		boolean wellPut = board.put(pos, tile);
		
		assertTrue(wellPut);
	}
	
	@Test
	void shouldNotPutATileIfThereAreOneOrMoreShapeNotMatching() {
		
		Board board = createABoardWithThreeTileOneIt();
		Tile tileOne = new Tile(Symbol.XENOVIA, Color.GREEN);
		Position posOne = new Position(6, 5);
		Tile tileTwo = new Tile(Symbol.XENOVIA, Color.GREEN);
		Position posTwo = new Position(6, 7);
		
		boolean wellPutTileOne = board.put(posOne, tileOne);
		boolean wellPutTileTwo = board.put(posTwo, tileTwo);
		
		assertFalse(wellPutTileOne);
		assertFalse(wellPutTileTwo);
	}
	
	@Test
	void shouldPutATileIfAllTheTileAroundMatch() {
		
		Board board = createABoardWithAEmptyEmplacementWhereATileCanBePut();
		Tile tile = new Tile(Symbol.RIAS, Color.RED);
		Position pos = new Position(6, 5);
		boolean wellPut = board.put(pos, tile);
		
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

	@BeforeEach
	void initBoard() {
		this.board = new Board();
	}
	
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
