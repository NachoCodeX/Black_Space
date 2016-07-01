package graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BarraDeSalud {
	private Rectangle lifeRed, lifeGreen;

	public BarraDeSalud() {
		lifeRed = new Rectangle(10, 10, 100, 20);
		lifeGreen = new Rectangle(10, 10, Nave.SALUD, 20);
	}

	public void render(Graphics g) {

		g.setColor(Color.RED);
		g.fillRect(lifeRed.x, lifeRed.y, lifeRed.width, lifeRed.height);
		g.setColor(Color.GREEN);
		g.fillRect(lifeGreen.x, lifeGreen.y, Nave.SALUD, lifeGreen.height);

	}

	public void update() {

	}

}
