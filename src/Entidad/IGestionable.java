package Entidad;

import java.util.List;

public interface IGestionable<T> {
	
	public List<T> get(int inicio, int tamPagina, String aBuscar);
	public List<T> get(int inicio, int tamPagina, String aBuscar,String desde,String hasta,int d);
	public int size(String busqueda,String desde,String hasta,int d);
	public int size(String busqueda);
}
