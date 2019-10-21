package Negocio;

import java.util.ArrayList;

import Entidad.Paciente;

public interface IPacienteNegocio {
	
	public ArrayList<Paciente> getAll();
	public Paciente get(int id);
	public ArrayList<Paciente> buscar(String strBusqueda);
	public boolean insertar(Paciente articulo);
	public boolean modificar(Paciente articulo);
	public boolean eliminar(int id);
	
}
