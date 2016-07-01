package graficos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		// rectJugar = new Rectangle(Juego.ANCHO / 3 + 40, 150, 100, 50);
		// rectAcercade = new Rectangle(Juego.ANCHO / 3 + 40, 210, 100, 50);
		// rectSalir = new Rectangle(Juego.ANCHO / 3 + 40, 270, 100, 50);
		//

		if (Juego.obtenerEstadoActual() == GAMESTATE.MENU) {

			if (x >= Juego.ANCHO / 3 + 40 && x <= Juego.ANCHO / 3 + 140) {
				if (y >= 150 && y <= 200) {
					Juego.cambiarEstado(GAMESTATE.JUEGO);
					System.out.println("JUGAR!");
				} else if (y >= 210 && y <= 260) {
					System.out.println("AYUDA!");
				} else if (y >= 270 && y <= 320) {
					System.exit(0);
					System.out.println("SALIR!");
				}
			}
		}

		// rectContinuar = new Rectangle(100, 200, 100, 50);
		// rectSalir = new Rectangle(400, 200, 100, 50)

		else if (Juego.obtenerEstadoActual() == GAMESTATE.GAMEOVER) {
			if (x >= 100 && x <= 200) {
				if (y >= 200 && y <= 250) {
					Juego.reiniciar();
					System.out.println("CONTINUAR");
					Juego.cambiarEstado(GAMESTATE.JUEGO);
				}
			} else if (x >= 400 && x <= 500) {
				if (y >= 200 && y <= 250) {
					System.exit(0);
				}
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
