package Entidad;

import java.time.format.DateTimeFormatter;

public class Inasistencias {

	Paciente pac;
	int inasistencias;
	String estado;
	
	public Inasistencias(Paciente pac, int inasistencias, String estado) {
		super();
		this.pac = pac;
		this.inasistencias = inasistencias;
		this.estado = estado;
	}
	public Paciente getPac() {
		return pac;
	}
	public void setPac(Paciente pac) {
		this.pac = pac;
	}
	public int getInasistencias() {
		return inasistencias;
	}
	public void setInasistencias(int inasistencias) {
		this.inasistencias = inasistencias;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
