package DatosImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Datos.iUsuarioDao;
import Entidad.Administrador;
import Entidad.Odontologo;
import Entidad.iUsuario;

public class UsuarioDaoImpl implements iUsuarioDao {

	@Override
	public iUsuario login(String email, String password) throws SQLException {
		iUsuario usuario;
		Conexion cn = new Conexion();
		ResultSet rs;
		cn.Open();
		
		rs = cn.query("Select * from usuarios where usuarios.Email ="+email+ "and usuarios.password="+password+";");
		usuario = new Odontologo(rs.getString("usuarios.IDUsuario"));
		usuario.setEmail(rs.getString("usuarios.Email"));
		usuario.setPassword(rs.getString("usuarios.Password"));
		usuario.setTipoUsuario(rs.getBoolean("usuarios.TipoUsuario"));
		
		cn.close();
		return usuario;
		//return new Odontologo(usuario);
		//return new Administrador();
	}

	@Override
	public boolean insertar(iUsuario user) {
		Conexion cn = new Conexion();
		cn.Open();
		boolean state= cn.execute("Insert into Usuarios(IDUsuario, TipoUsuario, Email, Password) VALUES"+user.getIDUsuario()+","+1+user.getEmail()+user.getPassword()+";");
		cn.close();
		return state;
	}

	@Override
	public boolean modificar(iUsuario user) {
		Conexion cn = new Conexion();
		cn.Open();
		boolean state= cn.execute("Update usuarios set Email="+user.getEmail()+",Password="+user.getPassword()+"where IDUsuario = "+user.getIDUsuario()+";");
		cn.close();
		return state;
	}

	@Override
	public boolean eliminar(String IDUsuario) {
		Conexion cn = new Conexion();
		cn.Open();
		boolean state= cn.execute("Update usuarios set EstadoUsuario = false where IDUsuario = "+IDUsuario+";");
		cn.close();
		return state;
	}

	@Override
	public ArrayList<iUsuario> getAll() throws SQLException {
		ArrayList<iUsuario> ListUsers = new ArrayList<iUsuario>();
		Conexion cn = new Conexion();
		ResultSet rs;
		cn.Open();
		rs = cn.query("Select * from usuarios");
		while(rs.next())
		{
			iUsuario usuario = new Odontologo(rs.getString("usuarios.IDUsuario"));
			usuario.setEmail(rs.getString("usuarios.Email"));
			usuario.setPassword(rs.getString("usuarios.Password"));
			usuario.setTipoUsuario(rs.getBoolean("usuarios.TipoUsuario"));
			ListUsers.add(usuario);
		}
		
		
		cn.close();
		return ListUsers;
	}

	@Override
	public Administrador getAdmin(Administrador admin) {
		Administrador adm = new Administrador(admin);
		Conexion cn = new Conexion();
		ResultSet rs;
		cn.Open();
		
		rs = cn.query("Select * from administradores where administradores.IDAdministrador="+adm.getIDUsuario()+";");
		
		try {
			adm.setNombre(rs.getString("administradores.nombre"));
			adm.setApellido(rs.getString("administradores.apellido"));
			adm.setDni(rs.getString("administradores.dni"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cn.close();
		return adm;
	}

	@Override
	public Odontologo getOdont(Odontologo odont) {
		Odontologo odo = new Odontologo(odont);
		Conexion cn = new Conexion();
		ResultSet rs;
		cn.Open();
		
		rs = cn.query("Select * from odontologos where odontologos.IDOdontologo="+odo.getIDUsuario()+";");
		
		try {
			odo.setNombre(rs.getString("odontologos.nombre"));
			odo.setApellido(rs.getString("odontologos.apellido"));
			odo.setDNI(rs.getString("odontologos.dni"));
			odo.setMatricula(rs.getString("odontologos.matricula"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cn.close();
		return odo;
	}


	
}
