package ejercicio01;

public class HabitacionEstandar {
	private double precioBase;
	private boolean ocupada;
	private String cliente;
	private int dias;
	private int ocupantes;
	
	public HabitacionEstandar(double precioBase, boolean ocupada, String cliente, int dias, int ocupantes) {
		super();
		this.precioBase = precioBase;
		this.ocupada = ocupada;
		this.cliente = cliente;
		this.dias = dias;
		this.ocupantes = ocupantes;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	public boolean isOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public int getOcupantes() {
		return ocupantes;
	}

	public void setOcupantes(int ocupantes) {
		this.ocupantes = ocupantes;
	}

	@Override
	public String toString() {
		return "HabitacionEstandar [precioBase=" + precioBase + ", ocupada=" + ocupada + ", cliente=" + cliente
				+ ", dias=" + dias + ", ocupantes=" + ocupantes + "]";
	}
	
	public double calcularEstancia() {
		return precioBase*dias;
	}
}
