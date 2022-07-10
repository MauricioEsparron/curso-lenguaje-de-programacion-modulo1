package interfaces;

import java.util.ArrayList;

import entidad.ReporteTipoCuenta;
import entidad.ReporteTipoUsuario;
import entidad.TipoCuenta;

public interface TipoCuentaInterfacesDAO {

	public int registrar(TipoCuenta tc);

	public int actualizar(TipoCuenta tc);

	public int eliminar(int codTipoCuenta);

	public ArrayList<TipoCuenta> listaTipoCuenta();
	
	public ArrayList<ReporteTipoCuenta> listarReporteCuentaXTipocuenta(int TipoCuenta);

}
