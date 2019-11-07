package Negocio;

import java.util.ArrayList;

import Entidad.Tratamiento;
import Entidad.Consulta;

public interface IConsultaNegocio {
	public ArrayList<Tratamiento> getAll();
	public ArrayList<Consulta> getAll(int idPaciente);
	public boolean insertar(Consulta consulta);
}
