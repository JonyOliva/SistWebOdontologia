package Datos;

import java.util.List;

import Entidad.Odontologo;

public interface IOdontologoDao {
	public Odontologo get(String IDPaciente);
	public List<Odontologo> getAll();
	public boolean insertar(Odontologo paciente);
	public boolean modificar(Odontologo paciente);
	public boolean eliminar(String IDPaciente);
}
