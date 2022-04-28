package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AlumnoDao;
import dao.CursosDao;
import model.Alumno;
import model.Curso;

@Service
public class FormacionServiceImpl implements FormacionService {
	
	private AlumnoDao alumnoDao;
	private CursosDao cursosDao;
	
	public FormacionServiceImpl(@Autowired AlumnoDao alumnoDao, @Autowired CursosDao cursosDao) {
		this.alumnoDao = alumnoDao;
		this.cursosDao = cursosDao;
	}	

	@Override
	public Alumno validar(String usuario, String password) {
		return alumnoDao.findByUsuarioAndPassword(usuario, password);
	}

	@Override
	public List<Curso> cursosAlumno(String usuario) {
		return cursosDao.findByAlumno(usuario);
	}

	@Override
	public List<Curso> cursos() {
		return cursosDao.findAll();
	}

	@Override
	public List<Alumno> alumnosCurso(String curso) {
		return alumnoDao.findByCurso(curso);
	}
	
	@Override
	public boolean matricular(String usuario, int idCurso) {
		Curso c = cursosDao.findById(idCurso);
		Alumno al = alumnoDao.findById(usuario);
		
		if(c!=null && al != null) {
			al.getCurso().add(c);
			alumnoDao.update(al);
			return true;
		}
		return false;		
	}

	@Override
	public List<Alumno> alumnos() {
		return alumnoDao.findAll();
	}
	

}
