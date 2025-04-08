package ejemplo;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Comparator;

public class CRUD {

	private List<Producto> list;

	public CRUD(List<Producto> list) {
		this.list = list;
	}

	public List<Producto> getList() {
		return list;
	}

	public void setList(List<Producto> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "CRUD [list=" + list + "]";
	}

	// Añade productos a la lista de productos
	public void addProducto(Producto p) {
		list.add(p);
	}
	
	// Filtra y devuelve los productos que cuestan más de 50€
	public Stream<Producto> mostrarProductosCaros() {
		return list.stream().filter(p -> p.getPrecio() > 50);
	}

	// Extrae y devuelve solo los nombres de los productos
	public Stream<String> mostrarNombresProductos() {
		return list.stream().map(Producto::getNombre);
	}

	// Convierte los precios de los productos a enteros y los devuelve en un Stream
	public IntStream redondearPrecios() {
		return list.stream().mapToInt(p -> (int) p.getPrecio());
	}

	// Extrae y devuelve todas las letras de los nombres de los productos, una por
	// una
	public Stream<Character> mostrarLetrasDeProductos() {
		return list.stream().flatMap(p -> p.getNombre().chars().mapToObj(c -> (char) c));
	}

	// Convierte los caracteres de los nombres de los productos a sus valores ASCII
	public Stream<Integer> mostrarValoresASCII() {
		return list.stream().flatMapToInt(p -> p.getNombre().chars()).boxed();
	}

	// Devuelve un Stream sin productos repetidos
	public Stream<Producto> mostrarProductosUnicos() {
		return list.stream().distinct();
	}

	// Ordena los productos por precio de menor a mayor
	public Stream<Producto> ordenarPorPrecioAscendente() {
		return list.stream().sorted(Comparator.comparingDouble(Producto::getPrecio));
	}

	// Ordena los productos por precio de mayor a menor
	public Stream<Producto> ordenarPorPrecioDescendente() {
		return list.stream().sorted((p1, p2) -> Double.compare(p2.getPrecio(), p1.getPrecio()));
	}

	// Muestra detalles de cada producto sin modificar la lista
	public Stream<Producto> mostrarProductosConDetalles() {
		return list.stream().peek(System.out::println);
	}

	// Devuelve los 3 productos más baratos de la lista
	public Stream<Producto> mostrarTresProductosMasEconomicos() {
		return list.stream().sorted(Comparator.comparingDouble(Producto::getPrecio)).limit(3);
	}

	// Omite los 2 productos más baratos y devuelve el resto
	public Stream<Producto> omitirProductosEconomicos() {
		return list.stream().sorted(Comparator.comparingDouble(Producto::getPrecio)).skip(2);
	}

	// Devuelve los productos hasta encontrar el primero que cuesta más de 100€
	public Stream<Producto> mostrarProductosHasta100() {
		return list.stream().takeWhile(p -> p.getPrecio() <= 100);
	}

	// Omite los productos baratos y devuelve la lista a partir del primero que
	// cuesta más de 100€
	public Stream<Producto> omitirHastaEncontrarProductoCaro() {
		return list.stream().dropWhile(p -> p.getPrecio() <= 100);
	}

	// Devuelve todos los productos de la lista sin modificaciones
	public Stream<Producto> recogerTodosLosProductos() {
		return list.stream();
	}
}
