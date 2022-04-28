package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import service.FormacionService;



@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ServiceConfig.class })
public class TestEscuela {

	@Autowired
	FormacionService service;
	
	@Test
	void testvalidar() {
		assertEquals("tomates", service.validar("admin", "a").getNombre());
	}
	
	@Test
	void testcursosAlumno() {
		assertEquals(8, service.cursosAlumno("webmvc").size());
	}
	
	@Test
	void testCursos() {
		assertEquals(18, service.cursos().size());
	}
	
	@Test
	void testalumnoCurso() {
		assertEquals(1, service.alumnosCurso("servlet").size());
		
	}
	@Test
	void testValidarAlumno() {
		assertNotNull(service.validar("admin", "a"));
		assertNull(service.validar("tesss", "texxt"));
	}
	
	
}
