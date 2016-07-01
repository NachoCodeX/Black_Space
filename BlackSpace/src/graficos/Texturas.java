package graficos;

import java.awt.image.BufferedImage;

public class Texturas {
	private BufferedImageLoader loader = null;
	private SpriteSheet spriteSheet = null;

	public Texturas() {
		loader = new BufferedImageLoader();
	}

	public BufferedImage crearTextura(String nombre, int fila, int col, int w, int h) {
		spriteSheet = new SpriteSheet(loader.loadImage("/" + nombre + ".png"));

		return spriteSheet.grabImage(fila, col, w, h);
	}

}
