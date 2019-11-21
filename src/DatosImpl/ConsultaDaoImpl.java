package DatosImpl;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Datos.IConsultaDao;
import Entidad.ConsultaData;
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
		List<Consulta> listCons = new ArrayList<Consulta>();
		try {
			cn.Open();
			ResultSet rs = cn.query("SELECT IDTurno_CON, odontologos.nombre AS NombreOdontologo, IDTratamiento_CON, Fecha, AnotacionExtra  FROM consultas " + 
					"INNER JOIN odontologos ON IDOdontologo_CON=IDOdontologo " + 
					"INNER JOIN turnos ON IDTurno_CON=IDTurno WHERE IDPaciente_CON ="+idPaciente);
			while(rs.next()) {
				Consulta Con = new Consulta();
				Con.setIDTurno(rs.getInt("IDTurno_CON"));
				Con.setNombreOdontologo(rs.getString("NombreOdontologo"));
				Con.setIdTratamiento(rs.getString("IDTratamiento_CON"));
				Con.setFecha(rs.getObject("Fecha", LocalDateTime.class));
				Con.setAnotacion(rs.getString("AnotacionExtra"));
				listCons.add(Con);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		
		return listCons;
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
	public boolean insertar(ConsultaData consulta) {
		try {
			cn.Open();
			String query = "INSERT INTO consultas(IDTurno_CON, IDOdontologo_CON, IDTratamiento_CON, IDPaciente_CON, AnotacionExtra) ";
			String data = "SELECT "+consulta.getIDTurno()+", '"+consulta.getIDOdontologo()+"', '"+consulta.getIDTratamiento()
			+"',"+consulta.getIDPaciente()+", "+ "'"+consulta.getAnotacion()+"'";
			boolean res = cn.execute(query+data);
			cn.close();
			return res;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			cn.close();
		}
		return false;
	}

}
