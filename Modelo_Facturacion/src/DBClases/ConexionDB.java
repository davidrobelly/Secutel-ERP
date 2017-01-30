package DBClases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import modelo_clases.cliente;

public class ConexionDB {

	public Connection conn = null;
	public String usu = "root";
	public String pass = "";
	public String bd = "secutel-erp";
	public String url = "jdbc:mysql://localhost/"+bd;
	
	public void conectar () {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url,usu,pass);
			if (conn != null) {
				System.out.println("conexion a base de datos exitosa");
				
			}
		} 
		catch (SQLException ex) {
			// TODO: handle exception
			System.out.println("hubo un problema al intentar conectarse a la base.");
		}
		catch (ClassNotFoundException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		
		
	}
	
	public void cerrarConexion()  {
	  	try {
		   conn.close();
		   System.out.println ("Conexion cerrada exitosamente.");  
		}catch (SQLException  ex) {
			System.out.println ("Ha ocurrido un error al intentar cerrar la conexion.");                                   
		}
	}
	
	
}
