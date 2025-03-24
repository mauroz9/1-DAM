package ejercicio01;

public class Suite extends HabitacionEstandar{
	private double metrosCuad;
	private double servicioHab;
	private double descuento;
	
	public Suite(double precioBase, boolean ocupada, String cliente, int dias, int ocupantes, double metrosCuad,
			double servicioHab, double descuento) {
		super(precioBase, ocupada, cliente, dias, ocupantes);
		this.metrosCuad = metrosCuad;
		this.servicioHab = servicioHab;
		this.descuento = descuento;
	}

	public double getMetrosCuad() {
		return metrosCuad;
	}

	public void setMetrosCuad(double metrosCuad) {
		this.metrosCuad = metrosCuad;
	}

	public double getServicioHab() {
		return servicioHab;
	}

	public void setServicioHab(double servicioHab) {
		this.servicioHab = servicioHab;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		return "Suite [metrosCuad=" + metrosCuad + ", servicioHab=" + servicioHab + ", descuento=" + descuento + "]";
	}

	@Override
	public double calcularEstancia() {
		return super.calcularEstancia()-calcularDescuento()+servicioHab;
	}
	
	public double calcularDescuento() {
		return super.calcularEstancia()*descuento/100;
	}
	
	
	
}
