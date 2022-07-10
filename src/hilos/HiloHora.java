package hilos;

import java.text.SimpleDateFormat;
import java.util.Date;

import vista.FrmPrincipal;
import vista.FrmPrincipal2;

public class HiloHora extends Thread {

	public void run() {

		while (true) {
			Date hora = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			FrmPrincipal.lblHora.setText(sdf.format(hora));
			//FrmPrincipal2.lblHora.setText(sdf.format(hora));
		}

	}

}
