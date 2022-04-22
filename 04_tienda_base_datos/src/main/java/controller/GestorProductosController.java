package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Producto;
import service.GestorProductoService;

@Controller
public class GestorProductosController {

	@Autowired
	GestorProductoService gestor;
	
	@GetMapping(value="Buscador")
	public String buscar(@RequestParam("seccion") String seccion, HttpServletRequest request) {
		List<Producto>productos = gestor.buscar(seccion);
		request.setAttribute("productos", productos);
		return "listado";
	}
	
	@PostMapping(value="Alta")
	public String aniadir(@ModelAttribute Producto producto) {
		gestor.alta(producto);
		return "alta";
	}
	
	@GetMapping(value="Eliminar")
	public String eliminar(@RequestParam("nombre") String nombre) {
		gestor.eliminar(nombre);
		return "eliminar";
	}
	
	@GetMapping(value="Modificar")
	public String modificar(@RequestParam("nombre") String nombre, @RequestParam("precio") double precio) {
		gestor.modificar(nombre, precio);
		return "modificar";
	}
	
	
}
