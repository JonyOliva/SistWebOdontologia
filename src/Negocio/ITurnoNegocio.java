package Negocio;

import java.time.LocalDateTime;
import java.util.List;

import Entidad.Turno;
import Entidad.TurnosVista;

public interface ITurnoNegocio {

	public Turno getTurno(int id);
	public List<Turno> listTurno();
	public List<TurnosVista> listTurnovista();
	public boolean guardarTurno(String dni,String idOdon,String fecha, String hora);
	public boolean modificarTurno(Turno turno, String dni,String fechahora);
	public boolean borrarTurno(int idTurno);
	public boolean existe(String idOdon,String fechahora);
	public boolean existePac(String dnipac,String fechahora);
	public List<TurnosVista> listaTurnoOdontologo(String idod);
	public boolean presente(int idturno);
	public boolean ausente(int idturno);
	public int nuevoTurno(String idOdont, int idPac, LocalDateTime fecha);
	
}
