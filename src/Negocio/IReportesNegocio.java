package Negocio;

import java.util.ArrayList;

import Entidad.IGestionable;
import Entidad.Inasistencias;
import Entidad.InasistenciasDetalle;
import Entidad.Paciente;

public interface IReportesNegocio extends IGestionable<Inasistencias> {

	public Inasistencias getInasistencias(String dniPaciente);
	public ArrayList<InasistenciasDetalle> getInasistenciasDet(Paciente pac);
}
