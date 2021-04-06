package service;

import java.util.List;

import excepciones.ErrorConexionException;
import model.Libro;

public interface LibrosService {

	List<Libro> recuperarLibros() throws ErrorConexionException;

	List<Libro> recuperarLibros(int idTema) throws ErrorConexionException;
	
	Libro recuperarLibroPorIsbn(int isbn) throws ErrorConexionException;

}