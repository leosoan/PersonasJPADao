package com.agsnasoft.Persona;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.agsnasoft.Persona.bo.Persona;
import com.agsnasoft.Persona.dao.jpa.GenericDAOJPAImpl;
import com.agsnasoft.Persona.dao.jpa.PersonaDAOJPAImpl;

public class FormularioPersonaManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombre;
	private String apellidos;
	private String direccion;
	private Integer edad;
	private String email;
	private Persona persona;
	private List<Persona> personas;

    public FormularioPersonaManagedBean () {
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

	//@Override
	public List<Persona> getPersonas() {

		PersonaDAOJPAImpl personaDAO = new PersonaDAOJPAImpl();		
        if (personas.size()==0) personas= personaDAO.buscarTodos();

		return personas; 
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
		
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "FormularioPersonaManagedBean [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", direccion=" + direccion + ", edad=" + edad + ", email=" + email + ", persona=" + persona
				+ ", personas=" + personas + "]";
	}

	public String borrar() { 

		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String idString = params.get("id");

			Integer idInt; 

			if (idString.matches("[0-9]*") && idString.trim() != "")
				idInt = Integer.valueOf(idString.trim());
			else
				idInt = 0;

			PersonaDAOJPAImpl personaDAO = new PersonaDAOJPAImpl();			
	        personaDAO.borrar(idInt);			
			personas.clear();
			personas = personaDAO.buscarTodos();			

		nombre = "";
		return "/MostrarPersona1.xhtml";
	}

	public String editar() { 
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String idString = params.get("id");

		PersonaDAOJPAImpl personaDAO = new PersonaDAOJPAImpl();			
		Persona persona = personaDAO.buscarPorClave(Integer.valueOf(idString));

		id = persona.getId();
		nombre = persona.getNombre();
		apellidos = persona.getApellidos();
		direccion = persona.getDireccion();
		edad = persona.getEdad();
		email = persona.getEmail();

		return "/FormularioEditarPersona1.xhtml";
	}

	public String salvarPersona() {

			Persona persona = new Persona(id, nombre, apellidos, direccion, edad, email);

			PersonaDAOJPAImpl personaDAO = new PersonaDAOJPAImpl();			
			personaDAO.salvar (persona);
			personas.clear();
			personas = personaDAO.ObtenerIdDePersona(persona);
			
		nombre = "";
		return "/MostrarPersona1.xhtml";
	}

	public String formularioInsertar() {
		id = 0;
		nombre = "";
		apellidos = "";
		direccion = "";
		edad = 0;
		email = "";

		return "/FormularioInsertarPersona.xhtml";
	}

	public String insertar() {

		Persona persona = new Persona(nombre, apellidos, direccion, edad, email);

		PersonaDAOJPAImpl personaDAO = new PersonaDAOJPAImpl();
		personaDAO.insertar( persona );
		personas.clear();
		personas = personaDAO.ObtenerIdDePersona(persona);

        nombre = "";
		return "/MostrarPersona1.xhtml";
	}

	public String filtrar() {

		if (nombre == null) 		nombre = "*";
		if (nombre.trim() == "") 	nombre = "*";

		personas.clear();
		PersonaDAOJPAImpl personaDAO = new PersonaDAOJPAImpl();
		if (nombre.equals("*"))
			personas = personaDAO.buscarTodos();
		else
			personas = personaDAO.buscarPorNombre(nombre);

		nombre = "";
		return "/MostrarPersona1.xhtml";

	}

}
