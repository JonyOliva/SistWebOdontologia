package Entidad;

import java.util.List;

public class Paginador<T> {

	private List<T> list;
	private int paginaActual;
	private int cantPaginas;
	private int tamPaginas;
	private int cantRegistros;
	
	public Paginador(List<T> list, int tamPaginas) {
		super();
		this.list = list;
		paginaActual = 1;
		this.tamPaginas = tamPaginas;
		cantPaginas = Math.round(list.size() / tamPaginas);
		cantRegistros = list.size();
	}

	public boolean pagina(int pag) {
		if(pag > 0 && pag <= cantPaginas) {
			paginaActual = pag;
			return true;
		}else {
			return false;
		}
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
	
	public int size() {
		return cantRegistros;
	}
	
	public List<T> getPaginaActual(){
		if(cantRegistros > 0)
			return list.subList((paginaActual * tamPaginas)-tamPaginas, paginaActual * tamPaginas);
		else
			return null;
	}
}
