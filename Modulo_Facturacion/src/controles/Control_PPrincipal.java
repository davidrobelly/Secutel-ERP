package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import pantallas.Consultar_Clientes;
import pantallas.Pantalla_Ingreso;
import pantallas.Pantalla_Principal;
import pantallas.Ventana_Ingreso_Clientes;
import pantallas.Ventana_Ingreso_Empleado;
import pantallas.Ventana_Ingreso_Sucursal;

public class Control_PPrincipal implements ActionListener{

	Pantalla_Principal vista;
	Pantalla_Ingreso ingreso;
	Ventana_Ingreso_Clientes cliente;
	Consultar_Clientes consulcliente;
	Ventana_Ingreso_Empleado empleado;
	Ventana_Ingreso_Sucursal local;
	
	
	public Control_PPrincipal (Pantalla_Principal vista)
	{
		this.vista = vista;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object boton = e.getSource();
		
		if (boton == vista.menuCerrar)
		{
			ingreso = new Pantalla_Ingreso();
			vista.dispose();
		}
		
		if (boton == vista.menuRegLocal)
		{
			local = new Ventana_Ingreso_Sucursal();
		}
		
		if (boton == vista.menuRegCliente)
		{
			cliente = new Ventana_Ingreso_Clientes();
			//vista.setEnabled(false);
			
		}
		
		if (boton == vista.menuRegEmpleado)
		{
			empleado = new Ventana_Ingreso_Empleado();
			//vista.setEnabled(false);
		}
		
		if (boton == vista.menuSalirSistema)
		{
			vista.dispose();
			JOptionPane.showMessageDialog(null, "Usted ha salido del sistema");
		}
		
		if (boton == vista.menuConsulCliente)
		{
			consulcliente = new Consultar_Clientes();
			vista.dispose();
		}
		
	}

}
