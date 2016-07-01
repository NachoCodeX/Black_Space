package graficos;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Teclado extends KeyAdapter {
	private Handler handler;
	private GAMESTATE STATE = Juego.obtenerEstadoActual();

	public Teclado(Handler handler) {
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		for (int i = 0; i < handler.objects.size(); i++) {
			Entity temp = handler.objects.get(i);

			if (temp.getId() == ID.Nave) {
				mover(temp, key);
			}

		}

		if (key == KeyEvent.VK_ESCAPE && STATE == GAMESTATE.JUEGO) {
			STATE = GAMESTATE.MENU;
			Juego.cambiarEstado(STATE);

		} else if (key == KeyEvent.VK_ESCAPE && STATE == GAMESTATE.MENU) {
			STATE = GAMESTATE.JUEGO;
			Juego.cambiarEstado(STATE);
		}

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		for (int i = 0; i < handler.objects.size(); i++) {
			Entity temp = handler.objects.get(i);

			if (temp.getId() == ID.Nave) {
				reposo(temp, key);
			}

		}

	}

	public void mover(Entity temp, int key) {
		if (key == KeyEvent.VK_RIGHT)
			temp.setDerecha(true);

		if (key == KeyEvent.VK_LEFT)
			temp.setIzquierda(true);

		if (key == KeyEvent.VK_UP)
			temp.setArriba(true);

		if (key == KeyEvent.VK_DOWN)
			temp.setAbajo(true);

		if (key == KeyEvent.VK_SPACE)
			temp.setDisparando(true);

	}

	public void reposo(Entity temp, int key) {
		if (key == KeyEvent.VK_RIGHT)
			temp.setDerecha(false);

		if (key == KeyEvent.VK_LEFT)
			temp.setIzquierda(false);

		if (key == KeyEvent.VK_UP)
			temp.setArriba(false);

		if (key == KeyEvent.VK_DOWN)
			temp.setAbajo(false);

		if (key == KeyEvent.VK_SPACE) {
			temp.setEspacio(false);
			temp.setDisparando(false);
		}

	}

}
