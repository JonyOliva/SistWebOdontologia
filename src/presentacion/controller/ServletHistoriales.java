package presentacion.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.*;

import Entidad.ConsultaData;
import Entidad.Diente;
import Entidad.DientePaciente;
import Entidad.iUsuario;
import Negocio.IConsultaNegocio;
import Negocio.IDientePacienteNegocio;
import Negocio.ITurnoNegocio;
import NegocioImpl.GestionConsultas;
import NegocioImpl.GestionDientes;
import NegocioImpl.GestionTurno;

/**
 * Servlet implementation class ServletHistoriales
 */
@WebServlet("/ServletHistoriales")
public class ServletHistoriales extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IDientePacienteNegocio dp;
	IConsultaNegocio consNeg;
	ITurnoNegocio turneg;

	public ServletHistoriales() {
		super();
		dp = new GestionDientes();
		consNeg = new GestionConsultas();
		turneg = new GestionTurno();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("id") != null) {
			Gson gson = new Gson();
			int idPaciente = Integer.valueOf(request.getParameter("id"));
			String pData = gson.toJson(dp.getOdontograma(idPaciente));
			// response.getWriter().append("Served at: ").append(request.getContextPath());
			response.getWriter().append(pData);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("usuario") != null) {
			if (request.getParameter("idturno") != null && request.getParameter("idpaciente") != null
					&& request.getParameter("tratamiento") != null && request.getParameter("anotacion") != null) {
				
				iUsuario user = (iUsuario) request.getSession().getAttribute("usuario");
				int idpaciente = Integer.valueOf(request.getParameter("idpaciente"));
				String anot = request.getParameter("anotacion");
				String idtrat = request.getParameter("tratamiento");
				int idturno = -1;
				if(!request.getParameter("idturno").equals("null")) {
					idturno = Integer.valueOf(request.getParameter("idturno"));
				}else {
					idturno = turneg.nuevoTurno(user.getIDUsuario(), idpaciente, LocalDateTime.now());
				}
				boolean consGuardada = false;
				System.out.println("turno? " + idturno);
				if (!user.isTipoUsuario() && idturno != -1) {
					System.out.println("guardado?");
					ConsultaData consulta = new ConsultaData();
					consulta.setIDTurno(idturno);
					consulta.setIDPaciente(idpaciente);
					consulta.setAnotacion(anot);
					consulta.setIDTratamiento(idtrat);
					consulta.setIDOdontologo(user.getIDUsuario());
					consGuardada = consNeg.insertar(consulta);
				}

				if (request.getParameter("odontograma") != null && consGuardada) {
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
						if (estado != 0) {
							newd.setParte("L");
							newd.setIDEstado(estado);
							dp.insertar(newd);
						}
						estado = Integer.valueOf(d.up);
						if (estado != 0) {
							newd.setParte("U");
							newd.setIDEstado(estado);
							dp.insertar(newd);
						}
						estado = Integer.valueOf(d.right);
						if (estado != 0) {
							newd.setParte("R");
							newd.setIDEstado(estado);
							dp.insertar(newd);
						}
						estado = Integer.valueOf(d.bottom);
						if (estado != 0) {
							newd.setParte("B");
							newd.setIDEstado(estado);
							dp.insertar(newd);
						}
						estado = Integer.valueOf(d.center);
						if (estado != 0) {
							newd.setParte("C");
							newd.setIDEstado(estado);
							dp.insertar(newd);
						}

					}
				}
			}
		}
	}

}
