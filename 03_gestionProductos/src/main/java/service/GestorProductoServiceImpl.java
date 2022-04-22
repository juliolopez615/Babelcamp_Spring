package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import model.Producto;

@Service
public class GestorProductoServiceImpl implements GestorProductoService{
	static ArrayList<Producto> productos=new ArrayList<>(List.of(new Producto("vino","alimentación",8.4,25),
			new Producto("leche","alimentación",1.2,70),
			new Producto("cable usb","informática",5.6,30),
			new Producto("arroz","alimentación",3.1,16),
			new Producto("silla","hogar",30.6,10),
			new Producto("monitor","informática",125.0,5),
			new Producto("escritorio","hogar",230,4)
			));
	
	@Override
	public List<Producto> buscar(String seccion) {
		return productos
				.stream()
				.filter(p->p.getSeccion().equals(seccion))
				.collect(Collectors.toList());
	}

	@Override
	public void alta(String nombre, String seccion, double precio, int stock) {
		productos.add(new Producto(nombre, seccion, precio, stock));
	}

	@Override
	public void eliminar(String nombre) {
		for(int i=0; i<productos.size();i++) {
			if(productos.get(i).getNombre().equals(nombre)) productos.remove(i);
		}
	}

	@Override
	public void modificar(String nombre, double nuevoPrecio) {
		productos.forEach(p->{
			if(p.getNombre().equals(nombre)) p.setPrecio(nuevoPrecio);
		});
	}
}
