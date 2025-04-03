package proyecto;

import java.time.Duration;


public class Destino {

	private String nombre;
	private Duration tiempoVuelo;
	
	public Destino(String nombre, Duration tiempoVuelo) {
		super();
		this.nombre = nombre;
		this.tiempoVuelo = tiempoVuelo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Duration getTiempoVuelo() {
		return tiempoVuelo;
	}

	public void setTiempoVuelo(Duration tiempoVuelo) {
		this.tiempoVuelo = tiempoVuelo;
	}

	@Override
	public String toString() {
		return "Destino [nombre=" + nombre + ", tiempoVuelo=" + tiempoVuelo + "]";
	}
	
	
	
	
}
