package presentacion.controller;


import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;

import Entidad.Odontologo;
import Entidad.Paciente;
import Entidad.Turno;
import Entidad.TurnosVista;
import Negocio.IOdontologoNegocio;
import Negocio.ITurnoNegocio;
import NegocioImpl.GestionOdontologos;
import NegocioImpl.GestionPacientes;
import NegocioImpl.GestionTurno;

/**
 * Servlet implementation class ServletTurnos
 */
@WebServlet("/ServletTurnos")
public class ServletTurnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ITurnoNegocio gt = new GestionTurno();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTurnos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//  response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispachero;
		
		String operacion = request.getParameter("operacion");
		if(operacion != null)
		{
			if(operacion.equals("operacion"))
			{
				GestionTurno gt = new GestionTurno();
				int id = Integer.parseInt(request.getParameter("id"));
				gt.borrarTurno(id);
			}
		}
		if(request.getParameter("txtBuscar")!= null)
			doPost(request, response);
		
		dispachero = request.getRequestDispatcher("/adminTurnos.jsp");
		dispachero.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispachero;//= request.getRequestDispatcher("/registroTurno.jsp");
		
		//CARGAR LA LISTA DE TURNOS
		String action = request.getParameter("txtBuscar");
		if(action == null)
		{
			request.setAttribute("turnos", gt.listTurnovista());
			
		}
		
		//CARGAR LISTA ODONTOLOGOS
		/*List<Odontologo> listaOd = new ArrayList<Odontologo>();
		IOdontologoNegocio go = new GestionOdontologos();
		listaOd = go.getAll();
		request.setAttribute("listaodontologos", listaOd);*/
		
		if(request.getParameter("btnGuardar") != null)
		{

			

			
		}
		dispachero = request.getRequestDispatcher("/adminTurnos.jsp");
		dispachero.forward(request, response);
		//doGet(request, response);
	}

}
