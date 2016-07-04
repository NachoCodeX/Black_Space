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

}
