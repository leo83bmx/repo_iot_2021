package service;

import java.util.List;

import excepciones.ErrorConexionException;
import model.Tema;

public interface TemasService {

	List<Tema> obtenerTemas() throws ErrorConexionException;
	
	Tema recuperarTemaPorId(int idTema) throws ErrorConexionException;
}