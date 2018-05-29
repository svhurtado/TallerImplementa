package repositoriosclientes;

import java.util.ArrayList;
import dominioclientes.Cliente;


/**
 * Clase que simula (con una lista) un repositorio de datos de clientes.
 * Se usa para pruebas.
 * Esta clase se usa en un taller, puede estar incompleta.
 * @author Sandra V. Hurtado
 * @version 1.0
 */
public class RepositorioClientesFalso implements IRepositorioClientes {

	private ArrayList<Cliente> clientes;

    public RepositorioClientesFalso() {
    	clientes = new ArrayList<>();
        clientes.add(new Cliente("10283111", "cliente1", "apellido1","telefono1", "correo1"));
        clientes.add(new Cliente("10283222", "cliente2", "apellido2","telefono2", "correo2"));
        clientes.add(new Cliente("10283333", "cliente3", "apellido3","telefono3", "correo3"));
    }
	
	/**
	 * Buscar un cliente a partir de su número de documento
	 * @param documento	número de identificación del cliente que se desea buscar,
	 * 					debe ser diferente de null
	 * @return	el objeto cliente con el número de documento dado, o null si no se encuentra
	 */
	@Override
	public Cliente buscarCliente(String documento) {
		for (Cliente cliente : clientes) {
            if(cliente.getDocumento().equals(documento))
                return cliente;
        }
        return null;
	}
}
