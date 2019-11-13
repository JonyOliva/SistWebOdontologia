package Entidad;

import java.time.LocalDateTime;

public class Turno {
	
	private final int IDTurno;
	private int IDPaciente;
	private String IDOdontologo;
	private LocalDateTime Fecha;
	private String estado;
		
	public Turno(int iDTurno, int iDPaciente, String iDOdontologo, LocalDateTime fecha, String estado) {
		super();
		IDTurno = iDTurno;
		IDPaciente = iDPaciente;
		IDOdontologo = iDOdontologo;
		Fecha = fecha;
		this.estado = estado;
	}
	
	public Turno(int idTurno) {
		IDTurno = idTurno;
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
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public int getIDTurno() {
		return IDTurno;
	}
	
}
