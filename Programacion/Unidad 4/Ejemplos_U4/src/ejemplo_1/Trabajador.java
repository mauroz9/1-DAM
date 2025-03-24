package ejemplo_1;

public class Trabajador {
	private String nombre;
	private String puesto;
	
	public Trabajador(String nombre, String puesto) {
		super();
		this.nombre = nombre;
		this.puesto = puesto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	
	public String toString() {
		return "Trabajador [nombre=" + nombre + ", puesto=" + puesto + "]";
	}
	
	public double calcularPaga (double base) {
		double total;
		
		total=base*200;
		total=total+350-10;
		total=total-total*20/100;
		
		return total;
	}
}
