package ejemplocomparator;

import java.util.Comparator;

/*Para múltiples secuencias de ordeanción u orden no natural, 
 * se utiliza la interface Comparator.
 * Se debe crear una clase para  cada criterio de comparación, 
 * dicha clase debe implementar la interface y, por tanto, 
 * reescribir el método compare, en este caso, por ejemplo, 
 * orden inverso a albaféticamente
 **/
public class ComparaPorNombre implements Comparator <Corredor>{	
	
	public int compare (Corredor c1, Corredor c2) {
		
		//Creamos las 2 variables tipo cadena 
		//(porque nombre es String) que vamos a comparar
		
		String nombrec1 = c1.getNombre();
		String nombrec2= c2.getNombre();
		
		//El método retorna el int que devuelve la comparación 
		//del primero con el segundo
		//El metodo toLowerCase nos devuelve la cadena en minúsculas
		//El metodo compareTo es para comparar cadenas 
		//de manera natural, es decir, lexicográficamente
		
		return (nombrec1.toLowerCase().compareTo(nombrec2.toLowerCase()));
		
	}
	

	
	
}
