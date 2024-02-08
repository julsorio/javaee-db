package com.accenture.ejAccesoBBDD;

import java.sql.Connection;
import java.sql.Statement;

public class EliminarGrupos {
	
	public static void eliminarGrupo() {
		Connection conexion = DBUtilidades.abrirConexionBD();
		String query = "DELETE FROM grupos WHERE grupoId=32 AND genero='Hard Rock' AND nombre='Kiss' AND creacion=1973 AND origen='Estados Unidos' AND discograficaIdActual=2";
		Statement statement = null;
		
		try {
			statement = conexion.createStatement();
			int resultado = statement.executeUpdate(query);
			if(resultado == 1) {
				System.out.println("Datos eliminados correctamente");
			} else {
				System.out.println("No se ha eliminado el registro");
			}
			
			ConsultarGrupos.listarGrupos();
			statement.close();
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error al actualizar/obtener resultado");
		}
		
		DBUtilidades.cerrarConexionBD();
	}

	public static void main(String[] args) {
		EliminarGrupos.eliminarGrupo();
	}

}
