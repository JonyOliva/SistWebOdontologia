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
		
		///Iniciar Sesion
		if(request.getParameter("btnIniciarSesion")!=null)
		{
			HttpSession session = request.getSession();
			
			RequestDispatcher miDispacher = request.getRequestDispatcher("/index.jsp");
			String mail, pass;
			mail = request.getParameter("txtEmail").toString();
			pass = request.getParameter("txtPassword").toString();
			iUsuario user = gu.login(mail,pass);
			if(user == null)
			{
				request.setAttribute("ErrorSesion", true);
				miDispacher.forward(request, response);
			}
			else {
			if(user.isTipoUsuario() == false)
			{
				user = gu.getOdo(user);
				session.setAttribute("usuario", user);
				miDispacher = request.getRequestDispatcher("/ServletTurnos");
			}
			else if(user.isTipoUsuario() == true)
			{
				user = gu.getAdm(user);
				session.setAttribute("usuario", user);
				miDispacher = request.getRequestDispatcher("/ServletTurnos");
			}
			
				miDispacher.forward(request, response);
			}
			
		}
		
		///Cerrar Sesion
		if(request.getParameter("btnCerrarSesion")!=null)
		{
			HttpSession session = request.getSession();
			session.removeAttribute("usuario");
			RequestDispatcher miDispacher = request.getRequestDispatcher("/index.jsp");
			miDispacher.forward(request, response);
			//response.sendRedirect("index.jsp");
		}
		
		//Recuperar Contraseña
		if(request.getParameter("btnPass")!=null)
		{
			RequestDispatcher miDispacher = request.getRequestDispatcher("/RecuperarPass.jsp");
			String mail, dni;
			mail = request.getParameter("txtEmail").toString();
			dni = request.getParameter("txtDni").toString();
			String pass = gu.getPass(mail, dni);
			request.setAttribute("Pass", pass);
			miDispacher.forward(request, response);
		}
	}

}