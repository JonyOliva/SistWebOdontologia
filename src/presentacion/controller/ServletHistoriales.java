package presentacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.*;

import Entidad.ConsultaData;
import Entidad.Diente;
import Entidad.DientePaciente;
import Negocio.IConsultaNegocio;
import Negocio.IDientePacienteNegocio;
import NegocioImpl.GestionConsultas;
import NegocioImpl.GestionDientes;
/**
 * Servlet implementation class ServletHistoriales
 */
@WebServlet("/ServletHistoriales")
public class ServletHistoriales extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IDientePacienteNegocio dp;
	IConsultaNegocio consNeg;

    public ServletHistoriales() {
        super();
        dp = new GestionDientes();
        consNeg = new GestionConsultas();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id") != null) {
			Gson gson = new Gson();
			int idPaciente = Integer.valueOf(request.getParameter("id"));
			String pData = gson.toJson(dp.getOdontograma(idPaciente));
			//response.getWriter().append("Served at: ").append(request.getContextPath());
			response.getWriter().append(pData);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("idturno") != null && request.getParameter("idpaciente") != null) {
			int idturno = Integer.valueOf(request.getParameter("idturno"));
			int idpaciente = Integer.valueOf(request.getParameter("idpaciente"));
			if(request.getParameter("odontograma") != null) {
				JsonParser parser = new JsonParser();
				Gson gson = new Gson();
				JsonArray odontograma = parser.parse(request.getParameter("odontograma")).getAsJsonArray();
				for (JsonElement element : odontograma) {
					JsonObject diente = element.getAsJsonObject();
					Diente d = gson.fromJson(diente, Diente.class);
					DientePaciente newd = new DientePaciente();
					newd.setIDDiente(d.id);
					newd.setIDPaciente(idpaciente);
					newd.setIDTurno(idturno);

					int estado = Integer.valueOf(d.left);
					if(estado != 0) {
						newd.setParte("L");
						newd.setIDEstado(estado);
						dp.insertar(newd);
					}
					estado = Integer.valueOf(d.up);
					if(estado != 0) {
						newd.setParte("U");
						newd.setIDEstado(estado);
						dp.insertar(newd);
					}
					estado = Integer.valueOf(d.right);
					if(estado != 0) {
						newd.setParte("R");
						newd.setIDEstado(estado);
						dp.insertar(newd);
					}
					estado = Integer.valueOf(d.bottom);
					if(estado != 0) {
						newd.setParte("B");
						newd.setIDEstado(estado);
						dp.insertar(newd);
					}
					estado = Integer.valueOf(d.center);
					if(estado != 0) {
						newd.setParte("C");
						newd.setIDEstado(estado);
						dp.insertar(newd);
					}				

				}				
			}else if(request.getParameter("tratamiento") != null && request.getParameter("anotacion") != null && request.getParameter("idodontologo") != null) {
				ConsultaData consulta = new ConsultaData();
				consulta.setIDTurno(idturno);
				consulta.setIDPaciente(idpaciente);
				consulta.setAnotacion(request.getParameter("anotacion"));
				consulta.setIDTratamiento(request.getParameter("tratamiento"));
				consulta.setIDOdontologo(request.getParameter("idodontologo"));
				consNeg.insertar(consulta);
			}
		}
	}

}
