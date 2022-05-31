package latice.model;

public class Box {
    private final Shape shape;
    private Tile tile;

    public Box(Shape shape, Tile tile) {
        this.shape = shape;
        this.tile = tile;
    }

    public Shape getShape() {
        return shape;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

	@Override
	public String toString() {
		return this.shape.getName();
	}
}