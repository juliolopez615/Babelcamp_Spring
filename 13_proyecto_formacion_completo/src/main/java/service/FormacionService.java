package service;


import java.util.Date;
import java.util.List;

import model.Alumno;
import model.Curso;

public interface FormacionService {
	
	public Alumno validar(String usuario, String password);
	public List<Curso> cursosAlumno(String usuario);
	public List<Curso> cursos();
	public List<Alumno> alumnos();
	public List<Alumno> alumnosCurso(String curso);
	public boolean matricular(String usuario, int idCurso);
	public boolean altaAlumno(Alumno alumno);
	public boolean altaCurso(Curso curso);
	List<Curso> matriculasConsulta(Date fecha1, Date fecha2);
	List<Curso> cursosPuedeMatricular(String usuario);
	
	
}
