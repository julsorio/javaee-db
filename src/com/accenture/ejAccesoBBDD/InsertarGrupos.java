package com.accenture.ejAccesoBBDD;

import java.sql.Connection;
import java.sql.Statement;

public class InsertarGrupos {
	
	public static void insertarGrupo() {
		Connection conexion = DBUtilidades.abrirConexionBD();
		String query = "INSERT INTO grupos (nombre, creacion, origen, genero, discograficaIdActual) VALUES ('Kiss',1973,'Estados Unidos','Rock',2)";
		Statement statement = null;
		
		try {
			statement = conexion.createStatement();
			int resultado = statement.executeUpdate(query);
			if(resultado == 1) {
				System.out.println("Datos insertados correctamente");
			} else {
				System.out.println("No se ha insertado el registro");
			}
			
			ConsultarGrupos.listarGrupos();
			
			statement.close();
			
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error al insertar/obtener resultado");
		}
		
		DBUtilidades.cerrarConexionBD();
	}
	
	public static void main(String[] args) {
		InsertarGrupos.insertarGrupo();
		
	}
}
