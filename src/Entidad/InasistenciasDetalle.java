package Entidad;

public class InasistenciasDetalle {

	Paciente pac;
	Turno turno;
	Odontologo odon;
	public InasistenciasDetalle(Paciente pac, Turno turno, Odontologo odon) {
		super();
		this.pac = pac;
		this.turno = turno;
		this.odon = odon;
	}
	public Paciente getPac() {
		return pac;
	}
	public void setPac(Paciente pac) {
		this.pac = pac;
	}
	public Turno getTurno() {
		return turno;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	public Odontologo getOdon() {
		return odon;
	}
	public void setOdon(Odontologo odon) {
		this.odon = odon;
	}
	
	
}
