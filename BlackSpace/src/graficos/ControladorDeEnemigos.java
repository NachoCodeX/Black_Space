package graficos;

import java.awt.Graphics;
import java.util.ArrayList;

public class ControladorDeEnemigos {
	protected static ArrayList<Aliens> aliens;

	public ControladorDeEnemigos() {
		aliens = new ArrayList<Aliens>();

	}

	public void render(Graphics g) {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).render(g);
		}
	}

	public void update() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
		}
	}

	public static void removerAlien(Aliens alien) {
		aliens.remove(alien);
	}

	public static void addAlien(Aliens alien) {
		aliens.add(alien);
	}

	public static void crearEnemigos(int numEnemigos) {

		for (int i = 1; i <= numEnemigos; i++) {
			int xTemp = (int) (Math.random() * (Juego.ANCHO - 100)) + 20;
			addAlien(new Aliens(xTemp, -10, ID.Enemigos));
		}
	}

	public static void limpiarNivel() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.clear();
		}
	}

}
