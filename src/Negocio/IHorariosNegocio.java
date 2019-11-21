package Negocio;
import java.util.ArrayList;
import java.util.List;

import Entidad.HorarioOdonto;

public interface IHorariosNegocio {

	
public List <HorarioOdonto> VerHorarios (String IDOdontologo);
public List<HorarioOdonto> VerHorarios (String IDOdontologo, String dia);
public boolean insertar(HorarioOdonto horario);
public boolean modificar(HorarioOdonto horario);
public boolean eliminar(int IDHorario);
	
}
