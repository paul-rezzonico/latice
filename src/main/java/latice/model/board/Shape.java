package latice.model.board;

public enum Shape {
	LOGO("CaseDepart"),
	PENTACLE("Pentacle"),
	EMPTY("Vide");
	
	private String name;

	private Shape(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
