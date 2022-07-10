package interfaces;

import java.util.ArrayList;

import entidad.TipoUsuario;

public interface TipoUsuarioInterfacesDAO {

	public int registrar(TipoUsuario tu);

	public int actualizar(TipoUsuario tu);

	public int eliminar(int codOperacion);

	public ArrayList<TipoUsuario> listaTipoUsuario();
}
