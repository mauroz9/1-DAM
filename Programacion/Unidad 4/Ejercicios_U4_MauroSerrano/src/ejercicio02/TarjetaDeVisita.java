package ejercicio02;

public class TarjetaDeVisita extends Documento{
	private String nombrePersona;
	private String telefono;
	private String email;
	
	public TarjetaDeVisita(String nombreEmpresa, String nombrePersona, String telefono, String email) {
		super(nombreEmpresa);
		this.nombrePersona = nombrePersona;
		this.telefono = telefono;
		this.email = email;
	}
	
	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "TarjetaDeVisita [nombrePersona=" + nombrePersona + ", telefono=" + telefono + ", email=" + email + "]";
	}

	public void imprimirCabecera() {
		System.out.println("[Tarjeta de Visita]");
		super.imprimirCabecera();
		System.out.println("Nombre: "+nombrePersona);
		System.out.println("Teléfono: "+telefono);
		System.out.println("Email: "+email);
	}
	
}
