package com.agsnasoft.Persona.dao;

import com.agsnasoft.Persona.bo.Persona;
import com.agsnasoft.Persona.dao.jpa.PersonaDAOJPAImpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MostrarPersonaAccion extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nombre;
	private String apellidos;
	private String direccion;
	private Integer edad;
	private String email;
	private Persona persona;
	private List<Persona> personas;

    public MostrarPersonaAccion () {
    	personas = new ArrayList<Persona>();
    	
    }
    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Persona> getPersonas() {
		PersonaDAOJPAImpl personaDAO = new PersonaDAOJPAImpl();
        if (personas.size()==0) personas = personaDAO.buscarTodos(); 
        
        System.out.println("Tamaño de la lista: "+ personas.size());
        for (int i=0; i < personas.size(); i++ ) {	        	
            System.out.println("setPersonas 1:"+ personas.get(i).toString());
        }

        
		return personas; 
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
		
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	
	public String ejecutar (HttpServletRequest request, HttpServletResponse response){
//public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		
	System.out.println("Dentro de MostrarPersonaAccion: Leo");
	PersonaDAOJPAImpl personaDAO = new PersonaDAOJPAImpl();
	//CategoriaDAO categoriaDAO = new CategoriaDAO();
	List<Persona> personas = personaDAO.buscarTodos();
	
    System.out.println("Tamaño de la lista: "+ personas.size());
    for (int i=0; i < personas.size(); i++ ) {	        	
        System.out.println("setPersonas 1:"+ personas.get(i).toString());
    }
	
	//List<Categoria> listaDeCategorias = categoriaDAO.buscarTodos();
	request.setAttribute("listaDePersonas", personas);
	//request.setAttribute("listaDeCategorias", listaDeCategorias);
	return "MostrarPersonas2.xhtml";
	
	}
}
