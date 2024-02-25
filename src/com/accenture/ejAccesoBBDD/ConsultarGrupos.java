package com.accenture.ejAccesoBBDD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Andrea Ravagli
 */
public class ConsultarGrupos {
	
	/**
	 * metodo encargado de realizar la consulta a la bd
	 * para mostrar el listado de grupos
	 */
	public static void listarGrupos() {
		Connection conexion = DBUtilidades.abrirConexionBD();
		String query = "SELECT nombre,origen,creacion,genero FROM grupos";
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = conexion.createStatement();
			resultSet = statement.executeQuery(query);
			
			if(resultSet != null) {
				
				System.out.println("Listado de grupos musicales");
				System.out.println("---------------------------");
				
				while(resultSet.next()) {
					System.out.printf("%s - %s %d - %s \n", resultSet.getString("nombre"), resultSet.getString("origen"), resultSet.getInt("creacion"), resultSet.getString("genero"));
				}
			}
			
			resultSet.close();
			statement.close();
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error al ejecutar consulta/obtener resultado");
		}
		
		DBUtilidades.cerrarConexionBD();
	}
	
	public static void main(String[] args) {
		ConsultarGrupos.listarGrupos();
	}
}
