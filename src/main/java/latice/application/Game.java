package latice.application;

import java.util.ArrayList;
import java.util.Collections;

import latice.model.Color;
import latice.model.Symbol;
import latice.model.Tile;

public class Game {

	public static void main(String[] args) {
		
		launch();  
	}

	private static void launch() {
		
		ArrayList<Color> colorList = colorListCreation();
		ArrayList<Symbol> symbolList = symbolListCreation();
		ArrayList<Tile> tileList = new ArrayList<>();
		for (Color color : colorList) {
			for (Symbol symbol : symbolList) {
				tileList.add(new Tile(symbol,color));
				tileList.add(new Tile(symbol,color));
			}
		}
		suffleAndDistribute(tileList);
	}

	private static void suffleAndDistribute(ArrayList<Tile> tileList) {
		Collections.shuffle(tileList);
		ArrayList <Tile> tileListJ1 = new ArrayList<>();
		ArrayList <Tile> tileListJ2 = new ArrayList<>();
		for (int i = 0; i <  tileList.size() ;i++) {
			if (i<36) {
				tileListJ1.add(tileList.get(i));
			}else {
				tileListJ2.add(tileList.get(i));
			}
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
	
	private static ArrayList<Symbol> symbolListCreation() {
		ArrayList<Symbol> symbolList = new ArrayList<>();
		symbolList.add(Symbol.RIAS);
		symbolList.add(Symbol.AKENO);
		symbolList.add(Symbol.ASIA);
		symbolList.add(Symbol.IRINA);
		symbolList.add(Symbol.KONEKO);
		symbolList.add(Symbol.XENOVIA);
		return symbolList;
	}
	
	
}
