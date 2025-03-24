package ejercicio05;

public class Gerente extends Empleado{
	public double impuesto;

	public Gerente(String nombre, String apellido, double sueldoBase, int numeroEmpleado, double impuesto) {
		super(nombre, apellido, sueldoBase, numeroEmpleado);
		this.impuesto = impuesto;
	}

	public double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}

	@Override
	public String toString() {
		return super.toString()+"Gerente [impuesto=" + impuesto + "]";
	}

	@Override
	public double calcularSueldo(double topeVentas) {
		double cien=100;
		return super.calcularSueldo(topeVentas)-(super.calcularSueldo(topeVentas)*impuesto/cien);
	}
	
	
}
