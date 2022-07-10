package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.ReporteTarjeta;
import entidad.ReporteTipoUsuario;
import entidad.Tarjeta;
import interfaces.TarjetaInrterfacesDAO;
import utils.MySQLConexion8;

public class GestionTarjetaDAO implements TarjetaInrterfacesDAO {

	@Override
	public int registrar(Tarjeta t) {

		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();

			String sql = "insert into tb_tarjeta values(?,?,?,?,?,?,?);";

			pstm = con.prepareStatement(sql);

			pstm.setInt(1, t.getNum_Tarjeta());
			pstm.setInt(2, t.getCod_cliente());
			pstm.setInt(3, t.getCodTipo_cuenta());
			pstm.setInt(4, t.getNum_cuenta());
			pstm.setString(5, t.getFecAfliacion());
			pstm.setString(6, t.getFecCaducidad());
			pstm.setDouble(7, t.getSaldo());

			res = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println(">>>>>> Error en la instrucción SQL - Registrar " + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();

			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos " + e2.getMessage());
			}
		}

		return res;

	}

	@Override
	public int actualizar(Tarjeta t) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();
			String sql = "update tb_tarjeta set cod_cliente = ?,cod_tipocuenta = ?, num_cuenta = ?, fecha_afiliacion = ?, fecha_caducidad = ?, saldo = ? where numtb_tarjeta = ?;";
			pstm = con.prepareStatement(sql);

			pstm.setInt(1, t.getCod_cliente());
			pstm.setInt(2, t.getCodTipo_cuenta());
			pstm.setInt(3, t.getNum_cuenta());
			pstm.setString(4, t.getFecAfliacion());
			pstm.setString(5, t.getFecCaducidad());
			pstm.setDouble(6, t.getSaldo());
			pstm.setInt(7, t.getNum_Tarjeta());

			res = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println(">>>>>> Error en la instrucción SQL - Actualizar" + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();

			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos " + e2.getMessage());
			}
		}

		return res;
	}

	@Override
	public int eliminar(int num_Tarjeta) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();

			String sql = "delete from tb_tarjeta where numtb_tarjeta = ?;";

			pstm = con.prepareStatement(sql);

			pstm.setInt(1, num_Tarjeta);

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
	public ArrayList<Tarjeta> listartarjeta() {
		ArrayList<Tarjeta> lista = new ArrayList<Tarjeta>();
		Tarjeta tarjeta;
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {

			con = MySQLConexion8.getConexion();

			String sql = "SELECT * FROM tb_tarjeta;";

			pstm = con.prepareStatement(sql);

			res = pstm.executeQuery();

			while (res.next()) {

				tarjeta = new Tarjeta();

				tarjeta.setNum_Tarjeta(res.getInt(1));
				tarjeta.setCod_cliente(res.getInt(2));
				tarjeta.setCod_cuenta(res.getInt(3));
				tarjeta.setNum_cuenta(res.getInt(4));
				tarjeta.setFecAfliacion(res.getString(5));
				tarjeta.setFecCaducidad(res.getString(6));
				tarjeta.setSaldo(res.getDouble(7));

				lista.add(tarjeta);

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
	public ArrayList<Tarjeta> listarTarjetaXTipoCuenta(int tipoCuenta) {
		ArrayList<Tarjeta> lista = new ArrayList<Tarjeta>();
		Tarjeta tarjeta;
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {

			con = MySQLConexion8.getConexion();

			String sql = "SELECT * FROM tb_tarjeta where cod_tipocuenta = ?;";

			pstm = con.prepareStatement(sql);

			pstm.setInt(1, tipoCuenta);

			res = pstm.executeQuery();

			while (res.next()) {

				tarjeta = new Tarjeta();

				tarjeta.setNum_Tarjeta(res.getInt(1));
				tarjeta.setCod_cliente(res.getInt(2));
				tarjeta.setCod_cuenta(res.getInt(3));
				tarjeta.setNum_cuenta(res.getInt(4));
				tarjeta.setFecAfliacion(res.getString(5));
				tarjeta.setFecCaducidad(res.getString(6));
				tarjeta.setSaldo(res.getDouble(7));

				lista.add(tarjeta);

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
	public ArrayList<Tarjeta> listarTarjetaXCodigoCliente(int codCliente) {
		ArrayList<Tarjeta> lista = new ArrayList<Tarjeta>();
		Tarjeta tarjeta;
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {

			con = MySQLConexion8.getConexion();

			String sql = "SELECT * FROM tb_tarjeta where cod_cliente = ?;";

			pstm = con.prepareStatement(sql);

			pstm.setInt(1, codCliente);

			res = pstm.executeQuery();

			while (res.next()) {

				tarjeta = new Tarjeta();

				tarjeta.setNum_Tarjeta(res.getInt(1));
				tarjeta.setCod_cliente(res.getInt(2));
				tarjeta.setCod_cuenta(res.getInt(3));
				tarjeta.setNum_cuenta(res.getInt(4));
				tarjeta.setFecAfliacion(res.getString(5));
				tarjeta.setFecCaducidad(res.getString(6));
				tarjeta.setSaldo(res.getDouble(7));

				lista.add(tarjeta);

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
	public ArrayList<ReporteTarjeta> listaReporterTarjetaXCodigoCliente(int codCliente) {
		ArrayList<ReporteTarjeta> lista = new ArrayList<ReporteTarjeta>();
		ReporteTarjeta ReportTarj;
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {

			con = MySQLConexion8.getConexion();

			String sql = "{call usp_listarTarjetaxCliente(?)};";

			pstm = con.prepareStatement(sql);

			pstm.setInt(1, codCliente);

			res = pstm.executeQuery();

			while (res.next()) {

				ReportTarj = new ReporteTarjeta();

				ReportTarj.setNumTarjeta(res.getInt(1));
				ReportTarj.setNombCliente(res.getString(2));
				ReportTarj.setTipoCuenta(res.getString(3));
				ReportTarj.setNumCuenta(res.getInt(4));
				ReportTarj.setFecAfiliacion(res.getString(5));
				ReportTarj.setFecCaducidad(res.getString(6));
				ReportTarj.setSaldo(res.getDouble(7));

				lista.add(ReportTarj);

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

	@Override
	public ArrayList<ReporteTarjeta> listaReporterTarjetaXTipoCuenta(int codTipoCuenta) {
		ArrayList<ReporteTarjeta> lista = new ArrayList<ReporteTarjeta>();
		ReporteTarjeta ReportTarj;
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {

			con = MySQLConexion8.getConexion();

			String sql = "{call usp_listarTarjetaxTipoCuenta(?)};";

			pstm = con.prepareStatement(sql);

			pstm.setInt(1, codTipoCuenta);

			res = pstm.executeQuery();

			while (res.next()) {

				ReportTarj = new ReporteTarjeta();

				ReportTarj.setNumTarjeta(res.getInt(1));
				ReportTarj.setNombCliente(res.getString(2));
				ReportTarj.setTipoCuenta(res.getString(3));
				ReportTarj.setNumCuenta(res.getInt(4));
				ReportTarj.setFecAfiliacion(res.getString(5));
				ReportTarj.setFecCaducidad(res.getString(6));
				ReportTarj.setSaldo(res.getDouble(7));

				lista.add(ReportTarj);

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
