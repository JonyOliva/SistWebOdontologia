package DatosImpl;
import Datos.IDientePacienteDao;
import Entidad.DientePaciente;
import Entidad.Paciente;

public class DientePacienteDaoImpl implements IDientePacienteDao{

	Conexion cn;
	
	public DientePacienteDaoImpl() {
		this.cn = new Conexion();
	}

	@Override
	public boolean insertar(DientePaciente dPaciente) {
		try {
			cn.Open();
			String query = "INSERT INTO dientes_x_paciente(IDPaciente_DxP, IDDiente, Parte, IDEstado_DxP, IDTurno_DxP) ";
			String data = "SELECT "+dPaciente.getIDPaciente()+", "+dPaciente.getIDDiente()+", '"+dPaciente.getParte()+"',"
							+dPaciente.getIDEstado()+", "+dPaciente.getIDTurno();
			boolean r = cn.execute(query+data);

			cn.close();
			return r;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return false;
	}

	@Override
	public boolean getAll(Paciente paciente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DientePaciente get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
