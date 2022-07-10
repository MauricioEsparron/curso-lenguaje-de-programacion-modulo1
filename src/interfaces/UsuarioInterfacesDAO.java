package interfaces;

import java.util.ArrayList;

import entidad.Usuario;
import entidad.ReporteTipoUsuario;

public interface UsuarioInterfacesDAO {

	public int registrar(Usuario u);

	public int actualizar(Usuario u);

	public int eliminar(int codigoUsuario);

	public ArrayList<Usuario> listarUsuario();

	public ArrayList<Usuario> listarUsuarioXTipousuario(int TipoUsuario);

	public ArrayList<ReporteTipoUsuario> listarReporteUsuarioXTipousuario(int TipoUsuario);

	public Usuario validarAcceso(String user, String clave);
}
