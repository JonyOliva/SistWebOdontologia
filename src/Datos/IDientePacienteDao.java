package Datos;

import Entidad.DientePaciente;
import Entidad.Paciente;

public interface IDientePacienteDao {

	public boolean insertar(DientePaciente dienteP);
	public boolean getAll(Paciente paciente);
	public DientePaciente get(int id);
	
}
