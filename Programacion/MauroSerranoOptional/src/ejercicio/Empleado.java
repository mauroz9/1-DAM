package ejercicio;

public class Empleado implements Comparable <Empleado>{
	private int id;
	private String nombre;
	private String departamento;
	private double salario;
	private int antiguedad;
	
	public Empleado(int id, String nombre, String departamento, double salario, int antiguedad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.departamento = departamento;
		this.salario = salario;
		this.antiguedad = antiguedad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", departamento=" + departamento + ", salario=" + salario
				+ ", antiguedad=" + antiguedad + "]";
	}

	@Override
	public int compareTo(Empleado e) {
		// TODO Auto-generated method stub
		return Integer.compare(this.id, e.id);
	}
	
	
}
