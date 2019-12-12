package Entidad;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;



public class HorarioOdonto {
@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Dia == null) ? 0 : Dia.hashCode());
		result = prime * result + ((HoraFin == null) ? 0 : HoraFin.hashCode());
		result = prime * result + ((HoraInicio == null) ? 0 : HoraInicio.hashCode());
		result = prime * result + IDHorario;
		result = prime * result + ((IDOdontologo == null) ? 0 : IDOdontologo.hashCode());
		result = prime * result + ((activo == null) ? 0 : activo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
	
		HorarioOdonto other = (HorarioOdonto) obj;
		if (Dia == null) {
			if (other.Dia != null)
				return false;
		} else if (!Dia.equals(other.Dia))
			return false;
		if (HoraFin == null) {
			if (other.HoraFin != null)
				return false;
		} else if (!HoraFin.equals(other.HoraFin))
			return false;
		if (HoraInicio == null) {
			if (other.HoraInicio != null)
				return false;
		} else if (!HoraInicio.equals(other.HoraInicio))
			return false;
		if (activo == null) {
			if (other.activo != null)
				return false;
		} else if (!activo.equals(other.activo))
			return false;
		return true;
	}


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
