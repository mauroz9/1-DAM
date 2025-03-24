package ejercicio02;

public class Alimentacion extends Producto{
	private boolean refrigerado;

	public Alimentacion(double precio, boolean refrigerado) {
		super(precio);
		this.refrigerado = refrigerado;
	}

	public boolean isRefrigerado() {
		return refrigerado;
	}

	public void setRefrigerado(boolean refrigerado) {
		this.refrigerado = refrigerado;
	}

	@Override
	public String toString() {
		return "Alimentacion [refrigerado=" + refrigerado + "]";
	}

	@Override
	public double calcularPVP(int iva) {
		return super.calcularPVP(iva)+super.calculoIva(iva);
	}
	
	
}
