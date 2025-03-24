package ejercicio02;

public class Documento {
	private String nombreEmpresa;

	public Documento(String nombreEmpresa) {
		super();
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	@Override
	public String toString() {
		return "Documento [nombreEmpresa=" + nombreEmpresa + "]";
	}
	
	public void imprimirCabecera() {
		System.out.println("Empresa: "+nombreEmpresa);
	}
}
