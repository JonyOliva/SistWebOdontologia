package presentacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Inasistencias;
import Entidad.Paciente;
import Negocio.IPacienteNegocio;
import NegocioImpl.GestionPacientes;

/**
 * Servlet implementation class ServletReportes
 */
@WebServlet("/ServletReportes")
public class ServletReportes extends HttpServlet {
	IPacienteNegocio pn = new GestionPacientes();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletReportes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("Param")!= null)
		{
			RequestDispatcher miDispatcher;
			request.setAttribute("listaInasistencias", pn.getInasistencias());
			miDispatcher = request.getRequestDispatcher("ReporteInasistencias.jsp");
			miDispatcher.forward(request, response);

			}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher miDispatcher;
		
		//Buscar Inasistencias por Dni de Paciente
		if(request.getParameter("btnBuscar") != null)
		{
			if(request.getParameter("txtDNI").equals("")) response.sendRedirect("ServletReportes?Param=1");
			else
			{
				Inasistencias ina = pn.getInasistencias(request.getParameter("txtDNI").toString());
				if(ina!=null) {
					List<Inasistencias> listaInasistencias = new ArrayList<Inasistencias>();
					listaInasistencias.add(ina);
					request.setAttribute("listaInasistencias", listaInasistencias);
					miDispatcher = request.getRequestDispatcher("ReporteInasistencias.jsp");
					miDispatcher.forward(request, response);
				}
				else {
					request.setAttribute("NoExiste", "No se encuentra ningun paciente registrado con ese DNI.");
					miDispatcher = request.getRequestDispatcher("ReporteInasistencias.jsp");
					miDispatcher.forward(request, response);
				}
			}
		}
		
		
		//Detalle de Inasistencias de Paciente
		if(request.getParameter("btnDetalle")!=null)
		{
			int id = Integer.valueOf(request.getParameter("Param").toString().trim());
			Paciente pac = pn.get(id);
			request.setAttribute("listaDetalleIna", pn.getInasistenciasDet(pac));
			request.setAttribute("PacienteDetalle", pac);
			miDispatcher = request.getRequestDispatcher("ReporteInasistenciasDetalle.jsp");
			miDispatcher.forward(request, response);
			
		}
	}

}
