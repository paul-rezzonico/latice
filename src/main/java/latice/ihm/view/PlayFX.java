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
	private Button btnSkip; 
	private Label lblPointJ1;
	private Label lblPointJ2;
	private HBox rack;
	private Game game;
	
	private AudioClip musique;
	
	public PlayFX(Game game) {
		
		this.game = game;
		this.setCenter(new BoardFX(game.getBoard()));
		
		this.rack =  new HBox(40);
		this.rack.getChildren().addAll(new RackFX(game.getPlayer1().getRack()), new RackFX(game.getPlayer2().getRack()));
		this.rack.setAlignment(Pos.CENTER);
		this.rack.setMaxHeight(300);
		this.setBottom(rack);
		
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

	public Button getBtnSkip() {
		return btnSkip;
	}

	public void setBtnSkip(Button btnSkip) {
		this.btnSkip = btnSkip;
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

	public HBox getRack() {
		return rack;
	}

	public void setRack(HBox rack) {
		this.rack = rack;
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
}
