package com.agsnasoft.Persona.servicios;
import java.util.List;

import javax.faces.event.ActionEvent;

import com.agsnasoft.Persona.bo.Persona;
import com.agsnasoft.Persona.servicios.ServicioPersonas;



public class FormularioPersonaManagedBean {
	
	//public class FormularioLibroManagedBean {
	private Integer id;
	private String nombre;
	private String apellidos;
	private String  direccion;
	private Integer edad;
	private String  email;
	
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


	

	//private List<SelectItem> listaDeNombres;
	private List<Persona> listaDePersonas;
	
	public List<Persona> getListaDePersonas() {
		return listaDePersonas;
	}
	

	//public void iniciar() {
	//	listaDePersonas = getServicioPersonas().buscarTodosLosPersonas();
	//	List<Categoria> categorias = getServicioPersonas().buscarTodasLasCategorias();
	//	listaDeCategorias = new ArrayList<SelectItem>();
	//	for (Categoria categoria : categorias) {
	//		listaDeCategorias.add(new SelectItem(categoria.getId().categoria.getDescripcion()));
	//	}
	//}
	
	public void setListaDePersonas(List<Persona> listaDePersonas) {
		this.listaDePersonas = listaDePersonas;
	}
	
	//public List<SelectItem> getListaDeCategorias() {
	//	return listaDeCategorias;
	//}
	
	//public void setListaDeCategorias(List<SelectItem> listaDeCategorias) {
	//	this.listaDeCategorias = listaDeCategorias;
	//}
	//-------------------------------------------------

	//-------------------------------------------------
	//public String getCategoria() {
	//	return categoria;
	//}
	
	//public void setCategoria(String categoria) {
	//	this.categoria = categoria;
	//}
	
	//public void insertar(ActionEvent evento) {
	//	getServicioPersonas().insertarLibro( new Persona (id, nombre, apellidos, direccion, edad, email)); // titulo, new Categoria(Integer.parseInt(categoria))));
	//	setListaDePersonas(getServicioPersonas().buscarTodosLosPersonas());
	//	categoria="0";
	//}
	
	public void borrar(ActionEvent evento) {
		//UIComponent componente = (UIComponent) evento.getComponent();
		//String id = componente.getAttributes().get("id").toString();
		//getServicioPersonas().borrarPersona(new Persona(Integer.valueOf(id.trim()), "nombre", "apellidos", "direccion", 0, "email"));
		
		//setListaDePersonas(getServicioPersonas().buscarTodosLosPersonas());
	}
	
	//public void filtrar(ValueChangeEvent evento) {
	//	int idCategoria = Integer.parseInt(evento.getComponent().getAttributes().get("value").toString());
	//	if(idCategoria!=0) {
	//	setListaDePersonas(getServicioPersonas().buscarLibrosPorCategoria(new Categoria(idCategoria)));
	//	}else {
	//		setListaDePersonas(getServicioPersonas().buscarTodosLosLibros());
	//	}
	//}
	
	public void editar(ActionEvent evento) {
		//UIComponent componente = (UIComponent) evento.getComponent();
		//Persona	persona = getServicioPersonas().buscarPersonaPorId(componente.getAttributes().get("id").toString());
		//id = persona.getId();
		//nombre = persona.getNombre();
	}
	
	public void formularioInsertar(ActionEvent evento) {
		id = 0; //"";
		nombre = "";
	}
		
	//public void salvar(ActionEvent evento) {
	//	getServicioPersonas().salvarPersona(new Persona(id, nombre, apellidos, edad, email)); 
	//	//titulo, new Categoria(Integer.parseInt(categoria))));
	//	setListaDePersonas(getServicioPersonas().buscarTodosLosPersonas());
	//	categoria="0";
	//}
	
	public ServicioPersonas getServicioPersonas() {
	//	ApplicationContext contexto = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
	//	return (ServicioPersonas) contexto.getBean("servicioPersonas");
		return null;
	}
	
	
}
