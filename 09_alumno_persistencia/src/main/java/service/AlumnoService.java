package service;

import java.util.List;

import model.Alumno;

public interface AlumnoService {
	public List<Alumno> buscar(String seccion);
	public void alta(Alumno producto);
	public List<String> buscarCursos();
	public boolean existeAlumno(String nombre);
}
