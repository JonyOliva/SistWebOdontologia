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
					"pacientes ON pacientes.IDPaciente = IDPaciente_T INNER JOIN Odontologos ON IDOdontologo = IDOdontologo_T WHERE Estado='Activo'");
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
		List<Turno> lista = new ArrayList<Turno>();
		try {
				cn.Open();
				ResultSet rs = cn.query("SELECT * FROM Turnos WHERE IDOdontologo_T = '"+turno.getIDOdontologo()+"' "
						+ "AND Fecha = '"+turno.getFecha().toString().replace('T', ' ')+"'");
				while(rs.next())
				{
					Turno tur = new Turno(rs.getInt("IDTurno"));
					tur.setIDOdontologo(rs.getString("IDOdontologo_T"));
					
					lista.add(tur);
				}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally 
		{
			cn.close();

		}
		if(lista.isEmpty())return false;
		else return true;
				
	}

	@Override
	public List<TurnosVista> turnosOdontologo(String idod) {
		List<TurnosVista> lista = new ArrayList<TurnosVista>();
		try {
			cn.Open();
			ResultSet rs = cn.query("SELECT IDTurno,IDPaciente_T,Fecha,IDOdontologo_T,Estado,Pacientes.Nombre,pacientes.Apellido," + 
					"pacientes.DNI,odontologos.Nombre,odontologos.Apellido FROM Turnos INNER JOIN " + 
					"pacientes ON pacientes.IDPaciente = IDPaciente_T INNER JOIN Odontologos ON IDOdontologo = IDOdontologo_T "
					+ "WHERE IDOdontologo_T = '"+idod+"' AND Estado = 'Activo' AND date(Fecha) = current_date()");
			
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

	@Override
	public boolean existePac(Turno turno) {
		List<Turno> lista = new ArrayList<Turno>();
		try {
				cn.Open();
				ResultSet rs = cn.query("SELECT * FROM Turnos WHERE IDPaciente_T = "+turno.getIDPaciente()+" "
						+ "AND Fecha = '"+turno.getFecha().toString().replace('T', ' ')+"'");
				while(rs.next())
				{
					Turno tur = new Turno(rs.getInt("IDTurno"));
					tur.setIDPaciente(rs.getInt("IDPaciente_T"));
					
					lista.add(tur);
				}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally 
		{
			cn.close();

		}
		if(lista.isEmpty())return false;
		else return true;
	}

	@Override
	public Turno getTurno(int id) {
		Turno turno =  new Turno(1);
		
		try {
			
			cn.Open();
			ResultSet rs = cn.query("SELECT * FROM Turnos WHERE IDTurno = "+id);
			rs.next();
			turno = new Turno(rs.getInt("IDTurno"));
			turno.setIDPaciente(rs.getInt("IDPaciente_T"));
			turno.setFecha(rs.getObject("Fecha",LocalDateTime.class));
			turno.setIDOdontologo(rs.getString("IDOdontologo_T"));
			turno.setEstado(rs.getString("Estado"));

		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			cn.close();
		}
		return turno;
	}

	@Override
	public boolean modificar(Turno turno) {
		String query="UPDATE Turnos SET Estado = 'Activo',IDOdontologo_T = '"+turno.getIDOdontologo()+"', "
				+ "IDPaciente_T = '"+turno.getIDPaciente()+"', Fecha = '"+turno.getFecha().toString().replace('T', ' ')+"' "
						+ "WHERE IDTurno = "+turno.getIDTurno();
		try {
			cn.Open();
			return cn.execute(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int nuevoTurno(Turno turno) {
		if(insertar(turno)) {
			try {
				cn.Open();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				ResultSet rs = cn.query("SELECT IDTurno FROM Turnos WHERE Fecha = '"+turno.getFecha().format(formatter)+"' AND Estado='Presente'");
				if(rs.next())
				{   
					int id = rs.getInt("IDTurno"); 
					cn.close();
					return id;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally
			{
				cn.close();
			}
		}
		return -1;
	}

	@Override
	public List<TurnosVista> turnosVistapaginado(int inicio, int cantidad, String busqueda) {
List<TurnosVista> lista = new ArrayList<TurnosVista>();
		
		try {
			cn.Open();
			String consulta ="SELECT IDTurno,IDPaciente_T,Fecha,IDOdontologo_T,Estado,Pacientes.Nombre,pacientes.Apellido," + 
					"pacientes.DNI,odontologos.Nombre,odontologos.Apellido FROM Turnos INNER JOIN " + 
					"pacientes ON pacientes.IDPaciente = IDPaciente_T INNER JOIN Odontologos ON IDOdontologo = IDOdontologo_T  WHERE Estado = 'Activo' ";
			String condiciones="AND (pacientes.Nombre LIKE '%"+busqueda+"%' OR pacientes.DNI LIKE '%"+busqueda+"%' OR "
					+ "pacientes.Apellido LIKE '%"+busqueda+"%') ";
			String pagina="LIMIT "+inicio+", "+cantidad;
			if(busqueda != null)
				consulta = consulta + condiciones;
			ResultSet rs = cn.query(consulta+pagina);
			
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

	public int size(String busqueda) {
		try {
			cn.Open();
			String query = "SELECT COUNT(IDPaciente_T) AS Cantidad FROM Turnos INNER JOIN pacientes ON IDPaciente_T = IDPaciente"
					+ " WHERE Estado = 'Activo' ";
			if(busqueda != null) {
				if(!busqueda.isEmpty()) {
					query += "AND (pacientes.Nombre LIKE '%"+busqueda+"%' OR pacientes.Apellido LIKE '%"+busqueda+"%' OR pacientes.DNI LIKE '%"+busqueda+"%') ";
				}
			}
			ResultSet rs = cn.query(query);
			if(rs.next()) {
				return rs.getInt("Cantidad");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return 0;
	}
	

	
}
