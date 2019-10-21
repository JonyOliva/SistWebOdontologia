package Datos;

import java.util.ArrayList;
import java.util.List;

import Entidad.Paciente;

public interface IPacienteDao {
	
	public Paciente get(int IDPaciente);
	public List<Paciente> getAll();
	public List<Paciente> buscar(String strBusqueda);
	public boolean insertar(Paciente paciente);
	public boolean modificar(Paciente paciente);
	public boolean eliminar(int IDPaciente);
	
}
