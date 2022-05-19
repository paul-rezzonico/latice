package latice.ihm.view;

import java.util.ArrayList;
import java.util.Random;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import latice.ihm.controller.ExitController;
import latice.ihm.controller.PlayController;

public class MenuFX extends BorderPane {

	private Label title;
	private Label titleEdition;
	private VBox vBTop;

	private Button btnGame;
	private Button btnParameters;
	private Button btnExit;
	private VBox vBCenter;

	private BackgroundImage bck;
	private Random rdm = new Random();
	private AudioClip song;

	public MenuFX(Stage primaryStage) {

		this.title = new Label("Latice Game");
		this.title.setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 60));
		this.title.setTextFill(Color.DARKRED);

		this.titleEdition = new Label("High School DxD Edition");
		this.titleEdition.setFont(Font.font("Bernard MT Condensed", 50));
		this.titleEdition.setTextFill(Color.WHITE);

		this.vBTop = new VBox();
		this.vBTop.getChildren().addAll(title, titleEdition);
		this.vBTop.setAlignment(Pos.CENTER);
		this.vBTop.setPrefHeight(250);
		this.setTop(vBTop);

		this.btnGame = new Button("Jouer");
		this.btnGame.setFont(Font.font(32));
		this.btnGame.setPrefWidth(400);

		this.btnParameters = new Button("Paramètres");
		this.btnParameters.setFont(Font.font(32));
		this.btnParameters.setPrefWidth(400);

		this.btnExit = new Button("Quitter");
		this.btnExit.setFont(Font.font(32));
		this.btnExit.setPrefWidth(400);

		this.vBCenter = new VBox(10);
		this.vBCenter.getChildren().addAll(btnGame, btnParameters, btnExit);
		this.vBCenter.setAlignment(Pos.CENTER);
		this.setCenter(vBCenter);

		BackgroundSize backgroundSize = new BackgroundSize(100, 100, false, false, false, true);
		this.bck = new BackgroundImage(new Image("/Menu.png"), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, backgroundSize);
		this.setBackground(new Background(bck));

		this.song = listOfSong();
		this.song.play();

	}

	public AudioClip listOfSong() {
		
		ArrayList<AudioClip> audioList = new ArrayList<AudioClip>();
		audioList.add(new AudioClip(getClass().getResource("/music/MenuSong1.mp3").toExternalForm()));
		audioList.add(new AudioClip(getClass().getResource("/music/MenuSong2.mp3").toExternalForm()));
		audioList.add(new AudioClip(getClass().getResource("/music/MenuSong3.mp3").toExternalForm()));
		
		int nb = this.rdm.nextInt(3);
		
		AudioClip clip = audioList.get(nb);
		clip.setCycleCount(AudioClip.INDEFINITE);
		return clip;
	}

	public Label getTitle() {
		return title;
	}

	public void setTitle(Label title) {
		this.title = title;
	}

	public Label getTitleEdition() {
		return titleEdition;
	}

	public void setTitleEdition(Label titleEdition) {
		this.titleEdition = titleEdition;
	}

	public VBox getvBTop() {
		return vBTop;
	}

	public void setvBTop(VBox vBTop) {
		this.vBTop = vBTop;
	}

	public Button getBtnGame() {
		return btnGame;
	}

	public void setBtnGame(Button btnGame) {
		this.btnGame = btnGame;
	}

	public Button getBtnParameters() {
		return btnParameters;
	}

	public void setBtnParameters(Button btnParameters) {
		this.btnParameters = btnParameters;
	}

	public Button getBtnExit() {
		return btnExit;
	}

	public void setBtnExit(Button btnExit) {
		this.btnExit = btnExit;
	}

	public VBox getvBCenter() {
		return vBCenter;
	}

	public void setvBCenter(VBox vBCenter) {
		this.vBCenter = vBCenter;
	}

	public BackgroundImage getBck() {
		return bck;
	}

	public void setBck(BackgroundImage bck) {
		this.bck = bck;
	}

	public Random getRdm() {
		return rdm;
	}

	public void setRdm(Random rdm) {
		this.rdm = rdm;
	}

	public AudioClip getSong() {
		return song;
	}

	public void setSong(AudioClip song) {
		this.song = song;
	}
	
}
