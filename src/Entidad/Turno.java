package Entidad;

import java.time.LocalDateTime;

public class Turno {
	
	private final int IDTurno;
	private int IDPaciente;
	private String IDOdontologo;
	private LocalDateTime Fecha;
	private boolean activo;
		
	public Turno(int iDTurno, int iDPaciente, String iDOdontologo, LocalDateTime fecha, boolean activo) {
		super();
		IDTurno = iDTurno;
		IDPaciente = iDPaciente;
		IDOdontologo = iDOdontologo;
		Fecha = fecha;
		this.activo = activo;
	}
	
	public int getIDPaciente() {
		return IDPaciente;
	}
	public void setIDPaciente(int iDPaciente) {
		IDPaciente = iDPaciente;
	}
	public String getIDOdontologo() {
		return IDOdontologo;
	}
	public void setIDOdontologo(String iDOdontologo) {
		IDOdontologo = iDOdontologo;
	}
	public LocalDateTime getFecha() {
		return Fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		Fecha = fecha;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public int getIDTurno() {
		return IDTurno;
	}
	
}
