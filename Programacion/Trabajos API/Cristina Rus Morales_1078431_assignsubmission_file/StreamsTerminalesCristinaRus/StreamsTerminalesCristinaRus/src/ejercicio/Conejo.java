package ejercicio;

import java.time.LocalDate;

public class Conejo extends Animal{

	private boolean peloCorto;

	public boolean isPeloCorto() {
		return peloCorto;
	}

	public void setPeloCorto(boolean peloCorto) {
		this.peloCorto = peloCorto;
	}

	@Override
	public String toString() {
		return "Conejo [peloCorto=" + peloCorto + "]\n"+super.toString()+"\n";
	}

	public Conejo(String nombre, int edad, int numChip, double precioAdopcion, boolean disponible,
			LocalDate fechaIngreso, boolean peloCorto) {
		super(nombre, edad, numChip, precioAdopcion, disponible, fechaIngreso);
		this.peloCorto = peloCorto;
	}


	
	
	
	
	
}
