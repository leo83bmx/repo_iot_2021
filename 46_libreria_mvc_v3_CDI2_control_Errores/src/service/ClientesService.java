package service;

import excepciones.ErrorConexionException;
import model.Cliente;

public interface ClientesService {
	
	Cliente validarCliente(String user, String password) throws ErrorConexionException;
	
	boolean registrarCliente(Cliente cliente) throws ErrorConexionException;
}
