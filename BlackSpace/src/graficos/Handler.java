package graficos;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	protected LinkedList<Entity> objects = new LinkedList<Entity>();

	public void update() {
		for (int i = 0; i < objects.size(); i++) {
			Entity tempObject = objects.get(i);

			tempObject.update();
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			Entity tempObject = objects.get(i);
			tempObject.render(g);
		}
	}

	public void addObject(Entity object) {
		this.objects.add(object);
	}

	public void removeObject(Entity object) {
		this.objects.remove(object);
	}

	public void crearAliens(int numeroDeAliens) {

		int xTemp = (int) (Math.random() * (Juego.ANCHO - 100)) + 20;

		for (int i = 0; i < numeroDeAliens; i++) {
			// int rand = ThreadLocalRandom.current().nextInt(20, Juego.ANCHO -
			// 40);
			addObject(new Aliens(xTemp, -100, ID.Enemigos));
			xTemp = (int) (Math.random() * (Juego.ANCHO - 100)) + 20;
		}

	}

	public void limpiarNivel() {
		for (int i = 0; i < objects.size(); i++) {
			Entity tempAline = objects.get(i);

			if (tempAline.getId() == ID.Enemigos) {
				removeObject(tempAline);
				System.out.println(i);
			}
		}
	}

}
