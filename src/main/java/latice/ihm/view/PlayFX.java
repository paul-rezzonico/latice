package latice.ihm.view;

import java.util.ArrayList;
import java.util.Random;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import latice.application.Game;

public class PlayFX extends BorderPane {

	private BoardFX boardfx;
	private Label lblPointJ1;
	private Label lblPointJ2;
	private Label tileInStackJ1;
	private Label tileInStackJ2;
	
	private RackFX rackJ1;
	private RackFX rackJ2;
	private HBox hBrack;
	
	private Label turn;
	private Button btnEndTurn;
	private Button btnChangeRack;
	private VBox vbBtn;
	
	private VBox hbptsJ1;
	private VBox hbptsJ2;
	
	private HBox hbRight; 
	private HBox hbLeft; 
	
	private AudioClip song;
	
	public PlayFX() {
		
		Game game = Game.getInstance();
		this.setCenter(new BoardFX(game.getBoard()));
		
		this.rackJ1 = new RackFX(game.getPlayer1().getRack());
		this.rackJ2 = new RackFX(game.getPlayer2().getRack());
		
		
		this.vbBtn = new VBox(15);
		
		this.turn = new Label("Tour " + game.getTurn());
		this.turn.setFont(Font.font("Times New Roman", 25));
		this.turn.setTextFill(Color.RED);
		this.turn.setPrefWidth(150);
		this.turn.setAlignment(Pos.CENTER);
		
		this.btnChangeRack = new Button("Changer le rack");
		this.btnChangeRack.setPrefWidth(150);
		this.btnChangeRack.setAlignment(Pos.CENTER);
		
		this.btnEndTurn = new Button("Finir le tour");
		this.btnEndTurn.setPrefWidth(150);
		this.btnEndTurn.setAlignment(Pos.CENTER);
		
		this.vbBtn.getChildren().addAll(turn, btnEndTurn, btnChangeRack);
		this.vbBtn.setAlignment(Pos.CENTER);
		
		this.hBrack =  new HBox(40);
		this.hBrack.getChildren().addAll(rackJ1, vbBtn, rackJ2);
		this.hBrack.setAlignment(Pos.CENTER);
		this.hBrack.setMaxHeight(300);
		this.hBrack.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, getInsets())));
		this.setBottom(hBrack);
		
		
		this.hbptsJ1 = new VBox(10);
		
		this.tileInStackJ1 = new Label(game.getPlayer1().getName() + ", il vous reste " + game.getPlayer1().getStack().size() + " tuiles dans votre stack ");
		this.tileInStackJ1.setAlignment(Pos.CENTER);
		this.tileInStackJ1.setFont(Font.font("System", 12));
		this.tileInStackJ1.setTextFill(Color.RED);
		
		this.lblPointJ1 = new Label("Vous avez actuellement " + game.getPlayer1().getPoint() + " points");
		this.lblPointJ1.setAlignment(Pos.CENTER);
		this.lblPointJ1.setFont(Font.font("System", 12));
		this.lblPointJ1.setTextFill(Color.WHITE);
		
		this.hbLeft = new HBox();
		this.hbptsJ1.getChildren().addAll(lblPointJ1, tileInStackJ1);
		this.hbptsJ1.setPrefSize(300, 100);
		this.hbptsJ1.setMaxHeight(200);
		this.hbptsJ1.setBackground(new Background(new BackgroundFill(Color.BLACK, null, getInsets())));
		this.hbptsJ1.setAlignment(Pos.CENTER);
		this.hbLeft.getChildren().add(hbptsJ1);
		this.hbLeft.setPadding(new Insets(50, 50, 50, 50));
		this.setLeft(hbLeft);
		
		
		this.hbRight = new HBox();
		this.hbptsJ2 = new VBox(10);
		
		this.tileInStackJ2 = new Label(game.getPlayer2().getName() + ", il vous reste " + game.getPlayer2().getStack().size() + " tuiles dans votre stack ");
		this.tileInStackJ2.setAlignment(Pos.CENTER);
		this.tileInStackJ2.setFont(Font.font("System", 12));
		this.tileInStackJ2.setTextFill(Color.RED);
		
		this.lblPointJ2 = new Label("Vous avez actuellement " + game.getPlayer2().getPoint() + " points");
		this.lblPointJ2.setAlignment(Pos.CENTER);
		this.lblPointJ2.setFont(Font.font("System", 12));
		this.lblPointJ2.setTextFill(Color.WHITE);
		
		this.hbptsJ2.getChildren().addAll(lblPointJ2, tileInStackJ2);
		this.hbptsJ2.setPrefSize(300, 100);
		this.hbptsJ2.setMaxHeight(200);
		this.hbptsJ2.setBackground(new Background(new BackgroundFill(Color.BLACK, null, getInsets())));
		this.hbptsJ2.setAlignment(Pos.CENTER);
		this.hbRight.getChildren().add(hbptsJ2);
		this.hbRight.setPadding(new Insets(50, 50, 50, 50));
		this.setRight(hbRight);
		
		BackgroundSize backgroundSize = new BackgroundSize(100, 100, false, false, false, true);
		BackgroundImage bck  = new BackgroundImage(new Image("/Fond.png"), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, backgroundSize);
		this.setBackground(new Background(bck));
		
		this.song = listOfSong();
		this.song.play(0.1);
	}
	
	public AudioClip listOfSong() {
		
		ArrayList<AudioClip> audioList = new ArrayList<>();
		audioList.add(new AudioClip(getClass().getResource("/music/AmbianceMusic1.mp3").toExternalForm()));
		audioList.add(new AudioClip(getClass().getResource("/music/AmbianceMusic2.mp3").toExternalForm()));
		
		int nb = new Random().nextInt(2);
		
		AudioClip clip = audioList.get(nb);
		clip.setCycleCount(AudioClip.INDEFINITE);
		return clip;
	}

	public VBox getVbBtn() {
		return vbBtn;
	}

	public AudioClip getSong() {
		return song;
	}

	public void setSong(AudioClip song) {
		this.song = song;
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
