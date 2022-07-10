package entidad;

public class ReporteTipoUsuario {

	private int cod;
	private String NombCompleto;
	private int dni;
	private int telefono;
	private String usuario;
	private String clave;
	private String descripcion;

	public ReporteTipoUsuario() {

	}

	public ReporteTipoUsuario(int cod, String nombCompleto, int dni, int telefono, String usuario, String clave,
			String descripcion) {

		this.cod = cod;
		NombCompleto = nombCompleto;
		this.dni = dni;
		this.telefono = telefono;
		this.usuario = usuario;
		this.clave = clave;
		this.descripcion = descripcion;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNombCompleto() {
		return NombCompleto;
	}

	public void setNombCompleto(String nombCompleto) {
		NombCompleto = nombCompleto;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
