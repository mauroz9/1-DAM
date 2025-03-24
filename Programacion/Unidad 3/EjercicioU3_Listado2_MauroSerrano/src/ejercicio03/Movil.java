package ejercicio03;

public class Movil {
	
	private String marca;
	private String modelo;
	private boolean vendido;
	private boolean segundaMano;
	private double precio;
	
	public Movil(String marca, String modelo, boolean vendido, boolean segundaMano, double precio) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.vendido = vendido;
		this.segundaMano = segundaMano;
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public boolean isVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}

	public boolean isSegundaMano() {
		return segundaMano;
	}

	public void setSegundaMano(boolean segundaMano) {
		this.segundaMano = segundaMano;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Movil [marca=" + marca + ", modelo=" + modelo + ", vendido=" + vendido + ", segundaMano=" + segundaMano
				+ ", precio=" + precio + "]";
	}
	
}
