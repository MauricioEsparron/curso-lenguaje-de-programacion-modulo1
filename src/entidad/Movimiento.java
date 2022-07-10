package entidad;

public class Movimiento {

	private int cod_movimiento;
	private int num_tarjeta;
	private int cod_cliente;
	private int num_cuenta;
	private int cod_operacion;
	private String fecha_movimiento;
	private int cuenta_destino;
	private double monto;

	public Movimiento() {

	}

	public Movimiento(int cod_movimiento, int num_tarjeta, int cod_cliente, int num_cuenta, int cod_operacion,
			String fecha_movimiento, int cuenta_destino, double monto) {

		this.cod_movimiento = cod_movimiento;
		this.num_tarjeta = num_tarjeta;
		this.cod_cliente = cod_cliente;
		this.num_cuenta = num_cuenta;
		this.cod_operacion = cod_operacion;
		this.fecha_movimiento = fecha_movimiento;
		this.cuenta_destino = cuenta_destino;
		this.monto = monto;
	}

	public int getCod_movimiento() {
		return cod_movimiento;
	}

	public void setCod_movimiento(int cod_movimiento) {
		this.cod_movimiento = cod_movimiento;
	}

	public int getNum_tarjeta() {
		return num_tarjeta;
	}

	public void setNum_tarjeta(int num_tarjeta) {
		this.num_tarjeta = num_tarjeta;
	}

	public int getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public int getNum_cuenta() {
		return num_cuenta;
	}

	public void setNum_cuenta(int num_cuenta) {
		this.num_cuenta = num_cuenta;
	}

	public int getCod_operacion() {
		return cod_operacion;
	}

	public void setCod_operacion(int cod_operacion) {
		this.cod_operacion = cod_operacion;
	}

	public String getFecha_movimiento() {
		return fecha_movimiento;
	}

	public void setFecha_movimiento(String fecha_movimiento) {
		this.fecha_movimiento = fecha_movimiento;
	}

	public int getCuenta_destino() {
		return cuenta_destino;
	}

	public void setCuenta_destino(int cuenta_destino) {
		this.cuenta_destino = cuenta_destino;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

}
