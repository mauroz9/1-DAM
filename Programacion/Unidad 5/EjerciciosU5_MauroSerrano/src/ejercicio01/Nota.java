package ejercicio01;

public class Nota {
	private String titulo;
	private String contenido;
	private String fecha;
	
	public Nota(String titulo, String contenido, String fecha) {
		super();
		this.titulo = titulo;
		this.contenido = contenido;
		this.fecha = fecha;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Nota [titulo=" + titulo + ", contenido=" + contenido + ", fecha=" + fecha + "]";
	}
	
	
}
