package logicaclientes;

import dominioclientes.Cliente;
import dominioclientes.ClienteNoRegistradoException;
import repositoriosclientes.IRepositorioClientes;
import repositoriosclientes.RepositorioClientesBD;
import repositoriosclientes.RepositorioClientesFalso;

/**
 * Clase con la lógica del caso de uso "Gestión de clientes",
 * para lo cual implementa la interfaz IControlClientes,
 * que permite adicionar, modificar, consultar y eliminar clientes.
 * Después de hacer los procesos y validaciones del negocio,
 * usa los servicios de un repositorio para hacer persistentes los cambios.
 * Esta clase se usa en un taller, puede estar incompleta.
 * @author Sandra V. Hurtado
 * @version 1.0
 */
public class ControlGestionClientes implements IControlClientes {
	
	private IRepositorioClientes repositorioClientes;

	/**
	 * Crear el objeto controlador, inicializando el repositorio
	 * @param repositorioClientes	el tipo de repositorio que se trabajará:
	 * 								1--> falso (en memoria), 2--> BD
	 */
	public ControlGestionClientes(int tipoRepositorio) {
		switch (tipoRepositorio) {
			case 1:	repositorioClientes = new RepositorioClientesFalso();
				break;
			case 2: repositorioClientes = new RepositorioClientesBD();
				break;
			default: repositorioClientes = new RepositorioClientesFalso();
		}
	}
	
	/**
	 * Consulta en el repositorio los datos básicos de un cliente a partir del número de documento.
	 * Los datos son guardados en los parámetros (StringBuffer), de manera que pueden ser
	 * usados desde donde se llame este método.
	 * @param documento	el número de documento por el cual se busca el cliente	
	 * @param nombre	el nombre del cliente consultado
	 * @param apellidos	los apellidos del cliente consultado
	 * @param telefono	el teléfono del cliente consultado
	 * @param correo	el correo del cliente consultado
	 * @throws ClienteNoRegistradoException	se lanza si no encuentra un cliente con ese número de documento
	 */
    @Override
    public void consultarCliente(String documento, StringBuffer nombre,
            StringBuffer apellidos, StringBuffer telefono, StringBuffer correo) 
            		throws ClienteNoRegistradoException {
    	if (documento == null) {
    		throw new ClienteNoRegistradoException("Debe ingresarse un número de documento para poder hacer la consulta");
    	}
        Cliente cliente = repositorioClientes.buscarCliente(documento);
        if (cliente == null) {
        	throw new ClienteNoRegistradoException("No se encuentra un cliente registrado con ese número de documento");
        }
       
        nombre.append(cliente.getNombre());
        apellidos.append(cliente.getApellidos());
        telefono.append(cliente.getTelefono());
        correo.append(cliente.getCorreo());
    }

}
