package com.accenture.ejAccesoBBDD;

import java.sql.Connection;
import java.sql.Statement;

public class ModificarGrupos {
	
	public static void modificarGrupo() {
		Connection conexion = DBUtilidades.abrirConexionBD();
		String query = "UPDATE grupos SET genero='Hard Rock' WHERE nombre='Kiss' AND creacion=1973 AND origen='Estados Unidos' AND discograficaIdActual=2";
		Statement statement = null;
		
		try {
			statement = conexion.createStatement();
			int resultado = statement.executeUpdate(query);
			if(resultado == 1) {
				System.out.println("Datos modificados correctamente");
			} else {
				System.out.println("No se ha modificado el registro");
			}
			
			ConsultarGrupos.listarGrupos();
			
			statement.close();
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error al actualizar/obtener resultado");
		}
		
		DBUtilidades.cerrarConexionBD();
	}

	public static void main(String[] args) {
		ModificarGrupos.modificarGrupo();
	}

}
