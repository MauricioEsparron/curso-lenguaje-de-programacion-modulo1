package interfaces;

import java.util.ArrayList;

import entidad.Movimiento;
import entidad.Tarjeta;

public interface MovimientoInterfacesDAO {

	public int registrar(Movimiento m);

	public int actualizar(Movimiento m);

	public int eliminar(int codigoMovimiento);

	public ArrayList<Movimiento> listarMovimiento();

	public ArrayList<Movimiento> listarMovimientoXCodigoOperacion(int codOperacion);

}
