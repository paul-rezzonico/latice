package latice.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javafx.scene.control.Label;
import javafx.stage.Stage;
import latice.ihm.controller.EndTurnController;
import latice.ihm.view.PlayFX;
import latice.model.Board;
import latice.model.Color;
import latice.model.Player;
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
		
	
		this.player1 = new Player("Player1", this.rackCreation(), stackJ1, pointJ1);
		this.player2 = new Player("Player2", this.rackCreation(), stackJ2, pointJ2);
		this.player1.fillRack();
		this.player2.fillRack();

		this.board = new Board();
		this.instance = this;
		
		this.playerTurn = turn();
		this.playFX = new PlayFX();
		this.primaryStage.getScene().setRoot(playFX);
		this.playFX.getBtnEndTurn().setOnMouseClicked(new EndTurnController());
		this.turnbegin();
	}	
	
	public ArrayList<Tile> rackCreation(){
		ArrayList<Tile> rack = new ArrayList<Tile>();
		rack.add(null);
		rack.add(null);
		rack.add(null);
		rack.add(null);
		rack.add(null);
		return rack;
		
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
		for (int i = 0; i < 36; i++) {
			stack.add(tileList.get(0));
			tileList.remove(0);
		}
		return stack;	
	}
	
	private boolean turn() {
		Random random = new Random();
		boolean PlayerTurn = random.nextBoolean();
		return PlayerTurn;
	}
	
	public void turnbegin() {
		
		this.setTurn(this.getTurn() + 1);
		this.playFX.getTurn().setText(("Tour : " + (this.getTurn())));
		
		if(this.getPlayerTurn()) {
			this.getPlayer1().setPtsFree(true);
			this.playFX.getRackJ1().setVisible(true);
			this.playFX.getRackJ2().setVisible(false);
			this.playFX.getTileInStackJ1().setText("Il reste " + this.getPlayer1().getStack().size() + " tuile dans votre stack");
		} else {
			this.getPlayer2().setPtsFree(true);
			this.playFX.getRackJ1().setVisible(false);
			this.playFX.getRackJ2().setVisible(true);
			this.playFX.getTileInStackJ2().setText("Il reste " + this.getPlayer2().getStack().size() + " tuile dans votre stack");
		}
	}
	
	public void endTurn() {
		
		if(this.getPlayerTurn()) {
			this.getPlayer1().fillRack();
			this.playFX.getRackJ1().fillRackFX(this.getPlayer1().getRack());
		} else { 
			this.getPlayer2().fillRack();
			this.playFX.getRackJ2().fillRackFX(this.getPlayer2().getRack());
		}
		
		this.setPlayerTurn(!this.getPlayerTurn());
		this.turnbegin();
		
	}
	public Integer getTurn() {
		return turn;
	}

	public void setTurn(Integer turn) {
		this.turn = turn;
	}

	public boolean getPlayerTurn() {
		return playerTurn;
	}

	public void setPlayerTurn(boolean playerTurn) {
		this.playerTurn = playerTurn;
	}

	public PlayFX getPlayFX() {
		return playFX;
	}

	public void setPlayFX(PlayFX playFX) {
		this.playFX = playFX;
	}

	public static Game getInstance() {
		return instance;
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
