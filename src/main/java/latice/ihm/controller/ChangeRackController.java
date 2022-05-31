package latice.ihm.controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import latice.application.Game;

public class ChangeRackController implements EventHandler<MouseEvent>{

	@Override
	public void handle(MouseEvent event) {
		Game game = Game.getInstance();
		if(game.getPlayerTurn()) {
			game.getPlayer1().clearRack();
		} else {
			game.getPlayer2().clearRack();
		}
		game.endTurn();
		
	}

}
