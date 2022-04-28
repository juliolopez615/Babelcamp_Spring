package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Producto;

@Service
public class GestorProductoServiceImpl implements GestorProductoService{
	@PersistenceContext
	EntityManager entityManager;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> buscar(String seccion) {
		String jpql="select p from Producto p where p.seccion=:seccion";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("seccion", seccion);
		return (List<Producto>)query.getResultList();
	}
	
	@Transactional
	@Override
	public void alta(Producto producto) {
		entityManager.persist(producto);
	}

	@Transactional
	@Override
	public void eliminar(String nombre) {
		String jpql="Delete from Producto p where p.nombre=:nombre";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("nombre", nombre);
		query.executeUpdate();
	}

	
	@Transactional
	@Override
	public void modificar(String nombre, double nuevoPrecio) {
		String jpql="update from Producto p set p.precio=:nuevoPrecio where nombre=:nombre";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("nuevoPrecio", nuevoPrecio);
		query.setParameter("nombre", nombre);
		query.executeUpdate();
	}

	@Override
	public Producto buscarProducto(int idProducto) {
		return entityManager.find(Producto.class, idProducto);
	}

	@Override
	public double precioMedioSeccion(String seccion) {
		String jpql = "select avg(p.precio) from Producto p where p.seccion=:seccion";
		TypedQuery<Double> query=entityManager.createQuery(jpql, Double.class);
		query.setParameter("seccion", seccion);
		return query.getSingleResult();
	}
}
