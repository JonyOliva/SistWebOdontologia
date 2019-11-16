package DatosImpl;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Datos.IPacienteDao;
import Entidad.Inasistencias;
import Entidad.Paciente;


public class PacienteDaoImpl implements IPacienteDao{

	Conexion cn;
	
	public PacienteDaoImpl() {
		this.cn = new Conexion();
	}

	@Override
	public Paciente get(int IDPaciente) {
		try {
			cn.Open();
			ResultSet rs = cn.query("SELECT * FROM pacientes WHERE IDPaciente =" + IDPaciente);
			if(rs.next()) {
				Paciente paciente = new Paciente(rs.getInt("IDPaciente"));
				paciente.setNombre(rs.getString("Nombre"));
				paciente.setApellido(rs.getString("Apellido"));
				paciente.setDni(rs.getString("DNI"));
				paciente.setTelefono(rs.getString("Telefono"));
				paciente.setDomicilio(rs.getString("Domicilio"));
				paciente.setInfoExtra(rs.getString("InformacionExtra"));
				paciente.setFechaNacimiento(rs.getObject("FechaNacimiento", LocalDate.class));
				
				return paciente;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return null;
	}

	@Override
	public List<Paciente> getAll() {
		
		List<Paciente> listPacientes = new ArrayList<Paciente>();
		try {
			cn.Open();
			ResultSet rs = cn.query("SELECT * FROM pacientes");
			while(rs.next()) {
				Paciente paciente = new Paciente(rs.getInt("IDPaciente"));
				paciente.setActivo(rs.getBoolean("Activo"));
				paciente.setNombre(rs.getString("Nombre"));
				paciente.setApellido(rs.getString("Apellido"));
				paciente.setDni(rs.getString("DNI"));
				paciente.setTelefono(rs.getString("Telefono"));
				paciente.setDomicilio(rs.getString("Domicilio"));
				paciente.setInfoExtra(rs.getString("InformacionExtra"));
				paciente.setFechaNacimiento(rs.getObject("FechaNacimiento", LocalDate.class));
				listPacientes.add(paciente);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		
		return listPacientes;
	}

	@Override
	public boolean insertar(Paciente paciente) {
		try {
			cn.Open();
			String query = "INSERT INTO pacientes(Nombre, Apellido, DNI, Telefono, Domicilio, FechaNacimiento, InformacionExtra, Activo) ";
			String data = "SELECT '"+paciente.getNombre()+"', '"+paciente.getApellido()+"', '"+paciente.getDni()+"','"+paciente.getTelefono()+"', "
					+ "'"+paciente.getDomicilio()+"', '"+paciente.getFechaNacimiento()+"', '"+paciente.getInfoExtra()+"', '"+paciente.isActivo()+"'";
			
			return cn.execute(query+data);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return false;
	}

	@Override
	public boolean modificar(Paciente paciente) {
		try {
			cn.Open();
			String query = "UPDATE pacientes SET ";
			String data = "Nombre='"+paciente.getNombre()+"', Apellido='"+paciente.getApellido()+"', DNI='"+paciente.getDni()+"', Telefono='"+paciente.getTelefono()
			+"', Domicilio='"+paciente.getDomicilio()+"', FechaNacimiento='"+paciente.getFechaNacimiento()+"', InformacionExtra='"+paciente.getInfoExtra()
			+"' WHERE IDPaciente=" + paciente.getIDPaciente();
			return cn.execute(query+data);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return false;
	}

	@Override
	public boolean eliminar(int IDPaciente) {
		try {
			cn.Open();
			String query = "UPDATE pacientes SET Activo=0 WHERE IDPaciente=" + IDPaciente;
			return cn.execute(query);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return false;
	}

	@Override
	public int size(String busqueda) {
		try {
			cn.Open();
			String query = "SELECT COUNT(IDPaciente) AS Cantidad FROM pacientes WHERE Activo=1 ";
			if(busqueda != null) {
				if(!busqueda.isEmpty()) {
					query += "AND (Nombre LIKE '%"+busqueda+"%' OR Apellido LIKE '%"+busqueda+"%' OR DNI LIKE '%"+busqueda+"%') ";
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

	@Override
	public List<Paciente> get(int inicio, int cantidad, String aBuscar) {
		List<Paciente> listPacientes = new ArrayList<Paciente>();
		try {
			cn.Open();
			String query = "SELECT * FROM pacientes WHERE Activo=1 ";
			String pagina = "LIMIT " + inicio + ", " + cantidad;
			if(aBuscar != null) {
				if(!aBuscar.isEmpty()) {
					query += "AND (Nombre LIKE '%"+aBuscar+"%' OR Apellido LIKE '%"+aBuscar+"%' OR DNI LIKE '%"+aBuscar+"%') ";
				}
			}
			ResultSet rs = cn.query(query+pagina);
			while(rs.next()) {
				Paciente paciente = new Paciente(rs.getInt("IDPaciente"));
				paciente.setNombre(rs.getString("Nombre"));
				paciente.setApellido(rs.getString("Apellido"));
				paciente.setDni(rs.getString("DNI"));
				paciente.setTelefono(rs.getString("Telefono"));
				paciente.setDomicilio(rs.getString("Domicilio"));
				paciente.setInfoExtra(rs.getString("InformacionExtra"));
				paciente.setFechaNacimiento(rs.getObject("FechaNacimiento", LocalDate.class));
				listPacientes.add(paciente);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}		
		return listPacientes;
	}

	@Override
	public Paciente get(String dni) {
		try {
			cn.Open();
			ResultSet rs = cn.query("SELECT * FROM pacientes WHERE DNI = '" +dni+ "'");
			if(rs.next()) {
				Paciente paciente = new Paciente(rs.getInt("IDPaciente"));
				paciente.setNombre(rs.getString("Nombre"));
				paciente.setApellido(rs.getString("Apellido"));
				paciente.setDni(rs.getString("DNI"));
				paciente.setTelefono(rs.getString("Telefono"));
				paciente.setDomicilio(rs.getString("Domicilio"));
				paciente.setInfoExtra(rs.getString("InformacionExtra"));
				paciente.setFechaNacimiento(rs.getObject("FechaNacimiento", LocalDate.class));
				cn.close();
				return paciente;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return null;
	}

	@Override
	public List<Inasistencias> getInasistencias() {
		List<Inasistencias> listaInasistencias = new ArrayList<Inasistencias>();
		try {
			cn.Open();
			ResultSet rs = cn.query("SELECT pacientes.IDPaciente, pacientes.Nombre, pacientes.Apellido,"
					+ " pacientes.DNI, count(pacientes.IDPaciente) as Inasistencias FROM odontologiadb.pacientes\r\n" + 
					"inner join turnos on pacientes.IDPaciente = turnos.IDPaciente_T\r\n" + 
					"where pacientes.Activo = 1 and turnos.Estado = 'Ausente'\r\n" + 
					"group by pacientes.IDPaciente\r\n" + 
					"order by Inasistencias desc;");
			while(rs.next())
			{
				Paciente pac = new Paciente(rs.getInt("IDPaciente"));
				pac.setNombre(rs.getString("Nombre"));
				pac.setApellido(rs.getString("Apellido"));
				pac.setDni(rs.getString("DNI"));
				Inasistencias ina = new Inasistencias(pac, rs.getInt("Inasistencias"));
				listaInasistencias.add(ina);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return listaInasistencias;
	}

	
		
}
