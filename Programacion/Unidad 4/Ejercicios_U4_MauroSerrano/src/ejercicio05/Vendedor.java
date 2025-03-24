package ejercicio05;

public class Vendedor extends Empleado{
	private int cantidadVentas;
	private double incentivo;
	
	public Vendedor(String nombre, String apellido, double sueldoBase, int numeroEmpleado, int cantidadVentas,
			double incentivo) {
		super(nombre, apellido, sueldoBase, numeroEmpleado);
		this.cantidadVentas = cantidadVentas;
		this.incentivo = incentivo;
	}

	public int getCantidadVentas() {
		return cantidadVentas;
	}

	public void setCantidadVentas(int cantidadVentas) {
		this.cantidadVentas = cantidadVentas;
	}

	public double getIncentivo() {
		return incentivo;
	}

	public void setIncentivo(double incentivo) {
		this.incentivo = incentivo;
	}

	@Override
	public String toString() {
		return super.toString()+"Vendedor [cantidadVentas=" + cantidadVentas + ", incentivo=" + incentivo + "]";
	}
	
	public double calcularSueldo(double topeVentas) {
		double cien=100;
		return super.calcularSueldo(topeVentas)+(super.calcularSueldo(topeVentas)*incentivo/cien)*cantidadVentas;
	}
	
	public void comprobarVentas(double topeVentas) {
		if(cantidadVentas>=topeVentas) {
			System.out.printf("Felicidades por superar las %.2f ventas",topeVentas);
		}
	}
}
