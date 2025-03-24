package ejercicio04;

public class Electronica extends Producto{
	private boolean lujo;

	public Electronica(double precioUnitario, String nombre, int id, boolean lujo) {
		super(precioUnitario, nombre, id);
		this.lujo = lujo;
	}

	public boolean isLujo() {
		return lujo;
	}

	public void setLujo(boolean lujo) {
		this.lujo = lujo;
	}

	@Override
	public String toString() {
		return "Electronica [lujo=" + lujo + "]";
	}

	public double calcularPVP(double iva, double descuento, int topeCaducidad) {
		double cien=100.0;
		double total=super.calcularPVP(iva, descuento, topeCaducidad);
		
		if(lujo) {
			total=total+total*descuento/cien;
		}
		
		return total;
	}
	
	
	
	
}
