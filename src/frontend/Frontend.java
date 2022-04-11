package frontend;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import backend.Dificultad;
import backend.Idioma;
import backend.Modo;
import controller.ControllerAhorcado;

public class Frontend {

	private JFrame frameInicial;
	private JFrame frameModo;
	private JFrame frameIdioma;
	private JFrame frameDificultad;
	private JFrame frameJuego;
	private JPanel panelJuego;

	ControllerAhorcado controlador = new ControllerAhorcado();

	Modo modoAJugar;
	Idioma idiomaAUtilizar;
	Dificultad dificultadAUtilizar;

	public Frontend() {
		initialize();
	}

	public void crearVistaInterfaz() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frontend window = new Frontend();
					window.frameInicial.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initialize() {
		frameInicial();
	}

	private JFrame frameInicial() {
		frameInicial = new JFrame();
		fondoDePantalla(frameInicial);
		frameInicial.setTitle("Ahorcado 2.0");
		frameInicial.setBounds(100, 100, 450, 300);
		frameInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameInicial.getContentPane().setLayout(null);

		fondoDePantalla(frameInicial);

		JButton botonMusicaIniciar = new JButton("\u25B6");
		botonMusicaIniciar.setBounds(393, 0, 43, 23);
		frameInicial.getContentPane().add(botonMusicaIniciar);
		botonMusicaIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Iniciar Musica");
			}
		});

		JButton botonMusicaDetener = new JButton("\u23F8");
		botonMusicaDetener.setBounds(351, 0, 43, 23);
		frameInicial.getContentPane().add(botonMusicaDetener);
		botonMusicaDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Detener Musica");
			}
		});

		JButton botonInstrucciones = new JButton("Instrucciones");
		botonInstrucciones.setBounds(71, 215, 110, 23);
		frameInicial.getContentPane().add(botonInstrucciones);
		botonInstrucciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Instrucciones");
			}
		});

		JButton botonInicio = new JButton("Comenzar juego");
		botonInicio.setBounds(244, 215, 110, 23);
		botonInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Comenzar juego");
			}
		});
		frameInicial.getContentPane().add(botonInicio);
		return frameInicial;
	}

	private JFrame frameModo() {
		frameModo = new JFrame();
		fondoDePantalla(frameModo);
		frameModo.setTitle("Ahorcado 2.0");
		frameModo.setBounds(100, 100, 450, 300);
		frameModo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameModo.getContentPane().setLayout(null);

		JButton botonInicial = new JButton("Modo normal");
		botonInicial.setBounds(169, 56, 100, 23);
		frameModo.getContentPane().add(botonInicial);
		botonInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Modo normal");
			}
		});

		JButton botonMedio = new JButton("Modo torneo");
		botonMedio.setBounds(169, 90, 100, 23);
		frameModo.getContentPane().add(botonMedio);
		botonMedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Modo torneo");
			}
		});

		JButton botonVuelta = new JButton("Volver al menu");
		botonVuelta.setBounds(10, 227, 114, 23);
		frameModo.getContentPane().add(botonVuelta);
		botonVuelta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Volver al menu");
			}
		});

		return frameModo;
	}

	private JFrame frameIdioma() {
		frameIdioma = new JFrame();
		fondoDePantalla(frameIdioma);
		frameIdioma.setTitle("Ahorcado 2.0");
		frameIdioma.getContentPane().setLayout(null);
		frameIdioma.setBounds(100, 100, 450, 300);
		frameIdioma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton botonEspa�ol = new JButton("Espa�ol");
		botonEspa�ol.setBounds(169, 56, 89, 23);
		frameIdioma.getContentPane().add(botonEspa�ol);
		botonEspa�ol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Espa�ol");
			}
		});

		JButton botonIngles = new JButton("Ingles");
		botonIngles.setBounds(169, 90, 89, 23);
		frameIdioma.getContentPane().add(botonIngles);
		botonIngles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Ingles");
			}
		});

		JButton botonPortugues = new JButton("Frances");
		botonPortugues.setBounds(169, 124, 89, 23);
		frameIdioma.getContentPane().add(botonPortugues);
		botonPortugues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Frances");
			}
		});

		JButton botonVuelta = new JButton("Volver al menu");
		botonVuelta.setBounds(10, 227, 114, 23);
		frameIdioma.getContentPane().add(botonVuelta);
		botonVuelta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Volver al menu");
			}
		});

		return frameIdioma;
	}

	private JFrame frameDificultad() {
		frameDificultad = new JFrame();
		fondoDePantalla(frameDificultad);
		frameDificultad.setTitle("Ahorcado 2.0");
		frameDificultad.getContentPane().setLayout(null);
		frameDificultad.setBounds(100, 100, 450, 300);
		frameDificultad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton botonInicial = new JButton("Inicial");
		botonInicial.setBounds(169, 56, 89, 23);
		frameDificultad.getContentPane().add(botonInicial);
		botonInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Inicial");
			}
		});

		JButton botonMedio = new JButton("Medio");
		botonMedio.setBounds(169, 90, 89, 23);
		frameDificultad.getContentPane().add(botonMedio);
		botonMedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Medio");
			}
		});

		JButton botonDificil = new JButton("Dificil");
		botonDificil.setBounds(169, 124, 89, 23);
		frameDificultad.getContentPane().add(botonDificil);
		botonDificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Dificil");
			}
		});

		JButton botonVuelta = new JButton("Volver al menu");
		botonVuelta.setBounds(10, 227, 114, 23);
		frameDificultad.getContentPane().add(botonVuelta);
		botonVuelta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Volver al menu");
			}
		});

		return frameDificultad;
	}

	private JFrame frameJuego() {

		controlador.crearJuego(idiomaAUtilizar, dificultadAUtilizar, modoAJugar);
		frameJuego = new JFrame();
		frameJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameJuego.setBounds(100, 100, 800, 600);

		panelJuego = new JPanel();
		panelJuego.setBorder(new EmptyBorder(5, 5, 5, 5));
		frameJuego.setContentPane(panelJuego);
		panelJuego.setLayout(new BorderLayout(0, 0));

		JLabel palabra = new JLabel(controlador.getPalabra());

		JPanel panel = new JPanel();
		frameJuego.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 8, 0, 0));

		crearBotones(panel);

		JPanel panelCronometro = new JPanel();
		panel.add(panelCronometro);

		panelJuego.add(palabra);

		JLabel etiquetaTextoTiempoRestante = new JLabel("Tiempo restante:");
		panelCronometro.add(etiquetaTextoTiempoRestante);
		etiquetaTextoTiempoRestante.setHorizontalAlignment(SwingConstants.TRAILING);
		etiquetaTextoTiempoRestante.setFont(new Font("Dialog", Font.PLAIN, 10));

		JLabel etiquetaIntentosRestantes = new JLabel(controlador.getIntentosRestantes());
		panelCronometro.add(etiquetaIntentosRestantes);
		etiquetaIntentosRestantes.setFont(new Font("Dialog", Font.BOLD, 14));
		etiquetaIntentosRestantes.setHorizontalAlignment(SwingConstants.CENTER);

		Box verticalBox = Box.createVerticalBox();
		panelCronometro.add(verticalBox);

		Component margenInferiorCentralIzquierdo = Box.createHorizontalGlue();
		panel.add(margenInferiorCentralIzquierdo);

		Component margenInferiorCentralDerecho = Box.createHorizontalGlue();
		panel.add(margenInferiorCentralDerecho);

		JButton botonRendirse = new JButton("Rendirse");
		panel.add(botonRendirse);
		botonRendirse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelesFinales("derrota");
			}
		});

		Component margenInferiorDerecho = Box.createHorizontalGlue();
		panel.add(margenInferiorDerecho);
		return frameJuego;
	}

	public void crearBotones(JPanel panel) {

		JButton[] botones = new JButton[26];
		String[] letras = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z" };

		for (int i = 0; i < botones.length; i++) {
			botones[i] = new JButton(letras[i]);
			botones[i].setSize(40, 40);
			botones[i].setActionCommand(letras[i]);
			ActionListener listener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() instanceof JButton) {
						String boton = e.getActionCommand();
						accionBotonTeclado(boton);
					}
				}
			};

			botones[i].addActionListener(listener);
			panel.add(botones[i]);
		}

	}

	protected void accionBotonTeclado(String tecla) {
		if (controlador.getEstado()) {
			switch (tecla) {
			case "A": {
				controlador.intentar(tecla);
				break;
			}
			case "B": {
				controlador.intentar(tecla);
				break;
			}
			case "C": {
				controlador.intentar(tecla);
				break;
			}
			case "D": {
				controlador.intentar(tecla);
				break;
			}
			case "E": {
				controlador.intentar(tecla);
				break;
			}
			case "F": {
				controlador.intentar(tecla);
				break;
			}
			case "G": {
				controlador.intentar(tecla);
				break;
			}
			case "H": {
				controlador.intentar(tecla);
				break;
			}
			case "I": {
				controlador.intentar(tecla);
				break;
			}
			case "J": {
				controlador.intentar(tecla);
				break;
			}
			case "K": {
				controlador.intentar(tecla);
				break;
			}
			case "L": {
				controlador.intentar(tecla);
				break;
			}
			case "M": {
				controlador.intentar(tecla);
				break;
			}
			case "N": {
				controlador.intentar(tecla);
				break;
			}
			case "�": {
				controlador.intentar(tecla);
				break;
			}
			case "O": {
				controlador.intentar(tecla);
				break;
			}
			case "P": {
				controlador.intentar(tecla);
				break;
			}
			case "Q": {
				controlador.intentar(tecla);
				break;
			}
			case "R": {
				controlador.intentar(tecla);
				break;
			}
			case "S": {
				controlador.intentar(tecla);
				break;
			}
			case "T": {
				controlador.intentar(tecla);
				break;
			}
			case "U": {
				controlador.intentar(tecla);
				break;
			}
			case "V": {
				controlador.intentar(tecla);
				break;
			}
			case "W": {
				controlador.intentar(tecla);
				break;
			}
			case "X": {
				controlador.intentar(tecla);
				break;
			}
			case "Y": {
				controlador.intentar(tecla);
				break;
			}
			case "Z": {
				controlador.intentar(tecla);
				break;
			}
			}
		} else {
			panelesFinales("derrota");
		}

	}

	private void volverAlMenu() {
		frameInicial.setVisible(true);
		if (frameIdioma.isActive()) {
			frameIdioma.setVisible(false);
		} else if (frameModo.isActive()) {
			frameModo.setVisible(false);
		} else if (frameDificultad.isActive()) {
			frameDificultad.setVisible(false);
		} else {
			frameJuego.setVisible(false);
		}
	}

	private void accionBoton(String boton) {
		switch (boton) {
		case "Iniciar Musica": {
			estadoMusica(true);
			break;
		}
		case "Detener Musica": {
			estadoMusica(false);
			break;
		}
		case "Instrucciones": {
			mostrarInstrucciones();
			break;
		}
		case "Comenzar juego": {
			frameModo();
			frameModo.setVisible(true);
			frameInicial.setVisible(false);
			break;
		}
		case "Modo normal": {
			modoAJugar = Modo.NORMAL;
			frameIdioma();
			frameIdioma.setVisible(true);
			frameModo.setVisible(false);
			break;
		}
		case "Modo torneo": {
			modoAJugar = Modo.TORNEO;
			frameIdioma();
			frameIdioma.setVisible(true);
			frameModo.setVisible(false);
			break;
		}
		case "Espa�ol": {
			idiomaAUtilizar = Idioma.ESPANIOL;
			frameDificultad();
			frameDificultad.setVisible(true);
			frameIdioma.setVisible(false);

			break;
		}
		case "Ingles": {
			idiomaAUtilizar = Idioma.INGLES;
			frameDificultad();
			frameDificultad.setVisible(true);
			frameIdioma.setVisible(false);

			break;
		}
		case "Frances": {
			idiomaAUtilizar = Idioma.FRANCES;
			frameDificultad();
			frameDificultad.setVisible(true);
			frameIdioma.setVisible(false);
			break;
		}
		case "Inicial": {
			dificultadAUtilizar = Dificultad.FACIL;
			frameJuego();
			frameJuego.setVisible(true);
			frameDificultad.setVisible(false);
			break;
		}
		case "Medio": {
			dificultadAUtilizar = Dificultad.MEDIO;
			frameJuego();
			frameJuego.setVisible(true);
			frameDificultad.setVisible(false);
			break;
		}
		case "Dificil": {
			dificultadAUtilizar = Dificultad.DIFICIL;
			frameJuego();
			frameJuego.setVisible(true);
			frameDificultad.setVisible(false);
			break;
		}
		case "Volver al menu": {
			volverAlMenu();
			break;
		}
		}
	}

	public void panelesFinales(String condicion) {
		int resultadoFinal;
		String[] buttons = { "Volver al menu", "Salir" };
		switch (condicion) {
		case "victoria":
			resultadoFinal = JOptionPane.showOptionDialog(null, "!Felidades, ganaste!", "!Victoria!",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, buttons, null);
			if (resultadoFinal == JOptionPane.YES_OPTION) {
				volverAlMenu();
			} else if (resultadoFinal == JOptionPane.NO_OPTION) {
				volverAlMenu();
			} else {
				System.exit(0);
			}
			break;
		case "derrota":
			resultadoFinal = JOptionPane.showOptionDialog(null, "!Mejor suerte la proxima!", "Derrota...",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, buttons, null);
			if (resultadoFinal == JOptionPane.YES_OPTION) {
				volverAlMenu();
			} else if (resultadoFinal == JOptionPane.NO_OPTION) {
				volverAlMenu();
			} else {
				System.exit(0);
			}
			break;
		}
	}

	public void mostrarInstrucciones() {
		JOptionPane.showMessageDialog(frameInicial,
				"A continuacion vas a poder seleccionar entre distintas opciones:\nModo de juego\nIdioma\nDificultad");
		JOptionPane.showMessageDialog(frameInicial,
				"Hay dos modos de juego para elegir:\nModo normal: tratas de adivinar la palabra.\nModo torneo: jugas vos y si ganas juega la maquina y asi sucesivamente.");
		JOptionPane.showMessageDialog(frameInicial,
				"Vas a ver tres idiomas para elegir en qu� jugar:\nEspa�ol.\nIngles.\nFrances.");
		JOptionPane.showMessageDialog(frameInicial,
				"Record� que en la dificultad:\nInicial: 5 intentos\nMedio: 3 intentos\nDificil: 1 intento\nSuerte");
	}

	public void estadoMusica(boolean estado) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/data/columbia.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			if (estado) {
				clip.start();
			} else {
				clip.stop();
			}
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}

	private void fondoDePantalla(JFrame frame) {
		try {
			BackgroundPane background = new BackgroundPane();
			background.setBackground(ImageIO.read(new File("src/data/Background.png")));
			frame.setContentPane(background);
			frame.getContentPane().setLayout(null);
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridwidth = GridBagConstraints.REMAINDER;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
