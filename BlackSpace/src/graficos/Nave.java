package graficos;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Nave extends Entity {

	private static final String NOMBRE = "Nave";
	private Proyectiles proyectiles;
	private Handler handler;
	private Texturas textura;
	private BufferedImage texturaDeNave;
	private static final int W = 64, H = 64;
	private BarraDeSalud healthBar;
	public static int SALUD;

	public Nave(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		init();
	}

	private void init() {

		SALUD = 100;
		healthBar = new BarraDeSalud();
		textura = new Texturas();
		texturaDeNave = textura.crearTextura(NOMBRE, 0, 0, W, H);

		this.setVelX(5);
		this.setVelY(5);
		proyectiles = new Proyectiles();
	}

	@Override
	public void update() {
		verificarAcciones();

		proyectiles.update();
		if (x <= 0) {
			x = 0;
		} else if (x >= Juego.ANCHO - 60) {
			x = Juego.ANCHO - 60;
		}
		if (y <= 0) {
			y = 0;
		} else if (y >= Juego.ALTO - 80) {
			y = Juego.ALTO - 80;
		}

		collision();
		bulletCollision();
	}

	@Override
	public void render(Graphics g) {
		healthBar.render(g);
		g.drawImage(texturaDeNave, this.getX(), this.getY(), null);
		// g.setColor(Color.GRAY);
		// g.drawRect(getBounds().x, getBounds().y, getBounds().width,
		// getBounds().height);
		proyectiles.render(g);
	}

	public Rectangle getBounds() {

		return new Rectangle(this.x + 10, this.y + 10, 40, 40);

	}

	private void verificarAcciones() {
		if (isDerecha()) {
			x += this.getVelX();

		}

		if (isIzquierda()) {
			x -= this.getVelX();
		}

		if (isArriba()) {
			y -= this.getVelY();
		}

		if (isAbajo()) {
			y += this.getVelY();
		}

		if (isDisparando() && !isEspacio()) {
			proyectiles.addBullet(new Bala(this.x + 22, this.y));
			this.setEspacio(true);
		}

	}

	private void collision() {
		for (int i = 0; i < ControladorDeEnemigos.aliens.size(); i++) {
			Aliens enemigoTemp = ControladorDeEnemigos.aliens.get(i);

			if (enemigoTemp.getId() == ID.Enemigos) {

				if (getBounds().intersects(enemigoTemp.getBounds()) && !enemigoTemp.isEnColision()) {
					enemigoTemp.setEnColision(true);
					SALUD -= 10;
					System.out.println(SALUD);
					if (SALUD <= 0) {
						Juego.cambiarEstado(GAMESTATE.GAMEOVER);
						System.out.println("ENTRE");
					}

				} else if (!getBounds().intersects(enemigoTemp.getBounds())) {
					enemigoTemp.setEnColision(false);
				}
			}
		}
	}

	private void bulletCollision() {

		for (int i = 0; i < ControladorDeEnemigos.aliens.size(); i++) {
			Aliens tempObject = ControladorDeEnemigos.aliens.get(i);

			if (tempObject.getId() == ID.Enemigos) {

				for (int j = 0; j < proyectiles.objBalas.size(); j++) {
					GameObject balaTemp = proyectiles.objBalas.get(j);

					if (tempObject.getBounds().intersects(balaTemp.getBounds())) {
						ControladorDeEnemigos.removerAlien(tempObject);
						Juego.numEnemigos--;

						int num = (int) (Math.random() * 2) + 0;
						Juego.numEnemigos += num;
						// System.out.println(num);
						ControladorDeEnemigos.crearEnemigos(num);
						proyectiles.removeBullet(balaTemp);
						Juego.score++;
						Juego.enemigosEliminados++;
					}
				}
			}

		}
	}

}
