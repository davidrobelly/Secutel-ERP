package modelo_clases;

import java.sql.CallableStatement;
import java.sql.SQLException;

import DBClases.ConexionDB;

public class sucursal {
	
	private String nombre;
	private String direccion;
	public String estado;
	ConexionDB conexion;
	
	
	public sucursal(String nombre, String direccion) {
		super();
		this.setNombre(nombre);
		this.setDireccion(direccion);
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = "a";
	}
	
	
	
	//metodos de sucursal
	
	
	


	public void ingresarSucursal(sucursal sucursal){
		conexion = new ConexionDB();
		conexion.conectar();
		try {
			String sentencia = "call ingresarsucursal(?,?)";
			CallableStatement procedure = conexion.conn.prepareCall(sentencia);
			procedure.setString(1, sucursal.getNombre());
			procedure.setString(2, sucursal.getDireccion());
			procedure.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		conexion.cerrarConexion();
	}
	
}
