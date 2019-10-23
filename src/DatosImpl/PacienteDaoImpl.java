package DatosImpl;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Datos.IPacienteDao;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(Paciente paciente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int IDPaciente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size(String busqueda) {
		try {
			cn.Open();
			String query = "SELECT COUNT(IDPaciente) AS Cantidad FROM pacientes ";
			if(busqueda != null) {
				if(!busqueda.isEmpty()) {
					query += "WHERE Nombre LIKE '%"+busqueda+"%' OR Apellido LIKE '%"+busqueda+"%' OR DNI LIKE '%"+busqueda+"%' ";
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
			String query = "SELECT * FROM pacientes ";
			String pagina = "LIMIT " + inicio + ", " + cantidad;
			if(aBuscar != null) {
				if(!aBuscar.isEmpty()) {
					query += "WHERE Nombre LIKE '%"+aBuscar+"%' OR Apellido LIKE '%"+aBuscar+"%' OR DNI LIKE '%"+aBuscar+"%' ";
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

	
		
}
