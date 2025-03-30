package ejercicio;

import java.util.Comparator;

public class CompararPorAntigüedad implements Comparator <Empleado>{

	@Override
	public int compare(Empleado e1, Empleado e2) {
		// TODO Auto-generated method stub
		return -Double.compare(e1.getAntiguedad(), e2.getAntiguedad());
	}
	
}
