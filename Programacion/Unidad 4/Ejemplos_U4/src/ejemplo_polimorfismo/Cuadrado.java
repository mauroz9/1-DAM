package ejemplo_polimorfismo;

public class Cuadrado extends Figura{
	private double lado;

	public Cuadrado(String nombre, String color, double lado) {
		super(nombre, color);
		this.lado = lado;
	}

	public Cuadrado(String nombre, String color) {
		super(nombre, color);
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}
	
	public double calcularArea() {
		return lado*lado;
	}
	
	public double calcularPerimetro() {
		int cuatro=4;
		return lado*cuatro;
	}
	
	public void mostrarLados() {
		System.out.println("Solo estoy en la clase cuadrado porque los demás no tienen lados, en concreto tengo 4 lados");
	}

	@Override
	public String toString() {
		return super.toString()+"Cuadrado [lado=" + lado + "]";
	}
	
	
}
