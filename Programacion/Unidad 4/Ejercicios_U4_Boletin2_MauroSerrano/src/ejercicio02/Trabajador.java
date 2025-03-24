package ejercicio02;

public class Trabajador implements IImpuesto{
	public double sueldo;

	public Trabajador(double sueldo) {
		super();
		this.sueldo = sueldo;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "Trabajador [sueldo=" + sueldo + "]";
	}

	@Override
	public double calculoIva(int iva) {
		return 0;
	}

	@Override
	public double calculoIrpf(double irpf) {
		double cien=100;
		return sueldo*irpf/cien;
	}
	
	
}
