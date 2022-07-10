package entidad;

public class TipoUsuario {

	private int codTipoUsuario;
	private String descripcion;

	public TipoUsuario() {
	}

	public TipoUsuario(int codTipoUsuario, String descripcion) {
		this.codTipoUsuario = codTipoUsuario;
		this.descripcion = descripcion;
	}

	public int getCodTipoUsuario() {
		return codTipoUsuario;
	}

	public void setCodTipoUsuario(int codTipoUsuario) {
		this.codTipoUsuario = codTipoUsuario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
