package DatosImpl;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Datos.ITurnosDao;
import Entidad.Turno;
import Entidad.TurnosVista;

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
				turno.setEstado(rs.getString("Estado"));
				
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
		String query = "INSERT INTO Turnos (IDOdontologo_T,IDPaciente_T,Fecha,Estado) "
				+ "SELECT '"+turno.getIDOdontologo()+"',"+turno.getIDPaciente()+",'"+turno.getFecha().toString().replace('T', ' ')+"', '"+turno.getEstado()+"'";
		try {
			cn.Open();
			boolean asd = cn.execute(query);
			return asd;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean eliminar(int idTurno) {
		String query = "UPDATE Turnos SET Estado = 'Cancelado' WHERE IDTurno = "+idTurno;
		try {
			cn.Open();
			return cn.execute(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<TurnosVista> obtenerTurnovista() {
		List<TurnosVista> lista = new ArrayList<TurnosVista>();
		
		try {
			cn.Open();
			ResultSet rs = cn.query("SELECT IDTurno,IDPaciente_T,Fecha,IDOdontologo_T,Estado,Pacientes.Nombre,pacientes.Apellido," + 
					"pacientes.DNI,odontologos.Nombre,odontologos.Apellido FROM Turnos INNER JOIN " + 
					"pacientes ON pacientes.IDPaciente = IDPaciente_T INNER JOIN Odontologos ON IDOdontologo = IDOdontologo_T");
			//DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm") ;

			while(rs.next())
			{
				TurnosVista TurnoVista= new TurnosVista();
				Turno turno = new Turno(rs.getInt("IDTurno"));
				turno.setIDPaciente(rs.getInt("IDPaciente_T"));
				turno.setFecha(rs.getObject("Fecha", LocalDateTime.class));
				turno.setIDOdontologo(rs.getString("IDOdontologo_T"));
				turno.setEstado(rs.getString("Estado"));
				TurnoVista.setTurno(turno);
				TurnoVista.setApellidoPac(rs.getString("Pacientes.Apellido"));
				TurnoVista.setNombrePac(rs.getString("Pacientes.Nombre"));
				TurnoVista.setNombreOd(rs.getString("Odontologos.Nombre"));
				TurnoVista.setApellidoOd(rs.getString("Odontologos.Apellido"));
				
				lista.add(TurnoVista);
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
	public List<TurnosVista> turnosPacienteVista() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(Turno turno) {
		cn.Open();
		ResultSet rs = cn.query("SELECT * FROM Turnos WHERE IDOdontologo_T = '"+turno.getIDOdontologo()+"' "
				+ "AND Fecha = '"+turno.getFecha().toString().replace('T', ' ')+"'");
		if(rs != null)
			return true;
		else
			return false;
	}

	@Override
	public List<TurnosVista> turnosOdontologo(String idod) {
		List<TurnosVista> lista = new ArrayList<TurnosVista>();
		try {
			cn.Open();
			ResultSet rs = cn.query("SELECT IDTurno,IDPaciente_T,Fecha,IDOdontologo_T,Estado,Pacientes.Nombre,pacientes.Apellido," + 
					"pacientes.DNI,odontologos.Nombre,odontologos.Apellido FROM Turnos INNER JOIN " + 
					"pacientes ON pacientes.IDPaciente = IDPaciente_T INNER JOIN Odontologos ON IDOdontologo = IDOdontologo_T "
					+ "WHERE IDOdontologo_T = '"+idod+"' AND Estado = 'Activo' AND Fecha >= current_date()");
			
			while(rs.next())
			{
			
				TurnosVista TurnoVista= new TurnosVista();
				Turno turno = new Turno(rs.getInt("IDTurno"));
				turno.setIDPaciente(rs.getInt("IDPaciente_T"));
				turno.setFecha(rs.getObject("Fecha", LocalDateTime.class));
				turno.setIDOdontologo(rs.getString("IDOdontologo_T"));
				turno.setEstado(rs.getString("Estado"));
				TurnoVista.setTurno(turno);
				TurnoVista.setApellidoPac(rs.getString("Pacientes.Apellido"));
				TurnoVista.setNombrePac(rs.getString("Pacientes.Nombre"));
				TurnoVista.setNombreOd(rs.getString("Odontologos.Nombre"));
				TurnoVista.setApellidoOd(rs.getString("Odontologos.Apellido"));
				TurnoVista.setDni(rs.getString("pacientes.DNI"));
				
				lista.add(TurnoVista);
				
			}
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			cn.close();
		}
		
		return lista;
	}

	@Override
	public boolean presente(int idTurno) {
		String query = "UPDATE Turnos SET Estado = 'Presente' WHERE IDTurno = "+idTurno;
		try {
			cn.Open();
			return cn.execute(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean ausente(int idTurno) {
		String query = "UPDATE Turnos SET Estado = 'Ausente' WHERE IDTurno = "+idTurno;
		try {
			cn.Open();
			return cn.execute(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	

	
}
