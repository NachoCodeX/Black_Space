package graficos;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	protected LinkedList<Entity> objects = new LinkedList<Entity>();
	protected LinkedList<GameObject> objectBonus = new LinkedList<GameObject>();

	public void update() {
		for (int i = 0; i < objects.size(); i++) {
			Entity tempObject = objects.get(i);

			tempObject.update();
		}

		for (int i = 0; i < objectBonus.size(); i++) {
			GameObject tempObject = objectBonus.get(i);
			tempObject.update();

		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			Entity tempObject = objects.get(i);
			tempObject.render(g);
		}

		for (int i = 0; i < objectBonus.size(); i++) {
			GameObject tempObject = objectBonus.get(i);
			tempObject.render(g);
		}
	}

	public void addObject(Entity object) {
		this.objects.add(object);
	}

	public void removeObject(Entity object) {
		this.objects.remove(object);
	}

	public void addObject(GameObject object) {
		this.objectBonus.add(object);
	}

	public void removeObject(GameObject object) {
		this.objectBonus.remove(object);
	}
}
