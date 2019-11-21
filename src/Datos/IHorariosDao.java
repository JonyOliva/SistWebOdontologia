package Datos;
import Entidad.HorarioOdonto;


import java.util.List;

public interface IHorariosDao {
	
public List <HorarioOdonto> VerHorarios (String IDOdontologo);
public List<HorarioOdonto> VerHorarios (String IDOdontologo, String dia);
public boolean insertar(HorarioOdonto horario);
public boolean modificar(HorarioOdonto horario);
public boolean eliminar(int IDHorario);


}
