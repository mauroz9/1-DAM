package ejercicio01;

public class Sobremesa extends Ordenador{
	private double precioMontaje;

	public Sobremesa(double capacidadDisco, double frecuenciaProce, double precioBase, String modelo,
			double precioMontaje) {
		super(capacidadDisco, frecuenciaProce, precioBase, modelo);
		this.precioMontaje = precioMontaje;
	}

	public double getPrecioMontaje() {
		return precioMontaje;
	}

	public void setPrecioMontaje(double precioMontaje) {
		this.precioMontaje = precioMontaje;
	}

	public String toString() {
		return super.toString()+"Sobremesa [precioMontaje=" + precioMontaje + "]";
	}
	
	public double precioVenta(double porcentajeGanancia) {
		return super.precioVenta(porcentajeGanancia)+precioMontaje;
	}
	
}
