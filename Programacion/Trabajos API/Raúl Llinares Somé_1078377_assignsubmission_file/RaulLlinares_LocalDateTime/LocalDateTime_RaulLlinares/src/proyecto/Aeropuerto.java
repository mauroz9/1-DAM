package proyecto;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
public class Aeropuerto {
	private List<Vuelo> listaVuelos;
	public Aeropuerto(List<Vuelo> listaVuelos) {
		super();
		this.listaVuelos = listaVuelos;
	}
	public List<Vuelo> getListaVuelos() {
		return listaVuelos;
	}
	public void setListaVuelos(List<Vuelo> listaVuelos) {
		this.listaVuelos = listaVuelos;
	}
	@Override
	public String toString() {
		return "Aeropuerto [listaVuelos=" + listaVuelos + "]";
	}
	
	//Buscar por id
	public Vuelo buscarVueloPorId(int id){
		for (Vuelo v : listaVuelos) {
			if(v.getId()==id) {
				return v;
			}
		}		
		return null;
	}
	
	//Buscar por rango de fecha (Raúl opción 3)
	public List<Vuelo> buscarPorHora(LocalDateTime h){
		List<Vuelo> nuevaLista = new ArrayList<Vuelo>();
		
		for (Vuelo v : listaVuelos) {
			if(h.isBefore(v.getT()) || h.isEqual(v.getT())) {
				nuevaLista.add(v);
			}
		}
		
		return nuevaLista;
	}
	
	//Calcular a qué hora llegaré a mi destino
	public LocalDateTime calcularHoraLlegada (int id) {
		Vuelo v = buscarVueloPorId(id);
		LocalDateTime salida = v.getT();
		Duration duracion = v.getD().getTiempoVuelo();
		if(v.getD().getNombre().equalsIgnoreCase("Canarias (Tenerife)")) {
			return salida.plus(duracion).minus(Duration.ofMinutes(60));
		}else {
			return salida.plus(duracion);
		}		
	}
	
	//Calcular a qué hora hay que embarcar
	public LocalTime calcularHoraEmbarque(int id) {
		Vuelo v = buscarVueloPorId(id);
		LocalTime t = LocalTime.of(v.getT().getHour(), v.getT().getMinute());
		
		return t.minusMinutes(90);
	}
	
	//Calcular cuanto tiempo queda
	public Duration calcularTiempoRestante(int id) {
		Vuelo v = buscarVueloPorId(id);
		LocalDateTime hoy = LocalDateTime.now();
		LocalDateTime salida = v.getT();
		
		if(hoy.isAfter(salida)) {
			return Duration.ZERO;
		}	
		return Duration.between(hoy,salida);
	}
	
	// Buscar por día específico(Jaime opción 2)
	public List<Vuelo> buscarPorDia(LocalDate ld){
		List<Vuelo> lista = new ArrayList<Vuelo>();
		for(Vuelo v: listaVuelos) {
			if(v.getT().toLocalDate().equals(ld)) { // Pasamos de un objeto LocalDateTime a un LocalDate
				lista.add(v);
			}
		}
		return lista;
	}
	
	// Mostrar una lista de vuelos con Lista como parámetro
	public void mostrarVuelos(List<Vuelo> lista) {
		for(Vuelo v:lista) {
			System.out.println("*************");
			System.out.println("ID: "+v.getId());
			System.out.println("Día: "+v.getT().toLocalDate());
			System.out.println("Salida: "+v.getT().toLocalTime());
			System.out.println("Destino: "+v.getD().getNombre());
			System.out.println("*************");
		}
	}
	// Imprimir billete pasando un ID de vuelo
	public void imprimirBillete(int id) {
		Vuelo v=buscarVueloPorId(id);
		
		if(v.getT().isBefore(LocalDateTime.now())) {
			System.err.println("¡¡¡¡¡Este billete está obsoleto!!!!!");
			System.out.println("********************");
			System.out.println("DON BOSCO AIRLINES");
			System.out.println("Destino: "+v.getD().getNombre());
			System.out.println("Día: "+v.getT().toLocalDate());
			System.out.println();
			System.out.println("Salida: "+v.getT().toLocalTime());
			System.out.println("Llegada: "+calcularHoraLlegada(id));
			System.out.println();
			System.out.println("Hora de embarque: "+calcularHoraEmbarque(id));
			System.out.println("********************");
		}else {
			System.out.println("********************");
			System.out.println("DON BOSCO AIRLINES");
			System.out.println("Destino: "+v.getD().getNombre());
			System.out.println("Día: "+v.getT().toLocalDate());
			System.out.println();
			System.out.println("Salida: "+v.getT().toLocalTime());
			System.out.println("Llegada: "+calcularHoraLlegada(id));
			System.out.println();
			System.out.println("Hora de embarque: "+calcularHoraEmbarque(id));
			System.out.println("********************");
		}
		
	}
	
}
