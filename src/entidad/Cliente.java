package entidad;

public class Cliente {

	private int cod_cliente;
	private String nombre;
	private String apellido;
	private int dni;
	private int telefono;

	public Cliente() {

	}

	public Cliente(int cod_cliente, String nombre, String apellido, int dni, int telefono) {
		super();
		this.cod_cliente = cod_cliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
	}

	public int getCod_cliente() {
		return cod_cliente;
	}

	public void setCod(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

}
