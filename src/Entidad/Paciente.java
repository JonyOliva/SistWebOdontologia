package Entidad;

import java.time.LocalDate;

public class Paciente {
	
	private final int IDPaciente;
	private String nombre;
	private String apellido;
	private String dni;
	private String telefono;
	private String domicilio;
	private String localidad;
	private LocalDate FechaNacimiento;
	private String InfoExtra;
	private boolean activo;

	public Paciente(int iDPaciente, String nombre, String apellido, String dni, String telefono, String domicilio, String localidad,
			LocalDate fechaNacimiento, String infoExtra, boolean activo) {
		super();
		IDPaciente = iDPaciente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.localidad = localidad;
		FechaNacimiento = fechaNacimiento;
		InfoExtra = infoExtra;
		this.activo = activo;
	}
		
	public Paciente(int iDPaciente) {
		IDPaciente = iDPaciente;
	}

	public int getIDPaciente() {
		return IDPaciente;
	}

	public String getNombre() {
		return nombre;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public LocalDate getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}

	public String getInfoExtra() {
		return InfoExtra;
	}

	public void setInfoExtra(String infoExtra) {
		InfoExtra = infoExtra;
	}

	public int isActivo() {
		return activo ? 1 : 0;
	}

	public boolean hayExtra() {
		if(InfoExtra != null) {
			return !InfoExtra.isEmpty();
		}else {
			return false;
		}
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
}
