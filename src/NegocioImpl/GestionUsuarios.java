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

	@Override
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
		Administrador admin = new Administrador(user);
		admin = userDao.getAdmin(admin);
		return admin;
	}

	@Override
	public boolean insertar(Odontologo odontologo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(Odontologo odontologo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(String idUsuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public iUsuario login(String email, String password) {
		iUsuarioDao userDao = new UsuarioDaoImpl();
		iUsuario user = null;
		try {
			user = userDao.login(email, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public Odontologo getOdo(iUsuario user) {
		iUsuarioDao userDao = new UsuarioDaoImpl();
		Odontologo odon = new Odontologo(user);
		odon = userDao.getOdont(odon);
		return odon;
	}

}
