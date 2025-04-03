package ejercicio01;

public class Alumno {
	private String nombre;
	private String apellido;
	private String curso;
	private double notaMedia;
	private int edad;
	
	public Alumno(String nombre, String apellido, String curso, double notaMedia, int edad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.curso = curso;
		this.notaMedia = notaMedia;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", curso=" + curso + ", notaMedia=" + notaMedia
				+ ", edad=" + edad + "]";
	}
	
	
}
