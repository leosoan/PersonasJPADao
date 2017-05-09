package com.agsnasoft.Persona.servicios;

import java.util.List;
//import com.agsnasoft.Persona.bo.Categoria;
import com.agsnasoft.Persona.bo.Persona;

public interface ServicioPersonas {

		public void salvarPersona(Persona persona);
		public void borrarPersona(Persona persona);
		//public List<Libro> buscarTodosLosLibros();
		//public List<Categoria> buscarCategoriasLibros();
		//public Persona buscarPersonasPorClave(String id);
		//public Categoria buscarCategoriaPorClave(int id);
		//public List<Libro> buscarPersonasPorCategoria(int categoria);
		public Persona buscarPersonaPorId(String id);
}
