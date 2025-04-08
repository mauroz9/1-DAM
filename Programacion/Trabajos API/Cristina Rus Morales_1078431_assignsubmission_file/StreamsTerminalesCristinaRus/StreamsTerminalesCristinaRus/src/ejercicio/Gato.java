package ejercicio;

import java.time.LocalDate;

public class Gato extends Animal{

	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Gato [color=" + color + "]\n"+super.toString()+"\n";
	}

	public Gato(String nombre, int edad, int numChip, double precioAdopcion, boolean disponible, LocalDate fechaIngreso,
			String color) {
		super(nombre, edad, numChip, precioAdopcion, disponible, fechaIngreso);
		this.color = color;
	}


	
	
	
}
