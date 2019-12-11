package Entidad;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;



public class HorarioOdonto {
private int IDHorario;
private String IDOdontologo;
private String Dia;
private LocalTime HoraInicio;
private LocalTime HoraFin;
private Boolean activo;

public HorarioOdonto () {}

public HorarioOdonto(int iDHorario) {
	this.IDHorario = iDHorario;
}



public HorarioOdonto(String iDOdontologo, String dia, LocalTime horaInicio, LocalTime horaFin,
		Boolean activo) {
	super();
	this.IDOdontologo = iDOdontologo;
	this.Dia = dia;
	this.HoraInicio = horaInicio;
	this.HoraFin = horaFin;
	this.activo = activo;
	
	
}


public int getIDHorario() {
	return IDHorario;
}



public String getIDOdontologo() {
	return IDOdontologo;
}


public void setIDOdontologo(String iDOdontologo) {
	IDOdontologo = iDOdontologo;
}


public String getDia() {
	return Dia;
}


public void setDia(String dia) {
	Dia = dia;
}


public LocalTime getHoraInicio() {
	return HoraInicio;
}


public void setHoraInicio(LocalTime horaInicio) {
	HoraInicio = horaInicio;
}


public LocalTime getHoraFin() {
	return HoraFin;
}


public void setHoraFin(LocalTime horaFin) {
	HoraFin = horaFin;
}


public Boolean getActivo() {
	return activo;
}


public void setActivo(Boolean activo) {
	this.activo = activo;
}


	
}
