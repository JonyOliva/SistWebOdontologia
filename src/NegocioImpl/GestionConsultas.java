package NegocioImpl;

import java.util.ArrayList;

import Datos.IConsultaDao;
import DatosImpl.ConsultaDaoImpl;
import Entidad.Consulta;
import Entidad.Tratamiento;
import Negocio.IConsultaNegocio;

public class GestionConsultas implements IConsultaNegocio{

	IConsultaDao cd;
	
	public GestionConsultas() {
		super();
		this.cd = new ConsultaDaoImpl();
	}

	@Override
	public ArrayList<Tratamiento> getAll() {
		return (ArrayList<Tratamiento>) cd.getAll();
	}

	@Override
	public ArrayList<Consulta> getAll(int idPaciente) {
		return (ArrayList<Consulta>) cd.getAll(idPaciente);
	}

	@Override
	public boolean insertar(Consulta consulta) {
		return cd.insertar(consulta);
	}

}
