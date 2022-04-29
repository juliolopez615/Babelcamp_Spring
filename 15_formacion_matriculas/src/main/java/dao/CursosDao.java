package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Curso;

public interface CursosDao extends JpaRepository<Curso, Integer>{
	@Query("select c from Curso c join c.matriculas m where m.alumno.usuario=?1")
	public List<Curso> findByAlumno(String usuario);
	
	@Query("select c from Curso c where c not in (select c from Curso c join c.matriculas m where m.alumno.usuario=?1)")
	List<Curso>findAlumnoNoMatriculado(String usuario);
	
	@Query("select c from Curso c where c.nombre=?1")
	List<Curso>findByNombre(String nombreCurso);
}
