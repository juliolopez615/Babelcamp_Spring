package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;

@Repository
public class AlumnoDaoImpl implements AlumnoDao {
	@PersistenceContext
	EntityManager entityManager;
	@Override
	public Alumno findById(String usuario) {
		return entityManager.find(Alumno.class, usuario);
	}

	@Override
	public Alumno findByUsuarioAndPassword(String usuario, String password) {
		String jpql = "select a from Alumno a where a.usuario=:usuario";
		TypedQuery<Alumno> query = entityManager.createQuery(jpql, Alumno.class);
		query.setParameter("usuario", usuario);
		List<Alumno> alumnos = query.getResultList();
		return alumnos.size() > 0 ? alumnos.get(0).getPassword().equals(password) ? alumnos.get(0) :null :null;
	}

	@Override
	public List<Alumno> findByCurso(String nombreCurso) {
		String jpql = "select a from Alumno a join a.curso c where c.nombre=:nombre";
		TypedQuery<Alumno> query = entityManager.createQuery(jpql, Alumno.class);
		query.setParameter("nombre", nombreCurso);
		List<Alumno> alumnos = query.getResultList();
		return alumnos.size()>0?alumnos:null;
	}
	
	@Transactional
	@Override
	public void update(Alumno alumno) {
		entityManager.merge(alumno);
	}

	@Override
	public List<Alumno> findAll() {
		String jpql = "select a from Alumno a";
		TypedQuery<Alumno> query = entityManager.createQuery(jpql, Alumno.class);
		List<Alumno> alumnos = query.getResultList();
		return alumnos.size()>0?alumnos:null;
	}
}
