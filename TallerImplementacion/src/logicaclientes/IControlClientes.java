package logicaclientes;

import dominioclientes.ClienteNoRegistradoException;

/**
 * Interfaz que establece los servicios para la gestión de datos de los clientes:
 * consultar, adicionar, modificar y eliminar.
 * Esta interfaz se usa en un taller, puede estar incompleta.
 * @author Sandra V. Hurtado
 * @version 1.0
 */
public interface IControlClientes {
	
	/**
	 * Consulta los datos de un cliente a partir del número de documento.
	 * Los datos son guardados en los parámetros (StringBuffer), de manera que pueden ser
	 * usados desde donde se llame este método.
	 * @param documento	el número de documento por el cual se busca el cliente	
	 * @param nombre	el nombre del cliente consultado
	 * @param apellidos	los apellidos del cliente consultado
	 * @param telefono	el teléfono del cliente consultado
	 * @param correo	el correo del cliente consultado
	 * @throws ClienteNoRegistradoException	se lanza si no encuentra un cliente con ese número de documento
	 */
    public void consultarCliente(String documento, StringBuffer nombre,
            StringBuffer apellidos, StringBuffer telefono, StringBuffer correo) 
            		throws ClienteNoRegistradoException;

}
