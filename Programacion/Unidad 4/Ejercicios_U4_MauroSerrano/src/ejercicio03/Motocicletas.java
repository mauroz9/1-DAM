package ejercicio03;

public class Motocicletas extends Vehiculo{
	private double cilindrada;

	public Motocicletas(int categoriaEmisiones, double cilindrada) {
		super(categoriaEmisiones);
		this.cilindrada = cilindrada;
	}

	public double getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(double cilindrada) {
		this.cilindrada = cilindrada;
	}

	@Override
	public String toString() {
		return "Motocicletas [cilindrada=" + cilindrada + "]";
	}
	
	public double calcularImpuesto() {
		double porcentaje=60.0;
		double cien=100.0;
		
		return super.calcularImpuesto()+(cilindrada*porcentaje/cien);
	}
}
