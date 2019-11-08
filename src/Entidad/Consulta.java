package Entidad;

import java.time.LocalDateTime;
import java.util.List;

public class Consulta {
	
	int IDTurno;
	String nombreOdontologo;
	String idTratamiento;
	LocalDateTime fecha;
	String anotacion;
	List<String> piezasArregladas;
	
	public Consulta() {
		super();
	}
	
	public int getIDTurno() {
		return IDTurno;
	}
	public void setIDTurno(int iDTurno) {
		IDTurno = iDTurno;
	}
	public String getNombreOdontologo() {
		return nombreOdontologo;
	}
	public void setNombreOdontologo(String nombreOdontologo) {
		this.nombreOdontologo = nombreOdontologo;
	}
	public String getIdTratamiento() {
		return idTratamiento;
	}
	public void setIdTratamiento(String idTratamiento) {
		this.idTratamiento = idTratamiento;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public String getAnotacion() {
		return anotacion;
	}
	public void setAnotacion(String anotacion) {
		this.anotacion = anotacion;
	}
	public List<String> getPiezasArregladas() {
		return piezasArregladas;
	}
	public void setPiezasArregladas(List<String> piezasArregladas) {
		this.piezasArregladas = piezasArregladas;
	}
	
}
