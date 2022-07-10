package entidad;

public class ReporteTarjeta {
	private int numTarjeta;
	private String NombCliente;
	private String TipoCuenta;
	private int numCuenta;
	private String fecAfiliacion;
	private String fecCaducidad;
	private double saldo;

	public ReporteTarjeta() {

	}

	public ReporteTarjeta(int numTarjeta, String nombCliente, String tipoCuenta, int numCuenta, String fecAfiliacion,
			String fecCaducidad, double saldo) {
		this.numTarjeta = numTarjeta;
		NombCliente = nombCliente;
		TipoCuenta = tipoCuenta;
		this.numCuenta = numCuenta;
		this.fecAfiliacion = fecAfiliacion;
		this.fecCaducidad = fecCaducidad;
		this.saldo = saldo;
	}

	public int getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(int numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public String getNombCliente() {
		return NombCliente;
	}

	public void setNombCliente(String nombCliente) {
		NombCliente = nombCliente;
	}

	public String getTipoCuenta() {
		return TipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		TipoCuenta = tipoCuenta;
	}

	public int getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(int numCuenta) {
		this.numCuenta = numCuenta;
	}

	public String getFecAfiliacion() {
		return fecAfiliacion;
	}

	public void setFecAfiliacion(String fecAfiliacion) {
		this.fecAfiliacion = fecAfiliacion;
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
