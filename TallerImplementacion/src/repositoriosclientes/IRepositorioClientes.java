package repositoriosclientes;

import dominioclientes.Cliente;

/**
 * Interfaz que determina el comportamiento (servicios CRUD)
 * de los repositorios de datos de clientes.
 * Esta interfaz se usa en un taller, puede estar incompleta.
 * @author Sandra V. Hurtado
 * @version 1.0
 */
public interface IRepositorioClientes {
	
	/**
	 * Buscar un cliente a partir de su número de documento
	 * @param documento	número de identificación del cliente que se desea buscar
	 * @return	el objeto cliente con el número de documento dado,
	 *          o null si no se encuentra
	 */
	public Cliente buscarCliente(String documento);

}
