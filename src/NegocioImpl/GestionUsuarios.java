package NegocioImpl;

import java.sql.SQLException;
import java.util.ArrayList;

import Datos.iUsuarioDao;
import DatosImpl.UsuarioDaoImpl;
import Entidad.Administrador;
import Entidad.Odontologo;
import Entidad.iUsuario;
import Negocio.iUsuarioNegocio;

public class GestionUsuarios implements iUsuarioNegocio{

	public ArrayList<iUsuario> getAll() {
		iUsuarioDao userDAO = new UsuarioDaoImpl();
		ArrayList<iUsuario>ListUsers = new ArrayList<>();
		try {
			ListUsers = userDAO.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListUsers;
	}

	@Override
	public Administrador getAdm(iUsuario user) {
		iUsuarioDao userDao = new UsuarioDaoImpl();
		iUsuario admin = userDao.getPerfil(user);
		return (Administrador) admin;
	}
	
	@Override
	public Odontologo getOdo(iUsuario user) {
		iUsuarioDao userDao = new UsuarioDaoImpl();
		iUsuario odon = userDao.getPerfil(user);
		return (Odontologo) odon;
	}

	@Override
	public boolean insertar(iUsuario odontologo) {
		iUsuarioDao userdao = new UsuarioDaoImpl();
		return userdao.insertar(odontologo);
	}

	@Override
	public boolean modificar(iUsuario odontologo) {
		iUsuarioDao userdao = new UsuarioDaoImpl();
		return userdao.modificar(odontologo);
	}

	@Override
	public boolean eliminar(String idUsuario) {
		return false;
	}

	@Override
	public iUsuario login(String email, String password) {
		iUsuarioDao userDao = new UsuarioDaoImpl();
		iUsuario user = userDao.login(email, password);
		return user;
	}

	@Override
	public String getNextID(boolean tipoUsuario) {
		iUsuarioDao ud = new UsuarioDaoImpl();
		return ud.getNextID(tipoUsuario);
	}

	@Override
	public String getPass(String mail, String dni) {
		iUsuarioDao userDao = new UsuarioDaoImpl();
		return userDao.getPass(mail, dni);
	}



}
