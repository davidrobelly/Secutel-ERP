package Persistencia;

import java.sql.CallableStatement; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Modelo.Producto;

public class BDProducto {

	private Connection conexion = null;
	private String usuario = "root";
	private String contraseņa = "1234";

	private String ubicacion = "jdbc:mysql://localhost/secutel-erp?";

	public void conectar () {

		try {			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conexion = DriverManager.getConnection(ubicacion, usuario, contraseņa);
			if (conexion != null) {
				System.out.println("Se establecio conexion a la Base de Datos");
			}
		}
		catch (SQLException ex) {
			System.out.println("Error en la conexion a la Base de Datos");
		}
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

	public void ingresarProducto(Producto producto){

		try {

			String sp = "call ingresarproducto(?,?,?,?)";

			CallableStatement procedimiento = conexion.prepareCall(sp);

			procedimiento.setString(1, producto.getNombre());
			procedimiento.setString(2, producto.getMarca());
			procedimiento.setString(3, producto.getModelo());
			procedimiento.setString(4, producto.getEstado());

			procedimiento.execute();

		} catch (SQLException e) {

			

			e.printStackTrace();

		}

		

	}

	

}
