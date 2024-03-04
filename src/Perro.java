
public class Perro {

	//ATRIBUTOS
	
	private String nombrePerro;
	private int edadMeses;
	private String raza;
	private int puntaje;
	private String foto;
	
	public Perro() {
	}

	public Perro(String nombrePerro, int edadMeses, String raza, int puntaje, String foto) {
		super();
		this.nombrePerro = nombrePerro;
		this.edadMeses = edadMeses;
		this.raza = raza;
		this.puntaje = puntaje;
		this.foto = foto;
	}

	public String getNombrePerro() {
		return nombrePerro;
	}

	public void setNombrePerro(String nombrePerro) {
		this.nombrePerro = nombrePerro;
	}

	public int getEdadMeses() {
		return edadMeses;
	}

	public void setEdadMeses(int edadMeses) {
		this.edadMeses = edadMeses;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
}
