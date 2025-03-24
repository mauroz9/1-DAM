package ejercicio01;

public class Ordenador {
	private double capacidadDisco;
	private double frecuenciaProce;
	private double precioBase;
	private String modelo;
	
	public Ordenador(double capacidadDisco, double frecuenciaProce, double precioBase, String modelo) {
		super();
		this.capacidadDisco = capacidadDisco;
		this.frecuenciaProce = frecuenciaProce;
		this.precioBase = precioBase;
		this.modelo = modelo;
	}

	public double getCapacidadDisco() {
		return capacidadDisco;
	}

	public void setCapacidadDisco(double capacidadDisco) {
		this.capacidadDisco = capacidadDisco;
	}

	public double getFrecuenciaProce() {
		return frecuenciaProce;
	}

	public void setFrecuenciaProce(double frecuenciaProce) {
		this.frecuenciaProce = frecuenciaProce;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String toString() {
		return "Ordenador [capacidadDisco=" + capacidadDisco + ", frecuenciaProce=" + frecuenciaProce + ", precioBase="
				+ precioBase + ", modelo=" + modelo + "]";
	}
	
	public double precioVenta(double porcentajeGanancia) {
		double pvp;
		double ganancia;
		double cien=100;
		
		ganancia=precioBase*porcentajeGanancia/cien;
		pvp=precioBase+ganancia;
		
		return pvp;
	}
	
	
}
