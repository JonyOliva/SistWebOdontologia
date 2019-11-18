package Negocio;

import java.util.List;

import Entidad.Turno;
import Entidad.TurnosVista;

public interface ITurnoNegocio {

	public Turno getTurno();
	public List<Turno> listTurno();
	public List<TurnosVista> listTurnovista();
	public boolean guardarTurno(String dni,String idOdon,String fecha, String hora);
	public boolean modificarTurno(Turno turno);
	public boolean borrarTurno(int idTurno);
	public boolean existe(String idOdon,String fechahora);
	public List<TurnosVista> listaTurnoOdontologo(String idod);
	public boolean presente(int idturno);
	public boolean ausente(int idturno);
	
}
