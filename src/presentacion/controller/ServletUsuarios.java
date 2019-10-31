package presentacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import Entidad.iUsuario;
import Negocio.iUsuarioNegocio;
import NegocioImpl.GestionUsuarios;


@WebServlet("/ServletUsuarios")
public class ServletUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	iUsuarioNegocio gu = new GestionUsuarios();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuarios() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnIniciarSesion")!=null)
		{
			HttpSession session = request.getSession();
			
			RequestDispatcher miDispacher = request.getRequestDispatcher("/index.jsp");
			String mail, pass;
			mail = request.getParameter("txtEmail").toString();
			pass = request.getParameter("txtPassword").toString();
			iUsuario user= gu.login(mail,pass);
			if(!(user.isTipoUsuario()))
			{
				user = gu.getOdo(user);
				miDispacher = request.getRequestDispatcher("/odonTurnos.jsp");
			}
			else
			{
				user = gu.getAdm(user);
				miDispacher = request.getRequestDispatcher("/adminTurnos.jsp");
			}
			session.setAttribute("usuario", user);
			miDispacher.forward(request, response);
			
		}
	}

}