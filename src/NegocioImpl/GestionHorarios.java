package NegocioImpl;

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
	
	public GestionHorarios (){
		this.hordao = new HorariosDaoImpl();
	}
	
	@Override
	public ArrayList<HorarioOdonto> VerHorarios(String IDOdontologo) {
		
		return (ArrayList<HorarioOdonto>)hordao.VerHorarios(IDOdontologo);
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


	
}
