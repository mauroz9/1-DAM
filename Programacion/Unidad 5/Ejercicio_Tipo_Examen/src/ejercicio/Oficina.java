package ejercicio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Oficina {
	private List <Trastero> listaTrasteros = new ArrayList <Trastero> ();

	public Oficina(List<Trastero> listaTrasteros) {
		super();
		this.listaTrasteros = listaTrasteros;
	}

	public List<Trastero> getListaTrasteros() {
		return listaTrasteros;
	}

	public void setListaTrasteros(List<Trastero> listaTrasteros) {
		this.listaTrasteros = listaTrasteros;
	}

	@Override
	public String toString() {
		return "Oficina [listaTrasteros=" + listaTrasteros + "]";
	}
	
	public void anadirTrastero(Trastero t) {
		listaTrasteros.add(t);
	}
	
	public List <Trastero> buscarTrasteroPrecio(double precio) {
		List <Trastero> trasterosBuscados = new ArrayList <Trastero>();
		
		for(Trastero t : listaTrasteros) {
			if(t.getPrecio() == precio) {
				trasterosBuscados.add(t);
			}
		}
		
		return trasterosBuscados;
	}
	
	public Trastero buscarTrasteroNumero(int num) {
		Trastero trasteroBuscado = null;
		
		for(Trastero t : listaTrasteros) {
			if(t.getNumRas() == num) {
				trasteroBuscado = t;
				return trasteroBuscado;
			}
		}
		return trasteroBuscado;
	}
	
	public double buscarPrecioMayor() {
		double precio = 0;
		
		for(int i = 0; i < listaTrasteros.size(); i++) {
			if(listaTrasteros.get(i).getPrecio() > precio) {
				precio = listaTrasteros.get(i).getPrecio();
			}
		}
		
		return precio;
	}
	
	public boolean eliminarTrastero(Trastero t) {
		boolean conseguido = false;
		
		if(t != null) {
			listaTrasteros.remove(t);
			conseguido = true;
		}
		
		return conseguido;
	}
	
	public boolean modificarPrecio(Trastero t, double precio) {
		boolean conseguido = false;
		
		if(t != null) {
			t.setPrecio(precio); 
			conseguido = true;
		}
		
		return conseguido;
	}
	
	public List <Trastero> ordenarNumero(){
		List <Trastero> listaOrdenada = new ArrayList <Trastero>(listaTrasteros);
		Collections.sort(listaOrdenada);
		return listaOrdenada;
	}
	
	public List <Trastero> ordenarPrecio(){
		List <Trastero> listaOrdenada = new ArrayList <Trastero>(listaTrasteros);
		Collections.sort(listaOrdenada, new CompararPorPrecio());
		return listaOrdenada;
	}
	
	public List <Trastero> listaLibres(){
		List <Trastero> listaLibres = new ArrayList <Trastero>();
		
		for(Trastero t : listaTrasteros) {
			if(t.isLibre()) {
				listaLibres.add(t);
			}
		}
		return listaLibres;
	}
}
