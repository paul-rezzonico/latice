package latice.model.tile;

public enum Color {
	RED("Rouge"),
	GREEN("Vert"),
	GREY("Gris"),
	YELLOW("Jaune"),
	PINK("Rose"),
	BLUE("Bleu");
	
	private String name;

	private Color(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
