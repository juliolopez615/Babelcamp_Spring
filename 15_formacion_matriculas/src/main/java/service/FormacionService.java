package service;


import java.util.Date;
import java.util.List;

import dto.AlumnoDto;
import dto.CursoDto;
import dto.MatriculaDto;

public interface FormacionService {
	
	public AlumnoDto validar(String usuario, String password);
	public List<CursoDto> cursosAlumno(String usuario);
	public List<CursoDto> cursos();
	public List<AlumnoDto> alumnos();
	public List<AlumnoDto> alumnosCurso(String curso);
	public boolean matricular(String usuario, int idCurso);
	public boolean altaAlumno(AlumnoDto alumno);
	public boolean altaCurso(CursoDto curso);
	List<MatriculaDto> matriculasConsulta(Date fecha1, Date fecha2);
	List<CursoDto> cursosPuedeMatricular(String usuario);
	
	
}
