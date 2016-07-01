package graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Menu {
	private Font fuenteTitulo;
	private Font fuenteNormal;
	private Color[] color = { Color.DARK_GRAY, Color.gray, Color.white };
	private Random rand = new Random(System.nanoTime());
	private int colorAzar;

	private Rectangle rectJugar, rectAcercade, rectSalir;

	public Menu() {
		fuenteTitulo = new Font("Arial", Font.BOLD, 50);
		fuenteNormal = new Font("Arial", Font.BOLD, 20);
		colorAzar = rand.nextInt(3);

		rectJugar = new Rectangle(Juego.ANCHO / 3 + 40, 150, 100, 50);
		rectAcercade = new Rectangle(Juego.ANCHO / 3 + 40, 210, 100, 50);
		rectSalir = new Rectangle(Juego.ANCHO / 3 + 40, 270, 100, 50);
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		// TITULO
		g2d.setColor(color[colorAzar]);
		g2d.setFont(fuenteTitulo);
		g2d.drawString("Black Space", Juego.ANCHO / 4, 100);
		// Boton JUGAR
		g2d.setColor(Color.WHITE);
		g2d.draw(rectJugar);
		g2d.setFont(fuenteNormal);
		g2d.drawString("Jugar!", rectJugar.x + 20, rectJugar.y + 30);

		// Boton Aceca de
		g2d.draw(rectAcercade);
		g2d.drawString("Acerca de", rectAcercade.x + 7, rectAcercade.y + 30);

		// Boton de salir
		g2d.draw(rectSalir);
		g2d.drawString("Salir", rectSalir.x + 20, rectSalir.y + 30);
	}

	public void update() {
		colorAzar = rand.nextInt(3);
	}
}
