package modelo_clases;

import java.sql.CallableStatement;
import java.sql.SQLException;

import DBClases.ConexionDB;

public class cliente {
	
	private String nombre;
	private String cedula;
	private String telefono;
	private String correo;
	private String direccion;
	private String tipo;
	public String estado;
	ConexionDB conexion;
	
	
	public cliente(String nombre, String cedula, String telefono, String correo, String direccion, String tipo) {
		super();
		this.setNombre(nombre);
		this.setCedula(cedula);
		this.setTelefono(telefono);
		this.setCorreo(correo);
		this.setDireccion(direccion);
		this.setTipo(tipo);
	}
	
	
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCedula() {
		return cedula;
	}
	
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = "a";
	}
	
	//Metodos de cliente 
	
	



	public void ingresarCliente(cliente cliente){
		conexion = new ConexionDB();
		conexion.conectar();
		try {
			String sentencia = "call ingresarcliente(?,?,?,?,?,?)";
			CallableStatement procedure = conexion.conn.prepareCall(sentencia);
			procedure.setString(1, cliente.getNombre());
			procedure.setString(2, cliente.getCedula());
			procedure.setString(3, cliente.getTelefono());
			procedure.setString(4, cliente.getCorreo());
			procedure.setString(5, cliente.getDireccion());
			procedure.setString(6, cliente.getTipo());
			procedure.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		conexion.cerrarConexion();
	}
	
	

}
