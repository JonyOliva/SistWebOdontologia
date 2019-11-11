package Negocio;

import java.time.LocalDateTime;
import java.util.List;

import Entidad.Turno;

public interface ITurnoNegocio {

	public Turno getTurno();
	public List<Turno> listTurno();
	public boolean guardarTurno(String dni,String idOdon,String fecha, String hora);
	public boolean modificarTurno(Turno turno);
	public boolean borrarTurno(int idTurno);
	
}
