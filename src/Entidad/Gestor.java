package Entidad;

import java.util.List;

public class Gestor<T> {

	private IGestionable<T> paginable;
	private int paginaActual;
	private int cantPaginas;
	private int tamPaginas;
	
	public Gestor(IGestionable<T> paginable, int tamPaginas) {
		super();
		this.paginable = paginable;
		paginaActual = 1;
		this.tamPaginas = tamPaginas;	
	}
	
	public int haySiguiente(){
		if(paginaActual < cantPaginas) {
			return paginaActual+1;
		}else {
			return -1;
		}
	}
	
	public int hayAnterior(){
		if(paginaActual > 1) {
			return paginaActual-1;
		}else {
			return -1;
		}
	}
	
	public int size(String busqueda) {
		return paginable.size(busqueda);
	}
	
	public List<T> get(String aBuscar, int nroPagina){
		cantPaginas = Math.round(size(aBuscar) / tamPaginas);
		if(nroPagina > 0 && nroPagina <= cantPaginas) {
			paginaActual = nroPagina;
		}else {
			paginaActual = 1;
		}
		return paginable.get((paginaActual-1)*tamPaginas, tamPaginas, aBuscar);
	}
}
