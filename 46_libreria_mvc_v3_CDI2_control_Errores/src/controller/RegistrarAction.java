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

@WebServlet("/RegistrarAction")
public class RegistrarAction extends HttpServlet {
	@Inject
	ClientesService clientesService;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente=new Cliente(0,request.getParameter("usuario"),
				request.getParameter("password"),
				request.getParameter("email"),
				Integer.parseInt(request.getParameter("telefono")));
		try {
		clientesService.registrarCliente(cliente);
		//request.getRequestDispatcher("login.html").forward(request, response);
		} catch (ErrorConexionException ex) {
			request.setAttribute("error", true);
			request.setAttribute("mensajeError", ex.getMessage());

		}
	}

}
