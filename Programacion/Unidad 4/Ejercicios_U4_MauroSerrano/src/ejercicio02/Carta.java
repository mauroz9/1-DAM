package ejercicio02;

public class Carta extends Documento{
	private String fecha;

	public Carta(String nombreEmpresa, String fecha) {
		super(nombreEmpresa);
		this.fecha = fecha;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Carta [fecha=" + fecha + "]";
	}
	
	public void imprimirCabecera() {
		System.out.println("[Carta]");
		super.imprimirCabecera();
		System.out.println("Fecha: "+fecha);
	}
}
