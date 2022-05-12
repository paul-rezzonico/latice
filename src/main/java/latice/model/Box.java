package latice.model;

public class Box {
    private Shape shape;
    private Tile tile;

    public Box(Shape shape, Tile tile) {
        this.shape = shape;
        this.tile = tile;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

	@Override
	public String toString() {
		return shape + " ";
	}
}