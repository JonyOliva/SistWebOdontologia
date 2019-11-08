package NegocioImpl;

import java.util.ArrayList;

import Datos.IConsultaDao;
import Datos.IDientePacienteDao;
import DatosImpl.ConsultaDaoImpl;
import DatosImpl.DientePacienteDaoImpl;
import Entidad.Consulta;
import Entidad.ConsultaData;
import Entidad.Tratamiento;
import Negocio.IConsultaNegocio;

public class GestionConsultas implements IConsultaNegocio{

	IConsultaDao cd;
	IDientePacienteDao dpd;
	
	public GestionConsultas() {
		super();
		this.cd = new ConsultaDaoImpl();
		this.dpd = new DientePacienteDaoImpl();
	}

	@Override
	public ArrayList<Tratamiento> getAll() {
		return (ArrayList<Tratamiento>) cd.getAll();
	}

	@Override
	public ArrayList<Consulta> getAll(int idPaciente) {
		ArrayList<Consulta> consultas = (ArrayList<Consulta>) cd.getAll(idPaciente);
		for (Consulta con : consultas) {
			con.setPiezasArregladas(dpd.getAll(idPaciente, con.getIDTurno()));
		}
		return consultas;
	}

	@Override
	public boolean insertar(ConsultaData consulta) {
		return cd.insertar(consulta);
	}

}
