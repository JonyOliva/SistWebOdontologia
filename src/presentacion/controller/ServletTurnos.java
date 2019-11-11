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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispachero= request.getRequestDispatcher("/registroTurno.jsp");
		
		//CARGAR LA LISTA DE TURNOS
		String action = request.getParameter("txtBuscar");
		if(action == null)
		{
			request.setAttribute("turnos", gt.listTurno());
			List<Turno> lista = gt.listTurno();
			for(Turno t : lista)
			{
				System.out.println(t.toString());
			}
			
			
		
		}
		System.out.println("asds");
		if(request.getParameter("txtDnipaciente") != null) {
			GestionPacientes gp = new GestionPacientes();
			Paciente pac = new Paciente(0);
			pac = gp.get(request.getParameter("txtDnipaciente").toString());
			request.setAttribute("paciente", pac);
		}
		
		//CARGAR LISTA ODONTOLOGOS
		/*List<Odontologo> listaOd = new ArrayList<Odontologo>();
		IOdontologoNegocio go = new GestionOdontologos();
		listaOd = go.getAll();
		request.setAttribute("listaodontologos", listaOd);*/
		
		if(request.getParameter("btnGuardar") != null)
		{
			//Guardar los valores para registrar turno
			GestionTurno gt = new GestionTurno();
			String dni;
			String idOdontologo;
			String fecha;
			String hora;
			
			dni = request.getParameter("txtDnipaciente");
			idOdontologo = request.getParameter("ddlOdontologo");
			hora = request.getParameter("ddlHorario");
			fecha = request.getParameter("txtFecha");
			System.out.println(dni);
			System.out.println(idOdontologo);
			System.out.println(hora);
			System.out.println(fecha );
			
			
			//Aviso de exito
			if(gt.guardarTurno(dni, idOdontologo, fecha, hora))
			{
				request.setAttribute("Correcto", true);
			}
			
		}
		dispachero = request.getRequestDispatcher("/adminTurnos.jsp");
		dispachero.forward(request, response);
		//doGet(request, response);
	}

}
