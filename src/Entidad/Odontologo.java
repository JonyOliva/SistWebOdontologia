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

	
	public Odontologo(String iDUsuario) {
		super(iDUsuario);
	}


	public Odontologo(iUsuario user) {
		super(user);
	}


	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getMatricula() {
		return Matricula;
	}

	public void setMatricula(String matricula) {
		Matricula = matricula;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	@Override
	public String toString() {
		return "Odontologo []";
	}

	
}
