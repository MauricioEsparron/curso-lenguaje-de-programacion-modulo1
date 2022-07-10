package hilos;

import vista.PreLoader;

public class HiloBarraProgreso extends Thread {
	@Override
	public void run() {
		for (int i = 0; i <= 100; i++) {
			PreLoader.prbCarga.setValue(i);
			try {
				Thread.sleep(50);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
