package latice.ihm.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import latice.application.Game;

public class PlayFX extends BorderPane {

	private BoardFX boardfx;
	private Label lblPointJ1;
	private Label lblPointJ2;
	private Label tileInStackJ1;
	private Label tileInStackJ2;
	private Label turn;
	private RackFX rackJ1;
	private RackFX rackJ2;
	private HBox hBrack;
	private Game game;
	private Button btnEndTurn;
	private Button btnChangeRack;
	
	private VBox hbptsJ1;
	private VBox hbptsJ2;
	private VBox vbBtn;
	
	private AudioClip musique;
	
	public PlayFX() {
		
		Game game = Game.getInstance();
		this.setCenter(new BoardFX(game.getBoard()));
		
		this.rackJ1 = new RackFX(game.getPlayer1().getRack());
		this.rackJ2 = new RackFX(game.getPlayer2().getRack());
		this.hBrack =  new HBox(40);
		
		this.vbBtn = new VBox(15);
		
		this.btnChangeRack = new Button("Changer le rack");
		this.btnChangeRack.setPrefWidth(150);
		this.btnChangeRack.setAlignment(Pos.CENTER);
		this.btnEndTurn = new Button("Finir le tour");
		this.btnEndTurn.setPrefWidth(150);
		this.btnEndTurn.setAlignment(Pos.CENTER);
		this.vbBtn.getChildren().addAll(btnEndTurn, btnChangeRack);
		this.vbBtn.setAlignment(Pos.CENTER);
		
		this.hBrack.getChildren().addAll(rackJ1, vbBtn, rackJ2);
		this.hBrack.setAlignment(Pos.CENTER);
		this.hBrack.setMaxHeight(300);
		this.hBrack.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, getInsets())));
		this.setBottom(hBrack);
		
		this.hbptsJ1 = new VBox(10);
		
		this.tileInStackJ1 = new Label("Il reste : " + game.getPlayer1().getStack().size() + " tuile dans votre stack ");
		this.lblPointJ1 = new Label("Vous avez actuellement " + game.getPlayer1().getPoint() + " points");
		this.lblPointJ1.setMaxWidth(200);
		this.lblPointJ1.setAlignment(Pos.CENTER);
		this.lblPointJ1.setTextAlignment(TextAlignment.CENTER);
		this.lblPointJ1.setPadding(new Insets(20, 20, 20, 20));
		
		this.turn = new Label("Tour : " + game.getTurn());
		
		this.hbptsJ1.getChildren().addAll(lblPointJ1, tileInStackJ1, turn);
		
		this.hbptsJ2 = new VBox(10);
		
		this.tileInStackJ2 = new Label("Il reste : " + game.getPlayer2().getStack().size() + " tuile dans votre stack ");
		this.lblPointJ2 = new Label("Vous avez actuellement " + game.getPlayer2().getPoint() + " points");
		this.lblPointJ2.setMaxWidth(200);
		this.lblPointJ2.setAlignment(Pos.CENTER);
		this.lblPointJ2.setTextAlignment(TextAlignment.CENTER);
		this.lblPointJ2.setPadding(new Insets(20, 20, 20, 20));
		this.hbptsJ2.getChildren().addAll(lblPointJ2, tileInStackJ2);
		
		this.setLeft(hbptsJ1);
		this.setRight(hbptsJ2);
		
		BackgroundSize backgroundSize = new BackgroundSize(100, 100, false, false, false, true);
		BackgroundImage bck  = new BackgroundImage(new Image("/Fond.png"), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, backgroundSize);
		this.setBackground(new Background(bck));
		
	}

	public Label getTurn() {
		return turn;
	}


	public void setTurn(Label turn) {
		this.turn = turn;
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

	public Label getTileInStackJ1() {
		return tileInStackJ1;
	}

	public void setTileInStackJ1(Label tileInStackJ1) {
		this.tileInStackJ1 = tileInStackJ1;
	}

	public Label getTileInStackJ2() {
		return tileInStackJ2;
	}

	public void setTileInStackJ2(Label tileInStackJ2) {
		this.tileInStackJ2 = tileInStackJ2;
	}

	public VBox getHbptsJ1() {
		return hbptsJ1;
	}

	public void setHbptsJ1(VBox hbptsJ1) {
		this.hbptsJ1 = hbptsJ1;
	}

	public VBox getHbptsJ2() {
		return hbptsJ2;
	}

	public void setHbptsJ2(VBox hbptsJ2) {
		this.hbptsJ2 = hbptsJ2;
	}

	public Button getBtnChangeRack() {
		return btnChangeRack;
	}

	public void setBtnChangeRack(Button btnChangeRack) {
		this.btnChangeRack = btnChangeRack;
	}
	
}
