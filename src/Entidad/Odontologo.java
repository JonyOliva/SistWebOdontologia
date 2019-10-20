package Entidad;

public class Odontologo extends iUsuario{

	private String Nombre;
	private String Apellido;
	private String Matricula;
	private String DNI;
	
	public Odontologo(iUsuario user, String _nombre, String _apellido, String _matricula, String _dni) {
		super(user);
		Nombre = _nombre;
		Apellido = _apellido;
		Matricula = _matricula;
		DNI = _dni;
	}

	@Override
	public String toString() {
		return "Odontologo []";
	}

	
}
