package ejercicio;

import java.util.Comparator;

public class CompararPorPrecio implements Comparator <Habitacion>{

	@Override
	public int compare(Habitacion h1, Habitacion h2) {
		// TODO Auto-generated method stub
		return Double.compare(h1.getPrecioBasico(), h2.getPrecioBasico());
	}

	
}
