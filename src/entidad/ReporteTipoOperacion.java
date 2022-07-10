package entidad;

public class ReporteTipoOperacion {

	private int codMovimiento;
	private int numTarjeta;
	private String cliente;
	private int numCuenta;
	private String tipoOperacion;
	private String fecMovimiento;
	private int cuentaDestino;
	private Double monto;

	public ReporteTipoOperacion() {

	}

	public ReporteTipoOperacion(int codMovimiento, int numTarjeta, String cliente, int numCuenta, String tipoOperacion,
			String fecMovimiento, int cuentaDestino, Double monto) {
		this.codMovimiento = codMovimiento;
		this.numTarjeta = numTarjeta;
		this.cliente = cliente;
		this.numCuenta = numCuenta;
		this.tipoOperacion = tipoOperacion;
		this.fecMovimiento = fecMovimiento;
		this.cuentaDestino = cuentaDestino;
		this.monto = monto;
	}

	public int getCodMovimiento() {
		return codMovimiento;
	}

	public void setCodMovimiento(int codMovimiento) {
		this.codMovimiento = codMovimiento;
	}

	public int getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(int numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(int numCuenta) {
		this.numCuenta = numCuenta;
	}

	public String getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public String getFecMovimiento() {
		return fecMovimiento;
	}

	public void setFecMovimiento(String fecMovimiento) {
		this.fecMovimiento = fecMovimiento;
	}

	public int getCuentaDestino() {
		return cuentaDestino;
	}

	public void setCuentaDestino(int cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

}
