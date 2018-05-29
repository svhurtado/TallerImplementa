package logicaclientes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dominioclientes.ClienteNoRegistradoException;

/**
 * Clase para las pruebas de la clase de control del caso de uso gestionar cliente.
 * Es parta de un taller, por lo que puede estar incompleta.
 * @author Sandra V. Hurtado
 * @version 1.0
 */
public class ControlGestionClientesTest {
	
	private ControlGestionClientes controlClientes;
	
	/**
	 * Inicializar el control, definiendo el tipo de repositorio
	 * para las pruebas.
	 */
	@Before
	public void inicializarControl() {
		controlClientes = new ControlGestionClientes(2);
	}

	/**
	 * Prueba para consultar un cliente que se encuentre registrado
	 * @throws ClienteNoRegistradoException
	 */
	@Test
	public void testConsultarClienteExiste() throws ClienteNoRegistradoException {
		String documento = "10283222";
        StringBuffer nombre= new StringBuffer(),
                apellidos = new StringBuffer(),
                telefono= new StringBuffer(),
                correo= new StringBuffer();
		controlClientes.consultarCliente(documento,nombre,apellidos,telefono,correo);
		assertEquals(nombre.toString(),"cliente2");
		assertEquals(apellidos.toString(),"apellido2");
		assertEquals(telefono.toString(),"telefono2");
		assertEquals(correo.toString(),"correo2");
	} 
	
	/**
	 * Prueba para consultar un cliente con un documento que no está registrado.
	 * Se espera que el método lance una excepción
	 * @throws ClienteNoRegistradoException
	 */
	@Test(expected=ClienteNoRegistradoException.class)
	public void testConsultarClienteNoExiste() throws ClienteNoRegistradoException {
		String documento = "123";
        StringBuffer nombre= new StringBuffer(),
                apellidos = new StringBuffer(),
                telefono= new StringBuffer(),
                correo= new StringBuffer();
		controlClientes.consultarCliente(documento,nombre,apellidos,telefono,correo);
	}
	
	/**
	 * Prueba para consultar un cliente con documento null.
	 * Se espera que el método lance una excepción
	 * @throws ClienteNoRegistradoException
	 */
	@Test(expected=ClienteNoRegistradoException.class)
	public void testConsultarClienteNull() throws ClienteNoRegistradoException {
		String documento = null;
        StringBuffer nombre= new StringBuffer(),
                apellidos = new StringBuffer(),
                telefono= new StringBuffer(),
                correo= new StringBuffer();
		controlClientes.consultarCliente(documento,nombre,apellidos,telefono,correo);
	}
}
