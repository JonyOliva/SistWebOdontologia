package presentacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.*;

import Entidad.Diente;
import Entidad.DientePaciente;
import Negocio.IDientePacienteNegocio;
import NegocioImpl.GestionDientes;
/**
 * Servlet implementation class ServletHistoriales
 */
@WebServlet("/ServletHistoriales")
public class ServletHistoriales extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IDientePacienteNegocio dp;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletHistoriales() {
        super();
        dp = new GestionDientes();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		// TODO Auto-generated method stub
		if(request.getParameter("odontograma") != null && request.getParameter("idpaciente") != null) {
			JsonParser parser = new JsonParser();
			Gson gson = new Gson();
			JsonArray odontograma = parser.parse(request.getParameter("odontograma")).getAsJsonArray();
			System.out.print(odontograma+"\n");
			for (JsonElement element : odontograma) {
				JsonObject diente = element.getAsJsonObject();
				Diente d = gson.fromJson(diente, Diente.class);
				DientePaciente newd = new DientePaciente();
				newd.setIDDiente(d.id);
				newd.setIDPaciente(Integer.valueOf(request.getParameter("idpaciente")));
				newd.setIDTurno(2);

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

		}
	}

}
