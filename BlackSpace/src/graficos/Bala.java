package graficos;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Bala extends GameObject {

	private static final String path = "bala";

	private BufferedImage texturaDeBala;
	private Texturas textura;
	private static int W = 16, H = 16;

	public Bala(int x, int y) {
		super(x, y);
		init();
		this.setVelY(10);
	}

	private void init() {
		textura = new Texturas();
		texturaDeBala = textura.crearTextura(path, 0, 0, W, H);
	}

	@Override
	public void update() {
		this.y -= this.getVelY();
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(texturaDeBala, this.getX(), this.getY(), null);
		// g.setColor(Color.BLUE);
		// g.drawRect(getBounds().x, getBounds().y, getBounds().width,
		// getBounds().height);
	}

}
