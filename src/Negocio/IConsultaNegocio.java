package Negocio;

import java.util.ArrayList;

import Entidad.Tratamiento;
import Entidad.Consulta;
import Entidad.ConsultaData;

public interface IConsultaNegocio {
	public ArrayList<Tratamiento> getAll();
	public ArrayList<Consulta> getAll(int idPaciente);
	public boolean insertar(ConsultaData consulta);
}
