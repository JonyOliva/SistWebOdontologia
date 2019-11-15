package Entidad;

public class Inasistencias {

	Paciente pac;
	int inasistencias;
	
	
	public Inasistencias(Paciente pac, int inasistencias) {
		super();
		this.pac = pac;
		this.inasistencias = inasistencias;
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
	
	
}
