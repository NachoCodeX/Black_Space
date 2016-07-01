package graficos;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage image;

	public SpriteSheet(BufferedImage image) {
		this.image = image;
	}

	public BufferedImage grabImage(int row, int col, int w, int h) {
		BufferedImage img = image.getSubimage((col * 64), (row * 64), w, h);

		return img;
	}

}
