package entidad;

public class Tarjeta {

	private int num_Tarjeta;
	private int cod_cliente;
	private int cod_cuenta;
	private int num_cuenta;
	private String fecAfliacion;
	private String fecCaducidad;
	private double saldo;

	public Tarjeta() {

	}

	public Tarjeta(int num_Tarjeta, int cod_cliente, int cod_cuenta, int num_cuenta, String fecAfliacion,
			String fecCaducidad, double saldo) {
		super();
		this.num_Tarjeta = num_Tarjeta;
		this.cod_cliente = cod_cliente;
		this.cod_cuenta = cod_cuenta;
		this.num_cuenta = num_cuenta;
		this.fecAfliacion = fecAfliacion;
		this.fecCaducidad = fecCaducidad;
		this.saldo = saldo;
	}

	public int getNum_Tarjeta() {
		return num_Tarjeta;
	}

	public void setNum_Tarjeta(int num_Tarjeta) {
		this.num_Tarjeta = num_Tarjeta;
	}

	public int getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public int getCodTipo_cuenta() {
		return cod_cuenta;
	}

	public void setCod_cuenta(int cod_cuenta) {
		this.cod_cuenta = cod_cuenta;
	}

	public int getNum_cuenta() {
		return num_cuenta;
	}

	public void setNum_cuenta(int num_cuenta) {
		this.num_cuenta = num_cuenta;
	}

	public String getFecAfliacion() {
		return fecAfliacion;
	}

	public void setFecAfliacion(String fecAfliacion) {
		this.fecAfliacion = fecAfliacion;
	}

	public String getFecCaducidad() {
		return fecCaducidad;
	}

	public void setFecCaducidad(String fecCaducidad) {
		this.fecCaducidad = fecCaducidad;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
