package DBClases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import modelo_clases.cliente;

public class ConexionDB {

	private Connection conn = null;
	private String usu = "root";
	private String pass = "";
	private String bd = "secutel-erp";
	private String url = "jdbc:mysql://localhost/"+bd;
	
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
	
	public void ingresarCliente(cliente cliente){
		
		try {
			String sentencia = "call ingresarcliente(?,?,?,?,?,?,?)";
			CallableStatement procedure = conn.prepareCall(sentencia);
			procedure.setString(1, cliente.getNombre());
			procedure.setString(2, cliente.getCedula());
			procedure.setString(3, cliente.getTelefono());
			procedure.setString(4, cliente.getCorreo());
			procedure.setString(5, cliente.getDireccion());
			procedure.setString(6, cliente.getTipo());
			procedure.setString(7, cliente.getEstado());
			procedure.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}
