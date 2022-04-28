package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import model.Alumno;
import model.Curso;

@Service
public class EscuelaServiceImpl implements EscuelaService {
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	@Override
	public List<Alumno> alumnosCurso(String curso) {
		String jpql = "select a from Alumno a where a.curso.denominacion=:curso";
		TypedQuery<Alumno> query = entityManager.createQuery(jpql, Alumno.class);
		query.setParameter("curso", curso);
		List<Alumno> alumnos = query.getResultList();
		return alumnos.size()>0?alumnos:null;
	}

	@Override
	public List<Alumno> alumnosCursoDuracion(int duracion) {
		String jpql = "select a from Alumno a where a.curso.duracion<=:duracion";
		TypedQuery<Alumno> query = entityManager.createQuery(jpql, Alumno.class);
		query.setParameter("duracion", duracion);
		List<Alumno> alumnos = query.getResultList();
		return alumnos.size()>0?alumnos:null;
	}

	@Override
	public Curso cursoMatriculadoAlumno(String dni) {
		String jpql = "select c from Curso c join c.alumnos a where a.dni=:dni";
		TypedQuery<Curso> query = entityManager.createQuery(jpql, Curso.class);
		query.setParameter("dni", dni);
		List<Curso> cursos = query.getResultList();
		return cursos.size()>0?cursos.get(0):null;
	}

	@Override
	public List<Curso> alumnosSenior(int edad) {
		String jpql = "select distinct (c) from Curso c join c.alumnos a where a.edad >=:edad";
		TypedQuery<Curso> query = entityManager.createQuery(jpql, Curso.class);
		query.setParameter("edad", edad);
		List<Curso> cursos = query.getResultList();
		return cursos.size()>0?cursos:null;
	}

	@Override
	public double edadMediaCurso(String nombreCurso) {
		String jpql = "select avg(a.edad) from Alumno a where a.curso.denominacion=:curso";
		TypedQuery<Double> query=entityManager.createQuery(jpql, Double.class);
		query.setParameter("curso", nombreCurso);
		return query.getSingleResult();
	}

	@Override
	public double precioCurso(String email) {
		String jpql = "select c.precio from Curso c join c.alumnos a where a.email =:email";
		TypedQuery<Double> query=entityManager.createQuery(jpql, Double.class);
		query.setParameter("email", email);
		return query.getSingleResult();
	}

}
