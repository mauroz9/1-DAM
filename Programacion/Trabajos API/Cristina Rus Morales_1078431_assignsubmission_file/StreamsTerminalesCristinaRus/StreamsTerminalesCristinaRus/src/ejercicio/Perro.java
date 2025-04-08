package ejercicio;

import java.time.LocalDate;

public class Perro extends Animal{

	private double peso;

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Perro [peso=" + peso + "]\n"+super.toString()+"\n";
	}

	public Perro(String nombre, int edad, int numChip, double precioAdopcion, boolean disponible,
			LocalDate fechaIngreso, double peso) {
		super(nombre, edad, numChip, precioAdopcion, disponible, fechaIngreso);
		this.peso = peso;
	}


	
	
}
