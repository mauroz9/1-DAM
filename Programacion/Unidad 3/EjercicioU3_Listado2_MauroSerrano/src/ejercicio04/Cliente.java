package ejercicio04;

public class Cliente {
	
	private String dni;
	private String nombre;
	private String apellido;
	private boolean activo;
	private double peso;
	private double altura;
	
	public Cliente(String dni, String nombre, String apellido, boolean activo, double peso, double altura) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.activo = activo;
		this.peso = peso;
		this.altura = altura;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", activo=" + activo
				+ ", peso=" + peso + ", altura=" + altura + "]";
	}
	
	public double calcularIMC() {
		double indice=2;
		return peso/Math.pow(altura, indice);
	}
}
