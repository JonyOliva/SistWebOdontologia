package Entidad;

public class ConsultaData {

	private final int IDConsulta;
	private int IDTurno;
	private String IDOdontologo;
	private String IDTratamiento;
	private int IDPaciente;
	private String Anotacion;
		
	public ConsultaData(int iDConsulta, int iDTurno, String iDOdontologo, String iDTratamiento, int iDPaciente,
			String anotacion) {
		super();
		IDConsulta = iDConsulta;
		IDTurno = iDTurno;
		IDOdontologo = iDOdontologo;
		IDTratamiento = iDTratamiento;
		IDPaciente = iDPaciente;
		Anotacion = anotacion;
	}
	
	public ConsultaData(int iDConsulta) {
		super();
		IDConsulta = iDConsulta;
	}

	public int getIDTurno() {
		return IDTurno;
	}
	public void setIDTurno(int iDTurno) {
		IDTurno = iDTurno;
	}
	public String getIDOdontologo() {
		return IDOdontologo;
	}
	public void setIDOdontologo(String iDOdontologo) {
		IDOdontologo = iDOdontologo;
	}
	public String getIDTratamiento() {
		return IDTratamiento;
	}
	public void setIDTratamiento(String iDTratamiento) {
		IDTratamiento = iDTratamiento;
	}
	public int getIDPaciente() {
		return IDPaciente;
	}
	public void setIDPaciente(int iDPaciente) {
		IDPaciente = iDPaciente;
	}
	public String getAnotacion() {
		return Anotacion;
	}
	public void setAnotacion(String anotacion) {
		Anotacion = anotacion;
	}
	public int getIDConsulta() {
		return IDConsulta;
	}
	
}
