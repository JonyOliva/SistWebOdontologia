package Entidad;

public class DientePaciente {
	
	private int IDPaciente;
	private int IDDiente;
	private String Parte;
	private int IDEstado;
	private int IDTurno;
		
	public DientePaciente() {
		super();
	}
		
	public DientePaciente(int iDPaciente, int iDDiente, String parte, int iDEstado, int iDTurno) {
		super();
		IDPaciente = iDPaciente;
		IDDiente = iDDiente;
		Parte = parte;
		IDEstado = iDEstado;
		IDTurno = iDTurno;
	}

	public int getIDTurno() {
		return IDTurno;
	}

	public void setIDTurno(int iDTurno) {
		IDTurno = iDTurno;
	}

	public int getIDPaciente() {
		return IDPaciente;
	}
	public void setIDPaciente(int iDPaciente) {
		IDPaciente = iDPaciente;
	}
	public int getIDDiente() {
		return IDDiente;
	}
	public void setIDDiente(int iDDiente) {
		IDDiente = iDDiente;
	}
	public String getParte() {
		return Parte;
	}
	public void setParte(String parte) {
		Parte = parte;
	}
	public int getIDEstado() {
		return IDEstado;
	}
	public void setIDEstado(int iDEstado) {
		IDEstado = iDEstado;
	}
	
}
