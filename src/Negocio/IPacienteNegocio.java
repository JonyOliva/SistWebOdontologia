package Negocio;

import java.util.ArrayList;

import Entidad.IGestionable;
import Entidad.Inasistencias;
import Entidad.Paciente;

public interface IPacienteNegocio extends IGestionable<Paciente>{
	
	public ArrayList<Paciente> getAll();
	public Paciente get(int idPaciente);
	public Paciente get(String dniPaciente);
	public boolean insertar(Paciente paciente);
	public boolean modificar(Paciente paciente);
	public boolean eliminar(int idPaciente);
	public ArrayList<Inasistencias> getInasistencias();
	public Inasistencias getInasistencias(String dniPaciente);
	
}
