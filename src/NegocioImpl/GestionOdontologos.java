package NegocioImpl;

import java.util.ArrayList;

import Datos.IOdontologoDao;
import Entidad.Odontologo;
import Negocio.IOdontologoNegocio;

public class GestionOdontologos implements IOdontologoNegocio{

	IOdontologoDao od;
	
	@Override
	public Odontologo get(int IDPaciente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Odontologo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertar(Odontologo paciente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(Odontologo paciente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int IDPaciente) {
		// TODO Auto-generated method stub
		return false;
	}

}
