package Secutel_ERP;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

public class ContactoProveedor {
	
	String nombre;
	String apellido;
	String cedula;
	ConectBase conectar;
	String sentencia;
	CallableStatement proc;
	ResultSet result = null;
	ArrayList<TelefonoContacto> lista = new ArrayList<>();
	
	public ArrayList<TelefonoContacto> getLista() {
		return lista;
	}
	public void setLista(ArrayList<TelefonoContacto> lista) {
		this.lista = lista;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public ContactoProveedor() {
		super();
		conectar = new ConectBase();
	}
	public ContactoProveedor(String nombre, String apellido, String cedula) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		conectar = new ConectBase();
	}
	void insertarContacto(ContactoProveedor con,String nombre){
		
		int id = 0;
		id = obtenerID(nombre);
		try {
			conectar.conectar();
			sentencia = "call insertarContactoProveedor(?,?,?,?)";
			proc = conectar.conn.prepareCall(sentencia);
			proc.setString(1, con.getNombre());
			proc.setString(2, con.getApellido());
			proc.setInt(3, id);
			proc.setString(4, con.getCedula());
			proc.execute();
			proc.close();
			conectar.cerrar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	int obtenerID(String nombre){
		conectar.conectar();
		int id = 0;
		try {
			sentencia = "call ObtenerIDProveedor(?)";
			proc = conectar.conn.prepareCall(sentencia);
			proc.setString(1, nombre);
			proc.execute();
			result = (ResultSet) proc.executeQuery(); 
			while (result.next()) {
				id = result.getInt("idproveedor");
             }
			proc.close();
			conectar.cerrar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	boolean verificarContacto(String cedula){
		conectar.conectar();
		boolean val = false;
		String ced = "";
		try {
			sentencia = "call obtenerContactoxNombre(?)";
			proc = conectar.conn.prepareCall(sentencia);
			proc.setString(1, cedula);
			proc.execute();
			result = (ResultSet) proc.executeQuery(); 
			while (result.next()) {
				ced = result.getString("cedula");
				if (ced != null) {
					val = true;
				}else{
					val = false;
				}
             }
			proc.close();
			conectar.cerrar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return val;
	}
	void inactivar(String cedula){
		conectar.conectar();
		try {
			sentencia = "call inactivarContactoProveedor(?)";
			proc = conectar.conn.prepareCall(sentencia);
			proc.setString(1, cedula);
			proc.execute();
			proc.close();
			conectar.cerrar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	void activar(String cedula){
		conectar.conectar();
		try {
			sentencia = "call activarContactoProveedor(?)";
			proc = conectar.conn.prepareCall(sentencia);
			proc.setString(1, cedula);
			proc.execute();
			proc.close();
			conectar.cerrar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
