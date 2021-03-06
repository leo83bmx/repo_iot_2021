package controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import excepciones.ErrorConexionException;
import service.TemasService;

@WebServlet("/TemasAction")
public class TemasAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	TemasService gtemas;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setAttribute("temas", gtemas.obtenerTemas());
		} catch (ErrorConexionException ex) {
			request.setAttribute("error", true);
			request.setAttribute("mensajeError", ex.getMessage());

		}

	}

}
