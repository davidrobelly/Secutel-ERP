package modelo_clases;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

import DBClases.ConexionDB;

public class Sucursal {
	
	private int idsucursal;
	private String nombre;
	private String direccion;
	private String ciudad;
	public String estado;
		
	String sentencia;
	CallableStatement procedure;
	ResultSet result = null;
	ConexionDB conexion;
	
	public Sucursal(int idsucursal, String nombre, String direccion, String ciudad, String estado) {
		super();
		this.setIdsucursal(idsucursal);
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setCiudad(ciudad);
		this.setEstado(estado);
		conexion = new ConexionDB ();
	}
	
	
	public Sucursal(String nombre, String direccion, String ciudad, String estado) {
		super();
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setCiudad(ciudad);
		this.setEstado(estado);
		conexion = new ConexionDB ();
	}


	public Sucursal(String nombre, String direccion, String ciudad) {
		super();
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setCiudad(ciudad);
		conexion = new ConexionDB ();
	}

	public Sucursal() {
		super();
		conexion = new ConexionDB ();
	}

	
	public int getIdsucursal() {
		return idsucursal;
	}


	public void setIdsucursal(int idsucursal) {
		this.idsucursal = idsucursal;
	}
	

	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
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
		this.estado = estado;
	}
	
	
	
	//metodos de sucursal
	

	public void ingresarSucursal(Sucursal sucursal){
		conexion = new ConexionDB();
		conexion.conectar();
		try {
			String sentencia = "call ingresarsucursal(?,?,?)";
			CallableStatement procedure = conexion.conn.prepareCall(sentencia);
			procedure.setString(1, sucursal.getNombre());
			procedure.setString(2, sucursal.getDireccion());
			procedure.setString(3, sucursal.getCiudad());
			procedure.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		conexion.cerrarConexion();
	}
	
	public ArrayList<Sucursal> listaSucursales(){
		 ArrayList<Sucursal> lista = new ArrayList<>();
		 conexion = new ConexionDB();
		 conexion.conectar();
			try {
				sentencia = "call consultar_todos_locales()";
				procedure = conexion.conn.prepareCall(sentencia);
				procedure.execute();
				result = (ResultSet) procedure.executeQuery();
				 while (result.next()) {
					 Sucursal cliente = new Sucursal();
					 cliente.setNombre(result.getString("nombre"));
					 cliente.setDireccion(result.getString("direccion"));
					 cliente.setCiudad(result.getString("ciudad"));
					 cliente.setEstado(result.getString("estado"));
					 if (cliente.getNombre() != null) {
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
	

	public void modificarSucursal(int term, Sucursal cliente){
		 conexion.conectar();
			try {
				sentencia = "call modificarsucursal(?,?,?,?,?)";
				procedure = conexion.conn.prepareCall(sentencia);
				procedure.setInt(1, cliente.getIdsucursal());
				procedure.setString(2, cliente.getNombre());
				procedure.setString(3, cliente.getDireccion());
				procedure.setString(4, cliente.getCiudad());
				procedure.setString(5, cliente.getEstado());
				procedure.execute();
				procedure.close();
				conexion.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	 }
	 
	 
	 public ArrayList<Sucursal> listaLocalxCiudad(String nombre){
		 ArrayList<Sucursal> lista = new ArrayList<>();
		 conexion = new ConexionDB();
		 conexion.conectar();
			try {
				sentencia = "call consulta_local_ciudad(?)";
				procedure = conexion.conn.prepareCall(sentencia);
				procedure.setString(1, nombre);
				procedure.execute();
				result = (ResultSet) procedure.executeQuery();
				while (result.next()) {
					Sucursal cliente = new Sucursal();
					cliente.setNombre(result.getString("nombre"));
					 cliente.setDireccion(result.getString("direccion"));
					 cliente.setCiudad(result.getString("ciudad"));
					 cliente.setEstado(result.getString("estado"));
					if (cliente.getNombre() != null) {
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
	 
	 public ArrayList<Sucursal> listaLocalxCiudadid(String nombre){
		 ArrayList<Sucursal> lista = new ArrayList<>();
		 conexion = new ConexionDB();
		 conexion.conectar();
			try {
				sentencia = "call consulta_local_ciudad(?)";
				procedure = conexion.conn.prepareCall(sentencia);
				procedure.setString(1, nombre);
				procedure.execute();
				result = (ResultSet) procedure.executeQuery();
				while (result.next()) {
					Sucursal cliente = new Sucursal();
					 cliente.setIdsucursal(result.getInt("idsucursal"));
					 cliente.setNombre(result.getString("nombre"));
					 cliente.setDireccion(result.getString("direccion"));
					 cliente.setCiudad(result.getString("ciudad"));
					 cliente.setEstado(result.getString("estado"));
					if (cliente.getNombre() != null) {
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
