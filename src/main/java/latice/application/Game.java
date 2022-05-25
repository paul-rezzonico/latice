package latice.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import latice.model.Board;
import latice.model.Color;
import latice.model.Player;
import latice.model.Position;
import latice.model.Symbol;
import latice.model.Tile;

public class Game {
	
	private static boolean Win = false;
	private static Integer pointJ1 = 0;
	private static Integer pointJ2 = 0;
	private Board board;
	private Player player1;
	private Player player2;

	public Game() {

		ArrayList<Tile> tileList = tileCreation();

		Collections.shuffle(tileList);
		
		ArrayList<Tile> stackJ1 = stackCreation(tileList);
		ArrayList<Tile> stackJ2 = stackCreation(tileList);
		
		this.player1 = new Player("Player1", new ArrayList<Tile>(), stackJ1, pointJ1);
		this.player2 = new Player("Player2", new ArrayList<Tile>(), stackJ2, pointJ2);
		this.player1.fillRack();
		this.player2.fillRack();

		this.board = new Board();
	}

	public static void main(String[] args) {
		Game game = new Game();
		
		game.play();
	}
	
	
	private static ArrayList<Tile> tileCreation() {
		ArrayList<Tile> tileList = new ArrayList<>();
		for (Color color : Color.values()) {
			for (Symbol symbol : Symbol.values()) {
				tileList.add(new Tile(symbol, color));
				tileList.add(new Tile(symbol, color));
			}
		}
		return tileList;
	}
	
	public static ArrayList<Tile> stackCreation(ArrayList<Tile> tileList) {
		
		ArrayList<Tile> stack = new ArrayList<>();
		for (int i = 0; i < tileList.size()/2; i++) {
			stack.add(tileList.get(i));
			tileList.remove(i);
		}
		return stack;	
	}

	private void play() {
		
		Console console = new Console();
		
		int pointJ1 = this.player1.getPoint();
		int pointJ2 = this.player2.getPoint();
		
		int turn = 1;
		boolean WellPut;
		boolean PlayerTurn = turn();
		boolean endturn;
		
		while (!Win && turn != 11) {
			int coup = 1;
			
			if (PlayerTurn) {
				System.out.println("Au tour du joueur 1");
				endturn = false;
			
				do {
					console.showBoard(board);
					System.out.println(this.player1.getRack().toString());
					System.out.println("Point : " + player1.getPoint());
					
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
						if(!player1.changeRack()) {
							System.out.println("vous ne pouvez pas changer de rack après avoir jouer");
							break;
						}  
					case 4:

						endturn = true;
						PlayerTurn = false;
						break;

					default:
						System.out.println("Choix incorrect");

					}
				} while (!endturn);
				player1.fillRack();

			} else {
				
				System.out.println("Au tour du joueur 2");
				endturn = false;
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
						if(!player2.changeRack()) {
							System.out.println("vous ne pouvez pas changer de rack après avoir jouer");
							break;
						}
					case 4:

						endturn = true;
						PlayerTurn = true;
						break;

					default:
						System.out.println("Choix incorrect");

					}
				} while (!endturn);
			}
			player2.fillRack();
		}
	}

	private static boolean turn() {
		Random random = new Random();
		boolean PlayerTurn = random.nextBoolean();
		return PlayerTurn;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	
}
