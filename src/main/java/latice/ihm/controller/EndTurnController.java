package latice.ihm.controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import latice.application.Game;

public class EndTurnController implements EventHandler<MouseEvent>{

	@Override
	public void handle(MouseEvent event) {
		Game game = Game.getInstance();
		game.endTurn();
	}
	
}