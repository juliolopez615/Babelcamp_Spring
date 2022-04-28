package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import service.EscuelaService;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ServiceConfig.class })
public class TestEscuela {

	@Autowired
	EscuelaService service;
	
	@Test
	void testalumnosCurso() {
		assertEquals("6666B", service.alumnosCurso("php").get(0).getDni());
		assertNotEquals(null, service.alumnosCurso("java"));
		
	}
	
	@Test
	void alumnosCursoDuracion() {
		assertEquals(3, service.alumnosCursoDuracion(68).size());
	}
	
	@Test
	void testcursoMatriculadoAlumno() {
		assertEquals("php", service.cursoMatriculadoAlumno("6666B").getDenominacion());
	}
	
	@Test
	void testalumnosSenior() {
		System.out.println(service.alumnosSenior(40).size());
		assertEquals(2, service.alumnosSenior(40).size());
	}
	
	@Test
	void testedadMediaCurso() {
		assertEquals(42, service.edadMediaCurso("php"));
	}
	
	@Test
	void testprecioCurso() {
		assertEquals(250, service.precioCurso("primero@gmail.com"));
	}
	
	
	
	
}
