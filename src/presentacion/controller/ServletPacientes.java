package presentacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Paciente;
import Entidad.Paginador;
import Negocio.IPacienteNegocio;
import NegocioImpl.GestionPacientes;


@WebServlet("/ServletPacientes")
public class ServletPacientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IPacienteNegocio gp = new GestionPacientes();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPacientes() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String userType = request.getParameter("userType").toString();
		String action = request.getParameter("action");
		
		//if(userType != null) {
			String view;
			//if(userType.equals("admin")) ACA TENDRIA QUE CHECKEAR LA VAR DE SESION
				view = "/adminPacientes.jsp";
			//else
			//	view = "/odonPacientes.jsp";
			if(action == null) {
				Paginador<Paciente> pagPacientes = new Paginador<Paciente>(gp.getAll(), 1);
				String pag = request.getParameter("pag");
				if(pag != null) {
					int nroPagina = Integer.valueOf(pag);
					pagPacientes.pagina(nroPagina);
				}
				request.setAttribute("Pacientes", pagPacientes.getPaginaActual());
				int siguiente = pagPacientes.haySiguiente();
				int anterior = pagPacientes.hayAnterior();
				if(siguiente != -1)
					request.setAttribute("Siguiente", siguiente);
				if(anterior != -1)
					request.setAttribute("Anterior", anterior);
				RequestDispatcher dispatcher = request.getRequestDispatcher(view);
				dispatcher.forward(request, response);				
			}
		//}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
