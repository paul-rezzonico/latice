package latice.model;

public class Tile {
	private final Symbol symbol;
	private final Color color;

	public Tile(Symbol symbol, Color color) {
		this.symbol = symbol;
		this.color = color;
	}

	public Symbol getSymbol() {
		return symbol;
	}

	public Color getColor() {
		return color;
	}

	@Override
	public String toString() {
		return this.symbol.getName() + this.color.getName();
	}
	
}
