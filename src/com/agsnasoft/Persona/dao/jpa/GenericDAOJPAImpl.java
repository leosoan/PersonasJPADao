package com.agsnasoft.Persona.dao.jpa;

import java.io.Serializable;
import java.util.List;
import java.lang.reflect.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.agsnasoft.Persona.DataBaseException;
import com.agsnasoft.Persona.DataBaseHelper;
import com.agsnasoft.Persona.JPAHelper;
import com.agsnasoft.Persona.bo.Persona;
import com.agsnasoft.Persona.dao.GenericDAO;

public abstract class GenericDAOJPAImpl<T, Id extends Serializable> implements GenericDAO<T, Id> {

	private Class<T> claseDePersistencia;
	@SuppressWarnings("unchecked")
	
	
	
	public GenericDAOJPAImpl() {
		//public interface ParameterizedType extends Type
		this.claseDePersistencia = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}
	
	public void insertar (Persona persona) throws DataBaseException{	
		
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		EntityTransaction tx = null;
		tx = manager.getTransaction();
		tx.begin();
		
		manager.persist( persona );
		tx.commit();		
	}
	
	//@Override
	public List<T> buscarTodos(T id){

		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		// TypedQuery<Persona> consulta = manager.createQuery( "SELECT l FROM Persona l ", Persona.class); //JOIN FETCH l.categoria
		List<T> listaDeObjetos = null;
		
		try {
			TypedQuery<T> consulta = manager.createQuery( "SELECT l FROM" + claseDePersistencia.getSimpleName()+ " l ", claseDePersistencia); 
			listaDeObjetos = consulta.getResultList();
			return listaDeObjetos;
		} finally {
		//listaDePersonas = consulta.getResultList();
			manager.close();
		}
		//return listaDePersonas;			
	}
	
	public void borrar(Integer id) throws DataBaseException{
		
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		EntityTransaction tx = null;
//		try {
			tx = manager.getTransaction();
			tx.begin();		
			Persona persona=manager.find( Persona.class, id );		
			manager.remove(manager.merge( persona ));
			tx.commit();
//		} catch (PersistenceException e) {
//				manager.getTransaction().rollback();
//				throw e;
//		} finally {
			manager.close();
//		}
	}
	
	@Override
	public T buscarPorClave (Id id){
		
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		//EntityTransaction tx = null;
		T objeto = null;
		try {
				//tx = manager.getTransaction();
				//tx.begin();
				objeto = (T) manager.find(claseDePersistencia, id);
				return objeto;
		}finally {
			manager.close();
		}
		
		
//		Persona persona =manager.find( Persona.class, id );
//		
//		tx.commit();
//		manager.close();
//		return persona; //listaDePersonas.get(0);		
	}
	
	public void salvar ( Persona persona) throws DataBaseException{
		
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		EntityTransaction tx = null;
		tx = manager.getTransaction();
		tx.begin();
				
		manager.merge( persona );
		tx.commit();
		manager.close();		
	}
	
	public static List <Persona> buscarPorNombre (String nombre){
		
		String consultaSQL = "SELECT l FROM Persona l WHERE l.nombre='"+ nombre+"'";
		
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Persona> consulta = manager.createQuery( consultaSQL, Persona.class); //JOIN FETCH l.categoria
		List<Persona> listaDePersonas = null;
		listaDePersonas = consulta.getResultList();
		manager.close();
						
		return listaDePersonas;		
	}
	
	public static List <Persona> buscarPorIdNum (Integer id){
		String consultaSQL = "SELECT id, nombre, apellidos, direccion, edad, email FROM Personas WHERE nombre='"+ id+"'";
		
		DataBaseHelper <Persona> helper = new DataBaseHelper <Persona>();
		List <Persona> listaDePersonas = helper.seleccionarRegistros (consultaSQL);
		
		return listaDePersonas;		
	}
	
	public static List <Persona> ObtenerIdDePersona(Persona persona){

		String consultaSQL = "SELECT l FROM Persona l WHERE l.nombre='"+ persona.getNombre()+"' AND l.apellidos='"+persona.getApellidos()+"' AND l.direccion='"+persona.getDireccion()+"' AND  l.edad='"+persona.getEdad()+"' AND l.email='"+persona.getEmail()+"'";
		
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Persona> consulta = manager.createQuery( consultaSQL, Persona.class); //JOIN FETCH l.categoria
		List<Persona> listaDePersonas = null;
		listaDePersonas = consulta.getResultList();
		manager.close();
		
		return listaDePersonas;	
	}

	
}
