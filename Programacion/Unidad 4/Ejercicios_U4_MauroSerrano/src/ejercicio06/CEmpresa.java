package ejercicio06;

public class CEmpresa extends Cuenta{
	private double supRetiro;

	public CEmpresa(int numeroCuenta, int cvv, double saldo, double supRetiro) {
		super(numeroCuenta, cvv, saldo);
		this.supRetiro = supRetiro;
	}

	public double getSupRetiro() {
		return supRetiro;
	}

	public void setSupRetiro(double supRetiro) {
		this.supRetiro = supRetiro;
	}
	
	@Override
	public double ingresarDinero(double ingreso) {
		double saldoRes=0;
		super.setSaldo(super.getSaldo()+ingreso);
		return saldoRes;
	}

	@Override
	public double retirarDinero(double retirar) {
		double saldoRes=0;
		super.setSaldo(super.getSaldo()-retirar-supRetiro);
		return saldoRes;
	}
}
