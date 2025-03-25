package ejecicioChatGPT;

import java.util.Comparator;

public class CompararPorAno implements Comparator <Libro>{

	@Override
	public int compare(Libro o1, Libro o2) {
		return Integer.compare(o1.getAnoPubli(), o2.getAnoPubli());
	}
	
}	
