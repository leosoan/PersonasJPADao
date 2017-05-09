package com.agsnasoft.Persona;

//<!-- sentencias de import necesarios para jdbc-->
import java.sql.Connection;
//import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.*;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import com.agsnasoft.Persona.bo.Persona;

public class DataBaseHelper<T>{
	
	private static final Logger log = Logger.getLogger(DataBaseHelper.class.getPackage().getName());
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/personasLeo";  
	private static final String USUARIO = "root";
	private static final String CLAVE = "root";
	
	public int modificarRegistro (String consultaSQL) throws DataBaseException {
		
		Connection conexion = null;		
		PreparedStatement ps = null;

		int filasAfectadas = 0;
		
		try {
			Class.forName(DRIVER);
			
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			
			ps = conexion.prepareStatement(consultaSQL);
				
			filasAfectadas = ps.executeUpdate();
			
		} catch (ClassNotFoundException e){
			log.error("Error de acceso al driver"+ e.getMessage());
			
			throw new DataBaseException ("Error de SQL ", e);
	} catch (NumberFormatException e){
		log.error("Edad no puede ser vacio"+ e.getMessage());
		throw new DataBaseException ("Error de SQL ", e);
	}
		catch (SQLException e) {
			log.error("Error de SQL" + e.getMessage());
			throw new DataBaseException ("Error SQL", e);
	} finally {
			if (ps != null){
				try { ps.close();} catch(SQLException e) {
					log.error("Error con la sentencia" + e.getMessage() );
				}
			}
				
			if ( conexion != null) {
				try { conexion.close();} catch (SQLException e) {
					log.error("Error cerrando la conexion"+ e.getMessage());
				}				
			}
		}
		return filasAfectadas;		
	}

	//Cierre de conexiones y reflexion
	
		
	public List<Persona> seleccionarRegistros(String consultaSQL){ //, Class clase){
		
		Connection conexion = null;	
		ResultSet filas = null;
		//List<T> listaDeObjetos = new ArrayList <T>();
		List<Persona> listaDeObjetos = new ArrayList <Persona>();
		
		try {
			Class.forName(DRIVER);
			
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			
			PreparedStatement ps = conexion.prepareStatement(consultaSQL);
				
			filas = ps.executeQuery();
			
			//try {
				while (filas.next()){
					listaDeObjetos.add(new Persona(filas.getInt("id"),
													filas.getString("nombre"),
													filas.getString("apellidos"),
													filas.getString("direccion"),
													filas.getInt("edad"),
													filas.getString("email")
													));
				} 
		} catch (ClassNotFoundException e) {
				
			} catch (SQLException e){
					System.out.println(e.getMessage());
			}			
			
			
			//while (filas.next()){
			//	T objeto = (T) Class.forName(clase.getName()).newInstance();
			//	Method[] metodos = objeto.getClass().getDeclaredMethods();
			//	for (int i=0; i<metodos.length;i++){
			//		System.out.println("Nombre columna sub: "+filas.getString(metodos[i].getName().substring(3)));
			//		System.out.println("Nombre columna: "+metodos[i].getName());
					
			//		if (metodos[i].getName().startsWith("set")){
			//			System.out.println("Filas Metodo:" + metodos[i].getReturnType().getTypeName()+" :String Integer:  "+metodos[i].getName().substring(3));
			//			if (metodos[i].getReturnType().getTypeName().equals("java.lang.String")) {
			//			System.out.println(filas.getString(metodos[i].getName().substring(3)));
			//			metodos[i].invoke(objeto, filas.getString(metodos[i].getName().substring(3)));
			//			objeto=(T)filas.getString(1);
			//			}
			//			if (metodos[i].getReturnType().getTypeName().equals("java.lang.Integer")) {
			//			System.out.println("Filas Metodo:" + metodos[i].getName().substring(3));
						//metodos[i].invoke(objeto, filas.getInt(metodos[i].getName().substring(3).toLowerCase()));
			//			metodos[i].invoke(objeto, filas.getString("id"));
			//			objeto=(T)filas.getString(1);
			//			}
						
			//		}
					//if (objeto.getClass().getName().equals("java.lang.String")){
					//	objeto=(T)filas.getString(1);
					//}			
					//System.out.println(objeto.toString().);
			//	}
			//	listaDeObjetos.add(objeto);
			//}
			//ps.close();
			
		//} catch (Exception e){
		//	System.out.println("Error al seleccionar Registros"+ e.getMessage());
		//} 
		//finally {
			//if (ps != null){
			//	try {ps.close();} catch (SQLException e) {}
			//}
		//	if (conexion != null){
		//		try {conexion.close();} catch (SQLException e) {}
		//	}

		//}	
		return listaDeObjetos;
	}
	
} 

