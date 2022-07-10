package entidad;

public class ReporteTipoCuenta {

	private int numTarjeta;
	private String NombCliente;
	private String tipoCuenta;

	private int numCuenta;
	private String fecAfiliacion;
	private String fecCaducidad;
	private Double saldo;

	public ReporteTipoCuenta() {

	}

	public ReporteTipoCuenta(int numTarjeta, String nombCliente, String tipoCuenta, int numCuenta, String fecAfiliacion,
			String fecCaducidad, Double saldo) {
		this.numTarjeta = numTarjeta;
		NombCliente = nombCliente;
		this.tipoCuenta = tipoCuenta;
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
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
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

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
}
