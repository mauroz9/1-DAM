package ejercicio;

public class Habitacion implements Comparable <Habitacion>{
	private int numHab;
	private String cliente;
	private boolean ocupada;
	private double precioBasico;
	
	public Habitacion(int numHab, String cliente, boolean ocupada, double precioBasico) {
		super();
		this.numHab = numHab;
		this.cliente = cliente;
		this.ocupada = ocupada;
		this.precioBasico = precioBasico;
	}

	public int getNumHab() {
		return numHab;
	}

	public void setNumHab(int numHab) {
		this.numHab = numHab;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public boolean isOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

	public double getPrecioBasico() {
		return precioBasico;
	}

	public void setPrecioBasico(double precioBasico) {
		this.precioBasico = precioBasico;
	}

	@Override
	public String toString() {
		return "Habitacion [numHab=" + numHab + ", cliente=" + cliente + ", ocupada=" + ocupada + ", precioBasico="
				+ precioBasico + "]";
	}

	@Override
	public int compareTo(Habitacion h) {
		// TODO Auto-generated method stub
		return this.cliente.compareToIgnoreCase(h.cliente);
	}
	
	
}
