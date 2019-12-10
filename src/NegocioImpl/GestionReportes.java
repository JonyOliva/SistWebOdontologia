package NegocioImpl;

import java.util.ArrayList;
import java.util.List;

import Datos.IPacienteDao;
import Entidad.Inasistencias;
import Entidad.InasistenciasDetalle;
import Entidad.Paciente;
import Negocio.IReportesNegocio;

public class GestionReportes implements IReportesNegocio{
	private IPacienteDao pdao;

	@Override
	public List<Inasistencias> get(int inicio, int tamPagina, String aBuscar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size(String busqueda) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Inasistencias getInasistencias(String dniPaciente) {
		return pdao.getInasistencias(dniPaciente);
	}

	@Override
	public ArrayList<InasistenciasDetalle> getInasistenciasDet(Paciente pac) {
		return (ArrayList<InasistenciasDetalle>)pdao.getInasistenciasDetalle(pac);
	}

	@Override
	public List<Inasistencias> get(int inicio, int tamPagina, String aBuscar, String desde, String hasta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size(String busqueda, String desde, String hasta) {
		// TODO Auto-generated method stub
		return 0;
	}

}
