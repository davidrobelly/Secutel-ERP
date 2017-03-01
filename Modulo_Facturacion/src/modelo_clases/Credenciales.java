package modelo_clases;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.ResultSet;

import DBClases.ConexionDB;

public class Credenciales {
	
	public int idempleado;
	public String user;
	public String key;
	public String estado;
	public String modulo;
	ConexionDB conexion;
	
	String sentencia;
	CallableStatement procedure;
	ResultSet result = null;
	
	
	public Credenciales(int idempleado, String user, String key) {
		super();
		this.setUser(user);
		this.setKey(key);
		conexion = new ConexionDB ();
	}
	
	public Credenciales(String estado) {
		super();
		this.setEstado(estado);
		conexion = new ConexionDB ();
	}


	public Credenciales(int idempleado, String user, String key, String modulo) {
		super();
		this.setIdempleado(idempleado);
		this.setUser(user);
		this.setKey(key);
		this.setModulo(modulo);
		conexion = new ConexionDB ();
	}

	public Credenciales() {
		super();
		conexion = new ConexionDB ();
	}

	public String getModulo() {
		return modulo;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	public int getIdempleado() {
		return idempleado;
	}
	public void setIdempleado(int empleado) {
		this.idempleado = empleado;
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
			String sentencia = "call ingresar_usuario(?,?,?,?)";
			CallableStatement procedure = conexion.conn.prepareCall(sentencia);
			procedure.setInt(1, credenciales.getIdempleado());
			procedure.setString(2, credenciales.getUser());
			procedure.setString(3, credenciales.getKey());
			procedure.setString(4, credenciales.getModulo());
			procedure.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		conexion.cerrarConexion();
	}
	
	public ArrayList<Credenciales> listaCredencialesxNombre(String nombre){
		 ArrayList<Credenciales> lista = new ArrayList<>();
		 conexion = new ConexionDB();
		 conexion.conectar();
			try {
				sentencia = "call consultar_credencial_nombre(?)";
				procedure = conexion.conn.prepareCall(sentencia);
				procedure.setString(1, nombre);
				procedure.execute();
				result = (ResultSet) procedure.executeQuery();
				while (result.next()) {
					Credenciales cliente = new Credenciales();
					cliente.setIdempleado(result.getInt("idempleado"));
					 cliente.setUser(result.getString("user"));
					 cliente.setKey(result.getString("key"));
					 cliente.setModulo(result.getString("modulo"));
					if (cliente.getUser() != null) {
						lista.add(cliente);
					}
	             }
				procedure.close();
				conexion.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return lista;
	 }
	 
	public ArrayList<Credenciales> listaCredenciales(){
		 ArrayList<Credenciales> lista = new ArrayList<>();
		 conexion = new ConexionDB();
		 conexion.conectar();
			try {
				sentencia = "call consultar_todas_credenciales()";
				procedure = conexion.conn.prepareCall(sentencia);
				procedure.execute();
				result = (ResultSet) procedure.executeQuery();
				 while (result.next()) {
					 Credenciales cliente = new Credenciales();
					 cliente.setIdempleado(result.getInt("idempleado"));
					 cliente.setUser(result.getString("usuario"));
					 cliente.setKey(result.getString("clave"));
					 cliente.setEstado(result.getString("estado"));
					 cliente.setModulo(result.getString("modulo"));
					 if (cliente.getUser() != null) {
						 lista.add(cliente);
					}
	             }
				procedure.close();
				conexion.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return lista;
	}
	
	public ArrayList<Credenciales> listaCredencialesxId(int id){
		 ArrayList<Credenciales> lista = new ArrayList<>();
		 conexion = new ConexionDB();
		 conexion.conectar();
			try {
				sentencia = "call credencial_id(?)";
				procedure = conexion.conn.prepareCall(sentencia);
				procedure.setInt(1, id);
				procedure.execute();
				result = (ResultSet) procedure.executeQuery();
				while (result.next()) {
					Credenciales cliente = new Credenciales();
					cliente.setIdempleado(result.getInt("idempleado"));
					cliente.setUser(result.getString("usuario"));
					cliente.setKey(result.getString("clave"));
					cliente.setModulo(result.getString("modulo"));
					cliente.setEstado(result.getString("estado"));
					if (cliente.getUser() != null) {
						lista.add(cliente);
					}
	             }
				procedure.close();
				conexion.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return lista;
	 }
}
