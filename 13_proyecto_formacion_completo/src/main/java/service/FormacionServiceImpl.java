package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional
	@Override
	public boolean matricular(String usuario, int idCurso) {
		/*Curso c = cursosDao.findById(idCurso);
		Alumno al = alumnoDao.findById(usuario);
		
		if(c!=null && al != null) {
			al.getCurso().add(c);
			alumnoDao.save(al);
			return true;
		}
		return false;
		*/
		Optional <Curso> c = cursosDao.findById(idCurso);
		Optional <Alumno> al = alumnoDao.findById(usuario);
		
		if(c.isPresent()&&al.isPresent()) {
			Alumno alumno = al.get();
			alumno.getCurso().add(c.get());
			alumnoDao.save(alumno);
			return true;
		}
		return false;
		
	}

	@Override
	public List<Alumno> alumnos() {
		return alumnoDao.findAll();
	}

	@Override
	public boolean altaAlumno(Alumno alumno) {
		Optional <Alumno> al = alumnoDao.findById(alumno.getUsuario());
		if(al.isPresent()) {
			return false;
		}
		alumnoDao.save(alumno);
		return true;
		
	}

	@Override
	public boolean altaCurso(Curso curso) {
		if(cursosDao.findByNombre(curso.getNombre()).isEmpty()) {
			cursosDao.save(curso);
			return true;
		}
		
		return false;
	}

	@Override
	public List<Curso> matriculasConsulta(Date fecha1, Date fecha2) {
		return cursosDao.findByRangoFecha(fecha1, fecha2);
	}

	@Override
	public List<Curso> cursosPuedeMatricular(String usuario) {
		return cursosDao.findAlumnoNoMatriculado(usuario);
	}

	

}
