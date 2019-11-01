package NegocioImpl;

import java.util.ArrayList;

import Datos.IOdontologoDao;
import Datos.iUsuarioDao;
import DatosImpl.OdontologoDaoImpl;
import DatosImpl.UsuarioDaoImpl;
import Entidad.Odontologo;
import Entidad.iUsuario;
import Negocio.IOdontologoNegocio;

public class GestionOdontologos implements IOdontologoNegocio{

	IOdontologoDao od;
	iUsuarioDao ud;
	
	public GestionOdontologos() {
		this.od = new OdontologoDaoImpl();
		ud = new UsuarioDaoImpl();
	}

	@Override
	public Odontologo get(String IDOdont) {
		Odontologo odont = od.get(IDOdont);
		iUsuario user = ud.get(IDOdont);
		odont.setEmail(user.getEmail());
		odont.setPassword(user.getPassword());
		return odont;
	}

	@Override
	public ArrayList<Odontologo> getAll() {
		return (ArrayList<Odontologo>)od.getAll();
	}

	@Override
	public boolean insertar(Odontologo odont) {
		return od.insertar(odont);
	}

	@Override
	public boolean modificar(Odontologo odont) {
		return od.modificar(odont);
	}

	@Override
	public boolean eliminar(String IDOdont) {
		// TODO Auto-generated method stub
		return false;
	}

}
