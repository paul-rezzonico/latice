package saebut1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import latice.model.Color;
import latice.model.Player;
import latice.model.Symbol;
import latice.model.Tile;

public class TestForPlayer {

	static int RACK_FULL = 5;

	@Test
	void shouldNotFillRackWhenRackIsFull() {

		ArrayList<Tile> stack = new ArrayList<>();
		stack.add(new Tile(Symbol.AKENO, Color.RED));
		stack.add(new Tile(Symbol.AKENO, Color.GREY));
		stack.add(new Tile(Symbol.RIAS, Color.YELLOW));
		stack.add(new Tile(Symbol.XENOVIA, Color.BLUE));
		stack.add(new Tile(Symbol.ASIA, Color.GREEN));
		ArrayList<Tile> rack = rackFullCreation();
		Player player = new Player("Player", stack, 0);

		player.fillRack();

		assertThat(player.sizeRack()).isEqualTo(RACK_FULL);
		assertThat(player.getRack()).usingRecursiveComparison().isEqualTo(rack);

	}

	@Test
	void shouldFillRackWhenRackIsEmpty() {

		ArrayList<Tile> stack = new ArrayList<>();
		stack.add(new Tile(Symbol.RIAS, Color.RED));
		stack.add(new Tile(Symbol.AKENO, Color.BLUE));
		stack.add(new Tile(Symbol.KONEKO, Color.YELLOW));
		ArrayList<Tile> rack = rackCreation();
		Player player = new Player("Player", stack, 0);

		player.fillRack();

	}

	@Test
	void shouldFillRackWhenThereAreThreeTilesOnTheRtack() {

	}

	@Test
	void shouldFillRackWhenThereStayOnly3TilesOnTheStack() {

		int NUMBER_OF_TILE_IN_THE_RACK = 3;

		ArrayList<Tile> stack = new ArrayList<>();
		stack.add(new Tile(Symbol.RIAS, Color.RED));
		stack.add(new Tile(Symbol.AKENO, Color.BLUE));
		stack.add(new Tile(Symbol.KONEKO, Color.YELLOW));
		ArrayList<Tile> rack = rackCreation();
		Player player = new Player("Player", stack, 0);

		player.fillRack();
		int size = player.sizeRack();

		assertThat(size).isEqualTo(NUMBER_OF_TILE_IN_THE_RACK);

	}

	@Test
	void shouldClearRack() {
		ArrayList<Tile> stack = new ArrayList<>();
		ArrayList<Tile> rack = new ArrayList<>();
		rack.add(new Tile(Symbol.RIAS, Color.RED));
		rack.add(new Tile(Symbol.AKENO, Color.BLUE));
		rack.add(new Tile(Symbol.KONEKO, Color.YELLOW));

		Player player = new Player("Player", stack, 0);

		assertThat(player.sizeRack()).isEqualTo(3);
		player.clearRack();
		assertThat(player.sizeRack()).isZero();

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

	private ArrayList<Tile> rackFullCreation() {
		
		ArrayList<Tile> rack = rackCreation();
		rack.add(new Tile(Symbol.RIAS, Color.RED));
		rack.add(new Tile(Symbol.AKENO, Color.BLUE));
		rack.add(new Tile(Symbol.AKENO, Color.GREEN));
		rack.add(new Tile(Symbol.ASIA, Color.GREY));
		rack.add(new Tile(Symbol.XENOVIA, Color.YELLOW));
		return rack;
	}

}
