package DatosImpl;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Datos.ITurnosDao;
import Entidad.Turno;

public class TurnosDaoImpl implements ITurnosDao{

	Conexion cn;
	public TurnosDaoImpl() {
		this.cn = new Conexion();
	}
	
	@Override
	public List<Turno> obtenerLista() {
		List<Turno> lista = new ArrayList<Turno>();
		try {
			cn.Open();
			ResultSet rs = cn.query("SELECT * FROM Turnos");
			//DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm") ;
			while(rs.next())
			{
				Turno turno = new Turno(rs.getInt("IDTurno"));
				turno.setIDPaciente(rs.getInt("IDPaciente_T"));
				turno.setFecha(rs.getObject("Fecha", LocalDateTime.class));
				turno.setIDOdontologo(rs.getString("IDOdontologo_T"));
				
				lista.add(turno);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			cn.close();
		}
		

		return lista;
	}

	@Override
	public List<Turno> turnosPaciente(int idPaciente) {
		List<Turno> lista = new ArrayList<Turno>();
		try {
			cn.Open();
			ResultSet rs = cn.query("SELECT * FROM Turnos WHERE IDPaciente_T = '"+idPaciente+"'");
			while(rs.next())
			{
				Turno turno = new Turno(rs.getInt("IDTurno"));
				turno.setIDPaciente(rs.getInt("IDPaciente_T"));
				turno.setFecha(rs.getDate("Fecha").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
				turno.setIDOdontologo(rs.getString("IDOdontologo_T"));
				turno.setActivo(rs.getBoolean("Activo"));
				
				lista.add(turno);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			cn.close();
		}
		
		return lista;
	}

	@Override
	public boolean insertar(Turno turno) {
		String query = "INSERT INTO Turnos (IDOdontologo_T,IDPaciente_T,Fecha,Activo) "
				+ "SELECT("+turno.getIDOdontologo()+","+turno.getIDPaciente()+","+turno.getFecha()+","+1+")";
		try {
			cn.Open();
			return cn.execute(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean eliminar(int idTurno) {
		String query = "UPDATE Turnos SET Activo = 0 WHERE IDTurno = "+idTurno;
		try {
			cn.Open();
			return cn.execute(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	

	
}
