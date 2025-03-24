package ejercicio02;

import java.util.Comparator;

public class CompararPorNombre implements Comparator<Socio>{

	@Override
	public int compare(Socio s1, Socio s2) {
		
		return (s1.getNombre().compareToIgnoreCase(s2.getNombre()));
	}
	
}
