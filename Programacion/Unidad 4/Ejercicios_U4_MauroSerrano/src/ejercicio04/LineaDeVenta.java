package ejercicio04;

public class LineaDeVenta {
	private Producto p;
	private int cantidad;
	
	public LineaDeVenta(Producto p, int cantidad) {
		super();
		this.p = p;
		this.cantidad = cantidad;
	}

	public Producto getP() {
		return p;
	}

	public void setP(Producto p) {
		this.p = p;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "LineaDeVenta [p=" + p + ", cantidad=" + cantidad + "]";
	}
	
	public double calcularImporte(double iva, double descuento, int topeCaducidad){
		return p.calcularPVP(iva, descuento, topeCaducidad)*cantidad;
	}
}
