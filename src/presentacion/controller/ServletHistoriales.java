package presentacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.*;
/**
 * Servlet implementation class ServletHistoriales
 */
@WebServlet("/ServletHistoriales")
public class ServletHistoriales extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletHistoriales() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("odontograma") != null) {
			JsonParser gson = new JsonParser();
			JsonArray odontograma = gson.parse(request.getParameter("odontograma")).getAsJsonArray();
			System.out.print(odontograma);
			for (JsonElement element : odontograma) {
				JsonObject diente = element.getAsJsonObject();
				System.out.print("\n id:" + diente.get("id") + "\n");
				System.out.print(diente.get("estado"));

			}
			
			doGet(request, response);
		}
	}

}
