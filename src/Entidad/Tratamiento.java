package Entidad;

public class Tratamiento {

	final String nombreID; //ID
	String descripcion;
	float precio;
	
	public Tratamiento(String nombreID, String descripcion, float precio) {
		super();
		this.nombreID = nombreID;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	public Tratamiento(String nombreID) {
		this.nombreID = nombreID;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getNombreID() {
		return nombreID;
	}
	
}
