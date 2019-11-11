package Datos;

import java.util.List;

import Entidad.IGestionable;
import Entidad.Paciente;

public interface IPacienteDao extends IGestionable<Paciente>{
	
	public Paciente get(int IDPaciente);
	public Paciente get(String dni);
	public List<Paciente> getAll();
	public boolean insertar(Paciente paciente);
	public boolean modificar(Paciente paciente);
	public boolean eliminar(int IDPaciente);
	
}
