package Datos;

import java.util.List;

import Entidad.Turno;
import Entidad.TurnosVista;

public interface ITurnosDao {
	public Turno getTurno(int id);
	List<Turno> obtenerLista();
	List<TurnosVista> obtenerTurnovista();
	List<Turno> turnosPaciente(int idPaciente);
	List<TurnosVista> turnosOdontologo(String idod);
	List<TurnosVista> turnosPacienteVista();
	public boolean existe(Turno turno);
	public boolean existePac(Turno turno);
	public boolean insertar(Turno turno);
	public boolean eliminar(int idTurno);
	public boolean presente(int idTurno);
	public boolean ausente(int idTurno);
	public boolean modificar(Turno turno);
	public int nuevoTurno(Turno turno);
	
}
