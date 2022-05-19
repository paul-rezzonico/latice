package latice.model;

public enum Shape {
	LOGO("CaseDepart"),
	PENTACLE("pentacle"),
	EMPTY("vide");
	
	private String name;

	private Shape(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
