package graficos;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {
	protected int x, y, velX, velY;
	protected ID id;
	protected boolean derecha, izquierda, arriba, abajo, espacio, disparando, enColision;

	public Entity(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;

		derecha = false;
		izquierda = false;
		arriba = false;
		abajo = false;
		espacio = false;
		disparando = false;

	}

	public boolean isEnColision() {
		return enColision;
	}

	public void setEnColision(boolean enColision) {
		this.enColision = enColision;
	}

	public Entity(int x, int y) {
		this.x = x;
		this.y = y;

		derecha = false;
		izquierda = false;
		arriba = false;
		abajo = false;

	}

	public boolean isDisparando() {
		return disparando;
	}

	public void setDisparando(boolean disparando) {
		this.disparando = disparando;
	}

	public abstract void update();

	public abstract void render(Graphics g);

	public abstract Rectangle getBounds();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public boolean isDerecha() {
		return derecha;
	}

	public void setDerecha(boolean derecha) {
		this.derecha = derecha;
	}

	public boolean isIzquierda() {
		return izquierda;
	}

	public void setIzquierda(boolean izquierda) {
		this.izquierda = izquierda;
	}

	public boolean isArriba() {
		return arriba;
	}

	public void setArriba(boolean arriba) {
		this.arriba = arriba;
	}

	public boolean isAbajo() {
		return abajo;
	}

	public void setAbajo(boolean abajo) {
		this.abajo = abajo;
	}

	public boolean isEspacio() {
		return espacio;
	}

	public void setEspacio(boolean espacio) {
		this.espacio = espacio;
	}

}
