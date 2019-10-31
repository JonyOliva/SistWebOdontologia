package DatosImpl;

import java.sql.ResultSet;
import java.util.List;

import Datos.IOdontologoDao;
import Entidad.Odontologo;

public class OdontologoDaoImpl implements IOdontologoDao{

	Conexion cn;
		
	public OdontologoDaoImpl() {
		super();
		this.cn = new Conexion();
	}

	@Override
	public Odontologo get(int IDOdontologo) {
		try {
			cn.Open();
			ResultSet rs = cn.query("SELECT * FROM Odontologos WHERE IDOdontologo='" + IDOdontologo + "'");
			if(rs.next()) {
				Odontologo odont = new Odontologo(rs.getString("IDOdontologo"));
				odont.setNombre(rs.getString("Nombre"));
				odont.setApellido(rs.getString("Apellido"));
				odont.setDNI(rs.getString("DNI"));
				odont.setMatricula(rs.getString("Matricula"));
				//odont.setActivo(rs.getBoolean("Activo"));
				cn.close();
				return odont;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return null;
	}

	@Override
	public List<Odontologo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertar(Odontologo paciente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(Odontologo paciente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int IDPaciente) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
