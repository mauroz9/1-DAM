package ejercicio03;

public class Vehiculo {
	private int categoriaEmisiones;
	private double[] impuestoBase = {20.0, 50.0, 100.0, 150.0};

	public Vehiculo(int categoriaEmisiones) {
		super();
		this.categoriaEmisiones = categoriaEmisiones;
	}

	public int getCategoriaEmisiones() {
		return categoriaEmisiones;
	}

	public void setCategoriaEmisiones(int categoriaEmisiones) {
		this.categoriaEmisiones = categoriaEmisiones;
	}

	@Override
	public String toString() {
		return "Vehiculo [categoriaEmisiones=" + categoriaEmisiones + "]";
	}
	
	public double calcularImpuesto() {
		return impuestoBase[categoriaEmisiones-1];
	}
}
