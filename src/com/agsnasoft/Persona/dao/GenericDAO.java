package com.agsnasoft.Persona.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO <T,Id extends Serializable> {
	
	T buscarPorClave (Id id);
	
	List<T>buscarPorNombre (Id nombre);
	List<T>buscarPorIdNum (Id id);
	List<T>ObtenerIdDePersona(T objeto);
	List<T>buscarTodos (T objeto);
	void salvar(T objeto);
	void borrar(T objeto);
	void insertar (T objeto);
		
}
