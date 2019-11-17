package DatosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
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
	public Odontologo get(String IDOdont) {
		try {
			cn.Open();
			ResultSet rs = cn.query("SELECT * FROM Odontologos WHERE IDOdontologo='" + IDOdont + "'");
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
		List<Odontologo> listOdonts = new ArrayList<Odontologo>();
		try {
			cn.Open();
			ResultSet rs = cn.query("SELECT * FROM odontologos");
			while(rs.next()) {
				Odontologo odont = new Odontologo(rs.getString("IDOdontologo"));
				odont.setNombre(rs.getString("Nombre"));
				odont.setApellido(rs.getString("Apellido"));
				odont.setDNI(rs.getString("DNI"));
				odont.setMatricula(rs.getString("Matricula"));
				//odont.setActivo(rs.getBoolean("Activo"));
				listOdonts.add(odont);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return listOdonts;
	}

	@Override
	public boolean insertar(Odontologo odont) {
		try {
			cn.Open();
			String query = "INSERT INTO Odontologos(IDOdontologo, Nombre, Apellido, DNI, Matricula) ";
			String data = "SELECT '"+odont.getIDUsuario()+"', '"+odont.getNombre()+"', '"+odont.getApellido()
			+"','"+odont.getDNI()+"', "+ "'"+odont.getMatricula()+"'";
			boolean res = cn.execute(query+data);
			cn.close();
			return res;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return false;
	}

	@Override
	public boolean modificar(Odontologo odont) {
		try {
			cn.Open();
			String query = "UPDATE Odontologos SET ";
			String data = "`Nombre`='"+odont.getNombre()+"',`Apellido`='"+odont.getApellido()+"', `DNI`='"+odont.getDNI()+
					"', `Matricula`='"+odont.getMatricula()+"' WHERE `IDOdontologo`='" + odont.getIDUsuario()+"';";
			boolean res = cn.execute(query+data);
			cn.close();
			return res;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return false;
	}

	@Override
	public boolean eliminar(String IDOdont) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
