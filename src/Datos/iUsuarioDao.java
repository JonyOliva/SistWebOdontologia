package Datos;

import java.sql.SQLException;
import java.util.ArrayList;

import Entidad.Administrador;
import Entidad.iUsuario;

public interface iUsuarioDao {

	public iUsuario login(String email, String password);
	public boolean insertar(iUsuario user);
	public boolean modificar(iUsuario user);
	public boolean eliminar(String IDUsuario);
	public ArrayList<iUsuario> getAll() throws SQLException;
	public Administrador getAdmin(Administrador admin);
	public iUsuario get(String id);
	
}
