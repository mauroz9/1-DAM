package ejemplo_1;

public class Consultor extends Trabajador{
	
	private int horas;
	private double tarifa;
	
	public Consultor(String nombre, String puesto, int horas, double tarifa) {
		super(nombre, puesto);
		this.horas = horas;
		this.tarifa = tarifa;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}

	public String toString() {
		return super.toString()+"Consultor [horas=" + horas + ", tarifa=" + tarifa + "]";
	}
	
	public double calcularPaga(double base) {
		return super.calcularPaga(base)+horas*tarifa;
	}
	
	public void imprimirPaga(double base) {
		System.out.println("Tu sueldo es: "+calcularPaga(base));
	}
	
	public int calcularDias(int horasDias) {
		return (int)horas/horasDias;
	}
}
