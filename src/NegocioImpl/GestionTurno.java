package NegocioImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DatosImpl.PacienteDaoImpl;
import DatosImpl.TurnosDaoImpl;
import Entidad.Paciente;
import Entidad.Turno;
import Negocio.ITurnoNegocio;

public class GestionTurno implements ITurnoNegocio{

	@Override
	public Turno getTurno() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Turno> listTurno() {
		
		List<Turno> lista = new ArrayList<Turno>();
		TurnosDaoImpl datosTurno= new TurnosDaoImpl();
		
		lista = datosTurno.obtenerLista();
		
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
			turno.setActivo(true);
			
			return datosTurno.insertar(turno);
		}

		return false;
	}

	@Override
	public boolean modificarTurno(Turno turno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrarTurno(int idTurno) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
