package ejercicio02;

public class Habitacion {
	
	private int id;
	private double precio;
	private double serviciosExtra;
	private String nombreCliente;
	private int diasContratados;
	private boolean ocupada;
	
	public Habitacion(int id, double precio, double serviciosExtra, String nombreCliente, int diasContratados,
			boolean ocupada) {
		this.id = id;
		this.precio = precio;
		this.serviciosExtra = serviciosExtra;
		this.nombreCliente = nombreCliente;
		this.diasContratados = diasContratados;
		this.ocupada = ocupada;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getServiciosExtra() {
		return serviciosExtra;
	}

	public void setServiciosExtra(double serviciosExtra) {
		this.serviciosExtra = serviciosExtra;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public int getDiasContratados() {
		return diasContratados;
	}

	public void setDiasContratados(int diasContratados) {
		this.diasContratados = diasContratados;
	}

	public boolean isOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

	@Override
	public String toString() {
		return "Habitacion [id=" + id + ", precio=" + precio + ", serviciosExtra=" + serviciosExtra + ", nombreCliente="
				+ nombreCliente + ", diasContratados=" + diasContratados + ", ocupada=" + ocupada + "]";
	}

	
}
