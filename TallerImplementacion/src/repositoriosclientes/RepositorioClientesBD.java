package repositoriosclientes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import dominioclientes.Cliente;

/**
 * Clase que realiza las operaciones básicas de los datos de los clientes (CRUD)
 * en una base de datos relacional.
 * Esta clase se usa en un taller, puede estar incompleta.
 * @author Sandra V. Hurtado
 * @version 1.0
 */
public class RepositorioClientesBD implements IRepositorioClientes {
	
	private static Logger logger;
	
	/**
	 * Inicialización del atributo estático.
	 * Se crea el logger para la clase, definiendo que escriba en un archivo (LogBD.txt) con formato de texto plano,
	 * y deshabilitando la propagación del error al log "padre" (para que no muestre el error por consola).
	 */
	static {
		logger = Logger.getLogger(RepositorioClientesBD.class.getName());
		try {
			logger.setUseParentHandlers(false);
			FileHandler archivoLog = new FileHandler("LogBD.txt", true);
			archivoLog.setFormatter(new SimpleFormatter());
			logger.addHandler(archivoLog);

		} catch (SecurityException | IOException e) {
			System.err.println("Error con el archivo LogBD.log");
		}
	}
	
	/**
	 * Permite obtener un objeto "Connection" para conectarse con la base de datos.
	 * Se llamará este método cada vez que se necesite crear una nueva conexión
	 * a la base de datos para realizar alguna operación (SQL). 
	 * 
	 * Si se presenta alguna excepción, el método retornará null, pero escribirá en el 
	 * log el error.
	 * 
	 * El método que obtiene esta conexión deberá llamar al método cerrarConexión
	 * (después de realizar la operación), para que no queden conexiones abiertas
	 * que consuman recursos.
	 * 
	 * @return	el objeto Connection que permite realizar operaciones en la base de datos,
	 * 			o null si no se pudo conectar (por que no encontró el driver o hay algún
	 * 			error en la cadena de conexión).
	 */
	public static Connection getConexion() {
		Connection conexion = null;
		try {
			DriverManager.registerDriver(new org.sqlite.JDBC());
			String cadenaConexion = "jdbc:sqlite:empresa.db";
			conexion = DriverManager.getConnection(cadenaConexion);
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "No se pudo obtener la conexión con la Base de Datos", e);
		}
		return conexion;
	}
	
	/**
	 * Cierra una conexión para liberar así los recursos de la misma.
	 * Si se presenta alguna excepción en el proceso, se escribe el error en el log.
	 * @param conexión la conexión que se cerrará. 
	 */
	public static void cerrarConexion(Connection conexion) {
		if (conexion != null) {
			try {
				conexion.close();
				conexion = null;
			} catch (SQLException e) {
				logger.log(Level.SEVERE, "No se pudo obtener la conexión con la Base de Datos:"+conexion, e);
			}
			
		}
	}

	/**
	 * Buscar un cliente en el repositorio a partir de su número de documento.
	 * En caso de presentarse alguna excepción, el error se escribe el log (y se retorna null).
	 * 
	 * @param documento	número de identificación del cliente que se desea buscar,
	 * 	  				debe ser diferente de null
	 * @return	el objeto cliente con el número de documento dado, o null si no se encuentra.
	 */
	@Override
	public Cliente buscarCliente(String documento) {		
		Connection conexion = getConexion();
		if (conexion != null) {
			String consultaSQL = "Select documento,nombre, apellidos, telefono, correo "
					+ " from Clientes "
					+ " where documento = ?";
			
			try {
				PreparedStatement sentencia = conexion.prepareStatement(consultaSQL);
				sentencia.setString(1, documento);
				ResultSet resultadoConsulta = sentencia.executeQuery();
				if (resultadoConsulta != null) {
					return instanciarCliente(resultadoConsulta);
				}
			} catch (SQLException e) {
				logger.log(Level.SEVERE, "No se pudo obtener la conexión con la Base de Datos:"+conexion, e);
			}
			finally {
				cerrarConexion(conexion);
			}
		}
		return null;
	}
	
	/**
	 * Crea un objeto cliente a partir de los datos de un ResultSet.
	 * @param datosCliente	el ResultSet resultante de una consulta de un cliente en la base de datos.
	 * 						Debe ser diferente de null.
	 * @return	el objeto cliente con sus valores (de la base de datos), 
	 *          o null si no se encuentra (es decir, el ResultSet está vacío).
	 */
	private Cliente instanciarCliente(ResultSet datosCliente) {
		Cliente cliente = null;
		try {
			if (datosCliente.next()) {
				String documento = datosCliente.getString("documento");
				String nombre = datosCliente.getString("nombre");
				String apellidos = datosCliente.getString("apellidos");
				String telefono = datosCliente.getString("telefono");
				String correo = datosCliente.getString("correo");
				cliente = new Cliente (documento,nombre,apellidos,telefono,correo);
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "No se pudo obtener el cliente con el ResultSet: "+datosCliente, e);
		}
		return cliente;
	}
	
}
