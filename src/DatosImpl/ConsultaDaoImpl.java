package DatosImpl;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Datos.IConsultaDao;
import Entidad.Consulta;
import Entidad.Tratamiento;

public class ConsultaDaoImpl implements IConsultaDao{

	Conexion cn;
	
	public ConsultaDaoImpl() {
		super();
		this.cn = new Conexion();
	}

	@Override
	public List<Consulta> getAll(int idPaciente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tratamiento> getAll() {
		
		List<Tratamiento> listTrats = new ArrayList<Tratamiento>();
		try {
			cn.Open();
			ResultSet rs = cn.query("SELECT * FROM tratamientos");
			while(rs.next()) {
				Tratamiento trat = new Tratamiento(rs.getString("IDTratamiento"));
				trat.setDescripcion(rs.getString("Descripcion"));
				trat.setPrecio(rs.getFloat("Precio"));
				listTrats.add(trat);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		
		return listTrats;
	}

	@Override
	public boolean insertar(Consulta paciente) {
		// TODO Auto-generated method stub
		return false;
	}

}
