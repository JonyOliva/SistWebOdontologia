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
		// TODO Auto-generated method stub
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
	public List<Paciente> buscar(String strBusqueda) {
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

	
		
}
