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
import Entidad.iUsuario;
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
		
		GestionTurno gt = new GestionTurno();
		if(request.getSession().getAttribute("usuario") != null)
		{
			iUsuario us = (iUsuario)request.getSession().getAttribute("usuario");
			request.setAttribute("listaod", gt.listaTurnoOdontologo(us.getIDUsuario()));
			
			dispachero = request.getRequestDispatcher("/odonTurnos.jsp");
			dispachero.forward(request, response);
		}else
		{
			dispachero = request.getRequestDispatcher("/index.jsp");
			dispachero.forward(request, response);
		}

		
		
		
		if(operacion != null)
		{
			if(operacion.equals("borrar"))
			{
				
				int id = Integer.parseInt(request.getParameter("id"));
				gt.borrarTurno(id);
			}
			
			if(operacion.equals("presente"))
			{
				int id = Integer.parseInt(request.getParameter("idtur"));
				gt.presente(id);
				dispachero = request.getRequestDispatcher("/menuPacientes.jsp");
				dispachero.forward(request, response);
			}
			
			if(operacion.equals("ausente"))
			{
				int id = Integer.parseInt(request.getParameter("idtur"));
				gt.ausente(id);
				dispachero = request.getRequestDispatcher("/odonTurnos.jsp");
				dispachero.forward(request, response);
			}
		}
		if(request.getParameter("txtBuscar")== null)
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
		
		

		if(request.getParameter("btnGuardar") != null)
		{
			//Guardar los valores para registrar turno
			GestionTurno gt = new GestionTurno();
			String dni;
			String idOdontologo;
			String fecha;
			String hora;
			
			dni = request.getParameter("txtDnipaciente");
			idOdontologo = request.getParameter("ddlOdontologo").toString();
			hora = request.getParameter("ddlHorario").toString();
			fecha = request.getParameter("txtFecha").toString();
			System.out.println(dni);
			System.out.println(idOdontologo);
			System.out.println(hora);
			System.out.println(fecha );
			
			//Aviso de exito
			if(!gt.existe(idOdontologo,fecha))
			{
				if(gt.guardarTurno(dni, idOdontologo, fecha, hora))
				{
					request.setAttribute("Correcto", true);
				}
				else {
					request.setAttribute("Correcto", false);
				}
			}

		}
		action = request.getParameter("loadOdo");
		System.out.println(action);


		dispachero = request.getRequestDispatcher("/adminTurnos.jsp");
		dispachero.forward(request, response);
		//doGet(request, response);
	}

}
