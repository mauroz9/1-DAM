package ejercicio01;

public class Portatil extends Ordenador{
	boolean seguro;
	double precioSeguro;
	
	public Portatil(double capacidadDisco, double frecuenciaProce, double precioBase, String modelo, boolean seguro,
			double precioSeguro) {
		super(capacidadDisco, frecuenciaProce, precioBase, modelo);
		this.seguro = seguro;
		this.precioSeguro = precioSeguro;
	}

	public boolean isSeguro() {
		return seguro;
	}

	public void setSeguro(boolean seguro) {
		this.seguro = seguro;
	}

	public double getPrecioSeguro() {
		return precioSeguro;
	}

	public void setPrecioSeguro(double precioSeguro) {
		this.precioSeguro = precioSeguro;
	}

	public String toString() {
		return super.toString()+"Portatil [seguro=" + seguro + ", precioSeguro=" + precioSeguro + "]";
	}
	
	public double precioVenta(double porcentajeGanancia) {
		if(seguro) {
			return super.precioVenta(porcentajeGanancia)+precioSeguro;
		}
		return super.precioVenta(porcentajeGanancia);
	}
	
}
