package ejemplocomparator;

import java.util.Comparator;

/*Para múltiples secuencias de ordeanción u orden no natural, 
 * se utiliza la interface Comparator.
 * Se debe crear una clase para  cada criterio de comparación 
 * y dicha clase debe implementar la interface Comparator y, por tanto, 
 * reescribir el método compare
 **/
public class ComparaPorMarca implements Comparator<Corredor> {

	// Comparamos 2 objetos tipo Corredor

	public int compare(Corredor c1, Corredor c2) {

		// Creamos las 2 variables tipo double (marca es double) 
		//que vamos a comparar, no haría falta
		double marcac1 = c1.getMarca();
		double marcac2 = c2.getMarca();

		// si el 1º es menor que el segundo devuelve -1, 
		//si es mayor 1 y si son iguales 0, consulta el API
		if (marcac1 < marcac2) {
			return -1;
		} else {
			if (marcac1 > marcac2) {
				return 1;
			}
			return 0;
		}
	}
}
