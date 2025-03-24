package ejercicio04;

public class Alimentacion extends Producto{
	private int diasCaducar;
	private boolean refrigerado;

	public Alimentacion(double precioUnitario, String nombre, int id, int diasCaducar, boolean refrigerado) {
		super(precioUnitario, nombre, id);
		this.diasCaducar = diasCaducar;
		this.refrigerado = refrigerado;
	}

	public int getDiasCaducar() {
		return diasCaducar;
	}

	public void setDiasCaducar(int diasCaducar) {
		this.diasCaducar = diasCaducar;
	}

	public boolean isRefrigerado() {
		return refrigerado;
	}

	public void setRefrigerado(boolean refrigerado) {
		this.refrigerado = refrigerado;
	}

	@Override
	public String toString() {
		return "Alimentacion [diasCaducar=" + diasCaducar + ", refrigerado=" + refrigerado + "]";
	}
	
	public double calcularPVP(double iva, double descuento, int topeCaducidad) {
		double cien=100.0;
		double total=super.calcularPVP(iva, descuento, topeCaducidad);
		
		if(diasCaducar>topeCaducidad) {
			total=total-total*descuento/100;
		}
		
		return total;
	}
	
	public void avisarCaducidad(int topeCaducidad) {
		if (diasCaducar < topeCaducidad) {
            System.out.println("¡Atención! Al producto " + getNombre() + " le faltan menos de "+topeCaducidad+" días para caducar.");
        }
	}
	
}
