package ejercicio;

import java.util.Comparator;

public class CompararPorPrecio implements Comparator <Trastero>{

	@Override
	public int compare(Trastero t1, Trastero t2) {
		int comparacionPrecio = Double.compare(t1.getPrecio(), t2.getPrecio());
        if (comparacionPrecio != 0) {
            return comparacionPrecio;
        }
        return t1.getDireccion().compareTo(t2.getDireccion());
	}

}
