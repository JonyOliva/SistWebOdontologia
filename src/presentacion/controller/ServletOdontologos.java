package presentacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entidad.Odontologo;
import Negocio.IOdontologoNegocio;
import NegocioImpl.GestionOdontologos;

/**
 * Servlet implementation class ServletOdontologos
 */
@WebServlet("/ServletOdontologos")
public class ServletOdontologos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IOdontologoNegocio go;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletOdontologos() {
        super();
        go = new GestionOdontologos();
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
			System.out.print("PAPAU´P");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
