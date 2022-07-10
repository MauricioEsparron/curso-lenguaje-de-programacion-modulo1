package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidad.Cliente;
import entidad.Tarjeta;
import entidad.Usuario;
import interfaces.UsuarioInterfacesDAO;
import utils.MySQLConexion8;
import entidad.ReporteTipoUsuario;

public class GestionUsuarioDAO implements UsuarioInterfacesDAO {

	@Override
	public int registrar(Usuario u) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();
			String sql = "insert into tb_usuario values (null,?,?,?,?,?,?,?)";

			pstm = con.prepareStatement(sql);

			pstm.setString(1, u.getNombUsuario());
			pstm.setString(2, u.getApeUsuario());
			pstm.setInt(3, u.getDni());
			pstm.setInt(4, u.getTelefono());
			pstm.setString(5, u.getUsuario());
			pstm.setString(6, u.getClave());
			pstm.setInt(7, u.getCodTipoUsuario());

			res = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println(">>>>>>Error en la instruccion SQL - Registrar " + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (pstm != null)
					con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar la base de datos " + e2.getMessage());
			}
		}
		return res;
	}

	@Override
	public int actualizar(Usuario u) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();

			String sql = "update tb_usuario set nombre = ?,apellido = ?, dni = ?, telefono = ?,usuario = ?, clave = ?, cod_tipousuario = ? where codtb_usuario = ?;";

			pstm = con.prepareStatement(sql);

			pstm.setString(1, u.getNombUsuario());
			pstm.setString(2, u.getApeUsuario());
			pstm.setInt(3, u.getDni());
			pstm.setInt(4, u.getTelefono());
			pstm.setString(5, u.getUsuario());
			pstm.setString(6, u.getClave());
			pstm.setInt(7, u.getCodTipoUsuario());
			pstm.setInt(8, u.getCodUsuario());

			res = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println(">>>>>>Error en la instruccion SQL - Actualizar " + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (pstm != null)
					con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar la base de datos " + e2.getMessage());
			}
		}
		return res;
	}

	@Override
	public int eliminar(int codigoUsuario) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();

			String sql = "delete from tb_usuario where codtb_usuario = ?";

			pstm = con.prepareStatement(sql);

			pstm.setInt(1, codigoUsuario);

			res = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println(">>>>>>Error en la instruccion SQL - Eliminar " + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (pstm != null)
					con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar la base de datos " + e2.getMessage());
			}
		}
		return res;
	}

	@Override
	public ArrayList<Usuario> listarUsuario() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		Usuario user;
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {

			con = MySQLConexion8.getConexion();

			String sql = "SELECT * FROM bd_banca.tb_usuario;";

			pstm = con.prepareStatement(sql);

			res = pstm.executeQuery();

			while (res.next()) {

				user = new Usuario();

				user.setCodUsuario(res.getInt(1));
				user.setNombUsuario(res.getString(2));
				user.setApeUsuario(res.getString(3));
				user.setDni(res.getInt(4));
				user.setTelefono(res.getInt(5));
				user.setUsuario(res.getString(6));
				user.setClave(res.getString(7));
				user.setCodTipoUsuario(res.getInt(8));

				lista.add(user);

			}

		} catch (Exception e) {
			System.out.println(">>>>>>Error en la instruccion SQL - Consultar " + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (pstm != null)
					con.close();
				if (pstm != null)
					res.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar la base de datos " + e2.getMessage());
			}
		}

		return lista;
	}

	@Override
	public ArrayList<Usuario> listarUsuarioXTipousuario(int TipoUsuario) {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		Usuario user;
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {

			con = MySQLConexion8.getConexion();

			String sql = "SELECT * FROM tb_usuario where cod_tipousuario = ?;";

			pstm = con.prepareStatement(sql);

			pstm.setInt(1, TipoUsuario);

			res = pstm.executeQuery();

			while (res.next()) {

				user = new Usuario();

				user.setCodUsuario(res.getInt(1));
				user.setNombUsuario(res.getString(2));
				user.setApeUsuario(res.getString(3));
				user.setDni(res.getInt(4));
				user.setTelefono(res.getInt(5));
				user.setUsuario(res.getString(6));
				user.setClave(res.getString(7));
				user.setCodTipoUsuario(res.getInt(8));

				lista.add(user);

			}

		} catch (Exception e) {
			System.out.println(">>>>>>Error en la instruccion SQL - Consultar " + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (pstm != null)
					con.close();
				if (pstm != null)
					res.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar la base de datos " + e2.getMessage());
			}
		}

		return lista;
	}

	@Override
	public Usuario validarAcceso(String user, String clave) {
		Usuario usuario = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {

			con = MySQLConexion8.getConexion();
			String sql = "{call usp_validarUsuarioLogeo(?,?)};";

			pstm = con.prepareStatement(sql);

			pstm.setString(1, user);
			pstm.setString(2, clave);

			res = pstm.executeQuery();

			if (res.next()) {
				usuario = new Usuario(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getInt(5),
						res.getString(6), res.getString(7), res.getInt(8));
			}

		} catch (Exception e) {
			System.out.println(">>>>>>Error en la instruccion SQL - Validar " + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (pstm != null)
					con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar la base de datos " + e2.getMessage());
			}
		}
		return usuario;
	}

	@Override
	public ArrayList<ReporteTipoUsuario> listarReporteUsuarioXTipousuario(int TipoUsuario) {
		ArrayList<ReporteTipoUsuario> lista = new ArrayList<ReporteTipoUsuario>();
		ReporteTipoUsuario ReportUser;
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {

			con = MySQLConexion8.getConexion();

			String sql = "{call usp_listarUsuario(?)};";

			pstm = con.prepareStatement(sql);

			pstm.setInt(1, TipoUsuario);

			res = pstm.executeQuery();

			while (res.next()) {

				ReportUser = new ReporteTipoUsuario();

				ReportUser.setCod(res.getInt(1));
				ReportUser.setNombCompleto(res.getString(2));
				ReportUser.setDni(res.getInt(3));
				ReportUser.setTelefono(res.getInt(4));
				ReportUser.setUsuario(res.getString(5));
				ReportUser.setClave(res.getString(6));
				ReportUser.setDescripcion(res.getString(7));

				lista.add(ReportUser);

			}

		} catch (Exception e) {
			System.out.println(">>>>>>Error en la instruccion SQL - Reporte " + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (pstm != null)
					con.close();
				if (pstm != null)
					res.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar la base de datos " + e2.getMessage());
			}
		}

		return lista;
	}

}
