package presentacion.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

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
		request.setAttribute("id",request.getParameter("id"));
		if(action != null)
		{
			if(action.equals("edit")) {
				String id = request.getParameter("id");
				if(id != null) {
					
					
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
		request.setAttribute("horarios", gh.VerHorarios(request.getParameter("id")));
		dispatcher = request.getRequestDispatcher("horariosOdon.jsp");
		dispatcher.forward(request, response);
			
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action = request.getParameter("action");
RequestDispatcher dispatcher;

if ((request.getParameter("btnAgregarHorario"))!= null ) {
		
		
	List <HorarioOdonto> lista =  gh.VerHorarios(request.getParameter("id"));
	
		DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime horaInicio = LocalTime.parse(request.getParameter("HoraInicio").toString(), df);
		LocalTime horaFin = LocalTime.parse(request.getParameter("HoraFin").toString(), df);
		
		
		
		
			
		String prueba = request.getParameter("id").toString();
		HorarioOdonto nh = new HorarioOdonto (prueba,request.getParameter("ddlDias").toString(),horaInicio,horaFin,true);
		
		// el que va es el verificar horarios, cuando lo termino lo cambio
		if (VerificarHorarios(nh,lista) == true) {
		
		request.setAttribute("Insertado", gh.insertar(nh));
		}
		
	}	
	else {
	request.setAttribute("Insertado", false);
	
	}	
	request.setAttribute("id", request.getParameter("id"));
	request.setAttribute("horarios", gh.VerHorarios(request.getParameter("id")));
	dispatcher = request.getRequestDispatcher("horariosOdon.jsp");
	dispatcher.forward(request, response);	
		
	}
	
	
	public Boolean VerificarHorarios (HorarioOdonto horNuevo, List <HorarioOdonto> lista) {
		
		for (HorarioOdonto h : lista) {
			
			if (h.equals(horNuevo))
				
				return false;
			if (h.getActivo()==true && h.getDia().equals(horNuevo.getDia())) {
				System.out.print("entra");
				if (h.getHoraInicio().equals(horNuevo.getHoraInicio())) {
					return false;
				}
				else if (horNuevo.getHoraInicio().isBefore(h.getHoraInicio()) && horNuevo.getHoraFin().isAfter(h.getHoraFin())) {
					return false;
				}
				else if (horNuevo.getHoraInicio().isAfter(h.getHoraInicio()) && horNuevo.getHoraInicio().isBefore(h.getHoraFin()) ) {return false;}
				
			}
		}
		
		 if (horNuevo.getHoraInicio() == null)
			 return false;
		 else if (horNuevo.getHoraFin() == null)
			 return false;
		 else if (horNuevo.getHoraFin().isBefore(horNuevo.getHoraInicio()))
	return false;
		
		 else
		return true;
	}
	
	public Boolean VerificarHorarios2 (HorarioOdonto horNuevo) {
		
		 if (horNuevo.getHoraInicio() == null)
			 return false;
		 else if (horNuevo.getHoraFin() == null)
			 return false;
		 else if (horNuevo.getHoraFin().isBefore(horNuevo.getHoraInicio()))
	return false;
		
		 else
		return true;
	}

}
