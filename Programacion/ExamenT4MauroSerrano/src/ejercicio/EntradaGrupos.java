package ejercicio;

public class EntradaGrupos extends EntradaNormal{
	private int numeroPersonas;

	public EntradaGrupos(int zona, int fila, int asiento, int numeroPersonas) {
		super(zona, fila, asiento);
		this.numeroPersonas = numeroPersonas;
	}

	public int getNumeroPersonas() {
		return numeroPersonas;
	}

	public void setNumeroPersonas(int numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}

	@Override
	public String toString() {
		return super.toString()+"EntradaGrupos [numeroPersonas=" + numeroPersonas + "]";
	}

	@Override
	public double precioEntrada(double precio1, double precio2, int limiteDescuento, double porcentaje, double suplemento) {
		double precioGrupo=0;
		
		if(numeroPersonas>limiteDescuento) {
			precioGrupo=(super.precioEntrada(precio1, precio2, limiteDescuento, porcentaje, suplemento)-super.precioEntrada(precio1, precio2, limiteDescuento, porcentaje, suplemento)*porcentaje/100)*numeroPersonas;
		}else {
			precioGrupo=super.precioEntrada(precio1, precio2, limiteDescuento, porcentaje, suplemento)*numeroPersonas;
		}
		
		return precioGrupo;
	}

	@Override
	public double calcularIVA(double porcentaje, double precio1, double precio2, int limiteDescuento, double suplemento) {
		// TODO Auto-generated method stub
		return super.calcularIVA(porcentaje, precio1, precio2, limiteDescuento, suplemento);
	}
	
	
}
