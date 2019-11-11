package Datos;

import java.util.List;

import Entidad.Turno;

public interface ITurnosDao {
	List<Turno> obtenerLista();
	List<Turno> turnosPaciente(int idPaciente);
	public boolean insertar(Turno turno);
	public boolean eliminar(int idTurno);
	
}
