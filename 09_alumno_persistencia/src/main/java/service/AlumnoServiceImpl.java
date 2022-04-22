package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;



@Service
public class AlumnoServiceImpl implements AlumnoService {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public List<Alumno> buscar(String curso) {
		String jpql="select a from Alumno a where a.curso=:curso";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("curso", curso);
		return (List<Alumno>)query.getResultList();
	}

	@Transactional
	@Override
	public void alta(Alumno alumno) {
		if(!existeAlumno(alumno.getNombre())) {
			entityManager.persist(alumno);		
		}	
	}

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public List<String> buscarCursos() {
		String jpql="select distinct(a.curso) from Alumno a";
		Query query=entityManager.createQuery(jpql);
		return (List<String>)query.getResultList();
	}
	//Hay que poner wl transaction
	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public boolean existeAlumno(String nombre) {
		String jpql="select a from Alumno a where a.nombre=:nombre";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("nombre", nombre);
		List<Alumno> alumnos = (List<Alumno>)query.getResultList();
		return alumnos.size()>0;
	}
	
}
