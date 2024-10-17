/* Programa Práctica 2: Entidad Motocicletas
   Paradigmas de programación II
   Profesor: M. en C. Manuel Alejandro Valdés Marrero
   Nombre: Allan Daniel Cruz Matias
   Grupo: 412
 */

package catalogo_motocicletas.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/*
 * Clase VentanaPrincipal que muestra la ventana 
 */
public class VentanaPrincipal extends JFrame {

	private JMenuBar menuBarra;
	private JMenu archivoMenu;
	private JMenu operacionesMenu;
	private JMenu ayudaMenu;
	private JMenuItem abrirArchivo;
	private JMenuItem guardarArchivo;
	private JMenuItem salirArchivo;
	private JMenuItem catalogoOperaciones;
	private JMenuItem consultaOperaciones;
	private JMenuItem acercadeAyuda;

	/*
	 * Id serial obligatorio de la clase.
	 */
	private static final long serialVersionUID = 1L;

	public VentanaPrincipal() {
		super("Catalmotos");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../imagenes/logo.png")));

		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().setLayout(new FlowLayout());
		JLabel fondo = new JLabel();
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("../imagenes/motos.png"));
		Image imagenEscalada = imagenFondo.getImage().getScaledInstance(-1, getSize().height - 80, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(imagenEscalada));
		this.getContentPane().add(fondo);
		this.getContentPane().setBackground(new Color(178, 186, 187));
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());

		// Menús
		archivoMenu = new JMenu("Archivo");
		archivoMenu.setIcon(new ImageIcon(getClass().getResource("../imagenes/archivo.png")));
		archivoMenu.setMnemonic(KeyEvent.VK_A);
		archivoMenu.setToolTipText("Despliega las opciones del archivo.");

		operacionesMenu = new JMenu("Operaciones");
		operacionesMenu.setIcon(new ImageIcon(getClass().getResource("../imagenes/operaciones.png")));
		operacionesMenu.setMnemonic(KeyEvent.VK_O);
		operacionesMenu.setToolTipText("Despliega las opciones de las operaciones.");

		ayudaMenu = new JMenu("Ayuda");
		ayudaMenu.setIcon(new ImageIcon(getClass().getResource("../imagenes/ayuda.png")));
		ayudaMenu.setMnemonic(KeyEvent.VK_Y);
		ayudaMenu.setToolTipText("Despliega ayuda al usuario.");

		// Construcción de opciones de menú
		abrirArchivo = new JMenuItem("Abrir");
		abrirArchivo.setIcon(new ImageIcon(getClass().getResource("../imagenes/abrir.png")));
		abrirArchivo.setMnemonic(KeyEvent.VK_B);
		abrirArchivo.setToolTipText("Abre el archivo a trabajar.");
		abrirArchivo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		abrirArchivo.addActionListener(new ManejoEventosMotocicletas());

		guardarArchivo = new JMenuItem("Guardar");
		guardarArchivo.setIcon(new ImageIcon(getClass().getResource("../imagenes/guardar.png")));
		guardarArchivo.setMnemonic(KeyEvent.VK_G);
		guardarArchivo.setToolTipText("Guarda los cambios realizados en el archivo.");
		guardarArchivo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
		guardarArchivo.addActionListener(new ManejoEventosMotocicletas());

		salirArchivo = new JMenuItem("Salir");
		salirArchivo.setIcon(new ImageIcon(getClass().getResource("../imagenes/salir.png")));
		salirArchivo.setMnemonic(KeyEvent.VK_S);
		salirArchivo.setToolTipText("Cierra la aplicación.");
		salirArchivo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_DOWN_MASK));
		salirArchivo.addActionListener(new ManejoEventosMotocicletas());

		catalogoOperaciones = new JMenuItem("Catálogo");
		catalogoOperaciones.setIcon(new ImageIcon(getClass().getResource("../imagenes/catalogo.png")));
		catalogoOperaciones.setMnemonic(KeyEvent.VK_C);
		catalogoOperaciones.setToolTipText("Abre el catálogo para mostrar las opciones.");
		catalogoOperaciones.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.SHIFT_DOWN_MASK));
		catalogoOperaciones.addActionListener(new ManejoEventosMotocicletas());

		consultaOperaciones = new JMenuItem("Consultas");
		consultaOperaciones.setIcon(new ImageIcon(getClass().getResource("../imagenes/consultar.png")));
		consultaOperaciones.setMnemonic(KeyEvent.VK_N);
		consultaOperaciones.setToolTipText("Muestra la información extraída del archivo.");
		consultaOperaciones.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.SHIFT_DOWN_MASK));
		consultaOperaciones.addActionListener(new ManejoEventosMotocicletas());

		acercadeAyuda = new JMenuItem("Acerca de...");
		acercadeAyuda.setIcon(new ImageIcon(getClass().getResource("../imagenes/acercaDe.png")));
		acercadeAyuda.setMnemonic(KeyEvent.VK_E);
		acercadeAyuda.setToolTipText("Muestra información del sistema.");
		acercadeAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		acercadeAyuda.addActionListener(new ManejoEventosMotocicletas());

		menuBarra = new JMenuBar();
		menuBarra.add(archivoMenu);
		menuBarra.add(operacionesMenu);
		menuBarra.add(ayudaMenu);
		this.setJMenuBar(menuBarra);

		archivoMenu.add(abrirArchivo);
		archivoMenu.add(guardarArchivo);
		archivoMenu.addSeparator();
		archivoMenu.add(salirArchivo);

		operacionesMenu.add(catalogoOperaciones);
		operacionesMenu.addSeparator();
		operacionesMenu.add(consultaOperaciones);

		ayudaMenu.add(acercadeAyuda);

		// Clase anónima
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				metodoSalir();
			}
		});

		this.setResizable(false); // Redimensiona la pantalla
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true); // Permite mostrar la pantalla
	}

	/*
	 * Método para abrir un archivo.
	 */
	private void metodoAbrir() {

	}

	/*
	 * Método para guardar un archivo.
	 */
	private void metodoGuardar() {

	}

	/*
	 * Método que permite cerrar la ventana.
	 */
	private void metodoSalir() {
		dispose();
	}

	/*
	 * Método que permite abrir la ventana Catálogo de Motocicletas.
	 */
	private void metodoCatalogo() {
		new DialogoMotocicletas(this);
	}

	/*
	 * Método que permite consultar el Catálogo de Motocicletas
	 */
	private void metodoConsultas() {

	}

	private void metodoAcercade() {
		JOptionPane.showMessageDialog(this,
				"Catalmotos" + "\n\n" + "Realizado por:" + "\nAllan Daniel Cruz Matias" + "\n\n"
						+ "Derechos reservados UMAR " + '\u00A9' + " 2024",
				"Acerca de... Catalmotos", JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon(getClass().getResource("../Imagenes/logo.png")));
	}

	// Clase interna
	private class ManejoEventosMotocicletas implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(abrirArchivo)) {
				metodoAbrir();
			} else if (e.getSource().equals(guardarArchivo)) {
				metodoGuardar();
			} else if (e.getSource().equals(salirArchivo)) {
				metodoSalir();
			} else if (e.getSource().equals(catalogoOperaciones)) {
				metodoCatalogo();
			} else if (e.getSource().equals(consultaOperaciones)) {
				metodoConsultas();
			} else if (e.getSource().equals(acercadeAyuda)) {
				metodoAcercade();
			}
		}
	}
}
