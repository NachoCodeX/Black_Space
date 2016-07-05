package graficos;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class BonusVida extends GameObject {
	private final static String NOMBRE = "vida";
	private Texturas texturaVida = null;
	private BufferedImage textura = null;
	private static final int W = 30, H = 15;

	public BonusVida(int x, int y) {
		super(x, y);
		this.setVelY(3);
		texturaVida = new Texturas();
		textura = texturaVida.crearTextura(NOMBRE, 0, 0, W, H);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(textura, x, y, null);
		g.drawRect(getBounds().x, getBounds().y, getBounds().width, getBounds().height);
	}

	@Override
	public void update() {
		this.setY(this.getY() + this.getVelY());

	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 30, 15);
	}

}
