package ejercicio04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Agenda {
	private Map<Integer, Contacto> listaContactos;

	public Agenda(Map<Integer, Contacto> listaContactos) {
		super();
		this.listaContactos = listaContactos;
	}

	public Map<Integer, Contacto> getListaContactos() {
		return listaContactos;
	}

	public void setListaContactos(Map<Integer, Contacto> listaContactos) {
		this.listaContactos = listaContactos;
	}

	@Override
	public String toString() {
		return "Agenda [listaContactos=" + listaContactos + "]";
	}
	
	public void agregar(Integer i, Contacto c) {
		listaContactos.put(i, c);
	}
	
	public Map<Integer, Contacto> ordenadorClave(){
		Map<Integer, Contacto> auxi = new TreeMap <Integer, Contacto>(listaContactos);
		return auxi;
		
	}
	
	public Contacto buscarContactoId(int id) {
		return listaContactos.get(id);
	}
	
	public List<Contacto> buscarContactoNombre(String nombre) {
		List <Contacto> contactosBuscados = new ArrayList <Contacto>();
		for(Contacto c: listaContactos.values()) {
			if(c.getNombre().equals(nombre)) {
				contactosBuscados.add(c);
			}		
		}
		return contactosBuscados;
	}
	
	public List<Contacto> ordenarPorNombre(){
		List<Contacto> listaOrdenada = new ArrayList<Contacto>();
		
		for(Contacto c: listaContactos.values()) {
			listaOrdenada.add(c);
		}
		
		return listaOrdenada;	
	}
	
	public Map<Contacto,Integer> ordenarPorNombreV2() {
        Map<Contacto,Integer> listaOrdenar = new TreeMap<>();
        for (Map.Entry<Integer, Contacto> par : listaContactos.entrySet()) {
            System.out.println(par);
            listaOrdenar.put(par.getValue(),par.getKey());
        }
        return listaOrdenar;
    }
}
