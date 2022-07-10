package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidad.Movimiento;
import interfaces.MovimientoInterfacesDAO;
import utils.MySQLConexion8;

public class GestionMovimientoDAO implements MovimientoInterfacesDAO {

	@Override
	public int registrar(Movimiento m) {

		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();
			String sql = "insert into tb_movimiento values (null,?,?,?,?,?,?,?);";

			pstm = con.prepareStatement(sql);

			pstm.setInt(1, m.getNum_tarjeta());
			pstm.setInt(2, m.getCod_cliente());
			pstm.setInt(3, m.getNum_cuenta());
			pstm.setInt(4, m.getCod_operacion());
			pstm.setString(5, m.getFecha_movimiento());
			pstm.setInt(6, m.getCuenta_destino());
			pstm.setDouble(7, m.getMonto());

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
	public int actualizar(Movimiento m) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();

			String sql = "update tb_movimiento set num_tarjeta = ?,cod_cliente = ?, num_cuenta = ?,cod_operacion = ?, fecha_movimiento = ?,cuenta_destino = ?, monto = ? where codtb_movimiento = ?;";

			pstm = con.prepareStatement(sql);

			pstm.setInt(1, m.getNum_tarjeta());
			pstm.setInt(2, m.getCod_cliente());
			pstm.setInt(3, m.getNum_cuenta());
			pstm.setInt(4, m.getCod_operacion());
			pstm.setString(5, m.getFecha_movimiento());
			pstm.setInt(6, m.getCuenta_destino());
			pstm.setDouble(7, m.getMonto());
			pstm.setInt(8, m.getCod_movimiento());

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
	public int eliminar(int codigoMovimiento) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();

			String sql = "delete from tb_movimiento where codtb_movimiento = ?;";

			pstm = con.prepareStatement(sql);

			pstm.setInt(1, codigoMovimiento);

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
	public ArrayList<Movimiento> listarMovimiento() {
		ArrayList<Movimiento> lista = new ArrayList<Movimiento>();
		Movimiento movimiento;
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {

			con = MySQLConexion8.getConexion();

			String sql = "SELECT * FROM bd_banca.tb_movimiento;";

			pstm = con.prepareStatement(sql);

			res = pstm.executeQuery();

			while (res.next()) {

				movimiento = new Movimiento();

				movimiento.setCod_movimiento(res.getInt(1));
				movimiento.setNum_tarjeta(res.getInt(2));
				movimiento.setCod_cliente(res.getInt(3));
				movimiento.setNum_cuenta(res.getInt(4));
				movimiento.setCod_operacion(res.getInt(5));
				movimiento.setFecha_movimiento(res.getString(6));
				movimiento.setCuenta_destino(res.getInt(7));
				movimiento.setMonto(res.getDouble(8));

				lista.add(movimiento);

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
	public ArrayList<Movimiento> listarMovimientoXCodigoOperacion(int codOperacion) {
		ArrayList<Movimiento> lista = new ArrayList<Movimiento>();
		Movimiento movimiento;
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {

			con = MySQLConexion8.getConexion();

			String sql = "SELECT * FROM tb_movimiento where cod_operacion = ?;";

			pstm = con.prepareStatement(sql);

			pstm.setInt(1, codOperacion);

			res = pstm.executeQuery();

			while (res.next()) {

				movimiento = new Movimiento();

				movimiento.setCod_movimiento(res.getInt(1));
				movimiento.setNum_tarjeta(res.getInt(2));
				movimiento.setCod_cliente(res.getInt(3));
				movimiento.setNum_cuenta(res.getInt(4));
				movimiento.setCod_operacion(res.getInt(5));
				movimiento.setFecha_movimiento(res.getString(6));
				movimiento.setCuenta_destino(res.getInt(7));
				movimiento.setMonto(res.getDouble(8));

				lista.add(movimiento);

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
