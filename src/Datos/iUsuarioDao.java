package Datos;

import Entidad.iUsuario;

public interface iUsuarioDao {

	public iUsuario login(String email, String password);
	public boolean insertar(iUsuario user);
	public boolean modificar(iUsuario user);
	public boolean eliminar(iUsuario user);
	
}
