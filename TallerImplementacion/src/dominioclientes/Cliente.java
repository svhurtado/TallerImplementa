package dominioclientes;

/**
 * Clientes de una empresa, que realizan compras.
 * Clase para un taller en clase, puede estar incompleta.
 * @author Sandra V. Hurtado
 * @version 1.0
 */
public class Cliente {

    private String documento;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String correo;
    
	/**
	 * Constructor de un nuevo cliente
	 * @param documento	el número de identificación del cliente
	 * @param nombre	nombres completos del cliente
	 * @param apellidos	apellidos del cliente
	 * @param telefono	teléfono de contacto del cliente
	 * @param correo	correo electrónico de contacto del cliente
	 */
	public Cliente(String documento, String nombre, String apellidos, String telefono, String correo) {
		this.documento = documento;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.correo = correo;
	}

	public String getDocumento() {
		return documento;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getCorreo() {
		return correo;
	}   
}
