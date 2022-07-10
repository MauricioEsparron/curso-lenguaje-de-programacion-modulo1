package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidad.ReporteTipoCuenta;
import entidad.ReporteTipoUsuario;
import entidad.TipoCuenta;
import interfaces.TipoCuentaInterfacesDAO;
import utils.MySQLConexion8;

public class GestionTipoCuentaDAO implements TipoCuentaInterfacesDAO {

	@Override
	public int registrar(TipoCuenta tc) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;

		try {

			con = MySQLConexion8.getConexion();
			String sql = "insert into bd_banca.tb_tipocuenta values (null,?)";

			pstm = con.prepareStatement(sql);

			pstm.setString(1, tc.getDescripcion());

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
	public int actualizar(TipoCuenta tc) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();

			String sql = "update tb_tipocuenta set descripcion = ? where codtb_tipocuenta = ?;";

			pstm = con.prepareStatement(sql);

			pstm.setString(1, tc.getDescripcion());
			pstm.setInt(2, tc.getCod_cuenta());

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
	public int eliminar(int codTipoCuenta) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();

			String sql = "delete from tb_tipocuenta where codtb_tipocuenta = ?";

			pstm = con.prepareStatement(sql);

			pstm.setInt(1, codTipoCuenta);

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
	public ArrayList<TipoCuenta> listaTipoCuenta() {

		ArrayList<TipoCuenta> lista = new ArrayList<TipoCuenta>();
		TipoCuenta tipo;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;

		try {

			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM bd_banca.tb_tipocuenta;";

			pstm = con.prepareStatement(sql);

			res = pstm.executeQuery();

			while (res.next()) {

				tipo = new TipoCuenta();

				tipo.setCod_cuenta(res.getInt(1));
				tipo.setDescripcion(res.getString(2));

				lista.add(tipo);

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
	public ArrayList<ReporteTipoCuenta> listarReporteCuentaXTipocuenta(int TipoCuenta) {
		ArrayList<ReporteTipoCuenta> lista = new ArrayList<ReporteTipoCuenta>();
		ReporteTipoCuenta ReportTipoCuenta;
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {

			con = MySQLConexion8.getConexion();

			String sql = "{call usp_listarTipoCuenta(?)};";

			pstm = con.prepareStatement(sql);

			pstm.setInt(1, TipoCuenta);

			res = pstm.executeQuery();

			while (res.next()) {

				ReportTipoCuenta = new ReporteTipoCuenta();

				ReportTipoCuenta.setNumTarjeta(res.getInt(1));
				ReportTipoCuenta.setNombCliente(res.getString(2));
				ReportTipoCuenta.setTipoCuenta(res.getString(3));
				ReportTipoCuenta.setNumCuenta(res.getInt(4));
				ReportTipoCuenta.setFecAfiliacion(res.getString(5));
				ReportTipoCuenta.setFecCaducidad(res.getString(6));
				ReportTipoCuenta.setSaldo(res.getDouble(7));

				lista.add(ReportTipoCuenta);

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
