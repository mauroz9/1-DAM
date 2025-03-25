package ejercicio04;

public class Contacto implements Comparable<Contacto>{
	private int id;
	private String nombre;
	private String apellido;
	private String telefono;
	
	public Contacto(int id, String nombre, String apellido, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Agenda [id=" + id + ",nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + "]";
	}

	@Override
	public int compareTo(Contacto o) {
		return nombre.compareTo(o.getNombre());
		
	}
	
	
}
