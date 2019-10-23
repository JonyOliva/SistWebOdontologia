package Entidad;

import java.util.List;

public interface IGestionable<T> {
	
	public List<T> get(int inicio, int tamPagina, String aBuscar);
	
	public int size(String busqueda);
}
