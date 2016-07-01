package graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class GameOver {

	private Rectangle rectContinuar, rectSalir;

	public GameOver() {
		rectContinuar = new Rectangle(100, 200, 100, 50);
		rectSalir = new Rectangle(400, 200, 100, 50);
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(Color.RED);
		g2d.setFont(new Font("Arial", Font.BOLD, 50));
		g2d.drawString("PERDISTE!", Juego.ANCHO / 3 - 50, 100);

		g2d.setFont(new Font("Arial", Font.BOLD, 20));
		g2d.draw(rectContinuar);
		g2d.drawString("Continar", rectContinuar.x + 10, rectContinuar.y + 30);

		g2d.draw(rectSalir);
		g2d.drawString("Salir", rectSalir.x + 10, rectSalir.y + 30);

	}
}
