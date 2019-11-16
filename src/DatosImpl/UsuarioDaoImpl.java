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

	public UsuarioDaoImpl() {
		super();
		this.cn = new Conexion();
	}

	@Override
	public iUsuario login(String email, String password) {
		;
		try {
			cn.Open();
			ResultSet rs = cn
					.query("Select * from usuarios where Email ='" + email + "' and Password='" + password + "'");
			if (rs != null) {
				if (rs.next()) {
					iUsuario usuario = new Odontologo(rs.getString("usuarios.IDUsuario"));
					usuario.setEmail(rs.getString("usuarios.Email"));
					usuario.setPassword(rs.getString("usuarios.Password"));
					usuario.setTipoUsuario(1 == rs.getInt("usuarios.TipoUsuario"));
					cn.close();
					return usuario;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return null;
	}

	@Override
	public boolean insertar(iUsuario user) {
		Conexion cn = new Conexion();
		cn.Open();
		boolean state = cn.execute("Insert into Usuarios(IDUsuario, TipoUsuario, Email, Password) VALUES ('"
				+ user.getIDUsuario() + "'," + 0 + ",'" + user.getEmail() + "','" + user.getPassword() + "');");
		cn.close();
		return state;
	}

	@Override
	public boolean modificar(iUsuario user) {
		Conexion cn = new Conexion();
		cn.Open();
		boolean state = cn.execute("Update usuarios set Email='" + user.getEmail() + "', Password='"
				+ user.getPassword() + "' where IDUsuario = '" + user.getIDUsuario() + "';");
		cn.close();
		return state;
	}

	@Override
	public boolean eliminar(String IDUsuario) {
		Conexion cn = new Conexion();
		cn.Open();
		boolean state = cn.execute("Update usuarios set EstadoUsuario = false where IDUsuario = " + IDUsuario + ";");
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
		while (rs.next()) {
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
	public iUsuario getPerfil(iUsuario user) {
		if (user.isTipoUsuario()) {
			Administrador adm = new Administrador(user);

			try {
				cn.Open();
				ResultSet rs = cn
						.query("Select * from administradores where IDAdministrador='" + adm.getIDUsuario() + "'");
				if (rs.next()) {
					adm.setNombre(rs.getString("administradores.nombre"));
					adm.setApellido(rs.getString("administradores.apellido"));
					adm.setDni(rs.getString("administradores.dni"));
					cn.close();
					return adm;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				cn.close();
			}
			return adm;
		}

		else {
			Odontologo odon = new Odontologo(user);

			try {
				cn.Open();
				ResultSet rs = cn.query("Select * from odontologos where IDOdontologo='" + odon.getIDUsuario() + "'");
				if (rs.next()) {
					odon.setNombre(rs.getString("odontologos.nombre"));
					odon.setApellido(rs.getString("odontologos.apellido"));
					odon.setDNI(rs.getString("odontologos.dni"));
					odon.setEmail("odontologos.email");
					odon.setMatricula("odontologos.matricula");
					cn.close();
					return odon;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				cn.close();
			}
			return odon;
		}
	}

	@Override
	public iUsuario get(String id) {
		iUsuario usuario = null;
		try {
			cn.Open();
			ResultSet rs = cn.query("Select * from usuarios where IDUsuario='" + id + "'");
			if (rs.next()) {
				if (1 == rs.getInt("usuarios.TipoUsuario")) {
					usuario = new Administrador(rs.getString("usuarios.IDUsuario"));
					usuario.setEmail(rs.getString("usuarios.Email"));
					usuario.setPassword(rs.getString("usuarios.Password"));
					usuario.setTipoUsuario(1 == rs.getInt("usuarios.TipoUsuario"));
					usuario = getPerfil(usuario);
				} else {
					usuario = new Odontologo(rs.getString("usuarios.IDUsuario"));
					usuario.setEmail(rs.getString("usuarios.Email"));
					usuario.setPassword(rs.getString("usuarios.Password"));
					usuario.setTipoUsuario(1 == rs.getInt("usuarios.TipoUsuario"));
					usuario = getPerfil(usuario);
				}
				cn.close();
				return usuario;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return null;
	}

	public String getNextID(boolean tipoUsuario) {
		int cant=-1;
		try {
			cn.Open();
			ResultSet rs = cn.query("Select count(IDUsuario) as cantUsuarios from usuarios");
			if (rs.next()) {
				cant = rs.getInt("cantUsuarios")+1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		if(cant != -1) {
			if(tipoUsuario)
				return "A"+String.format("%04d", cant);
			else
				return "O"+String.format("%04d", cant);
		}else {
			return null;
		}
	}
	
}
