/* Programa Práctica 2: Entidad Motocicletas
   Paradigmas de programación II
   Profesor: M. en C. Manuel Alejandro Valdés Marrero
   Nombre: Allan Daniel Cruz Matias
   Grupo: 412
 */

package catalogo_motocicletas.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SpinnerListModel;

import catalogo_motocicletas.utilerias.MiFocusTraversalPolicy;

/*
 * Clase DialogoMotocicletas que contiene los componentes gráficos. 
 */
public class DialogoMotocicletas extends JDialog implements ItemListener {

	/*
	 * Id serial obligatorio de la clase
	 */
	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;
	private JMenuBar menuBarra;
	private JMenu operacionesMenu;
	private JMenuItem nuevoOperaciones;
	private JMenuItem modificarOperaciones;
	private JMenuItem guardarOperaciones;
	private JMenuItem eliminarOperaciones;
	private JMenuItem cancelarOperaciones;
	private JComboBox<String> comboEntidad;
	private JButton botonNuevo;
	private JButton botonModificar;
	private JButton botonGuardar;
	private JButton botonEliminar;
	private JButton botonCancelar;
	private JTextField txtId;
	private JComboBox<String> comboMarca;
	private JComboBox<String> comboModelo;
	private JScrollPane barraDesplazadora;
	private JRadioButton radioGasolina;
	private JRadioButton radioElectrico;
	private JTextField txtSerie;
	private SpinnerListModel spinnerModel;
	private JSpinner spinnerCilindradas;
	private JCheckBox listaCaracteristicaABS;
	private JCheckBox listaCaracteristicaBluetooth;
	private JCheckBox listaCaracteristicaAlarma;
	private JTextField txtFechaFabricacion;
	private JComboBox<String> comboAccesorios;
	private JList<String> listaAccesorios;
	private JButton botonQuitar;
	private JButton botonAgregar;
	private JButton seleccionar;

	/*
	 * Constructor de la clase DialogoMotocicletas que organiza los componentes
	 * gráficos
	 */
	public DialogoMotocicletas(JFrame principal) {
		super(principal, "Catálogo de Motocicletas", true);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../imagenes/logo.png")));
		ventanaPrincipal = (VentanaPrincipal) principal;
		this.setSize(1280, 600);
		this.setLocationRelativeTo(ventanaPrincipal);

		operacionesMenu = new JMenu("Operaciones");
		operacionesMenu.setIcon(new ImageIcon(getClass().getResource("../imagenes/operaciones.png")));
		operacionesMenu.setMnemonic(KeyEvent.VK_P);

		Action actionNuevo = new AbstractAction("Nuevo",
				new ImageIcon(getClass().getResource("../imagenes/nuevo.png"))) {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				metodoNuevo();
			}
		};

		actionNuevo.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		actionNuevo.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_N);
		actionNuevo.putValue(Action.SHORT_DESCRIPTION, "Iniciar la creación nueva de la motocicleta");
		nuevoOperaciones = new JMenuItem(actionNuevo);

		Action actionModificar = new AbstractAction("Modificar",
				new ImageIcon(getClass().getResource("../imagenes/modificar.png"))) {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				metodoModificar();
			}
		};
		actionModificar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK));
		actionModificar.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_O);
		actionModificar.putValue(Action.SHORT_DESCRIPTION, "Hacer modificaciones en la entrada motocicleta");
		modificarOperaciones = new JMenuItem(actionModificar);

		Action actionGuardar = new AbstractAction("Guardar",
				new ImageIcon(getClass().getResource("../imagenes/guardar.png"))) {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				metodoGuardar();
			}
		};
		actionGuardar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
		actionGuardar.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_G);
		actionGuardar.putValue(Action.SHORT_DESCRIPTION, "Guardar los cambios realizados");
		guardarOperaciones = new JMenuItem(actionGuardar);

		Action actionEliminar = new AbstractAction("Eliminar",
				new ImageIcon(getClass().getResource("../imagenes/eliminar.png"))) {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				metodoEliminar();
			}
		};
		actionEliminar.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_E);
		actionEliminar.putValue(Action.SHORT_DESCRIPTION, "Eliminar lo que se haya ingresado");
		eliminarOperaciones = new JMenuItem(actionEliminar);

		Action actionCancelar = new AbstractAction("Cancelar",
				new ImageIcon(getClass().getResource("../imagenes/cancelar.png"))) {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				metodoCancelar();
			}
		};
		actionCancelar.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_R);
		actionCancelar.putValue(Action.SHORT_DESCRIPTION, "Cancelar los cambios");
		cancelarOperaciones = new JMenuItem(actionCancelar);

		getContentPane().setLayout(new BorderLayout());
		JPanel panelNorte = new JPanel();
		JPanel panelEste = new JPanel();
		JPanel panelOeste = new JPanel();
		JPanel panelCentro = new JPanel();
		JPanel panelAuxiliar = new JPanel();

		// Panel norte
		panelNorte.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 20));// xy

		JLabel nombreEntidad = new JLabel("Entidades");
		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelAuxiliar.add(nombreEntidad);
		panelNorte.add(panelAuxiliar);

		comboEntidad = new JComboBox<String>();
		nombreEntidad.setLabelFor(comboEntidad);
		nombreEntidad.setDisplayedMnemonic(KeyEvent.VK_D);
		comboEntidad.setPreferredSize(new Dimension(345, 20));
		comboEntidad.setToolTipText("Seleccionar la entidad de la motocicleta");
		comboEntidad.addItemListener(this);
		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelAuxiliar.add(comboEntidad);
		panelNorte.add(panelAuxiliar);

		panelEste.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelEste.setPreferredSize(new Dimension(235, 20));

		//////////// Panel Este
		panelEste.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelEste.setPreferredSize(new Dimension(235, 20));
		// Botón nuevo
		botonNuevo = new JButton(actionNuevo);
		botonNuevo.getActionMap().put("btnNuevo", actionNuevo);
		botonNuevo.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) actionNuevo.getValue(Action.ACCELERATOR_KEY), "btnNuevo");

		botonNuevo.setPreferredSize(new Dimension(192, 36));// ancho y alto

		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelAuxiliar.add(botonNuevo);
		panelEste.add(panelAuxiliar);
		// Botón modificar
		botonModificar = new JButton(actionModificar);
		botonModificar.getActionMap().put("btnModificar", actionModificar);
		botonModificar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) actionModificar.getValue(Action.ACCELERATOR_KEY), "btnModificar");

		botonModificar.setPreferredSize(new Dimension(192, 36));

		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelAuxiliar.add(botonModificar);
		panelEste.add(panelAuxiliar);
		// Botón guardar
		botonGuardar = new JButton(actionGuardar);
		botonGuardar.getActionMap().put("btnGuardar", actionGuardar);
		botonGuardar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) actionGuardar.getValue(Action.ACCELERATOR_KEY), "btnGuardar");

		botonGuardar.setPreferredSize(new Dimension(192, 36));

		panelAuxiliar = new JPanel();
		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelAuxiliar.add(botonGuardar);
		panelEste.add(panelAuxiliar);
		// Botón eliminar
		botonEliminar = new JButton(actionEliminar);
		botonEliminar.setPreferredSize(new Dimension(192, 36));

		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelAuxiliar.add(botonEliminar);
		panelEste.add(panelAuxiliar);
		// Botón cancelar
		botonCancelar = new JButton(actionCancelar);
		botonCancelar.setPreferredSize(new Dimension(192, 36));

		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelAuxiliar.add(botonCancelar);
		panelEste.add(panelAuxiliar);

		//////// Panel Oeste
		panelOeste.setLayout(new GridLayout(6, 2));// filas y columnas

		JLabel id = new JLabel("1. Id");
		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.RIGHT, 149, 0));// xy
		panelAuxiliar.add(id);
		panelOeste.add(panelAuxiliar);
		// caja de texto id
		txtId = new JTextField("");
		id.setLabelFor(txtId);
		id.setDisplayedMnemonic(KeyEvent.VK_1);
		txtId.setPreferredSize(new Dimension(192, 20));
		txtId.setToolTipText("Ingresar el ID de la motocicleta");
		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelAuxiliar.add(txtId);
		panelOeste.add(panelAuxiliar);

		JLabel marca = new JLabel("2. Marca");
		// guardarArchivo.setMnemonic(KeyEvent.VK_G);
		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.RIGHT, 126, 0));
		panelAuxiliar.add(marca);
		panelOeste.add(panelAuxiliar);
		// caja de texto id
		comboMarca = new JComboBox<String>();
		marca.setLabelFor(comboMarca);
		marca.setDisplayedMnemonic(KeyEvent.VK_2);
		comboMarca.setPreferredSize(new Dimension(192, 20));
		comboMarca.setToolTipText("Seleccionar la marca de la motocicleta");
		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelAuxiliar.add(comboMarca);
		panelOeste.add(panelAuxiliar);

		JLabel modeloNombre = new JLabel("3. Modelo");
		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.RIGHT, 123, 0));
		panelAuxiliar.add(modeloNombre);
		panelOeste.add(panelAuxiliar);

		// area de texto con scroll del modelo
		comboModelo = new JComboBox<String>();
		modeloNombre.setLabelFor(comboModelo);
		modeloNombre.setDisplayedMnemonic(KeyEvent.VK_3);
		comboModelo.setPreferredSize(new Dimension(192, 20));
		comboModelo.setToolTipText("Seleccionar el modelo de la motocicleta");
		barraDesplazadora = new JScrollPane(comboModelo);
		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelAuxiliar.add(barraDesplazadora);
		panelOeste.add(panelAuxiliar);

		JLabel tipoCombustible = new JLabel("4. Tipo de combustible");
		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.RIGHT, 50, 0));// 100,5
		panelAuxiliar.add(tipoCombustible);
		panelOeste.add(panelAuxiliar);
		// radios del combustible
		radioGasolina = new JRadioButton("Gasolina");
		tipoCombustible.setLabelFor(radioGasolina);
		tipoCombustible.setDisplayedMnemonic(KeyEvent.VK_4);
		radioElectrico = new JRadioButton("Eléctrico");
		tipoCombustible.setLabelFor(radioGasolina);
		ButtonGroup group = new ButtonGroup();
		group.add(radioGasolina);
		group.add(radioElectrico);
		radioGasolina.setSelected(true);
		radioGasolina.setToolTipText("Seleccionar si el combustible es Gasolina");
		radioGasolina.setMnemonic(KeyEvent.VK_S);
		radioElectrico.setToolTipText("Seleccionar si es de tipo Eléctrico");
		radioElectrico.setMnemonic(KeyEvent.VK_L);
		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelAuxiliar.add(radioGasolina);
		panelAuxiliar.add(radioElectrico);
		panelOeste.add(panelAuxiliar);

		JLabel serie = new JLabel("5. Serie");
		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.RIGHT, 136, 0));
		panelAuxiliar.add(serie);
		panelOeste.add(panelAuxiliar);
		// caja de texto serie
		txtSerie = new JTextField("");
		serie.setLabelFor(txtSerie);
		serie.setDisplayedMnemonic(KeyEvent.VK_5);
		txtSerie.setPreferredSize(new Dimension(192, 20));
		txtSerie.setToolTipText("Ingresar la serie de la motocicleta (ejemplo: JYA1GP1C5DA123456)");
		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelAuxiliar.add(txtSerie);
		panelOeste.add(panelAuxiliar);

		JLabel cilindrada = new JLabel("6. Cilindrada");
		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.RIGHT, 108, 0));
		panelAuxiliar.add(cilindrada);
		panelOeste.add(panelAuxiliar);
		// spinner de cilindradas
		spinnerModel = new SpinnerListModel(new String[] { "50", "125", "250", "300", "500", "1000" });
		spinnerCilindradas = new JSpinner(spinnerModel);
		cilindrada.setLabelFor(spinnerCilindradas);
		cilindrada.setDisplayedMnemonic(KeyEvent.VK_6);
		spinnerCilindradas.setPreferredSize(new Dimension(192, 20));
		spinnerCilindradas.setToolTipText("Seleccionar la cilindrada de la motocicleta");
		JFormattedTextField txt = ((JSpinner.DefaultEditor) spinnerCilindradas.getEditor()).getTextField();// se obtiene
																											// el
																											// spinner
		txt.setEditable(false); // se inhabilita la caja de texto del spinner
		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelAuxiliar.add(spinnerCilindradas);
		panelOeste.add(panelAuxiliar);

		//////// ***************Panel
		//////// Centro
		panelCentro.setLayout(new GridLayout(6, 2));// filas y columnas

		JLabel espacioImagen = new JLabel("7. Imagen");
		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 0));
		panelAuxiliar.add(espacioImagen);
		panelCentro.add(panelAuxiliar);
		// Etiqueta para mostrar la imagen
		JLabel imagen = new JLabel("Imagen");
		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelAuxiliar.add(imagen);
		panelCentro.add(panelAuxiliar);

		Action actionselec = new AbstractAction("Seleccionar",
				new ImageIcon(getClass().getResource("../imagenes/seleccionar.png"))) {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				metodoSeleccionar();
			}
		};
		actionselec.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_C);
		actionselec.putValue(Action.SHORT_DESCRIPTION, "Seleccionar imagen");
		JButton seleccionar = new JButton(actionselec);
		panelAuxiliar.add(seleccionar);

		JLabel caracteristicasFijas = new JLabel("8. Características propias");
		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 0));
		panelAuxiliar.add(caracteristicasFijas);
		panelCentro.add(panelAuxiliar);

		listaCaracteristicaABS = new JCheckBox("ABS");
		caracteristicasFijas.setLabelFor(listaCaracteristicaABS);
		caracteristicasFijas.setDisplayedMnemonic(KeyEvent.VK_8);
		listaCaracteristicaABS.setBounds(50, 10, 120, 60);
		listaCaracteristicaABS.setToolTipText("Seleccionar si la característica es ABS");

		listaCaracteristicaABS.setMnemonic(KeyEvent.VK_B);
		// add(listaCaracteristicaABS);
		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelAuxiliar.add(listaCaracteristicaABS);

		listaCaracteristicaBluetooth = new JCheckBox("Bluetooth");
		listaCaracteristicaBluetooth.setMnemonic(KeyEvent.VK_T);
		listaCaracteristicaBluetooth.setToolTipText("Seleccionar si la característica es Bluetooth");
		panelAuxiliar.add(listaCaracteristicaBluetooth);

		listaCaracteristicaAlarma = new JCheckBox("Alarma");
		listaCaracteristicaAlarma.setMnemonic(KeyEvent.VK_M);
		listaCaracteristicaAlarma.setToolTipText("Seleccionar si la característica es Alarma");
		panelAuxiliar.add(listaCaracteristicaAlarma);
		panelCentro.add(panelAuxiliar);

		JLabel fecha = new JLabel("9. Fecha de fabricación");
		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 0));
		panelAuxiliar.add(fecha);
		panelCentro.add(panelAuxiliar);
		// caja de texto fecha fabricación
		txtFechaFabricacion = new JTextField("");
		fecha.setLabelFor(txtFechaFabricacion);
		fecha.setDisplayedMnemonic(KeyEvent.VK_9);
		txtFechaFabricacion.setPreferredSize(new Dimension(182, 20));
		txtFechaFabricacion.setToolTipText("Ingresar la fecha de fabricación de la motocicleta");
		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelAuxiliar.add(txtFechaFabricacion);
		panelCentro.add(panelAuxiliar);

		JLabel accesorios = new JLabel("10. Accesorios");
		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 0));
		panelAuxiliar.add(accesorios);
		panelCentro.add(panelAuxiliar);
		// Etiqueta para la imagen
		comboAccesorios = new JComboBox<String>();
		accesorios.setLabelFor(comboAccesorios);
		accesorios.setDisplayedMnemonic(KeyEvent.VK_0);
		comboAccesorios.setEditable(true);
		comboAccesorios.setPreferredSize(new Dimension(182, 20));
		comboAccesorios.setToolTipText("Seleccionar un accesorio para la motocicleta");
		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelAuxiliar.add(comboAccesorios);
		panelCentro.add(panelAuxiliar);

		JLabel espacioAccesorios = new JLabel(" ");
		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelAuxiliar.add(espacioAccesorios);
		panelCentro.add(panelAuxiliar);

		comboAccesorios.addItem("Casco");
		comboAccesorios.addItem("Guantes");
		comboAccesorios.addItem("Chaqueta");
		comboAccesorios.addItem("GPS");

		// botones
		Action actionAgregar = new AbstractAction("Agregar",
				new ImageIcon(getClass().getResource("../imagenes/agregar.png"))) {
			/*
			 * Id serial obligatorio de la clase
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				metodoAgregar();
			}
		};
		actionAgregar.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_A);
		actionAgregar.putValue(Action.SHORT_DESCRIPTION, "Agregar los accesorios de la motocicleta");
		JButton botonAgregar = new JButton(actionAgregar);

		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelAuxiliar.add(botonAgregar);

		Action actionQuitar = new AbstractAction("Quitar",
				new ImageIcon(getClass().getResource("../imagenes/quitar.png"))) {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				metodoQuitar();
			}
		};
		actionQuitar.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_Q);
		actionQuitar.putValue(Action.SHORT_DESCRIPTION, "Quita el accesorio seleccionado de la lista");
		JButton botonQuitar = new JButton(actionQuitar);

		panelAuxiliar.add(botonQuitar);
		panelCentro.add(panelAuxiliar);

		JLabel espacioBotones = new JLabel(" ");
		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelAuxiliar.add(espacioBotones);
		panelCentro.add(panelAuxiliar);
		// JList para agregar accesorios
		DefaultListModel<String> caracteristicas2 = new DefaultListModel<>();
		listaAccesorios = new JList<>(caracteristicas2);
		listaAccesorios.setToolTipText("Lista de accesorios seleccionados para la motocicleta");
		JScrollPane barraDesplazadora3 = new JScrollPane(listaAccesorios);
		barraDesplazadora3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		barraDesplazadora3.setPreferredSize(new Dimension(182, 70));
		panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelAuxiliar.add(barraDesplazadora3);
		panelCentro.add(panelAuxiliar);

		menuBarra = new JMenuBar();
		// agregar el menu a la barra
		menuBarra.add(operacionesMenu);
		// agregar las operaciones al menu operaciones
		operacionesMenu.add(nuevoOperaciones);
		operacionesMenu.add(modificarOperaciones);
		operacionesMenu.add(guardarOperaciones);
		operacionesMenu.add(eliminarOperaciones);
		operacionesMenu.add(cancelarOperaciones);
		this.setJMenuBar(menuBarra);

		// paneles
		getContentPane().add(panelNorte, BorderLayout.NORTH);// norte
		getContentPane().add(panelEste, BorderLayout.EAST);// este
		getContentPane().add(panelOeste, BorderLayout.WEST);// oeste
		getContentPane().add(panelCentro, BorderLayout.CENTER);// oeste

		establecerPoliticaFocoGUI();
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	/*
	 * Método privado limpiarCampos() que limpiará el contenido de los campos de
	 * texto del diálogo y seleccionará el valor por defecto en los radios / listas
	 * desplegables con opciones fijas.
	 */
	private void limpiarCampos() {
		txtId.setText("");
		comboMarca.setSelectedIndex(0);
		comboModelo.setSelectedIndex(0);
		txtSerie.setText("");
		txtFechaFabricacion.setText("");
		radioGasolina.setSelected(true);
		listaCaracteristicaABS.setSelected(false);
		listaCaracteristicaBluetooth.setSelected(false);
		listaCaracteristicaAlarma.setSelected(false);
		comboAccesorios.setSelectedIndex(-1);
		listaAccesorios.clearSelection();
	}

	/*
	 * Método privado habilitarCampos(boolean) que habilitará o deshabilitará la
	 * escritura de los campos de texto
	 */
	private void habilitarCampos(boolean habilitar) {
		txtId.setEnabled(habilitar);
		comboMarca.setEnabled(habilitar);
		comboModelo.setEnabled(habilitar);
		txtSerie.setEnabled(habilitar);
		txtFechaFabricacion.setEnabled(habilitar);
		radioGasolina.setEnabled(habilitar);
		radioElectrico.setEnabled(habilitar);
		listaCaracteristicaABS.setEnabled(habilitar);
		listaCaracteristicaBluetooth.setEnabled(habilitar);
		listaCaracteristicaAlarma.setEnabled(habilitar);
		comboAccesorios.setEnabled(habilitar);
		listaAccesorios.setEnabled(habilitar);
		botonAgregar.setEnabled(habilitar);
		botonQuitar.setEnabled(habilitar);
		seleccionar.setEnabled(habilitar);
	}

	/*
	 * Método privado verificarLista() que verificará si la lista desplegable
	 * principal tiene elementos.
	 */
	private void verificarLista() {
		boolean tieneElementos = comboEntidad.getItemCount() > 0;

		modificarOperaciones.setEnabled(tieneElementos);
		eliminarOperaciones.setEnabled(tieneElementos);
		comboEntidad.setEnabled(tieneElementos);
	}

	/*
	 * Método inicializar(), que es llamado para inicializar el diálogo
	 */
	private void inicializar() {

	}

	/*
	 * Método que permite crear un nuevo registro
	 */
	private void metodoNuevo() {
		habilitarCampos(true);
	    limpiarCampos();  

	    botonGuardar.setEnabled(true);  
	    guardarOperaciones.setEnabled(true);
	    botonCancelar.setEnabled(true);
	    cancelarOperaciones.setEnabled(true);

	    botonNuevo.setEnabled(false);  
	    nuevoOperaciones.setEnabled(false);
	    botonModificar.setEnabled(false);
	    modificarOperaciones.setEnabled(false);
	    botonEliminar.setEnabled(false);
	    eliminarOperaciones.setEnabled(false);

	    comboEntidad.setEnabled(false);  
	    JOptionPane.showMessageDialog(this, "Nuevo", "Nuevo", JOptionPane.INFORMATION_MESSAGE);
	}

	/*
	 * Método que permite modificar un registro
	 */
	private void metodoModificar() {
		JOptionPane.showMessageDialog(this, "Modificar", "Modificar", JOptionPane.INFORMATION_MESSAGE);
	}

	/*
	 * Método que permite guardar el registro
	 */
	private void metodoGuardar() {
		JOptionPane.showMessageDialog(this, "Guardar", "Guardar", JOptionPane.INFORMATION_MESSAGE);

	}

	/*
	 * Método que permite eliminar el registro
	 */
	private void metodoEliminar() {
		JOptionPane.showMessageDialog(this, "Eliminar", "Eliminar", JOptionPane.INFORMATION_MESSAGE);

	}

	/*
	 * Método que permite cancelar el registro
	 */
	private void metodoCancelar() {
		habilitarCampos(false);  
	    limpiarCampos();  
	   
	    botonNuevo.setEnabled(true);
	    nuevoOperaciones.setEnabled(true);
	    
	   
	    botonGuardar.setEnabled(false);
	    guardarOperaciones.setEnabled(false);
	    botonCancelar.setEnabled(false);
	    cancelarOperaciones.setEnabled(false);

	    verificarLista();
	    
	    JOptionPane.showMessageDialog(this, "Operación cancelada.", "Cancelar", JOptionPane.INFORMATION_MESSAGE);

	}

	/*
	 * Método que permite agreagr un registro
	 */
	private void metodoAgregar() {
		JOptionPane.showMessageDialog(this, "Agregar", "Agregar", JOptionPane.INFORMATION_MESSAGE);

	}

	/*
	 * Método que permite quitar el registro
	 */
	private void metodoQuitar() {
		JOptionPane.showMessageDialog(this, "Quitar", "Quitar", JOptionPane.INFORMATION_MESSAGE);
	}

	/*
	 * Método que permite seleccionar una imagen
	 */
	private void metodoSeleccionar() {
		JOptionPane.showMessageDialog(this, "Seleccionar", "Seleccionar", JOptionPane.INFORMATION_MESSAGE);
	}

	/*
	 * Método para establecer el orden de cada componente usando la tecla tabulador
	 */
	private void establecerPoliticaFocoGUI() {

		Vector<Component> componentes = new Vector<Component>();
		componentes.add(botonNuevo);
		componentes.add(botonModificar);
		componentes.add(botonGuardar);
		componentes.add(botonEliminar);
		componentes.add(botonCancelar);
		componentes.add(txtId);
		componentes.add(comboMarca);
		componentes.add(comboModelo);
		componentes.add(radioGasolina);
		componentes.add(radioElectrico);
		componentes.add(txtSerie);
		componentes.add(spinnerCilindradas);
		componentes.add(seleccionar);
		componentes.add(listaCaracteristicaABS);
		componentes.add(txtFechaFabricacion);
		componentes.add(comboAccesorios);
		componentes.add(listaAccesorios);
		componentes.add(botonAgregar);
		componentes.add(botonQuitar);

		MiFocusTraversalPolicy politicaFoco = new MiFocusTraversalPolicy(componentes);
		this.setFocusTraversalPolicy(politicaFoco);

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub

	}

}