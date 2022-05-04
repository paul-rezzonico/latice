package latice.application;

import java.util.ArrayList;

import latice.model.Color;

public class Game {

	public static void main(String[] args) {
		
		launch();  

	}

	private static void launch() {
		
		ArrayList<Color> colorList = colorListCreation();
		for (Color color : colorList) {
			//TODO rajouter les instanciations
		}
	}

	private static ArrayList<Color> colorListCreation() {
		ArrayList<Color> colorList = new ArrayList<>();
		colorList.add(Color.RED);
		colorList.add(Color.BLUE);
		colorList.add(Color.GREEN);
		colorList.add( Color.GREY);
		colorList.add(Color.PINK);
		colorList.add(Color.YELLOW);
		return colorList;
	}

}
