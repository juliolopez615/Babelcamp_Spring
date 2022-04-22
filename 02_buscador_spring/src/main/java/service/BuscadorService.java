package service;

import java.util.List;

import model.Pagina;

public interface BuscadorService {
	List<Pagina> buscar(String tematica);
	public void aniadir(String direccion, String tematica, String descripcion);
}
