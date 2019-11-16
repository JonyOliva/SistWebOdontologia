package Entidad;

import java.time.LocalDateTime;

public class InasistenciasDetalle {

	Paciente pac;
	String odontologo;
	LocalDateTime fecha;
	String estado;
	int idTurno;
	
	public InasistenciasDetalle(Paciente pac) {
		super();
		this.pac = pac;
	}

	public Paciente getPac() {
		return pac;
	}

	public void setPac(Paciente pac) {
		this.pac = pac;
	}

	public String getOdontologo() {
		return odontologo;
	}

	public void setOdontologo(String odontologo) {
		this.odontologo = odontologo;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public int getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(int idTurno) {
		this.idTurno = idTurno;
	}
	
	
	
}
