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
		Integer pointJ1 = 0;
		Integer pointJ2 = 0;
		Player player1 = new Player("Player1", rackJ1, stackJ1, pointJ1);
		Player player2 = new Player("Player2", rackJ2, stackJ2, pointJ2);
		player1.fillRack();
		player2.fillRack();

		Board board = new Board();

		progress(board, player1, player2, console);
	}

	private static void progress(Board board, Player player1, Player player2, Console console) {
		
		int pointJ1=player1.getPoint();
		int pointJ2 = player2.getPoint();
		int turn = 1;
		boolean WellPut;
		boolean endturn = true;
		Random random = new Random();

		boolean PlayerTurn = random.nextBoolean();
		while (notWin != true && turn != 11) {
			int coup = 1;
			if (PlayerTurn == true) {
				endturn = true;
				System.out.println("Au tour du joueur 1");
				do {
					console.showBoard(board);
					System.out.println(player1.getRack().toString());
					System.out.println("Point : "+player1.getPoint());
					int choix1 = console.choice();
					switch (choix1) {

					case 1:
						if (coup == 1) {
							do {
								Tile tile = console.tileChoice(player1.getRack());
								Position position = console.positionChoice();
								WellPut = board.put(position, tile, board);
								if (!WellPut) {
									System.out.println("Veuillez placer la pièce de manière convenable");
								}else {
									pointJ1=board.sumpoint(position, pointJ1 );
									player1.setPoint(pointJ1);
									player1.getRack().remove(tile);
								}
							} while (!WellPut);
							coup = 0;
						} else {
							System.out.println("Vous n'avez plus de coup gratuit");
						}
						break;

					case 2:
						if (player1.getPoint()>=2) {
							coup++;
							player1.setPoint(pointJ1-2);
							
						}else {
							System.out.println("Vous n'avez pas assez de point");

						}
						break;
						
					case 3: 
						player1.changeRack();
						player1.fillRack();
					case 4:

						endturn = false;
						PlayerTurn = false;
						break;

					default:
						System.out.println("Choix incorrect");

					}
				} while (endturn);
				player1.fillRack();

			} else {
				System.out.println("Au tour du joueur 2");
				endturn = true;
				do {
					console.showBoard(board);
					System.out.println(player2.getRack().toString());
					System.out.println("Point : "+player1.getPoint());
					int choix2 = console.choice();
					switch (choix2) {

					case 1:
						if (coup == 1) {
							do {
								Tile tile = console.tileChoice(player2.getRack());
								Position position = console.positionChoice();
								WellPut = board.put(position, tile, board);
								if (!WellPut) {
									System.out.println("Veuillez placer la pièce de manière convenable");
								}else {
									pointJ2=board.sumpoint(position, pointJ2 );
									player2.setPoint(pointJ1);
									player2.getRack().remove(tile);
								}
							} while (!WellPut);
							coup = 0;
						} else {
							System.out.println("Vous n'avez plus de coup gratuit");
						}
						break;

					case 2:
						if (player2.getPoint()>=2) {
							coup++;
							player2.setPoint(pointJ2-2);
							
						}else {
							System.out.println("Vous n'avez pas assez de point");
						}
						break;
					case 3:
						player2.changeRack();
						player2.fillRack();
					case 4:

						endturn = false;
						PlayerTurn = true;
						break;

					default:
						System.out.println("Choix incorrect");

					}
				} while (endturn);
			}
			player2.fillRack();
		}
	}
}
