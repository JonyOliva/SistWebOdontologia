package DatosImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Datos.iUsuarioDao;
import Entidad.Administrador;
import Entidad.Odontologo;
import Entidad.iUsuario;

public class UsuarioDaoImpl implements iUsuarioDao {
	Conexion cn;
	
	public UsuarioDaoImpl()
	{
		super();
		this.cn = new Conexion();
	}
	

	@Override
	public iUsuario login(String email, String password){;
		try{
				cn.Open();
				ResultSet rs = cn.query("Select * from usuarios where Email ='" +email+ "' and password='" +password+ "'");
				if(rs.next()) {	
				iUsuario usuario = new Odontologo(rs.getString("usuarios.IDUsuario"));
				usuario.setEmail(rs.getString("usuarios.Email"));
				usuario.setPassword(rs.getString("usuarios.Password"));
				usuario.setTipoUsuario(1 == rs.getInt("usuarios.TipoUsuario"));
				cn.close();
				return usuario;
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return null;
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
		
		try {
			cn.Open();
			ResultSet rs = cn.query("Select * from administradores where IDAdministrador='"+adm.getIDUsuario()+"'");
			if(rs.next()) {
			adm.setNombre(rs.getString("administradores.nombre"));
			adm.setApellido(rs.getString("administradores.apellido"));
			adm.setDni(rs.getString("administradores.dni"));
			cn.close();
			return adm;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return adm;
	}

	@Override
	public iUsuario get(String id) {
			try{
				cn.Open();
				ResultSet rs = cn.query("Select * from usuarios where IDUsuario='" +id+ "'");
				if(rs.next()) {	
				iUsuario usuario = new Odontologo(rs.getString("usuarios.IDUsuario"));
				usuario.setEmail(rs.getString("usuarios.Email"));
				usuario.setPassword(rs.getString("usuarios.Password"));
				usuario.setTipoUsuario(1 == rs.getInt("usuarios.TipoUsuario"));
				cn.close();
				return usuario;
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return null;
	}


	
}
