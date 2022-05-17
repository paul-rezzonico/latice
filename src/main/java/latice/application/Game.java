package latice.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import latice.model.Board;
import latice.model.Color;
import latice.model.Player;
import latice.model.Position;
import latice.model.Symbol;
import latice.model.Tile;

public class Game {
	static boolean notWin;

	public static void main(String[] args) {

		Console console = new Console();
		
		// Création des tuiles
		ArrayList<Tile> tileList = new ArrayList<>();
		for (Color color : Color.values()) {
			for (Symbol symbol : Symbol.values()) {
				tileList.add(new Tile(symbol, color));
				tileList.add(new Tile(symbol, color));
			}
		}

		// Mélange et séparation des tuiles
		Collections.shuffle(tileList);
		List<Tile> stackJ1 = new ArrayList<>();
		List<Tile> stackJ2 = new ArrayList<>();
		for (int i = 0; i < tileList.size(); i++) {
			if (i < 36) {
				stackJ1.add(tileList.get(i));
			} else {
				stackJ2.add(tileList.get(i));
			}
		}

		// Création des tas
		List<Tile> rackJ1 = new ArrayList<>();
		List<Tile> rackJ2 = new ArrayList<>();
		Player player1 = new Player("Player1", rackJ1, stackJ1, 0);
		Player player2 = new Player("Player2", rackJ2, stackJ2, 0);
		player1.fillRack();
		player2.fillRack();

		Board board = new Board();

		progress(board, player1, player2, console);

	}
	
	private static void progress(Board board, Player player1, Player player2, Console console) {
		
		int turn = 1;
		Random random= new Random();
		
		boolean PlayerTurn= random.nextBoolean();
		while (notWin!=true && turn!=11) {
			console.showBoard(board);
			
			if(PlayerTurn==true) {
				System.out.println("Au tour du joueur 1");
				Tile tile = console.tileChoice(player1.getRack());
				Position position = console.positionChoice();
				board.put(position, tile);
				PlayerTurn=false;
				
			}else {
				System.out.println("Au tour du joueur 2");
				Tile tile = console.tileChoice(player2.getRack());
				Position position = console.positionChoice();
				System.out.println("Placement de votre tuile " + tile.toString() + " à la position " + position.toString());
				board.put(position, tile);
				PlayerTurn=true;
			}	
			turn++;
		}
		
	}
	
}
