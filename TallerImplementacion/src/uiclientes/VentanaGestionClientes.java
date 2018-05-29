package uiclientes;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import dominioclientes.ClienteNoRegistradoException;
import logicaclientes.ControlGestionClientes;
import logicaclientes.IControlClientes;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * Ventana (interfaz gráfica) para hacer la gestión de un cliente, es decir,
 * permite consultar, adicionar, modificar o eliminar un cliente.
 * La parte visual fue generada a partir del editor visual de Eclipse.
 * Esta clase es parte de un taller, puede estar incompleta.
 * @author Sandra V. Hurtado
 * @version 1.0
 */
@SuppressWarnings("serial")
public class VentanaGestionClientes extends JFrame {

	private JPanel contentPane;
	private JTextField textDocumento;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textTelefono;
	private JTextField textCorreo;
	private JButton btnConsultar;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	
	private IControlClientes controlClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaGestionClientes frame = new VentanaGestionClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaGestionClientes() {
		
		controlClientes = new ControlGestionClientes(2);
		
		setTitle("Gestión de Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{94, 89, 89, 89, 0};
		gbl_contentPane.rowHeights = new int[]{20, 20, 20, 20, 20, 31, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblDocumento = new JLabel("Documento:");
		GridBagConstraints gbc_lblDocumento = new GridBagConstraints();
		gbc_lblDocumento.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDocumento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDocumento.gridx = 0;
		gbc_lblDocumento.gridy = 0;
		contentPane.add(lblDocumento, gbc_lblDocumento);
		
		textDocumento = new JTextField();
		textDocumento.setEnabled(false);
		GridBagConstraints gbc_textDocumento = new GridBagConstraints();
		gbc_textDocumento.anchor = GridBagConstraints.NORTHWEST;
		gbc_textDocumento.insets = new Insets(0, 0, 5, 5);
		gbc_textDocumento.gridwidth = 2;
		gbc_textDocumento.gridx = 1;
		gbc_textDocumento.gridy = 0;
		contentPane.add(textDocumento, gbc_textDocumento);
		textDocumento.setColumns(10);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ejecutarConsulta();
			}
		});
		GridBagConstraints gbc_btnConsultar = new GridBagConstraints();
		gbc_btnConsultar.insets = new Insets(0, 0, 5, 0);
		gbc_btnConsultar.anchor = GridBagConstraints.NORTH;
		gbc_btnConsultar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnConsultar.gridx = 3;
		gbc_btnConsultar.gridy = 0;
		contentPane.add(btnConsultar, gbc_btnConsultar);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		contentPane.add(lblNombre, gbc_lblNombre);
		
		textNombre = new JTextField();
		textNombre.setEnabled(false);
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.anchor = GridBagConstraints.NORTH;
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textNombre.gridwidth = 3;
		gbc_textNombre.gridx = 1;
		gbc_textNombre.gridy = 1;
		contentPane.add(textNombre, gbc_textNombre);
		textNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.WEST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 0;
		gbc_lblApellidos.gridy = 2;
		contentPane.add(lblApellidos, gbc_lblApellidos);
		
		textApellidos = new JTextField();
		textApellidos.setEnabled(false);
		GridBagConstraints gbc_textApellidos = new GridBagConstraints();
		gbc_textApellidos.anchor = GridBagConstraints.NORTH;
		gbc_textApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_textApellidos.insets = new Insets(0, 0, 5, 0);
		gbc_textApellidos.gridwidth = 3;
		gbc_textApellidos.gridx = 1;
		gbc_textApellidos.gridy = 2;
		contentPane.add(textApellidos, gbc_textApellidos);
		textApellidos.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Teléfono:");
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.WEST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 0;
		gbc_lblTelefono.gridy = 3;
		contentPane.add(lblTelefono, gbc_lblTelefono);
		
		textTelefono = new JTextField();
		textTelefono.setEnabled(false);
		GridBagConstraints gbc_textTelefono = new GridBagConstraints();
		gbc_textTelefono.anchor = GridBagConstraints.NORTHWEST;
		gbc_textTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_textTelefono.gridwidth = 2;
		gbc_textTelefono.gridx = 1;
		gbc_textTelefono.gridy = 3;
		contentPane.add(textTelefono, gbc_textTelefono);
		textTelefono.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo:");
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.anchor = GridBagConstraints.WEST;
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.gridx = 0;
		gbc_lblCorreo.gridy = 4;
		contentPane.add(lblCorreo, gbc_lblCorreo);
		
		textCorreo = new JTextField();
		textCorreo.setEnabled(false);
		GridBagConstraints gbc_textCorreo = new GridBagConstraints();
		gbc_textCorreo.anchor = GridBagConstraints.NORTH;
		gbc_textCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCorreo.insets = new Insets(0, 0, 5, 0);
		gbc_textCorreo.gridwidth = 3;
		gbc_textCorreo.gridx = 1;
		gbc_textCorreo.gridy = 4;
		contentPane.add(textCorreo, gbc_textCorreo);
		textCorreo.setColumns(10);
		
		btnAdicionar = new JButton("Adicionar");
		GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
		gbc_btnAdicionar.anchor = GridBagConstraints.NORTH;
		gbc_btnAdicionar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAdicionar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdicionar.gridx = 1;
		gbc_btnAdicionar.gridy = 6;
		contentPane.add(btnAdicionar, gbc_btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.anchor = GridBagConstraints.NORTH;
		gbc_btnModificar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnModificar.insets = new Insets(0, 0, 0, 5);
		gbc_btnModificar.gridx = 2;
		gbc_btnModificar.gridy = 6;
		contentPane.add(btnModificar, gbc_btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.anchor = GridBagConstraints.NORTH;
		gbc_btnEliminar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEliminar.gridx = 3;
		gbc_btnEliminar.gridy = 6;
		contentPane.add(btnEliminar, gbc_btnEliminar);
		
		configurarFormularioInicial();
	}

    /**
     * Configura el formulario inicial: 
     * - Todos los campos sin texto y habilitados
     * - deshabilita los botones de eliminar y modificar
     * - habilita los botones de consultar y adicionar
     */
    private void configurarFormularioInicial() {
        textDocumento.setText("");
        textDocumento.setEnabled(true);
        textNombre.setText("");
        textNombre.setEnabled(true);
        textApellidos.setText("");
        textApellidos.setEnabled(true);
        textTelefono.setText("");
        textTelefono.setEnabled(true);
        textCorreo.setText("");
        textCorreo.setEnabled(true);
        
        btnConsultar.setEnabled(true);
        btnAdicionar.setEnabled(true);
        
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
    }

    /**
     * Muestra una ventana de diálogo con un mensaje de error
     * @param mensaje el mensaje de error que se mostrará
     */
    public void mostrarMensajeError(String mensaje) {
    	JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    
    /**
     * Ejecuta las acciones cuando el usuario presiona el botón consultar:
     * - Si no hay datos en el campo de documento, muestra un mensaje de error
     * - Si hay datos el campo:
     *    -- llama al método buscar de la clase de control (la de la lógica),
     *    y muestra los valores o muestra el error si se lanza la excepción
     *    -- Habilita los botones de modificar y eliminar,
     *      deshabilita los botones de adicionar y consultar,
     *      y deshabilita el campo del documento, para que no se pueda modificar. 
     */
    private void ejecutarConsulta() {
    	String documento = textDocumento.getText().trim();
    	
    	if (documento.equals("")) {
    		mostrarMensajeError("Debe ingresarse un número de documento para poder hacer la consulta");
    		return;
    	}
    	
        StringBuffer nombre= new StringBuffer(),
                apellidos = new StringBuffer(),
                telefono= new StringBuffer(),
                correo= new StringBuffer();
		try {
			controlClientes.consultarCliente(documento, nombre, apellidos, telefono, correo);
			textNombre.setText(nombre.toString());
			textApellidos.setText(apellidos.toString());
			textTelefono.setText(telefono.toString());
			textCorreo.setText(correo.toString());

			btnModificar.setEnabled(true);
			btnEliminar.setEnabled(true);
			btnAdicionar.setEnabled(false);
			btnConsultar.setEnabled(false);
			textDocumento.setEnabled(false);

		} catch (ClienteNoRegistradoException error) {
			mostrarMensajeError(error.getMessage());
		}
    }
}
