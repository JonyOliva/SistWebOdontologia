package DatosImpl;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Datos.IDientePacienteDao;
import Entidad.Diente;
import Entidad.DientePaciente;

public class DientePacienteDaoImpl implements IDientePacienteDao{

	Conexion cn;
	
	public DientePacienteDaoImpl() {
		this.cn = new Conexion();
	}

	@Override
	public boolean insertar(DientePaciente dPaciente) {
		try {
			cn.Open();
			String query = "INSERT INTO dientes_x_paciente(IDPaciente_DxP, IDDiente_DxP, Parte, IDEstado_DxP, IDTurno_DxP) ";
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
	public List<Diente> getOdontograma(int idPaciente) {
		List<Diente> listDientes = new ArrayList<Diente>();
		try {
			cn.Open();
			String query = "SELECT IDDiente, Parte, IDEstado_DxP FROM dientes_x_paciente INNER JOIN dientes"
					+ " ON IDDiente_DxP=IDDiente WHERE IDPaciente_DxP="+idPaciente+" ORDER BY IDTurno_DxP DESC";
			ResultSet dres = cn.query(query);
			while(dres.next()){
				Diente d = new Diente();
				d.id = dres.getInt("IDDiente");
				int index = listDientes.indexOf(d);
				if(index == -1) {
					listDientes.add(d);
					index = listDientes.size() - 1;
				}
				
				Diente actual = listDientes.get(index);
				switch(dres.getString("Parte")) {
					case "L":
						if(actual.left.isEmpty()) 
							actual.left = dres.getString("IDEstado_DxP");
						break;
					case "U":
						if(actual.up.isEmpty()) 
							actual.up = dres.getString("IDEstado_DxP");
						break;
					case "R":
						if(actual.right.isEmpty()) 
							actual.right = dres.getString("IDEstado_DxP");
						break;
					case "B":
						if(actual.bottom.isEmpty()) 
							actual.bottom = dres.getString("IDEstado_DxP");
						break;
					case "C":
						if(actual.center.isEmpty()) 
							actual.center = dres.getString("IDEstado_DxP");
						break;
				}
			}
			cn.close();
			return listDientes;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return null;
	}

	@Override
	public List<String> getAll(int idPaciente, int idTurno) {
		List<String> listDientes = new ArrayList<String>();
		try {
			cn.Open();
			String query = "SELECT IDDiente_DxP, Parte, IDEstado_DxP, Descripcion FROM dientes_x_paciente INNER JOIN estadosdientes " + 
					"ON IDEstado_DxP=IDEstado WHERE IDPaciente_DxP="+idPaciente+" AND IDTurno_DxP="+idTurno;
			ResultSet ds = cn.query(query);
			while(ds.next()){
				String registro = "Diente: " + ds.getInt("IDDiente_DxP") + ", arreglo: " + ds.getString("Descripcion");
				if(ds.getInt("IDEstado_DxP") < 3) {
					registro += ", parte ";
					switch(ds.getString("Parte")) {
						case "L":
							registro += "izquierda";
							break;
						case "U":
							registro += "superior";
							break;
						case "R":
							registro += "derecha";
							break;
						case "B":
							registro += "inferior";
							break;
						case "C":
							registro += "central";
							break;
					}
				}
				if(!listDientes.contains(registro))
					listDientes.add(registro);
			}
			cn.close();
			return listDientes;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return null;
	}

}
