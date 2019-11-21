package presentacion.controller;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Entidad.HorarioOdonto;
import Negocio.IHorariosNegocio;
import Negocio.IOdontologoNegocio;
import Negocio.iUsuarioNegocio;
import NegocioImpl.GestionHorarios;
import NegocioImpl.GestionOdontologos;
import NegocioImpl.GestionUsuarios;

/**
 * Servlet implementation class ServletHorarios
 */
@WebServlet("/ServletHorarios")
public class ServletHorarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    IHorariosNegocio gh;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletHorarios() {
        super();
        gh = new GestionHorarios();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		String action = request.getParameter("action");
		if(action == null) {
			request.setAttribute("horarios", gh.VerHorarios(request.getParameter("id")));
			dispatcher = request.getRequestDispatcher("horariosOdon.jsp");
			dispatcher.forward(request, response);
					}
		else if(action.equals("edit")) {
			String id = request.getParameter("id");
			if(id != null) {
				
				//request.setAttribute("horarios", gh.get(id));
				request.setAttribute("horarios", gh.VerHorarios(request.getParameter("id")));
				dispatcher = request.getRequestDispatcher("horariosOdon.jsp");
				dispatcher.forward(request, response);
			}
			
		} else if(action.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("idHorario"));
			gh.eliminar(id);
			request.setAttribute("horarios", gh.VerHorarios(request.getParameter("id")));
			dispatcher = request.getRequestDispatcher("horariosOdon.jsp");
			dispatcher.forward(request, response);
		}

			
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action = request.getParameter("action");
RequestDispatcher dispatcher;

	if ((request.getAttribute("btnAgregarHorario"))!= null ) {
		
		HorarioOdonto nuevo = new HorarioOdonto();
		nuevo.setActivo(true);
		nuevo.setIDOdontologo(request.getParameter("id").toString());
		nuevo.setDia(request.getAttribute("ddlDias").toString());
		nuevo.setHoraInicio((LocalTime)request.getAttribute("HoraInicio"));
		nuevo.setHoraFin((LocalTime)request.getAttribute("HoraFin"));
		
		gh.insertar(nuevo);
		dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}	
		
		
		
	}

}
