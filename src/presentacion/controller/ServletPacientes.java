package presentacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Paciente;
import Entidad.Gestor;
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
		RequestDispatcher dispatcher;
		String action = request.getParameter("action");
		String view;
		//if(userType.equals("admin")) ACA TENDRIA QUE CHECKEAR LA VAR DE SESION
			view = "/adminPacientes.jsp";
		//else
		//	view = "/odonPacientes.jsp";
		if(action == null) {
			Gestor<Paciente> pagPacientes = new Gestor<Paciente>(new GestionPacientes(), 2);
			String buscar = request.getParameter("buscar");
			String pag = request.getParameter("pag");			
			int nroPagina = 1;
			if(pag != null) {
				nroPagina = Integer.valueOf(pag);	
				if(buscar != null) {
					request.setAttribute("buscar", buscar);
				}
			}
			request.setAttribute("pacientes", pagPacientes.get(buscar, nroPagina));
			int siguiente = pagPacientes.haySiguiente();
			int anterior = pagPacientes.hayAnterior();
			
			if(siguiente != -1)
				request.setAttribute("siguiente", siguiente);
			if(anterior != -1)
				request.setAttribute("anterior", anterior);
			dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);				
		}else if(action.equals("edit")) {
			String id = request.getParameter("id");
			if(id != null) {
				int idPaciente = Integer.valueOf(id);
				request.setAttribute("paciente", gp.get(idPaciente));
				dispatcher = request.getRequestDispatcher("fichaPaciente.jsp");
				dispatcher.forward(request, response);
			}
			
		}else if(action.equals("delete")) {
			String id = request.getParameter("id");
			if(id != null) {
				int idPaciente = Integer.valueOf(id);
				Paciente paciente = gp.get(idPaciente);
				if(paciente != null) {
					paciente.setActivo(false);
					gp.modificar(paciente);
				}
			}
		}
		
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
