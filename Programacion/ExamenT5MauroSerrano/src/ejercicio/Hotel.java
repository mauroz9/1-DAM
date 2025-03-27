package ejercicio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Hotel {
	private List <Habitacion> listaHabitaciones;

	public Hotel(List<Habitacion> listaHabitaciones) {
		super();
		this.listaHabitaciones = listaHabitaciones;
	}

	public List<Habitacion> getListaHabitaciones() {
		return listaHabitaciones;
	}

	public void setListaHabitaciones(List<Habitacion> listaHabitaciones) {
		this.listaHabitaciones = listaHabitaciones;
	}

	@Override
	public String toString() {
		return "Hotel [listaHabitaciones=" + listaHabitaciones + "]";
	}
	
	public void agregarHabitacion(Habitacion h) {
		listaHabitaciones.add(h);
	}
	
	public boolean borrarHabitacion(Habitacion h) {
		boolean conseguido = false;
		
		if(h != null) {
			listaHabitaciones.remove(h);
			conseguido = true;
		}
		
		return conseguido;
	}
	
	public boolean modificarEstadoHab(Habitacion h) {
		boolean conseguido = false;
		
		if(h != null) {
			if(h.isOcupada()) {
				h.setOcupada(false);
			}else if(!h.isOcupada()) {
				h.setOcupada(true);
			}
			
			conseguido = true;
		}
		
		return conseguido;
	}
	
	public void imprimirLista() {
		Iterator <Habitacion> it = listaHabitaciones.iterator();
		
		while(it.hasNext()) {
			Habitacion h = it.next();
			System.out.println(h);
		}
	}
	
	public List <Habitacion> habitacionesOcupadas(){
		List <Habitacion> habOcupadas = new ArrayList <Habitacion> ();
		
		for(Habitacion h : listaHabitaciones) {
			if(h != null && h.isOcupada()) {
				habOcupadas.add(h);
			}
		}
		
		return habOcupadas;
	}
	
	public Habitacion buscarHabitacion(int num) {
		
		for(Habitacion h : listaHabitaciones) {
			if(h != null && h.getNumHab() == num) {
				return h;
			}
		}
		
		return null;
	}
	
	public double calcularGanancias() {
		double ganancias = 0;
		
		for(Habitacion h : habitacionesOcupadas()) {
			ganancias+=h.getPrecioBasico();
		}
		
		return ganancias;
	}
	
	public void mensajeAlerta(int num) {
		int habLibres = listaHabitaciones.size() - habitacionesOcupadas().size();
		
		if(habLibres <= num) {
			System.out.println("¡Cuidado, quedan " +habLibres+ " habitaciones libres!");
		}
		
	}
	
	public List <Habitacion> ordenarNombre(){
		List <Habitacion> listaOrdenada = new ArrayList <Habitacion> (listaHabitaciones);
		
		Collections.sort(listaOrdenada);
		
		return listaOrdenada;
	}
	
	public List <Habitacion> ordenarPrecio(){
		List <Habitacion> listaOrdenada = new ArrayList <Habitacion> (listaHabitaciones);
		
		Collections.sort(listaOrdenada, new CompararPorPrecio());
		
		return listaOrdenada;
	}
	
	public void imprimirListaBonito(List <Habitacion> lista){
		Iterator <Habitacion> it = lista.iterator();
		
		while(it.hasNext()) {
			Habitacion h = it.next();
			System.out.println(h);
		}
	}
	
}
