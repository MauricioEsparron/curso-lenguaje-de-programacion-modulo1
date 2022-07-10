package interfaces;

import java.util.ArrayList;

import entidad.ReporteTipoCuenta;
import entidad.ReporteTipoOperacion;
import entidad.TipoOperacion;

public interface TipoOperacionInterfacesDAO {

	public int registrar(TipoOperacion to);

	public int actualizar(TipoOperacion to);

	public int eliminar(int codOperacion);

	public ArrayList<TipoOperacion> listaTipoOperacion();
	
	public ArrayList<ReporteTipoOperacion> listarReporteTipoOperacion(int TipoOperacion);

}
