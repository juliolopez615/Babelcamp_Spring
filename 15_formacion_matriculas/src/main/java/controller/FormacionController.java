package controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.AlumnoDto;
import dto.CursoDto;
import dto.MatriculaDto;
import service.FormacionService;


@CrossOrigin("*")
@Controller
public class FormacionController {
	@Autowired
	FormacionService service;
	
	@PostMapping(value="Validar")
	public String validar(@RequestParam("usuario") String usuario, @RequestParam("password") String password) {
		AlumnoDto alumno = service.validar(usuario, password);
		if(alumno != null) {
			return "menu";
		}
		else {
			return "login";
		}
	}
	
	@GetMapping(value="BuscadorCursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CursoDto>buscarCursos() {
		return service.cursos();	
	}
	
	@GetMapping(value="BuscadorAlumnos", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<AlumnoDto>buscarAlumno() {
		return service.alumnos();	
	}
	
	@GetMapping(value="AlumnosCurso", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<AlumnoDto>alumnosCurso(@RequestParam("curso") String curso) {
		return service.alumnosCurso(curso);
	}
	
	@GetMapping(value="CursosAlumno", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CursoDto>cursosAlumno(@RequestParam("alumno") String alumno) {
		return service.cursosAlumno(alumno);
	}
	
	@GetMapping(value="CursosPuedeMatricular", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CursoDto>cursosPuedeMatricular(@RequestParam("usuario") String usuario) {
		return service.cursosPuedeMatricular(usuario);
	}
	
	@PostMapping(value="AltaAlumno")
	public String altaAlumno(@ModelAttribute AlumnoDto alumno) {
		if(service.altaAlumno(alumno)) {
			return "menu";
		}else {
			return "error";
		}
	}
	
	@PostMapping(value="AltaCurso")
	public String altaCurso(@ModelAttribute CursoDto curso) {
		if(service.altaCurso(curso)) {
			return "menu";
		}else {
			return "error";
		}
	}
	
	@GetMapping(value="Matriculas",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<MatriculaDto> matriculas(@RequestParam("fechaIni") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaIni, 
												@RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin){
		
			return service.matriculasConsulta(fechaIni, fechaFin);
		
	}
	
	@PostMapping(value="Matricular")
	public String matricular(@RequestParam("usuario") String usuario, @RequestParam("curso") int idCurso) {
		service.matricular(usuario, idCurso);
		return "";
	}

}
