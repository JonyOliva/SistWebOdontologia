package Negocio;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import Entidad.Administrador;
import Entidad.Odontologo;
import Entidad.iUsuario;

public interface iUsuarioNegocio {

	public ArrayList<iUsuario> getAll();
	public Administrador getAdm(iUsuario user );
	public Odontologo getOdo(iUsuario user);
	public String getPass(String mail, String dni);
	public boolean insertar(iUsuario odontologo);
	public boolean modificar(iUsuario odontologo);
	public boolean eliminar(String idUsuario);
	public iUsuario login(String email, String password);
	public String getNextID(boolean tipoUsuario);
}
