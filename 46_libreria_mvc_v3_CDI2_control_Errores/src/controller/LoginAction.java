package controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import excepciones.ErrorConexionException;
import model.Cliente;
import service.ClientesService;

@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {

	@Inject
	ClientesService clientesService;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url;
		try {
			Cliente cliente = clientesService.validarCliente(request.getParameter("user"), request.getParameter("pwd"));
			if (cliente != null) {
				request.getSession().setAttribute("cliente", cliente);
				request.setAttribute("resultado", true);
			} else {

				request.setAttribute("resultado", false);
			}

		} catch (ErrorConexionException ex) {
			request.setAttribute("error", true);
			request.setAttribute("mensajeError", ex.getMessage());

		}
	}

}
