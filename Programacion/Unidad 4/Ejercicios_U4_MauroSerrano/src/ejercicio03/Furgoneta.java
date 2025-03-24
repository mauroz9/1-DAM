package ejercicio03;

public class Furgoneta extends Vehiculo{
	private double impuestoFurgo=75.0;

	public Furgoneta(int categoriaEmisiones) {
		super(categoriaEmisiones);
	}

	public double getImpuestoFurgo() {
		return impuestoFurgo;
	}

	public void setImpuestoFurgo(double impuestoFurgo) {
		this.impuestoFurgo = impuestoFurgo;
	}

	@Override
	public String toString() {
		return "Furgoneta [impuestoFurgo=" + impuestoFurgo + "]";
	}
	
	public double calcularImpuesto() {
		return super.calcularImpuesto()+impuestoFurgo;
	}
}
