package latice.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javafx.stage.Stage;
import latice.ihm.controller.EndTurnController;
import latice.ihm.view.PlayFX;
import latice.ihm.view.RackFX;
import latice.model.Board;
import latice.model.Color;
import latice.model.Player;
import latice.model.Position;
import latice.model.Symbol;
import latice.model.Tile;

public class Game {
	
	private Integer pointJ1 = 0;
	private Integer pointJ2 = 0;
	private Board board;
	private Player player1;
	private Player player2;
	private Stage primaryStage;
	private PlayFX playFX;
	
	private boolean playerTurn;
	private Integer turn = 0; 

	private static Game instance;

	public Game(Stage primaryStage) {

		this.primaryStage = primaryStage;
		
		ArrayList<Tile> tileList = tileCreation();

		Collections.shuffle(tileList);
		
		ArrayList<Tile> stackJ1 = stackCreation(tileList);
		ArrayList<Tile> stackJ2 = stackCreation(tileList);
		
		this.player1 = new Player("Player1", new ArrayList<Tile>(), stackJ1, pointJ1);
		this.player2 = new Player("Player2", new ArrayList<Tile>(), stackJ2, pointJ2);
		this.player1.fillRack();
		this.player2.fillRack();

		this.board = new Board();
		this.instance = this;
		this.playerTurn = turn();
	}	
	
	private ArrayList<Tile> tileCreation() {
		ArrayList<Tile> tileList = new ArrayList<>();
		for (Color color : Color.values()) {
			for (Symbol symbol : Symbol.values()) {
				tileList.add(new Tile(symbol, color));
				tileList.add(new Tile(symbol, color));
			}
		}
		return tileList;
	}
	
	public ArrayList<Tile> stackCreation(ArrayList<Tile> tileList) {
		
		ArrayList<Tile> stack = new ArrayList<>();
		for (int i = 0; i < tileList.size()/2; i++) {
			stack.add(tileList.get(i));
			tileList.remove(i);
		}
		return stack;	
	}

	public boolean getPlayerTurn() {
		return playerTurn;
	}

	public void setPlayerTurn(boolean playerTurn) {
		this.playerTurn = playerTurn;
	}

	public void play() {
		
		this.playFX = new PlayFX();
		this.primaryStage.getScene().setRoot(playFX);
		this.playFX.getBtnEndTurn().setOnMouseClicked(new EndTurnController());
		this.playFX.getRackJ1().setVisible(this.getPlayerTurn());
		this.playFX.getRackJ2().setVisible(!this.getPlayerTurn());
		
		//à faire chaque tour
		this.playFX.getLblPointJ1().setText("Point du joueur 1 : " + this.getPlayer1().getPoint());
		this.playFX.getLblPointJ2().setText("Point du joueur 2 : " + this.getPlayer2().getPoint());
		
	}
	
	public void endTurn() {
		
		this.setPlayerTurn(!getPlayerTurn());
		this.playFX.getRackJ1().setVisible(this.getPlayerTurn());
		this.playFX.getRackJ2().setVisible(!this.getPlayerTurn());
		
	}

	public static Game getInstance() {
		return instance;
	}
	
	private boolean turn() {
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
