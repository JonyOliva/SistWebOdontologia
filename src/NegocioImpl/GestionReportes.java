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
	public Inasistencias getInasistencias(String dniPaciente) {
		return pdao.getInasistencias(dniPaciente);
	}

	@Override
	public ArrayList<InasistenciasDetalle> getInasistenciasDet(Paciente pac) {
		return (ArrayList<InasistenciasDetalle>)pdao.getInasistenciasDetalle(pac);
	}

}
