package graficos;

import java.awt.Graphics;
import java.util.LinkedList;

public class Proyectiles {

	protected LinkedList<GameObject> objBalas = new LinkedList<GameObject>();

	public void update() {

		for (int i = 0; i < objBalas.size(); i++) {
			GameObject balas = objBalas.get(i);

			if (balas.getY() <= 0) {
				removeBullet(balas);
			}

			balas.update();
		}

	}

	public void render(Graphics g) {
		for (int i = 0; i < objBalas.size(); i++) {
			GameObject balas = objBalas.get(i);
			balas.render(g);
		}
	}

	public void addBullet(GameObject bala) {
		this.objBalas.add(bala);
	}

	public void removeBullet(GameObject bala) {
		this.objBalas.remove(bala);
	}

}
