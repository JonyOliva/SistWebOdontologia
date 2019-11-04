package Datos;

import java.util.List;

import Entidad.Diente;
import Entidad.DientePaciente;

public interface IDientePacienteDao {

	public boolean insertar(DientePaciente dienteP);
	public List<Diente> getAll(int idPaciente);
	
}
