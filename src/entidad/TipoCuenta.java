package entidad;

public class TipoCuenta {

	private int cod_cuenta;
	private String descripcion;

	public TipoCuenta() {
	}

	public TipoCuenta(int cod_cuenta, String descripcion) {
		this.cod_cuenta = cod_cuenta;
		this.descripcion = descripcion;
	}

	public int getCod_cuenta() {
		return cod_cuenta;
	}

	public void setCod_cuenta(int cod_cuenta) {
		this.cod_cuenta = cod_cuenta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
