package ejercicio06;

public abstract class Cuenta {
	private int numeroCuenta;
	private int cvv;
	private double saldo;
	
	public Cuenta(int numeroCuenta, int cvv, double saldo) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.cvv = cvv;
		this.saldo = saldo;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Cuenta [numeroCuenta=" + numeroCuenta + ", cvv=" + cvv + ", saldo=" + saldo + "]";
	}
	
	public abstract double ingresarDinero(double ingreso);
	public abstract double retirarDinero(double retirar);
}
