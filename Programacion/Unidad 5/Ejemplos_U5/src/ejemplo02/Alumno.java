package ejemplo02;

public class Alumno {
	private String dni;
	private String nombre;
	private double notaMedia;
	
	public Alumno(String dni, String nombre, double notaMedia) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.notaMedia = notaMedia;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}

	@Override
	public String toString() {
		return "Alumo [dni=" + dni + ", nombre=" + nombre + ", notaMedia=" + notaMedia + "]";
	}
	
	
}
