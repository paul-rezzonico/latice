package saebut1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import latice.model.Color;
import latice.model.Player;
import latice.model.Symbol;
import latice.model.Tile;

class TestForPlayer {

	static int RACK_FULL = 5;

	@Test
	void shouldHaveASizeOfZeroIfTheRackIsEmpty() {

		ArrayList<Tile> stack = createASTackWithFiveTile();
		Player player = new Player("Player", stack, 0);

		assertThat(player.sizeRack()).isZero();

	}

	@Test
	void shouldNotHaveASizeOfZeroIfTheRackIsNotEmpty() {

		ArrayList<Tile> stack = createASTackWithFiveTile();
		Player player = new Player("Player", stack, 0);

		fillRackWithOnlyThreeTiles(player);

		assertThat(player.sizeRack()).isNotZero();

	}

	@Test
	void shouldHaveASizeOfThree() {

		ArrayList<Tile> stack = createASTackWithFiveTile();
		Player player = new Player("Player", stack, 0);

		fillRackWithOnlyThreeTiles(player);

		assertThat(player.sizeRack()).isEqualTo(3);

	}

	@Test
	void shouldFillRackWhenRackIsEmpty() {

		ArrayList<Tile> stack = createASTackWithFiveTile();
		Player player = new Player("Player", stack, 0);
		Player player2 = new Player("Player", stack, 0);
		int startSize = player.sizeRack();

		player.fillRack();

		assertThat(player.sizeRack()).isEqualTo(RACK_FULL)
										.isNotZero()
										.isNotEqualTo(startSize);
		assertThat(player.getRack()).usingRecursiveComparison().isNotEqualTo(player2.getRack());

	}

	@Test
	void shouldNotFillRackWhenRackIsFull() {

		ArrayList<Tile> stack = createASTackWithFiveTile();
		Player player = new Player("Player", stack, 0);
		ArrayList<Tile> rack = player.getRack();
		int startSize = player.sizeRack();

		player.fillRack();

		assertThat(player.sizeRack()).isEqualTo(RACK_FULL);
		assertThat(player.sizeRack()).isGreaterThan(startSize);
		assertThat(player.getRack()).usingRecursiveComparison().isEqualTo(rack);

	}

	@Test
	void shouldFillRackWhenThereAreThreeTilesOnTheRack() {

		ArrayList<Tile> stack = createASTackWithFiveTile();
		Player player = new Player("Player", stack, 0);
		fillRackWithOnlyThreeTiles(player);
		ArrayList<Tile> rack = player.getRack();

		int startSize = player.sizeRack();

		player.fillRack();

		assertThat(player.sizeRack()).isEqualTo(RACK_FULL);
		assertThat(player.sizeRack()).isGreaterThan(startSize);
		assertThat(player.getRack()).usingRecursiveComparison().isEqualTo(rack);

	}

	@Test
	void shouldFillRackWhenStayOnlyThreeTilesOnTheStack() {

		int NUMBER_OF_TILE_IN_THE_RACK = 3;

		ArrayList<Tile> stack = new ArrayList<>();
		stack.add(new Tile(Symbol.RIAS, Color.RED));
		stack.add(new Tile(Symbol.AKENO, Color.BLUE));
		stack.add(new Tile(Symbol.KONEKO, Color.YELLOW));
		Player player = new Player("Player", stack, 0);

		player.fillRack();

		assertThat(player.sizeRack()).isEqualTo(NUMBER_OF_TILE_IN_THE_RACK);
		assertThat(stack).isEmpty();

	}

	@Test
	void shouldClearRack() {
		ArrayList<Tile> stack = new ArrayList<>();
		Player player = new Player("Player", stack, 0);
		fillRackWithOnlyThreeTiles(player);
		int startSize = player.sizeRack();
		
		player.clearRack();
		
		assertThat(player.sizeRack()).isZero();
		assertThat(player.sizeRack()).isNotEqualTo(startSize);

	}
	
	@Test
	void shouldLeftEmptyTheSTackAfterFillRAckIfRackIsEmpty() {
		
		ArrayList<Tile> stack = createASTackWithFiveTile();
		Player player = new Player("Player", stack, 0);
		
		player.fillRack();
		
		assertThat(player.sizeRack()).isNotZero()
									.isEqualTo(RACK_FULL);
	}
	
	private ArrayList<Tile> createASTackWithFiveTile() {
		ArrayList<Tile> stack = new ArrayList<>();
		stack.add(new Tile(Symbol.AKENO, Color.RED));
		stack.add(new Tile(Symbol.AKENO, Color.GREY));
		stack.add(new Tile(Symbol.RIAS, Color.YELLOW));
		stack.add(new Tile(Symbol.XENOVIA, Color.BLUE));
		stack.add(new Tile(Symbol.ASIA, Color.GREEN));
		;
		return stack;
	}

	private void fillRackWithOnlyThreeTiles(Player player) {

		for (int i = 0; i < 3; i++) {
			if (player.getRack().get(i) == null) {
				player.getRack().set(i, new Tile(Symbol.RIAS, Color.RED));
			}
		}
	}
}
