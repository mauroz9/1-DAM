package ejemplo_1;

public class Empleado extends Trabajador{
	
	private double sueldo;
	private double impuestos;
	
	public Empleado(String nombre, String puesto, double sueldo, double impuestos) {
		super(nombre, puesto);
		this.sueldo = sueldo;
		this.impuestos = impuestos;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public double getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(double impuestos) {
		this.impuestos = impuestos;
	}

	public String toString() {
		return super.toString()+"Empleado [sueldo=" + sueldo + ", impuestos=" + impuestos + "]";
	}
	
	public double calcularPaga(double base) {
		return super.calcularPaga(base)+sueldo-impuestos;
	}
}
