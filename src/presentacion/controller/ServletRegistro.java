package presentacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Paciente;
import NegocioImpl.GestionPacientes;
import NegocioImpl.GestionTurno;

/**
 * Servlet implementation class ServletRegistro
 */
@WebServlet("/ServletRegistro")
public class ServletRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispachero= request.getRequestDispatcher("/registroTurno.jsp");
		
		
//		String asd;
//		if(asd != null) {
//			GestionPacientes gp = new GestionPacientes();
//			Paciente pac = gp.get(request.getParameter("txtDnipaciente"));
//			request.setAttribute("paciente", pac);
//			request.setAttribute("dni", request.getParameter("txtDnipaciente"));
//
//			
//		}
		
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
			hora = request.getParameter("ddlHorario").toString();
			fecha = request.getParameter("txtFecha").toString();
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
		
		dispachero = request.getRequestDispatcher("/registroTurno.jsp");
		dispachero.forward(request, response);
		//doGet(request, response);
	}

}
