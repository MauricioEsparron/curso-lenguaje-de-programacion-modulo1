package interfaces;

import java.util.ArrayList;

import entidad.Cliente;

public interface ClienteInterfacesDAO {

	public int registrar(Cliente c);

	public int actualizar(Cliente c);

	public int eliminar(int codigoCliente);

	public ArrayList<Cliente> listarCliente();



}
