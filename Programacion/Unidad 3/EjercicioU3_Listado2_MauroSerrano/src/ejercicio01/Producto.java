package ejercicio01;

public class Producto {
	
	private int id;
	private double precioFab;
	private String nombre;
	private boolean fragil;
	private int seccion;
	
	public Producto(int id, double precioFab, String nombre, boolean fragil, int seccion) {
		this.id = id;
		this.precioFab = precioFab;
		this.nombre = nombre;
		this.fragil = fragil;
		this.seccion = seccion;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrecioFab() {
		return precioFab;
	}
	public void setPrecioFab(double precioFab) {
		this.precioFab = precioFab;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isFragil() {
		return fragil;
	}
	public void setFragil(boolean fragil) {
		this.fragil = fragil;
	}
	public int getSeccion() {
		return seccion;
	}
	public void setSeccion(int seccion) {
		this.seccion = seccion;
	}
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", precioFab=" + precioFab + ", nombre=" + nombre + ", fragil=" + fragil
				+ ", seccion=" + seccion + "]";
	}
	
	public double calcularPrecioCoste(double transporte) {
		double div=100;
		precioFab+=precioFab*transporte/div;
		return precioFab;
	}
}
