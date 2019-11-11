package NegocioImpl;

import java.util.ArrayList;
import java.util.List;

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
	public Paciente get(int idPaciente) {
		return pdao.get(idPaciente);
	}

	@Override
	public boolean insertar(Paciente paciente) {
		return pdao.insertar(paciente);
	}

	@Override
	public boolean modificar(Paciente paciente) {
		return pdao.modificar(paciente);
	}

	@Override
	public boolean eliminar(int idPaciente) {
		return pdao.eliminar(idPaciente);
	}

	@Override
	public List<Paciente> get(int inicio, int tamPagina, String aBuscar) {
		return pdao.get(inicio, tamPagina, aBuscar);
	}

	@Override
	public int size(String busqueda) {
		return pdao.size(busqueda);
	}

	@Override
	public Paciente get(String dniPaciente) {
		return pdao.get(dniPaciente);
	}

}
