package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidad.TipoUsuario;
import interfaces.TipoUsuarioInterfacesDAO;
import utils.MySQLConexion8;

public class GestionTipoUsuarioDAO implements TipoUsuarioInterfacesDAO {

	@Override
	public int registrar(TipoUsuario tu) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;

		try {

			con = MySQLConexion8.getConexion();
			String sql = "insert into tb_tipousuario values (null,?)";

			pstm = con.prepareStatement(sql);

			pstm.setString(1, tu.getDescripcion());

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
	public int actualizar(TipoUsuario tu) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();

			String sql = "update tb_tipousuario set descripcion = ? where codtb_tipousuario = ?;";

			pstm = con.prepareStatement(sql);

			pstm.setString(1, tu.getDescripcion());
			pstm.setInt(2, tu.getCodTipoUsuario());

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
	public int eliminar(int codOperacion) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();

			String sql = "delete from tb_tipousuario where codtb_tipousuario = ?";

			pstm = con.prepareStatement(sql);

			pstm.setInt(1, codOperacion);

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
	public ArrayList<TipoUsuario> listaTipoUsuario() {
		ArrayList<TipoUsuario> lista = new ArrayList<TipoUsuario>();
		TipoUsuario tipoUser;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;

		try {

			con = MySQLConexion8.getConexion();
			String sql = "SELECT *FROM tb_tipousuario";

			pstm = con.prepareStatement(sql);

			res = pstm.executeQuery();

			while (res.next()) {

				tipoUser = new TipoUsuario();

				tipoUser.setCodTipoUsuario(res.getInt(1));
				tipoUser.setDescripcion(res.getString(2));

				lista.add(tipoUser);

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

}
