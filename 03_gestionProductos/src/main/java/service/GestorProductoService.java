package service;

import java.util.List;

import model.Producto;

public interface GestorProductoService {

	public List<Producto> buscar(String nombre);
	public void alta(String nombre, String seccion, double precio, int stock);
	public void eliminar(String nombre);
	public void modificar(String nombre, double nuevoPrecio);	
}
