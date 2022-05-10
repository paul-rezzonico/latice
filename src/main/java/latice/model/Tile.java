package latice.model;

public class Tile {
	private Symbol symbol;
	private Color color;

	public Tile(Symbol symbol, Color color) {
		this.symbol = symbol;
		this.color = color;
	}

	public Symbol getSymbol() {
		return symbol;
	}

	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return symbol + " "+ color ;
	}
	
}
