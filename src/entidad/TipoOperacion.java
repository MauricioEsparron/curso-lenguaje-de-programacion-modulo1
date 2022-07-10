package entidad;

public class TipoOperacion {

	private int cod_operacion;
	private String descripcion;

	public TipoOperacion() {

	}

	public TipoOperacion(int cod_operacion, String descripcion) {
		this.cod_operacion = cod_operacion;
		this.descripcion = descripcion;
	}

	public int getCod_operacion() {
		return cod_operacion;
	}

	public void setCod_operacion(int cod_operacion) {
		this.cod_operacion = cod_operacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
