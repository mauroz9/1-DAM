package ejercicio02;

public class Socio implements Comparable <Socio> {
	private String nombre;
	private String apellido;
	private String telefono;
	private int numsocio;
	
	public Socio(String nombre, String apellido, String telefono, int numsocio) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.numsocio = numsocio;
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

	public String gettelefono() {
		return telefono;
	}

	public void settelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getNumsocio() {
		return numsocio;
	}

	public void setNumsocio(int numsocio) {
		this.numsocio = numsocio;
	}

	@Override
	public int compareTo(Socio o) {
		
		if(this.numsocio > o.numsocio) {
			return 1;
		}else if(this.numsocio < o.numsocio) {
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Socio [nombre=" + nombre + ", apellido=" + apellido + ", teléfono=" + telefono + ", numsocio=" + numsocio + "]";
	}
	
	
}
