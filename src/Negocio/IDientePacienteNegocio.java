package Negocio;

import java.util.ArrayList;

import Entidad.Diente;
import Entidad.DientePaciente;

public interface IDientePacienteNegocio {
	public boolean insertar(DientePaciente dienteP);
	public ArrayList<Diente> getOdontograma(int idPaciente);
}
