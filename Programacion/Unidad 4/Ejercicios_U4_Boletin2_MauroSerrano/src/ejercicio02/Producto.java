package ejercicio02;

public class Producto implements IImpuesto{
	private double precio;

	public Producto(double precio) {
		super();
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [precio=" + precio + "]";
	}

	@Override
	public double calculoIva(int iva) {
		double cien=100;
		return precio*iva/cien;
	}

	@Override
	public double calculoIrpf(double irpf) {
		return 0;
	}
	
	public double calcularPVP(int iva) {
		return precio+10;
	}
	
}
