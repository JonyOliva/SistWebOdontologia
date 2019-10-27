package Negocio;

import java.util.ArrayList;

import Entidad.Administrador;
import Entidad.Odontologo;
import Entidad.iUsuario;

public interface iUsuarioNegocio {

	public ArrayList<iUsuario> getAll();
	public Administrador getAdm(iUsuario user );
	public Odontologo getOdo(iUsuario user);
	public boolean insertar(Odontologo odontologo);
	public boolean modificar(Odontologo odontologo);
	public boolean eliminar(String idUsuario);
	public iUsuario login(String email, String password);
}
