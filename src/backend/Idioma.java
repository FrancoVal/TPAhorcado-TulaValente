package backend;

public enum Idioma {
	ESPANIOL ("Espa�ol"), 
	INGLES ("Ingles"), 
	FRANCES ("Frances");
	
	private String nombre;
	
	
	private Idioma(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String nombre() {
		return this.nombre;
	}

}
