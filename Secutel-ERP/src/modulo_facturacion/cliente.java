package modulo_facturacion;

public class cliente {
	
	private int idcliente;
	private String nombre;
	private String cedula;
	private String telefono;
	private String correo;
	private String direccion;
	private String tipo_cliente;
	
	//constructores para los distintos tipos de metodos de ingreso y de actualizacion de clientes
	public cliente(int idcliente, String nombre, String cedula, String telefono, String correo, String direccion,
			String tipo_cliente) {
		super();

		this.setNombre(nombre);
		this.setCedula(cedula);
		this.setTelefono(telefono);
		this.setCorreo(correo);
		this.setDireccion(direccion);
		this.setTipo_cliente(tipo_cliente);
	}
	
	


	public int getIdcliente() {
		return idcliente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		if (this.nombre != null)  
		{
			this.nombre = nombre;
		}
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		
		if (this.cedula != null)  
		{
			this.cedula = cedula;
		}
		
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		if (this.telefono != null)
		{
			this.telefono = telefono;
		}
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		if (this.correo!= correo)
			
		{
			this.correo = correo;
		}
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		if (this.direccion!= null)
		{
			this.direccion = direccion;
		}
	}


	public String getTipo_cliente() {
		return tipo_cliente;
	}


	public void setTipo_cliente(String tipo_cliente) {
		if (this.tipo_cliente != null)
		{
			this.tipo_cliente = tipo_cliente;
		}
	}
	
	
	
	
	

}
