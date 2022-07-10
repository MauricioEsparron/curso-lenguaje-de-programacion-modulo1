package utils;

public class Validaciones {

	public static final String CODIGO_CLIENTE = "\\d";
	public static final String DNI = "\\d{8}";
	public static final String CODIGO_PRODUCTO = "[Pp]\\d{4}";
	public static final String CODIGO_CUENTA = "\\d+";
	public static final String TEXTO = "[a-zA-ZZáéíóúÁÉÍÓÚ\\s]{3,15}";
	public static final String NOMBRE = "[a-zA-ZáéíóúÁÉÍÓÚ\\s]{3,45}";
	public static final String APELLIDO = "[a-zA-ZáéíóúÁÉÍÓÚ\\s]{3,45}";
	public static final String TELEFONO = "\\d{9}";
	public static final String NUM_TARJETA = "\\d{6}";
	public static final String NUM_CUENTA = "\\d{4}";//voy a cambiar temporalmente a 4
	public static final String MONTO = "\\d+";
	public static final String SALDO = "\\d+";
	public static final String CLAVE = "d{4}";
	public static final String USUARIO = "[A-Z]{1}[0-9]{3}";
	
//	public static final String MONTO = "<= 99999";
}
