package com.accenture.ejAccesoBBDD;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Andrea Ravagli
 */
public class DBUtilidades {
	private static Connection conexionDB;

	/**
	 * metodo encargado de gestionar la conexion con la base de datos
	 * @return la conexion con la base de datos
	 */
	public static Connection abrirConexionBD() {
		if (conexionDB == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conexionDB = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicadb2", "cravagli", "52973571");
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error al obtener una conexion con la bd");
			}
		}

		return conexionDB;
	}

	/**
	 * metodo encargado de cerrar la conexion con la base de datos
	 */
	public static void cerrarConexionBD() {
		try {
			conexionDB.close();
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error al cerrar la conexion con la bd");
		}
	}
	
	
}
