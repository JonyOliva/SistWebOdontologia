package presentacion.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entidad.Odontologo;
import Entidad.Paciente;
import Entidad.Utilidades;
import Negocio.IOdontologoNegocio;
import Negocio.iUsuarioNegocio;
import NegocioImpl.GestionOdontologos;
import NegocioImpl.GestionUsuarios;

/**
 * Servlet implementation class ServletOdontologos
 */
@WebServlet("/ServletOdontologos")
public class ServletOdontologos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IOdontologoNegocio go;
    iUsuarioNegocio un;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletOdontologos() {
        super();
        go = new GestionOdontologos();
        un = new GestionUsuarios();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		String action = request.getParameter("action");
		if(action == null) {
			request.setAttribute("odontologos", go.getAll());
			dispatcher = request.getRequestDispatcher("adminOdontologos.jsp");
			dispatcher.forward(request, response);				
		}else if(action.equals("edit")) {
			String id = request.getParameter("id");
			if(id != null) {
				
				request.setAttribute("odontologo", go.get(id));
				dispatcher = request.getRequestDispatcher("fichaOdontologo.jsp");
				dispatcher.forward(request, response);
			}
			
		}else if(action.equals("delete")) {
			String id = request.getParameter("id");
			if(id != null) {
				go.eliminar(id);
			}
			response.sendRedirect("ServletOdontologos");
		}else if(action.equals("horario")) {
			String id = request.getParameter("id");
			if(id != null) {
				//dispatcher = request.getRequestDispatcher(".jsp");
				//dispatcher.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null) {
			Odontologo od;
			if(request.getParameter("ID") != null)
				 od = new Odontologo(request.getParameter("ID"));
			else 
				od = new Odontologo("-1");
			od.setNombre(Utilidades.cleanString(request.getParameter("Nombre"), true));
			od.setApellido(Utilidades.cleanString(request.getParameter("Apellido"), true));
			od.setDNI(request.getParameter("DNI"));
			od.setMatricula(request.getParameter("Matricula"));
			od.setEmail(request.getParameter("Email"));
			od.setPassword(request.getParameter("Password"));
			od.setTipoUsuario(true); //odontologo
			if(action.equals("edit")) {
				go.modificar(od);
			}else if(action.equals("new")) {
				go.insertar(od);
			}
		}
		response.sendRedirect("ServletOdontologos");
	}

}
