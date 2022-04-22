package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Pagina;
import service.BuscadorService;

@Controller
public class BuscadorController {
	
	@Autowired
	BuscadorService buscadorservice;
	@GetMapping(value="Buscador")
	public String buscar(@RequestParam("tematica") String tematica, HttpServletRequest request) {
		List<Pagina>paginas = buscadorservice.buscar(tematica);
		request.setAttribute("paginas", paginas);
		return "listado";
	}
	
	@PostMapping(value="Aniadir")
	public String aniadir(@RequestParam("direccion") String direccion, 
			@RequestParam("tematica") String tematica, 
			@RequestParam("descripcion") String descripcion) {
		
		buscadorservice.aniadir(direccion, tematica, descripcion);
		return "datos";
	}
}
