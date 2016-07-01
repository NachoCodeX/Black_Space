package graficos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import javax.swing.JFrame;

public class Juego extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame ventana;
	public static final int ANCHO = 640, ALTO = 480;
	private static volatile boolean enJuego;
	private Thread hilo;
	private static Handler handler;
	private int numEnemigos;
	public static boolean alienMeta = false;
	private Random rand = new Random(System.nanoTime());
	public static int enemigosEliminados = 0;
	public static int score;
	private static GAMESTATE STATE;
	private Menu menu;

	private static int FPSSCREEN = 0;

	public Juego() {
		numEnemigos = 6;
		score = 0;
		STATE = GAMESTATE.MENU;
		enJuego = true;

		this.setSize(ANCHO, ALTO);
		menu = new Menu();
		crearVentana();

		handler = new Handler();
		handler.addObject(new Nave(Juego.ANCHO / 2, Juego.ALTO - 100, ID.Nave, handler));
		handler.crearAliens(numEnemigos);

		menu = new Menu();

		this.addKeyListener(new Teclado(handler));
		this.addMouseListener(new Mouse());
		this.setIgnoreRepaint(true);
		this.requestFocus();
		this.requestFocusInWindow();

	}

	private void crearVentana() {
		ventana = new JFrame();
		ventana.setTitle("Black Space");

		ventana.setPreferredSize(new Dimension(ANCHO, ALTO));
		ventana.setMinimumSize(new Dimension(ANCHO, ALTO));
		ventana.setMaximumSize(new Dimension(ANCHO, ALTO));

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setResizable(false);
		// Agregarndo el canvas
		ventana.add(this);
		ventana.pack();
		ventana.setVisible(true);

	}

	public synchronized void iniciar() {
		hilo = new Thread(this);
		hilo.start();
	}

	public synchronized void detener() {
		try {
			hilo.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void render() {

		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			this.createBufferStrategy(2);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, ANCHO, ALTO);

		if (STATE.equals(GAMESTATE.JUEGO)) {
			// Muestra FPS
			g.setColor(Color.GREEN);
			g.drawString("FPS: " + FPSSCREEN, ANCHO - 100, 10);
			// Muestra el marcador
			g.setColor(Color.YELLOW);
			g.drawString("Score: " + score, 10, 50);

			handler.render(g);
		} else if (STATE.equals(GAMESTATE.MENU)) {

			menu.render(g);

		} else if (STATE.equals(GAMESTATE.GAMEOVER)) {
			new GameOver().render(g);
		}

		g.dispose();
		bs.show();

	}

	private void update() {
		if (STATE.equals(GAMESTATE.JUEGO)) {
			handler.update();

			if (enemigosEliminados == numEnemigos) {
				numEnemigos = rand.nextInt(10) + 2;
				handler.crearAliens(numEnemigos);
				enemigosEliminados = 0;
			}
		} else if (STATE.equals(GAMESTATE.MENU)) {
			menu.update();
		}
	}

	public static void cambiarEstado(GAMESTATE temp) {
		STATE = temp;
	}

	public static GAMESTATE obtenerEstadoActual() {
		return STATE;
	}

	public static void reiniciar() {
		Nave.SALUD = 100;
		score = 0;
		enemigosEliminados = 6;

		handler.limpiarNivel();

	}

	@Override
	public void run() {
		// Tomamos una referencia de tiempo en nano-segundos
		long lastTime = System.nanoTime();
		// Numero de nano-segundos en un segundo
		final int NS_POR_SEG = 1000000000;

		// Numero de Actualizaciones que queremos.
		final double APS = 60.0;

		// Cuantos nano-segundos pasan en 60 actualizaciones
		final double NS_POR_A = NS_POR_SEG / APS;

		// Tiempo transcurrido
		double tiempoTranscurrido = 0.0;

		// delta
		double delta = 0;

		// Agregado para mostrar FPS y APS
		long reframe = System.nanoTime();
		int fps = 0, aps = 0;

		while (enJuego) {

			// Tiempo de referencia en nano-segundos tomado desde este punto
			final long inicioBucle = System.nanoTime();

			/*
			 * Tomamos el tiempo transcurrido hasta ahora haciendo una simple
			 * resta del ultimo tiempo con el primero
			 */
			tiempoTranscurrido = inicioBucle - lastTime;

			lastTime = inicioBucle;

			delta += tiempoTranscurrido / NS_POR_A;

			if (delta >= 1) {
				update();
				delta--;
				aps++;
			}

			// render
			render();
			fps++;

			if (System.nanoTime() - reframe > NS_POR_SEG) {
				reframe = System.nanoTime();

				// System.out.println("fps: " + fps + "|| aps: " + aps);
				FPSSCREEN = fps;
				aps = 0;
				fps = 0;
			}

		}
	}

}
