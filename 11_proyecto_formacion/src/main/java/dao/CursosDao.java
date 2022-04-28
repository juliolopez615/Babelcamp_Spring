package dao;

import java.util.List;

import model.Curso;

public interface CursosDao {
	public Curso findById(int IdCurso);
	public List<Curso> findAll();
	public List<Curso> findByAlumno(String usuario);
	
}
