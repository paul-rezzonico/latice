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
	
	@Test
	void shouldFillRackWhenStackSizeMoreThan5() {
		ArrayList<Tile> stack = new ArrayList<>();
		stack.add(new Tile(Symbol.RIAS, Color.RED));
		stack.add(new Tile(Symbol.AKENO, Color.BLUE));
		stack.add(new Tile(Symbol.KONEKO, Color.YELLOW));
		stack.add(new Tile(Symbol.ASIA, Color.GREEN));
		stack.add(new Tile(Symbol.XENOVIA, Color.PINK));
		stack.add(new Tile(Symbol.IRINA, Color.GREY));
		
		ArrayList<Tile> rack = new ArrayList<>();
		Player player = new Player("Player", rack, stack, 0);
		
		player.fillRack();
		
		assertThat(rack).hasSize(5);
	}
	
	@Test
	void shouldFillRackWhenStackSizeLessThan5() {
		ArrayList<Tile> stack = new ArrayList<>();
		stack.add(new Tile(Symbol.RIAS, Color.RED));
		stack.add(new Tile(Symbol.AKENO, Color.BLUE));
		stack.add(new Tile(Symbol.KONEKO, Color.YELLOW));
		
		ArrayList<Tile> rack = new ArrayList<>();
		Player player = new Player("Player", rack, stack, 0);
		
		player.fillRack();
		
		assertThat(rack).hasSize(3);
	}
	@Test
	void shouldClearRack() {
		ArrayList<Tile> stack = new ArrayList<>();
		ArrayList<Tile> rack = new ArrayList<>();
		rack.add(new Tile(Symbol.RIAS, Color.RED));
		rack.add(new Tile(Symbol.AKENO, Color.BLUE));
		rack.add(new Tile(Symbol.KONEKO, Color.YELLOW));

		Player player = new Player("Player", rack, stack, 0);
		player.clearRack();
		assertThat(rack).hasSize(0);
		
	}
	
	@Test
	void shouldPlaceATileInALine() {
		Board board = new Board();
		Tile tt = new Tile(Symbol.RIAS, Color.RED);
		board.put(new Position(5, 5), tt, board);
		board.put(new Position(6, 5), tt, board);
		board.put(new Position(7, 5), tt, board);
		board.put(new Position(8, 5), tt, board);
		board.put(new Position(9, 5), tt, board);
		assertTrue(board.isTileAt(new Position(9, 5)));
	}
}
