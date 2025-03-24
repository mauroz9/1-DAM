package ejercicio02;

public class Principal {

	public static void main(String[] args) {
		Producto producto = new Producto(100.0);
		Producto p2=new Alimentacion(43.4, true);
		Trabajador trabajador = new Trabajador(1500.0);

		double ivaProducto = producto.calculoIva(21);
		System.out.println("IVA para el producto: " + ivaProducto);

		double irpfTrabajador = trabajador.calculoIrpf(12);
		System.out.println("IRPF para el trabajador: " + irpfTrabajador);

	}

}
