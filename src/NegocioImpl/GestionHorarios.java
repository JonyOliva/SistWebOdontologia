package NegocioImpl;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import Datos.IHorariosDao;
import Datos.IOdontologoDao;
import DatosImpl.HorariosDaoImpl;
import Entidad.HorarioOdonto;
import Entidad.Odontologo;
import Negocio.IHorariosNegocio;

public class GestionHorarios implements IHorariosNegocio {

	IHorariosDao hordao;

	public GestionHorarios() {
		this.hordao = new HorariosDaoImpl();
	}

	@Override
	public ArrayList<HorarioOdonto> VerHorarios(String IDOdontologo) {

		return (ArrayList<HorarioOdonto>) hordao.VerHorarios(IDOdontologo);
	}

	@Override
	public boolean insertar(HorarioOdonto horario) {
		return hordao.insertar(horario);
	}

	@Override
	public boolean modificar(HorarioOdonto horario) {

		return hordao.modificar(horario);
	}

	@Override
	public boolean eliminar(int IDHorario) {
		return hordao.eliminar(IDHorario);
	}

	@Override
    public List<HorarioOdonto> VerHorarios(String IDOdontologo, String dia) {
        HorariosDaoImpl hdao = new HorariosDaoImpl();
        List<HorarioOdonto> Horarios =hdao.VerHorarios(IDOdontologo, dia);
        List<HorarioOdonto> listaDigerida = new ArrayList<HorarioOdonto>();
        int tope;
        for(HorarioOdonto h : Horarios)
        {
            tope = (h.getHoraFin().getHour()-h.getHoraInicio().getHour())*2;
            if(h.getHoraInicio().getMinute()==30 && h.getHoraFin().getMinute()==0)
                tope-=1;
            for(int i = 0; i < tope ;i ++)
            {
                HorarioOdonto ho= new HorarioOdonto(-1);
                ho.setHoraInicio(h.getHoraInicio());
                h.setHoraInicio(h.getHoraInicio().plusMinutes(30));
                listaDigerida.add(ho);
            }
        }
        return listaDigerida;
    }

	
}
