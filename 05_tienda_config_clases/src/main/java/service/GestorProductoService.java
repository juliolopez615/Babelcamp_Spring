package service;

import java.util.List;

import model.Producto;

public interface GestorProductoService {

	public List<Producto> buscar(String seccion);
	public void alta(Producto producto);
	public void eliminar(String nombre);
	public void modificar(String nombre, double nuevoPrecio);
	public Producto buscarProducto(int idProducto);
}
