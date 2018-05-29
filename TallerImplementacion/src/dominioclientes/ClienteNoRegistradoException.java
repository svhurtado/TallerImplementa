package dominioclientes;

/**
 * Esta excepción se usa al consultar un cliente por algún criterio
 * y no encontrar ningún cliente que cumpla dicho criterio.
 * Esta clase se usa en un taller, puede estar incompleta.
 * @author Sandra V. Hurtado
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ClienteNoRegistradoException extends Exception {

	public ClienteNoRegistradoException() {
		super("Cliente no se encuentra registrado");
	}

	public ClienteNoRegistradoException(String mensaje) {
		super(mensaje);
	}
}
