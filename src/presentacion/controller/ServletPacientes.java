package presentacion.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entidad.iUsuario;
import Entidad.Paciente;
import Entidad.Utilidades;
import Entidad.iUsuario;
import Entidad.Gestor;
import Negocio.IConsultaNegocio;
import Negocio.IPacienteNegocio;
import Negocio.ITurnoNegocio;
import NegocioImpl.GestionConsultas;
import NegocioImpl.GestionPacientes;
import NegocioImpl.GestionTurno;

import com.google.gson.*;

@WebServlet("/ServletPacientes")
public class ServletPacientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IPacienteNegocio gp = new GestionPacientes();
	IConsultaNegocio gc = new GestionConsultas();
	ITurnoNegocio gt = new GestionTurno();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPacientes() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void getAllPacientes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Gestor<Paciente> pagPacientes = new Gestor<Paciente>(new GestionPacientes(), 4);
		String buscar = request.getParameter("buscar");
		String pag = request.getParameter("pag");
		
		buscar = (buscar != null) ? Utilidades.cleanString(buscar, true) : null;
		int nroPagina = 1;
		if (pag != null) {
			nroPagina = Integer.valueOf(pag);
			if (buscar != null) {
				request.setAttribute("buscar", buscar);
			}
		}
		request.setAttribute("pacientes", pagPacientes.get(buscar, nroPagina));
		int siguiente = pagPacientes.haySiguiente();
		int anterior = pagPacientes.hayAnterior();

		if (siguiente != -1)
			request.setAttribute("siguiente", siguiente);
		if (anterior != -1)
			request.setAttribute("anterior", anterior);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher;
		String action = request.getParameter("action");
		String view;
		iUsuario user = null;
		if(request.getSession().getAttribute("usuario") != null) {
			user = (iUsuario)request.getSession().getAttribute("usuario");
			if(user.isTipoUsuario())
				view = "/adminPacientes.jsp";
			else
				view = "/odonPacientes.jsp";
		}else {
			view = "/index.js";
			response.sendRedirect(view);
		}
 
		if (action == null) {
			getAllPacientes(request, response);
			dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		} else if (action.equals("edit")) {
			String id = request.getParameter("id");
			if (id != null) {
				int idPaciente = Integer.valueOf(id);
				request.setAttribute("paciente", gp.get(idPaciente));
				dispatcher = request.getRequestDispatcher("fichaPaciente.jsp");
				dispatcher.forward(request, response);
			}

		} else if (action.equals("delete")) {
			String id = request.getParameter("id");
			if (id != null) {
				int idPaciente = Integer.valueOf(id);
				request.setAttribute("resultado", gp.eliminar(idPaciente));
				getAllPacientes(request, response);
				dispatcher = request.getRequestDispatcher(view);
				dispatcher.forward(request, response);
			}
			response.sendRedirect("ServletPacientes");
		} else if (action.equals("ficha")) {
			String id = request.getParameter("id");
			if (id != null) {
				int idPaciente = Integer.valueOf(id);
				request.setAttribute("paciente", gp.get(idPaciente));
				request.setAttribute("tratamientos", gc.getAll());
				request.setAttribute("consultas", gc.getAll(idPaciente));
				if(request.getParameter("idturno") != null)
					request.setAttribute("idturno", request.getParameter("idturno"));

				dispatcher = request.getRequestDispatcher("menuPaciente.jsp");
				dispatcher.forward(request, response);
			}
		} else if (action.equals("get")) {
			String dni = request.getParameter("dni");
			if (dni != null) {
				Paciente paciente = gp.get(dni);
				Gson gson = new Gson();
				response.getWriter().append(gson.toJson(paciente));
			}
		}else if(action.equals("presente")) {
				if(!user.isTipoUsuario())
				{			
					if(request.getParameter("idturno") != null && request.getParameter("idpac") != null) {
						int idt = Integer.parseInt(request.getParameter("idturno"));
						int idPaciente = Integer.parseInt(request.getParameter("idpac"));
						
						gt.presente(idt);
						request.setAttribute("paciente", gp.get(idPaciente));
						request.setAttribute("tratamientos", gc.getAll());
						request.setAttribute("consultas", gc.getAll(idPaciente));
						request.setAttribute("idturno", request.getParameter("idturno"));

						dispatcher = request.getRequestDispatcher("menuPaciente.jsp");
						dispatcher.forward(request, response);
					}
				}
		}else if(action.equals("ausente")) {
				if(!user.isTipoUsuario()) {
					if(request.getParameter("idturno") != null) {
						int id = Integer.parseInt(request.getParameter("idturno"));
						request.setAttribute("resultado", gt.ausente(id));
						dispatcher = request.getRequestDispatcher("/ServletTurnos");
						dispatcher.forward(request, response);
					}
				}
		}

		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action != null) {
			if (action.equals("edit")) {
				Paciente p = new Paciente(Integer.valueOf(request.getParameter("ID")));
				p.setNombre(Utilidades.cleanString(request.getParameter("Nombre"), true));
				p.setApellido(Utilidades.cleanString(request.getParameter("Apellido"), true));
				p.setDni(request.getParameter("DNI"));
				p.setTelefono(request.getParameter("Telefono"));
				p.setDomicilio(Utilidades.cleanString(request.getParameter("Domicilio"), true));
				p.setLocalidad(Utilidades.cleanString(request.getParameter("Localidad"), true));
				p.setFechaNacimiento(LocalDate.parse(request.getParameter("Fecha")));
				p.setInfoExtra(request.getParameter("InfoExtra"));
				p.setActivo(true);

				request.setAttribute("resultado", gp.modificar(p));
				getAllPacientes(request, response);
				request.getRequestDispatcher("/adminPacientes.jsp").forward(request, response);
				
			} else if (action.equals("new")) {
				Paciente p = new Paciente(-1);
				p.setNombre(Utilidades.cleanString(request.getParameter("Nombre"), true));
				p.setApellido(Utilidades.cleanString(request.getParameter("Apellido"), true));
				p.setDni(request.getParameter("DNI"));
				p.setTelefono(request.getParameter("Telefono"));
				p.setDomicilio(Utilidades.cleanString(request.getParameter("Domicilio"), true));
				p.setLocalidad(Utilidades.cleanString(request.getParameter("Localidad"), true));
				p.setFechaNacimiento(LocalDate.parse(request.getParameter("Fecha")));
				p.setInfoExtra(request.getParameter("InfoExtra"));
				p.setActivo(true);

				request.setAttribute("resultado", gp.insertar(p));
				getAllPacientes(request, response);
				request.getRequestDispatcher("/adminPacientes.jsp").forward(request, response);
			}
		}
		doGet(request, response);
	}

}
