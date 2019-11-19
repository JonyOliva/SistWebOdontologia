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
		
		RequestDispatcher dispachero=request.getRequestDispatcher("ServletTurnos");
		
		String operacion = request.getParameter("operacion");
		
		GestionTurno gt = new GestionTurno();
		if(request.getSession().getAttribute("usuario") != null)
		{
			
			iUsuario us = (iUsuario)request.getSession().getAttribute("usuario");
			if(!us.isTipoUsuario())
			{

				if(operacion != null)
				{
					//Esto enlazalo vos joni lo intente pero no quiero romper nada
					if(operacion.equals("presente"))
					{
						int id = Integer.parseInt(request.getParameter("idtur"));
						gt.presente(id);
						dispachero = request.getRequestDispatcher("/ServletPaciente?action=ficha&id="+id);
					}
					
					if(operacion.equals("ausente"))
					{
						int id = Integer.parseInt(request.getParameter("idtur"));
						gt.ausente(id);
						dispachero = request.getRequestDispatcher("/odonTurnos.jsp");
					}
				}
				dispachero = request.getRequestDispatcher("/odonTurnos.jsp");
				dispachero.forward(request, response);
			}
			else
			{
				
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
						gt.borrarTurno(id);
					}
				}
				
				dispachero.forward(request, response);
			}

		}
		else
		{
			dispachero = request.getRequestDispatcher("/index.jsp");
			
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
				
				if(request.getParameter("btnGuardar") != null)
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
							response.sendRedirect("registroTurno.jsp");
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
						
						response.sendRedirect("registroTurno.jsp");
					}else 
					{
						response.sendRedirect("registroTurno.jsp");
					}
		
				}
			}
			else
			{
				dispachero = request.getRequestDispatcher("/odonTurnos.jsp");
				request.setAttribute("listaod", gt.listaTurnoOdontologo(us.getIDUsuario()));
			}

			dispachero.forward(request, response);
		}
	}
}
