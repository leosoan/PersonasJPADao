package com.agsnasoft.Persona.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.agsnasoft.Persona.DataBaseHelper;
import com.agsnasoft.Persona.dao.jpa.JPAHelper;
import com.agsnasoft.Persona.bo.Persona;
import com.agsnasoft.Persona.dao.PersonaDAO;

public class PersonaDAOJPAImpl implements PersonaDAO{

	public PersonaDAOJPAImpl() {
		super();
	}
	
	@Override
	public void insertar (Persona persona){	
		
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		EntityTransaction tx = null;
		tx = manager.getTransaction();
		tx.begin();
		
		manager.persist( persona );
		tx.commit();		
	}
	
	public List<Persona> buscarTodos(){

		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Persona> consulta = manager.createQuery( "SELECT l FROM Persona l ", Persona.class); //JOIN FETCH l.categoria
		List<Persona> listaDePersonas = null;
		listaDePersonas = consulta.getResultList();
		manager.close();
		return listaDePersonas;			
	}
	
	@Override
	public void borrar(Integer id){
		
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		EntityTransaction tx = null;

			tx = manager.getTransaction();
			tx.begin();		
			Persona persona=manager.find( Persona.class, id );		
			manager.remove(manager.merge( persona ));
			tx.commit();
			manager.close();
	}
	
	@Override
	public Persona buscarPorClave (Integer id){
		
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		EntityTransaction tx = null;
		tx = manager.getTransaction();
		tx.begin();
		
		Persona persona =manager.find( Persona.class, id );
		
		tx.commit();
		manager.close();
		return persona; //listaDePersonas.get(0);		
	}
	
	@Override
	public void salvar ( Persona persona){
		
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		EntityTransaction tx = null;
		tx = manager.getTransaction();
		tx.begin();
				
		manager.merge( persona );
		tx.commit();
		manager.close();		
	}
	
	@Override
	public List <Persona> buscarPorNombre (String nombre){
		
		String consultaSQL = "SELECT l FROM Persona l WHERE l.nombre='"+ nombre+"'";
		
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Persona> consulta = manager.createQuery( consultaSQL, Persona.class); //JOIN FETCH l.categoria
		List<Persona> listaDePersonas = null;
		listaDePersonas = consulta.getResultList();
		manager.close();
						
		return listaDePersonas;		
	}
	
	@Override
	public List <Persona> buscarPorIdNum (Integer id){
		String consultaSQL = "SELECT id, nombre, apellidos, direccion, edad, email FROM Personas WHERE nombre='"+ id+"'";
		
		DataBaseHelper <Persona> helper = new DataBaseHelper <Persona>();
		List <Persona> listaDePersonas = helper.seleccionarRegistros (consultaSQL);
		
		return listaDePersonas;		
	}
	
	@Override
	public List <Persona> ObtenerIdDePersona(Persona persona){

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
