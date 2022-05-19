package latice.model;

public enum Symbol {
	RIAS("Rias"),
	AKENO("Akeno"),
	XENOVIA("Xenovia"), 
	IRINA("Irina"), 
	KONEKO("Koneko"),
	ASIA("Asia");

	private String name;

	private Symbol(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
