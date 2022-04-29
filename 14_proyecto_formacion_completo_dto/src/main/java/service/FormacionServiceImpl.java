package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import converters.ConversorEntityDto;
import dao.AlumnoDao;
import dao.CursosDao;
import dto.AlumnoDto;
import dto.CursoDto;
import model.Alumno;
import model.Curso;

@Service
public class FormacionServiceImpl implements FormacionService {
	
	@Autowired
	ConversorEntityDto converter;
	
	private AlumnoDao alumnoDao;
	private CursosDao cursosDao;
	
	public FormacionServiceImpl(@Autowired AlumnoDao alumnoDao, @Autowired CursosDao cursosDao) {
		this.alumnoDao = alumnoDao;
		this.cursosDao = cursosDao;
	}	

	@Override
	public AlumnoDto validar(String usuario, String password) {
		return converter.alumnoToDto(alumnoDao.findByUsuarioAndPassword(usuario, password));
	}

	@Override
	public List<CursoDto> cursosAlumno(String usuario) {
		return cursosDao.findByAlumno(usuario)
				.stream()
				.map(c->converter.cursoToDto(c))
				.collect(Collectors.toList());
	}

	@Override
	public List<CursoDto> cursos() {
		return cursosDao.findAll()
				.stream()
				.map(c->converter.cursoToDto(c))
				.collect(Collectors.toList());				
	}

	@Override
	public List<AlumnoDto> alumnosCurso(String curso) {
		return alumnoDao.findByCurso(curso)
				.stream()
				.map(a->converter.alumnoToDto(a))
				.collect(Collectors.toList());	
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
	public List<AlumnoDto> alumnos() {
		return alumnoDao.findAll()
				.stream()
				.map(a->converter.alumnoToDto(a))
				.collect(Collectors.toList());
	}

	@Override
	public boolean altaAlumno(AlumnoDto alumno) {
		Optional <Alumno> al = alumnoDao.findById(alumno.getUsuario());
		if(al.isPresent()) {
			return false;
		}
		alumnoDao.save(converter.dtoToAlumno(alumno));
		return true;
		
	}

	@Override
	public boolean altaCurso(CursoDto curso) {
		if(cursosDao.findByNombre(curso.getNombre()).isEmpty()) {
			cursosDao.save(converter.dtoToCurso(curso));
			return true;
		}
		
		return false;
	}

	@Override
	public List<CursoDto> matriculasConsulta(Date fecha1, Date fecha2) {
		return cursosDao.findByRangoFecha(fecha1, fecha2)
				.stream()
				.map(c->converter.cursoToDto(c))
				.collect(Collectors.toList());	
	}

	@Override
	public List<CursoDto> cursosPuedeMatricular(String usuario) {
		return cursosDao.findAlumnoNoMatriculado(usuario)
				.stream()
				.map(c->converter.cursoToDto(c))
				.collect(Collectors.toList());	
	}

	

}
