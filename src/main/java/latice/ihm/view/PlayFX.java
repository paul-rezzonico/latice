package latice.ihm.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.scene.text.TextAlignment;
import latice.application.Game;

public class PlayFX extends BorderPane {

	private BoardFX boardfx;
	private Label lblPointJ1;
	private Label lblPointJ2;
	private RackFX rackJ1;
	private RackFX rackJ2;
	private HBox hBrack;
	private Game game;
	private Button btnEndTurn;
	
	private AudioClip musique;
	
	public PlayFX() {
		
		Game game = Game.getInstance();
		this.setCenter(new BoardFX(game.getBoard()));
		
		this.rackJ1 = new RackFX(game.getPlayer1().getRack());
		this.rackJ2 = new RackFX(game.getPlayer2().getRack());
		this.hBrack =  new HBox(40);
		
		this.btnEndTurn = new Button("Finir le tour");
		this.hBrack.getChildren().addAll(rackJ1, btnEndTurn, rackJ2);
		this.hBrack.setAlignment(Pos.CENTER);
		this.hBrack.setMaxHeight(300);
		this.setBottom(hBrack);
		
		this.lblPointJ1 = new Label();
		this.lblPointJ1.setMaxWidth(200);
		this.lblPointJ1.setAlignment(Pos.CENTER);
		this.lblPointJ1.setTextAlignment(TextAlignment.CENTER);
		this.lblPointJ1.setPadding(new Insets(20, 20, 20, 20));
		
		this.lblPointJ2 = new Label();
		this.lblPointJ2.setMaxWidth(200);
		this.lblPointJ2.setAlignment(Pos.CENTER);
		this.lblPointJ2.setTextAlignment(TextAlignment.CENTER);
		this.lblPointJ2.setPadding(new Insets(20, 20, 20, 20));
		
		this.setLeft(lblPointJ1);
		this.setRight(lblPointJ2);
		
	}

	public BoardFX getBoardfx() {
		return boardfx;
	}

	public void setBoardfx(BoardFX boardfx) {
		this.boardfx = boardfx;
	}

	public Button getBtnEndTurn() {
		return btnEndTurn;
	}

	public void setBtnEndTurn(Button btnEndTurn) {
		this.btnEndTurn = btnEndTurn;
	}

	public Label getLblPointJ1() {
		return lblPointJ1;
	}

	public void setLblPointJ1(Label lblPointJ1) {
		this.lblPointJ1 = lblPointJ1;
	}

	public Label getLblPointJ2() {
		return lblPointJ2;
	}

	public void setLblPointJ2(Label lblPointJ2) {
		this.lblPointJ2 = lblPointJ2;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public AudioClip getMusique() {
		return musique;
	}

	public void setMusique(AudioClip musique) {
		this.musique = musique;
	}

	public RackFX getRackJ1() {
		return rackJ1;
	}

	public void setRackJ1(RackFX rackJ1) {
		this.rackJ1 = rackJ1;
	}

	public RackFX getRackJ2() {
		return rackJ2;
	}

	public void setRackJ2(RackFX rackJ2) {
		this.rackJ2 = rackJ2;
	}

	public HBox gethBrack() {
		return hBrack;
	}

	public void sethBrack(HBox hBrack) {
		this.hBrack = hBrack;
	}
	
}
