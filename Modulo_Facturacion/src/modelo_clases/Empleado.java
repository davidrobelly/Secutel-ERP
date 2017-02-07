package modelo_clases;

import java.sql.CallableStatement;
import java.sql.SQLException;

import DBClases.ConexionDB;

public class Empleado {

	private String nombre;
	private String apellido;
	private String cedula;
	private String telefono;
	private String direccion;
	private int edad;
	private String tipo;
	public String estado; 
	ConexionDB conexion;
	
	
	
	public Empleado(String nombre, String apellido, String cedula, String telefono, String direccion, int edad,
			String tipo) {
		super();
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCedula(cedula);
		this.setTelefono(telefono);
		this.setDireccion(direccion);
		this.setEdad(edad);
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
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
	
	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	
	//metodos de empleado
	
	

	public void ingresarEmpleado(Empleado empleado){
		conexion = new ConexionDB();
		conexion.conectar();
		try {
			String sentencia = "call ingresarempleado(?,?,?,?,?,?,?)";
			CallableStatement procedure = conexion.conn.prepareCall(sentencia);
			procedure.setString(1, empleado.getNombre());
			procedure.setString(2, empleado.getApellido());
			procedure.setString(3, empleado.getCedula());
			procedure.setString(4, empleado.getTelefono());
			procedure.setString(5, empleado.getDireccion());
			procedure.setInt(6, empleado.getEdad());
			procedure.setString(7, empleado.getTipo());
			procedure.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		conexion.cerrarConexion();
	}

}
