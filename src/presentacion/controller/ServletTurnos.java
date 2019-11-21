package presentacion.controller;


import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Entidad.Turno;
import Entidad.iUsuario;
import Negocio.ITurnoNegocio;
import NegocioImpl.GestionHorarios;
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
		
		if(request.getParameter("idodontologo") != null && request.getParameter("fecha") != null) {
			Gson gson = new Gson();
			GestionHorarios gh = new GestionHorarios();
			String fecha = request.getParameter("fecha");
			DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd", new Locale("es","ES"));
			LocalDate fechaTurno = LocalDate.parse(fecha, df);
			String pData = gson.toJson(gh.VerHorarios(request.getParameter("idodontologo"), fechaTurno.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es","ES"))));
			// response.getWriter().append("Served at: ").append(request.getContextPath());
			response.getWriter().append(pData);
		}else {
		
			String operacion = request.getParameter("operacion");
			RequestDispatcher dispachero = request.getRequestDispatcher("/index.jsp");
			GestionTurno gt = new GestionTurno();
			
			if(request.getSession().getAttribute("usuario") != null)
			{
				
				iUsuario us = (iUsuario)request.getSession().getAttribute("usuario");
				if(!us.isTipoUsuario())
				{			
					String op = request.getParameter("op");
					if(op != null)
					{
						if(op.equals("presente"))
						{
							if(request.getParameter("idturno") != null && request.getParameter("idpac") != null) {
								int idt = Integer.parseInt(request.getParameter("idturno"));
								int idpac = Integer.parseInt(request.getParameter("idpac"));
								gt.presente(idt);
								dispachero = request.getRequestDispatcher("ServletPacientes?action=ficha&idturno="+idt+"&id="+idpac);
								dispachero.forward(request, response);
							}
						}else if(op.equals("ausente"))
						{
							int id = Integer.parseInt(request.getParameter("idturno"));
							request.setAttribute("resultado", gt.ausente(id));
							dispachero = request.getRequestDispatcher("/odonTurnos.jsp");
						}
					}
					request.setAttribute("listaod", gt.listaTurnoOdontologo(us.getIDUsuario()));
					dispachero = request.getRequestDispatcher("/odonTurnos.jsp");
	
				}
				else
				{
					request.setAttribute("turnos", gt.listTurnovista());
					dispachero = request.getRequestDispatcher("/adminTurnos.jsp");
	
					if(operacion != null)
					{
						if(operacion.equals("modificar"))
						{
							GestionPacientes gp = new GestionPacientes();
							int id = Integer.parseInt(request.getParameter("idturno"));
							int idpac = Integer.parseInt(request.getParameter("dni"));
							request.setAttribute("dnipac", gp.get(idpac).getDni());
							request.setAttribute("turnomod", gt.getTurno(id));
							dispachero = request.getRequestDispatcher("/registroTurno.jsp");
						}
						
						if(operacion.equals("borrar"))
						{
							int id = Integer.parseInt(request.getParameter("id"));
							request.setAttribute("resultado",gt.borrarTurno(id) );
						}
					}
					/*
					if(request.getParameter("txtFecha") != null)
					{
						request.setAttribute("Cambio",true);
						String IDOdontologo = request.getParameter("ddlOdontologo");
						String fecha = request.getParameter("txtFecha");
						Locale spanishLocale=new Locale("es", "ES");
						DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd",spanishLocale);
						LocalDateTime fechaTurno = LocalDateTime.parse(fecha, df);
						
						request.setAttribute("dni",request.getParameter("txtDnipaciente"));
						request.setAttribute("odontologo", request.getParameter("ddlOdontologo"));
						request.setAttribute("fecha", request.getParameter("txtFecha"));
						
						GestionHorarios gh = new GestionHorarios();
	
						request.setAttribute("listaHorario", gh.VerHorarios(IDOdontologo, fechaTurno.getDayOfWeek().toString()));
						
					}*/
	
				}
			}
			else
			{
				dispachero = request.getRequestDispatcher("/index.jsp");
				
			}
			dispachero.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispachero = request.getRequestDispatcher("/registroTurno.jsp");
		
		
		if(request.getSession().getAttribute("usuario") != null)
		{
			
			iUsuario us = (iUsuario)request.getSession().getAttribute("usuario");
			if(us.isTipoUsuario())
			{
				dispachero = request.getRequestDispatcher("/adminTurnos.jsp");
				request.setAttribute("turnos", gt.listTurnovista());
				if(request.getParameter("ddlHorario")!= null)
					if(request.getParameter("ddlHorario").equals("null"))
					{
						request.setAttribute("Correcto", "El horario no se puede dejar vacío.");
						dispachero = request.getRequestDispatcher("/registroTurno.jsp");
					}
						
				
				if(request.getParameter("btnGuardar") != null && 
						request.getParameter("txtDnipaciente") != null &&
						request.getParameter("ddlOdontologo")!= null &&
						!request.getParameter("ddlHorario").equals("null") && 
						request.getParameter("txtFecha") != null)
				{
					String op = request.getParameter("operacion");
					
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
					
					boolean existeOd = gt.existe(idOdontologo,fecha+" "+hora);
					boolean existePac = gt.existePac(dni, fecha+" "+hora);
					if(existeOd)
						request.setAttribute("Correcto", "Ya existe un turno en la misma fecha con el mismo odontólogo\n");
					if(existePac)
						request.setAttribute("Correcto", "Ya existe un turno en la misma fecha con el mismo paciente\n");
					

					//Aviso de exito
					if(!existeOd && !existePac)
					{
						if(op.equals("modificar"))
						{
							int idtur= Integer.parseInt(request.getParameter("idtu").toString());
							Turno tur = new Turno(idtur);
							tur.setIDOdontologo(idOdontologo);
							if(gt.modificarTurno(tur, dni, fecha+" "+hora))
							{
								request.setAttribute("Correcto", "Se modifico correctamente");
							}
							else
							{
								request.setAttribute("Correcto", "No se modifico");
							}
						}else 
						{
							
							if(gt.guardarTurno(dni, idOdontologo, fecha, hora))
							{
								request.setAttribute("Correcto", "Se agrego correctamente");
								
							}
							else {
								request.setAttribute("Correcto", "El paciente no existe.");
							}
						}
						dispachero = request.getRequestDispatcher("/registroTurno.jsp");
					}
					
				}
			}
			else
			{
				request.setAttribute("listaod", gt.listaTurnoOdontologo(us.getIDUsuario()));
				dispachero = request.getRequestDispatcher("/odonTurnos.jsp");
			}
		}
		else
		{
			dispachero = request.getRequestDispatcher("/index.jsp");
		}
		dispachero.forward(request, response);
	}
}
