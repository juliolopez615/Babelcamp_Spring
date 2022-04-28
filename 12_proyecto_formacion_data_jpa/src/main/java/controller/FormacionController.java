package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Alumno;
import model.Curso;
import service.FormacionService;


@CrossOrigin("*")
@Controller
public class FormacionController {
	@Autowired
	FormacionService service;
	
	@PostMapping(value="Validar")
	public String validar(@RequestParam("usuario") String usuario, @RequestParam("password") String password) {
		Alumno alumno = service.validar(usuario, password);
		if(alumno != null) {
			return "menu";
		}
		else {
			return "login";
		}
	}
	
	@GetMapping(value="BuscadorCursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso>buscarCursos() {
		return service.cursos();	
	}
	
	@GetMapping(value="BuscadorAlumnos", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Alumno>buscarAlumno() {
		return service.alumnos();	
	}
	
	@GetMapping(value="AlumnosCurso", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Alumno>alumnosCurso(@RequestParam("curso") String curso) {
		return service.alumnosCurso(curso);
	}
	
	@GetMapping(value="CursosAlumno", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso>cursosAlumno(@RequestParam("alumno") String alumno) {
		return service.cursosAlumno(alumno);
	}
}
