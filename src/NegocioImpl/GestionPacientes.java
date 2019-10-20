package NegocioImpl;

import java.util.ArrayList;

import Datos.IPacienteDao;
import DatosImpl.PacienteDaoImpl;
import Entidad.Paciente;
import Negocio.IPacienteNegocio;

public class GestionPacientes implements IPacienteNegocio{

	private IPacienteDao pdao;
		
	public GestionPacientes() {
		this.pdao = new PacienteDaoImpl();
	}

	@Override
	public ArrayList<Paciente> getAll() {
		return (ArrayList<Paciente>) pdao.getAll();
	}

	@Override
	public Paciente get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertar(Paciente articulo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(Paciente articulo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
