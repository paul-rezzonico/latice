package latice.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import latice.ihm.controller.ChangeRackController;
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
	private Integer turn = 1; 

	private static Game instance;

	public Game(Stage primaryStage) {

		this.primaryStage = primaryStage;
		
		ArrayList<Tile> tileList = tileCreation();

		Collections.shuffle(tileList);
		
		List<Tile> stackJ1 = stackCreation(tileList);
		List<Tile> stackJ2 = stackCreation(tileList);
		
	
		this.player1 = new Player("Joueur 1", stackJ1, pointJ1);
		this.player2 = new Player("Joueur 2", stackJ2, pointJ2);
		this.player1.fillRack();
		this.player2.fillRack();

		this.board = new Board();
		this.instance = this;
		
		this.playerTurn = turn();
		this.playFX = new PlayFX();
		this.primaryStage.getScene().setRoot(playFX);
		this.playFX.getBtnEndTurn().setOnMouseClicked(new EndTurnController(this.primaryStage));
		this.playFX.getBtnChangeRack().setOnMouseClicked(new ChangeRackController(this.primaryStage));
		this.turnbegin();
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
	
	public List<Tile> stackCreation(List<Tile> tileList) {
		
		ArrayList<Tile> stack = new ArrayList<>();
		for (int i = 0; i < 36; i++) {
			stack.add(tileList.get(0));
			tileList.remove(0);
		}
		return stack;	
	}
	
	private boolean turn() {
		Random random = new Random();
		return random.nextBoolean();
	}
	
	public void turnbegin() {
		
		this.setTurn(this.getTurn() + 1);
		int cycle = (int) Math.ceil(this.getTurn()/2);
		this.playFX.getTurn().setText(("Cycle : " + cycle));
		
		if(this.getPlayerTurn()) {
			this.getPlayer1().setPtsFree(true);
			this.playFX.getRackJ1().setVisible(true);
			this.playFX.getRackJ2().setVisible(false);
		} else {
			this.getPlayer2().setPtsFree(true);
			this.playFX.getRackJ1().setVisible(false);
			this.playFX.getRackJ2().setVisible(true);
		}
	}
	
	public void endTurn() {
		
		if(this.getPlayerTurn()) {
			this.getPlayer1().fillRack();
			this.playFX.getRackJ1().fillRackFX(this.getPlayer1().getRack());
			this.playFX.getTileInStackJ1().setText(this.getPlayer1().getStack().size() + this.getPlayer1().sizeRack() + " tuiles restantes ");
		} else { 
			this.getPlayer2().fillRack();
			this.playFX.getRackJ2().fillRackFX(this.getPlayer2().getRack());
			this.playFX.getTileInStackJ2().setText(this.getPlayer2().getStack().size() + this.getPlayer2().sizeRack() + " tuiles restantes ");
		}
		
		this.setPlayerTurn(!this.getPlayerTurn());
		
		if(this.getTurn() == 15) {
			this.getPlayFX().getSong().stop();
			this.getPlayFX().setSong(new AudioClip(getClass().getResource("/music/Time.mp3").toExternalForm()));
			this.getPlayFX().getSong().setCycleCount(AudioClip.INDEFINITE);
			this.getPlayFX().getSong().play();
		}
		
		this.turnbegin();
		
	}
	
	public boolean isATie() {
		
		return (this.getPlayer1().getStack().size() + this.getPlayer1().sizeRack() == this.getPlayer2().getStack().size() + this.getPlayer2().sizeRack());
			
	}
	
	public Player calculateWinner(){
		
		if(this.getPlayer1().getStack().size() + this.getPlayer1().sizeRack()  < this.getPlayer2().getStack().size() + this.getPlayer2().sizeRack()) {
			return player1;
		} else { 
			return player2;
		}
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
