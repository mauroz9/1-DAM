package ejercicio;

public class EntradaFamosos extends EntradaNormal{
	private String nombreFamoso;

	public EntradaFamosos(int zona, int fila, int asiento, String nombreFamoso) {
		super(zona, fila, asiento);
		this.nombreFamoso = nombreFamoso;
	}

	public String getNombreFamoso() {
		return nombreFamoso;
	}

	public void setNombreFamoso(String nombreFamoso) {
		this.nombreFamoso = nombreFamoso;
	}

	@Override
	public String toString() {
		return super.toString()+"EntradaFamosos [nombreFamoso=" + nombreFamoso + "]";
	}

	@Override
	public double precioEntrada(double precio1, double precio2, int limiteDescuento, double porcentaje, double suplemento) {
		return super.precioEntrada(precio1, precio2, limiteDescuento, porcentaje, suplemento)+suplemento;
	}

	@Override
	public double calcularIVA(double porcentaje, double precio1, double precio2, int limiteDescuento, double suplemento) {
		return super.calcularIVA(porcentaje, precio1, precio2, limiteDescuento, suplemento);
	}
	
	public void imprimirMensajeRegalo() {
		System.out.println("Por comprar la entrada edición Famoso le obsequiamos con una botella de champán y una foto firmada por "+nombreFamoso);
	}
	
	
}
