package Datos;

import java.time.LocalDate;
import java.util.List;

import Entidad.IGestionable;
import Entidad.Inasistencias;
import Entidad.InasistenciasDetalle;
import Entidad.Paciente;

public interface IPacienteDao extends IGestionable<Paciente>{
	
	public Paciente get(int IDPaciente);
	public Paciente get(String dni);
	public List<Paciente> getAll();
	public boolean insertar(Paciente paciente);
	public boolean modificar(Paciente paciente);
	public boolean eliminar(int IDPaciente);
	public List<Inasistencias> getInasistencias();
	public List<Inasistencias> getInasistencias(LocalDate desde, LocalDate hasta);
	public Inasistencias getInasistencias(String dniPaciente);
	public List<InasistenciasDetalle> getInasistenciasDetalle(Paciente pac);
}
