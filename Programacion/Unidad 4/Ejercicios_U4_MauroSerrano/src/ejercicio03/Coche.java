package ejercicio03;

public class Coche extends Vehiculo{
	private double potencia;

	public Coche(int categoriaEmisiones, double potencia) {
		super(categoriaEmisiones);
		this.potencia = potencia;
	}

	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

	@Override
	public String toString() {
		return "Coche [potencia=" + potencia + "]";
	}
	
	public double calcularImpuesto() {
		double porcentaje=25.0;
		double cien=100.0;
		
		return super.calcularImpuesto()+(potencia*porcentaje/cien);
	}
}
