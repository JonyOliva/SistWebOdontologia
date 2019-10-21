package Entidad;

import java.util.List;

public class Paginador<T> {

	private List<T> list;
	private int paginaActual;
	private int cantPaginas;
	private int tamPaginas;
	
	public Paginador(List<T> list, int tamPaginas) {
		super();
		this.list = list;
		paginaActual = 1;
		this.tamPaginas = tamPaginas;
		cantPaginas = Math.round(list.size() / tamPaginas);
	}
	
	public boolean haySiguiente() {
		return (paginaActual < cantPaginas);
	}
		
	public boolean hayAnterior() {
		return (paginaActual > 1);
	}
	
	public int paginaSiguiente() {
		if(paginaActual < cantPaginas) {
			paginaActual++;
			return paginaActual;
		}else {
			return -1;
		}
		
	}
			
	public int paginaAnterior() {
		if(paginaActual > 1) {
			paginaActual--;
			return paginaActual;
		}else {
			return -1;
		}
	}
	
	List<T> getPaginaActual(){
		return list.subList((paginaActual * tamPaginas)-tamPaginas, (paginaActual * tamPaginas)-1);
	}
}
