package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import service.GestorProductoService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ServiceConfig.class })
public class TestProductosService {
	
	@Autowired
	GestorProductoService service;
	
	@Test
	void testProducto() {
		assertEquals(3.1, service.buscarProducto(4).getPrecio());
		assertNull(service.buscarProducto(800));
	}
	
	@Test
	void testMedia() {
		assertEquals(130.3, service.precioMedioSeccion("hogar"));
	}
}
