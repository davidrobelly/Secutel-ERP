package modelo_clases;

import java.sql.CallableStatement;
import java.sql.SQLException;

import DBClases.ConexionDB;

public class Credenciales {
	
	public int empleado;
	public String user;
	public String key;
	public String estado;
	ConexionDB conexion;
	
	
	public Credenciales(int empleado, String user, String key) {
		super();
		this.setEmpleado(empleado);
		this.setUser(user);
		this.setKey(key);
	}
	
	
	public Credenciales() {
		super();
	}

	public int getEmpleado() {
		return empleado;
	}
	public void setEmpleado(int empleado) {
		this.empleado = empleado;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = "a";
	}
	
	//metodos de credenciales
	
	public void ingresarCredenciales(Credenciales credenciales){
		conexion = new ConexionDB();
		conexion.conectar();
		try {
			String sentencia = "call ingresar_usuario(?,?,?)";
			CallableStatement procedure = conexion.conn.prepareCall(sentencia);
			procedure.setInt(1, credenciales.getEmpleado());
			procedure.setString(2, credenciales.getUser());
			procedure.setString(3, credenciales.getKey());
			procedure.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		conexion.cerrarConexion();
	}
	
}
