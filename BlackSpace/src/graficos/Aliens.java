package graficos;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Aliens extends Entity {
	private static final String NOMBRE = "Alien";
	private Random rand = new Random(System.nanoTime());
	private int velocidad;
	private Texturas textura = null;
	private BufferedImage texturaDeAlien = null;
	private static final int W = 32, H = 32;
	private int aux = 0;

	public Aliens(int x, int y, ID id) {
		super(x, y, id);
		init();
		this.velocidad = rand.nextInt(5) + 1;
		this.setVelY(velocidad);
	}

	private void init() {
		textura = new Texturas();
		texturaDeAlien = textura.crearTextura(NOMBRE, 0, 0, W, H);

	}

	@Override
	public void update() {
		this.setY(this.getY() + this.getVelY());

		if (Juego.score >= 50)
			moviemientoLados();

		if (y >= Juego.ALTO) {
			this.setY(-20);
			int xTemp = (int) (Math.random() * (Juego.ANCHO - 100)) + 20;
			this.setX(xTemp);
			verificarSalud();

		}
	}

	private void verificarSalud() {
		Nave.SALUD -= 1;
		Juego.score--;
		if (Nave.SALUD <= 0) {
			Juego.cambiarEstado(GAMESTATE.GAMEOVER);
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(texturaDeAlien, x, y, null);
	}

	public Rectangle getBounds() {

		return new Rectangle(x, y, 32, 32);

	}

	public void moviemientoLados() {

		if (aux == 0) {
			this.x += this.velocidad;

			if (this.x >= Juego.ANCHO - 50) {
				this.setX(Juego.ANCHO - 60);
				aux = 1;

			}
		} else if (aux == 1) {
			System.out.println(":d");
			this.x -= this.velocidad;
			if (this.x <= 0) {
				this.setX(10);
				aux = 0;
			}
		}

	}

}
