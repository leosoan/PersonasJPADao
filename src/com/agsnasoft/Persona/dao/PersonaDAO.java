package com.agsnasoft.Persona.dao;
import com.agsnasoft.Persona.bo.Persona;
import java.util.List;

public interface PersonaDAO {
	
	public abstract void insertar (Persona persona); 
	
	public abstract List<Persona> buscarTodos();
	
	public abstract void borrar(Integer id);
	
	public abstract  Persona buscarPorClave (Integer id);
	
	public abstract void salvar ( Persona persona); 
	
	public abstract  List <Persona> buscarPorNombre (String nombre);
	
	public abstract  List <Persona> buscarPorIdNum (Integer id);
	
	public abstract  List <Persona> ObtenerIdDePersona(Persona persona);
	
}