package latice.model;

public enum Color {
	RED("Rouge"),
	GREEN("Vert"),
	GREY("Gris"),
	YELLOW("Jaune"),
	PINK("Rose"),
	BLUE("Bleu");
	
	private String color;

	private Color(String name) {
		this.color = name;
	}

	public String getColor() {
		return color;
	}

}
