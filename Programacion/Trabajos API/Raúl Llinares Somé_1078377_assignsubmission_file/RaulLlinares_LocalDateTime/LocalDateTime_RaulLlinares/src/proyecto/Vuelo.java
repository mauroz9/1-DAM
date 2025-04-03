package proyecto;

import java.time.LocalDateTime;

public class Vuelo {

	private int id;
	private Destino d;
	private LocalDateTime t ;
	
	public Vuelo(int id, Destino d, LocalDateTime t) {
		super();
		this.id = id;
		this.d = d;
		this.t = t;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Destino getD() {
		return d;
	}

	public void setD(Destino d) {
		this.d = d;
	}

	public LocalDateTime getT() {
		return t;
	}

	public void setT(LocalDateTime t) {
		this.t = t;
	}

	@Override
	public String toString() {
		return "Vuelo [id=" + id + ", d=" + d + ", t=" + t + "]";
	}
	
	
}
