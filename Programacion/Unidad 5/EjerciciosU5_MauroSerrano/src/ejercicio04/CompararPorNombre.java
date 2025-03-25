package ejercicio04;

import java.util.Comparator;

public class CompararPorNombre implements Comparator<Contacto>{

	@Override
	public int compare(Contacto o1, Contacto o2) {
		return (o1.getNombre().compareToIgnoreCase(o2.getNombre()));
	}
	
}
