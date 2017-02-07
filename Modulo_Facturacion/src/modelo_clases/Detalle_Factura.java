package modelo_clases;

import java.sql.CallableStatement;
import java.sql.SQLException;

import DBClases.ConexionDB;

public class Detalle_Factura {
	
	public int idfactura;
	public int idproducto;
	public int cantidad;
	public int valor;
	ConexionDB conexion;
	
	public Detalle_Factura(int idfactura, int idproducto, int cantidad, int valor) {
		super();
		this.idfactura = idfactura;
		this.idproducto = idproducto;
		this.cantidad = cantidad;
		this.valor = valor;
	}

	
	public int getIdfactura() {
		return idfactura;
	}

	
	
	public void setIdfactura(int idfactura) {
		this.idfactura = idfactura;
	}


	public int getIdproducto() {
		return idproducto;
	}


	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public int getValor() {
		return valor;
	}


	public void setValor(int valor) {
		this.valor = valor;
	}
	
	//metodos 
	
	public void ingresarDetalle(Detalle_Factura detalle){
		conexion = new ConexionDB();
		conexion.conectar();
		try {
			String sentencia = "call ingresar_detalle_factura(?,?,?,?)";
			CallableStatement procedure = conexion.conn.prepareCall(sentencia);
			procedure.setInt(1, detalle.getIdfactura());
			procedure.setInt(2, detalle.getIdproducto());
			procedure.setInt(3, detalle.getCantidad());
			procedure.setDouble(4, detalle.getValor());
			procedure.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		conexion.cerrarConexion();
	}

}
