package Negocio;

import java.util.ArrayList;

import Entidad.Odontologo;

public interface IOdontologoNegocio {
	
	public Odontologo get(int IDPaciente);
	public ArrayList<Odontologo> getAll();
	public boolean insertar(Odontologo paciente);
	public boolean modificar(Odontologo paciente);
	public boolean eliminar(int IDPaciente);
	
}
