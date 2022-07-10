package hilos;

import vista.Logueo;

public class HiloTiempo extends Thread {
	@Override
	public void run() {
		for (int i = 60; i >= 0; i--) {
			Logueo.lblTiempo.setText(i + "s");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Error en el conteo" + e);
			}
		}

		Logueo.frame.dispose();
	}

}
