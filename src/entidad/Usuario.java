package entidad;

public class Usuario {
	private int codUsuario;
	private String nombUsuario;
	private String apeUsuario;
	private int dni;
	private int telefono;
	private String usuario;
	private String clave;
	private int codTipoUsuario;

	public Usuario() {

	}

	public Usuario(int codUsuario, String nombUsuario, String apeUsuario, int dni, int telefono, String usuario,
			String clave, int codTipoUsuario) {
		this.codUsuario = codUsuario;
		this.nombUsuario = nombUsuario;
		this.apeUsuario = apeUsuario;
		this.dni = dni;
		this.telefono = telefono;
		this.usuario = usuario;
		this.clave = clave;
		this.codTipoUsuario = codTipoUsuario;
	}

	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getNombUsuario() {
		return nombUsuario;
	}

	public void setNombUsuario(String nombUsuario) {
		this.nombUsuario = nombUsuario;
	}

	public String getApeUsuario() {
		return apeUsuario;
	}

	public void setApeUsuario(String apeUsuario) {
		this.apeUsuario = apeUsuario;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public int getCodTipoUsuario() {
		return codTipoUsuario;
	}

	public void setCodTipoUsuario(int codTipoUsuario) {
		this.codTipoUsuario = codTipoUsuario;
	}

}
