package Entidad;

public class Diente {
	public int id;
	
	public String left = "";
	public String up = "";
	public String right = "";
	public String bottom = "";
	public String center = "";
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null) {
			Diente reg = (Diente)obj;
			return reg.id == this.id;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "ID: "+id+"; "+left+", "+up+", "+right+", "+bottom+", "+center;
	}
}
