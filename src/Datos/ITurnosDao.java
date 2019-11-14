package Datos;

import java.util.List;

import Entidad.Turno;
import Entidad.TurnosVista;

public interface ITurnosDao {
	List<Turno> obtenerLista();
	List<TurnosVista> obtenerTurnovista();
	List<Turno> turnosPaciente(int idPaciente);
	List<TurnosVista> turnosPacienteVista();
	public boolean existe(Turno turno);
	public boolean insertar(Turno turno);
	public boolean eliminar(int idTurno);
	
}
