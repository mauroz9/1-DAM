package ejercicio;

public class EntradaNormal implements IDesglosable{
	private int zona;
	private int fila;
	private int asiento;
	
	public EntradaNormal(int zona, int fila, int asiento) {
		super();
		this.zona = zona;
		this.fila = fila;
		this.asiento = asiento;
	}

	public int getZona() {
		return zona;
	}

	public void setZona(int zona) {
		this.zona = zona;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getAsiento() {
		return asiento;
	}

	public void setAsiento(int asiento) {
		this.asiento = asiento;
	}

	@Override
	public String toString() {
		return "EntradaNormal [zona=" + zona + ", fila=" + fila + ", asiento=" + asiento + "]";
	}
	
	public double precioEntrada(double precio1, double precio2, int limiteDescuento, double porcentaje, double suplemento) {
		double precio=0;
		if(zona==1) {
			precio=precio1;
		}else if(zona==2){
			precio=precio2;
		}
		return precio;
	}
	
	@Override
	public double calcularIVA(double porcentaje, double precio1, double precio2, int limiteDescuento, double suplemento) {
		return precioEntrada(precio1, precio2, limiteDescuento, porcentaje, suplemento)*porcentaje/100;
	}
	
	
}
