package ejercicio01;

public class Apartamento extends HabitacionEstandar{
	private double servicioLimp;

	public Apartamento(double precioBase, boolean ocupada, String cliente, int dias, int ocupantes,
			double servicioLimp) {
		super(precioBase, ocupada, cliente, dias, ocupantes);
		this.servicioLimp = servicioLimp;
	}

	public double getServicioLimp() {
		return servicioLimp;
	}

	public void setServicioLimp(double servicioLimp) {
		this.servicioLimp = servicioLimp;
	}

	@Override
	public String toString() {
		return "Apartamento [servicioLimp=" + servicioLimp + "]";
	}

	@Override
	public double calcularEstancia() {
		return super.calcularEstancia()+servicioLimp;
	}
	
	
}
