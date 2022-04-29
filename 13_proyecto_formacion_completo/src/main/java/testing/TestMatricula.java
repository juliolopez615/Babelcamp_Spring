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
class TestMatricula {

	@Autowired
	FormacionService service;
	
	@Test
	void testvalidar() {
		service.matricular("test1", 1);
		assertEquals(1, service.cursosAlumno("test1").size());
		assertEquals(9, service.alumnosCurso("java 10").size());
	}
}

