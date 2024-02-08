package com.accenture.ejAccesoBBDD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConsultarGrupos80 {
	
	public static void consultarGrupos80() {
		Connection conexion = DBUtilidades.abrirConexionBD();	
		String query = "SELECT nombre,origen,creacion,genero FROM grupos WHERE creacion BETWEEN 1980 AND 1989 ORDER BY creacion";
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = conexion.createStatement();
			resultSet = statement.executeQuery(query);
			if(resultSet != null) {
				System.out.println("Listado de grupos musicales de los 80");
				System.out.println("---------------------------");
				
				while(resultSet.next()) {
					System.out.printf("%s - %s %d - %s \n", resultSet.getString("nombre"), resultSet.getString("origen"), resultSet.getInt("creacion"), resultSet.getString("genero"));
				}
			} 
			
			resultSet.close();
			statement.close();
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error al obtener resultado");
		}
		
		DBUtilidades.cerrarConexionBD();
	}

	public static void main(String[] args) {
		ConsultarGrupos80.consultarGrupos80();
	}

}
