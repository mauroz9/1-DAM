package ejemplo01;

public class Producto {
	private String nombre;
	private double precioBase;
	private boolean refrigerado;
	
	public Producto(String nombre, double precioBase, boolean refrigerado) {
		super();
		this.nombre = nombre;
		this.precioBase = precioBase;
		this.refrigerado = refrigerado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	public boolean isRefrigerado() {
		return refrigerado;
	}

	public void setRefrigerado(boolean refrigerado) {
		this.refrigerado = refrigerado;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precioBase=" + precioBase + ", refrigerado=" + refrigerado + "]";
	}
	
	
}
