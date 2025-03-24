package ejemplo04;

import java.util.Map;
import java.util.Set;

public class Secretaria {
	private Map <Integer, Alumno> listado;

	public Secretaria(Map<Integer, Alumno> listado) {
		super();
		this.listado = listado;
	}

	public Map<Integer, Alumno> getListado() {
		return listado;
	}

	public void setListado(Map<Integer, Alumno> listado) {
		this.listado = listado;
	}

	@Override
	public String toString() {
		return "Secretaria [listado=" + listado + "]";
	}
	
	
}
