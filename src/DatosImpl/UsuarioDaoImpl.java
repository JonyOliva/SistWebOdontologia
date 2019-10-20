package DatosImpl;

import Datos.iUsuarioDao;
import Entidad.Odontologo;
import Entidad.iUsuario;

public class UsuarioDaoImpl implements iUsuarioDao {

	@Override
	public iUsuario login(String email, String password) {
		
		//return new Odontologo();
		//return new Administrador();
		return null;
	}

	@Override
	public boolean insertar(iUsuario user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(iUsuario user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(iUsuario user) {
		// TODO Auto-generated method stub
		return false;
	}


	
}
