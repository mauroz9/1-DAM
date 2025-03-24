package ejercicio05;

public class Empleado {
	private String nombre;
	private String apellido;
	private double sueldoBase;
	private int numeroEmpleado;
	
	public Empleado(String nombre, String apellido, double sueldoBase, int numeroEmpleado) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.sueldoBase = sueldoBase;
		this.numeroEmpleado = numeroEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public int getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNumeroEmpleado(int numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", apellido=" + apellido + ", sueldoBase=" + sueldoBase
				+ ", numeroEmpleado=" + numeroEmpleado + "]";
	}
	
	public double calcularSueldo(double topeVentas) {
		return sueldoBase;
	}
}
