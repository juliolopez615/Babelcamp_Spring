package dao;

import java.util.List;

import model.Alumno;

public interface AlumnoDao {
	public Alumno findById(String usuario);
	public Alumno findByUsuarioAndPassword(String usuario, String password);
	public List<Alumno> findByCurso(String nombreCurso);
	public void update(Alumno alumno);
	public List<Alumno> findAll();
}
