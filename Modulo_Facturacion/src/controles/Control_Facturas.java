package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import modelo_clases.Cliente;
import modelo_clases.Empleado;
import modelo_clases.Sucursal;
import pantallas.Pantalla_Facturas;
import pantallas.Pantalla_Principal;
import pantallas.Ventana_Ingreso_Factura;

public class Control_Facturas implements ActionListener{

	Pantalla_Facturas vista;
	
	
	public Control_Facturas (Pantalla_Facturas vista) {
		this.vista = vista;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 
		Object boton = e.getSource();
		
		if (boton == vista.btnreg) 
		{	
			Ventana_Ingreso_Factura ingreso = new Ventana_Ingreso_Factura ();
			ingreso.txtvendedor.setText(vista.objeto.txtempleado.getText());
			ingreso.txtlocal.setText(vista.objeto.txtlocal.getText());
			
			//aqui guaro el id del local para el registro de la factura
			Sucursal sucursal = new Sucursal();
			ArrayList<Sucursal> lisCliente = sucursal.listaLocalxNombreId(vista.objeto.txtlocal.getText());
			ingreso.setLocal(lisCliente.get(0).getIdsucursal());
			
			//aqui guardo el id del vendedor para el registro de la factura
			ingreso.setVendedor(vista.objeto.getIdvendedor());
			
		}
		
	}

	
	
}
