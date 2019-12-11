package Negocio;

import java.util.ArrayList;

import Entidad.IGestionable;
import Entidad.Inasistencias;
import Entidad.InasistenciasDetalle;
import Entidad.Paciente;

public interface IReportesNegocio{

	public Inasistencias getInasistencias(String dniPaciente);
	public ArrayList<InasistenciasDetalle> getInasistenciasDet(Paciente pac);
}
