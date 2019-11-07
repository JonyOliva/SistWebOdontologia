package Datos;

import java.util.List;

import Entidad.Tratamiento;
import Entidad.Consulta;

public interface IConsultaDao {

	public List<Consulta> getAll(int idPaciente);
	public List<Tratamiento> getAll();
	public boolean insertar(Consulta consulta);
	
}
