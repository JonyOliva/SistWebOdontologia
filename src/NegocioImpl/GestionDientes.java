package NegocioImpl;

import java.util.ArrayList;

import Datos.IDientePacienteDao;
import DatosImpl.DientePacienteDaoImpl;
import Entidad.Diente;
import Entidad.DientePaciente;
import Negocio.IDientePacienteNegocio;

public class GestionDientes implements IDientePacienteNegocio{

	IDientePacienteDao dpd;
	
	public GestionDientes() {
		super();
		this.dpd = new DientePacienteDaoImpl();
	}

	@Override
	public boolean insertar(DientePaciente dienteP) {
		return dpd.insertar(dienteP);
	}

	@Override
	public ArrayList<Diente> getOdontograma(int idPaciente) {
		return (ArrayList<Diente>) dpd.getOdontograma(idPaciente);
	}

}
