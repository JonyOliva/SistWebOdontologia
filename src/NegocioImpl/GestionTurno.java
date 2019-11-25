package NegocioImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import DatosImpl.PacienteDaoImpl;
import DatosImpl.TurnosDaoImpl;
import Entidad.Paciente;
import Entidad.Turno;
import Entidad.TurnosVista;
import Negocio.ITurnoNegocio;

public class GestionTurno implements ITurnoNegocio{

	@Override
	public Turno getTurno(int id) {
		TurnosDaoImpl tdao = new TurnosDaoImpl();
		return tdao.getTurno(id);
	}

	@Override
	public List<Turno> listTurno() {
		
		List<Turno> lista = new ArrayList<Turno>();
		TurnosDaoImpl datosTurno= new TurnosDaoImpl();
		
		lista = datosTurno.obtenerLista();
		
		return lista;
	}
	
	public List<TurnosVista> listTurnovista() {
		
		List<TurnosVista> lista = new ArrayList<TurnosVista>();
		TurnosDaoImpl datosTurno= new TurnosDaoImpl();
		
		lista = datosTurno.obtenerTurnovista();
		
		return lista;
	}

	@Override
	public boolean guardarTurno(String dni,String idOdon,String fecha,String hora) {
		
		TurnosDaoImpl datosTurno = new TurnosDaoImpl();
		PacienteDaoImpl pd= new PacienteDaoImpl();
		Turno turno = new Turno(-1);
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime fechaTurno = LocalDateTime.parse(fecha+" "+hora, df);
		
		if(pd.get(dni)!= null)
		{
			turno.setIDPaciente(pd.get(dni).getIDPaciente());
			turno.setIDOdontologo(idOdon);
			turno.setFecha(fechaTurno);
			turno.setEstado("Activo");
			
			return datosTurno.insertar(turno);
		}

		return false;
	}

	@Override
	public boolean modificarTurno(Turno turno,String dni,String fechahora) {
		
		TurnosDaoImpl tdao = new TurnosDaoImpl();
		PacienteDaoImpl pdao = new PacienteDaoImpl();
		Paciente pac = pdao.get(dni);
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime fechaTurno = LocalDateTime.parse(fechahora, df);
		
		if(pac != null)
		{
			turno.setIDPaciente(pac.getIDPaciente());
		}
		turno.setFecha(fechaTurno);
		
		return tdao.modificar(turno);
	}

	@Override
	public boolean borrarTurno(int idTurno) {
		
		TurnosDaoImpl tdao = new TurnosDaoImpl();
		
		return tdao.eliminar(idTurno);
	}

	@Override
	public boolean existe(String idOdon,String fechahora) {
		TurnosDaoImpl tdao = new TurnosDaoImpl();
		Turno turno = new Turno(1);
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime fechaTurno = LocalDateTime.parse(fechahora, df);
		
		turno.setIDOdontologo(idOdon);
		turno.setFecha(fechaTurno);
		boolean existe = tdao.existe(turno);
		return existe;
	}

	@Override
	public List<TurnosVista> listaTurnoOdontologo(String idod) {
		
		TurnosDaoImpl tdao = new TurnosDaoImpl();
		
		return tdao.turnosOdontologo(idod);
	}

	@Override
	public boolean presente(int idturno) {
		TurnosDaoImpl tdao = new TurnosDaoImpl();
		
		return tdao.presente(idturno);
	}

	@Override
	public boolean ausente(int idturno) {
		TurnosDaoImpl tdao = new TurnosDaoImpl();
		return tdao.ausente(idturno);
	}

	@Override
	public boolean existePac(String dniPac, String fechahora) {
		TurnosDaoImpl tdao = new TurnosDaoImpl();
		PacienteDaoImpl pdao = new PacienteDaoImpl();
		Turno turno = new Turno(1);
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime fechaTurno = LocalDateTime.parse(fechahora, df);
		Paciente pac = pdao.get(dniPac);
		boolean existe = false;
		
		if(pac != null)
		{
			turno.setIDPaciente(pac.getIDPaciente());
			turno.setFecha(fechaTurno);
			existe = tdao.existePac(turno);
		}

		return existe;
	}

	@Override
	public int nuevoTurno(String idOdont, int idPac, LocalDateTime fecha) {
		TurnosDaoImpl tdao = new TurnosDaoImpl();
		Turno turno = new Turno(-1);
		turno.setIDOdontologo(idOdont);
		turno.setIDPaciente(idPac);
		turno.setFecha(fecha.truncatedTo(ChronoUnit.SECONDS));
		turno.setEstado("Presente");
		return tdao.nuevoTurno(turno);
	}

	@Override
	public List<TurnosVista> listaPaginable(int inicio, int tamPagina, String busqueda) {
		return null;
	}

	@Override
	public List<TurnosVista> get(int inicio, int tamPagina, String aBuscar) {
		
		TurnosDaoImpl tdao = new TurnosDaoImpl();
		return tdao.turnosVistapaginado(inicio, tamPagina, aBuscar);
	}

	@Override
	public int size(String busqueda) {
		TurnosDaoImpl tdao = new TurnosDaoImpl();
		
		return tdao.size(busqueda);
	}
	
	
	

	
}
