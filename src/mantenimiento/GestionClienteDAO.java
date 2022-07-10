package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidad.Cliente;
import interfaces.ClienteInterfacesDAO;
import utils.MySQLConexion8;

public class GestionClienteDAO implements ClienteInterfacesDAO {

	@Override
	public int registrar(Cliente c) {

		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();
			String sql = "insert into tb_cliente values (null,?,?,?,?)";

			pstm = con.prepareStatement(sql);

			pstm.setString(1, c.getNombre());
			pstm.setString(2, c.getApellido());
			pstm.setInt(3, c.getDni());
			pstm.setInt(4, c.getTelefono());

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
	public int actualizar(Cliente c) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();

			String sql = "update tb_cliente set nombre = ?,apellido = ?, dni = ?, telefono = ? where codtb_cliente = ?;";

			pstm = con.prepareStatement(sql);

			pstm.setString(1, c.getNombre());
			pstm.setString(2, c.getApellido());
			pstm.setInt(3, c.getDni());
			pstm.setInt(4, c.getTelefono());
			pstm.setInt(5, c.getCod_cliente());

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
	public int eliminar(int codigoCliente) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();

			String sql = "delete from tb_cliente where codtb_cliente = ?";

			pstm = con.prepareStatement(sql);

			pstm.setInt(1, codigoCliente);

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
	public ArrayList<Cliente> listarCliente() {
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		Cliente client;
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {

			con = MySQLConexion8.getConexion();

			String sql = "SELECT * FROM tb_cliente;";

			pstm = con.prepareStatement(sql);

			res = pstm.executeQuery();

			while (res.next()) {

				client = new Cliente();

				client.setCod(res.getInt(1));
				client.setNombre(res.getNString(2));
				client.setApellido(res.getString(3));
				client.setDni(res.getInt(4));
				client.setTelefono(res.getInt(5));

				lista.add(client);

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
