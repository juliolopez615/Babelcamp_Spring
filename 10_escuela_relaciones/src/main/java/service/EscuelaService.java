package service;

import java.util.List;

import model.Alumno;
import model.Curso;

public interface EscuelaService {
	List<Alumno> alumnosCurso(String curso);
	List<Alumno> alumnosCursoDuracion(int duracion);
	Curso cursoMatriculadoAlumno(String dni);
	List<Curso> alumnosSenior(int edad);
	double edadMediaCurso(String nombreCurso);
	double precioCurso(String email);
}
