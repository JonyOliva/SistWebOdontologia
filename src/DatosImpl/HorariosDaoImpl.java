package DatosImpl;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Datos.IHorariosDao;
import Entidad.HorarioOdonto;
import Entidad.Turno;



public class HorariosDaoImpl implements IHorariosDao {
	Conexion cn;
	
	public HorariosDaoImpl (){
		this.cn = new Conexion();
	}
	
	

	@Override
	public List<HorarioOdonto> VerHorarios(String IDOdontologo) {
		List<HorarioOdonto> lista = new ArrayList<HorarioOdonto>();
		try {
			cn.Open();
			ResultSet rs = cn.query("SELECT * FROM HORARIOS WHERE IDOdontologo_HOR = '"+IDOdontologo+"' order by Dia, HoraInicio;");
			while(rs.next())
			{
				HorarioOdonto horario = new HorarioOdonto(rs.getInt("IDHorario"));
				horario.setDia(rs.getString("Dia"));
				horario.setHoraInicio(rs.getObject("HoraInicio",LocalTime.class));
				horario.setHoraFin(rs.getObject("HoraFin",LocalTime.class));
				horario.setActivo(rs.getBoolean("Activo"));
				
				lista.add(horario);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			cn.close();
		}
		
		return lista;
		
		
		
	}

	@Override
	public boolean insertar(HorarioOdonto horario) {
		
		String query = "INSERT INTO Horarios (IDOdontologo_HOR,Dia,HoraInicio, HoraFin,Activo) select '"+horario.getIDOdontologo()
		+"','"+horario.getDia()+"','"+horario.getHoraInicio().toString()+"','"+horario.getHoraFin().toString()+"',1";
		
		try {
			cn.Open();
			return cn.execute(query);
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modificar(HorarioOdonto horario) {
		String query="UPDATE Horarios SET IDOdontologo_T = '"+horario.getIDOdontologo()+"', "
				+ "Dia = '"+horario.getDia()+"', HoraInicio = '"+horario.getHoraInicio()+"', HoraFin = '"+horario.getHoraFin()+"' "
						+ "WHERE IDHorario = "+horario.getIDHorario();
		try {
			cn.Open();
			return cn.execute(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	@Override
	public boolean eliminar(int IDHorario) {
		String query = "UPDATE Horarios SET Activo = 0 WHERE IDHorario = "+IDHorario;
		try {
			cn.Open();
			return cn.execute(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}



	@Override
	public List<HorarioOdonto> VerHorarios(String IDOdontologo, String dia) {
		List<HorarioOdonto> lista = new ArrayList<HorarioOdonto>();
		try {
			cn.Open();
			ResultSet rs = cn.query("SELECT * FROM HORARIOS WHERE IDOdontologo_HOR = '"+IDOdontologo+"' AND Dia = '"+dia+"'" );
			while(rs.next())
			{
				HorarioOdonto horario = new HorarioOdonto(rs.getInt("IDHorario"));
				horario.setDia(rs.getString("Dia"));
				horario.setHoraInicio(rs.getObject("HoraInicio",LocalTime.class));
				horario.setHoraFin(rs.getObject("HoraFin",LocalTime.class));
				horario.setActivo(rs.getBoolean("Activo"));
				
				lista.add(horario);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			cn.close();
		}
		
		return lista;
	}
}
