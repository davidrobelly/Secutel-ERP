package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo_clases.Cliente;
import modelo_clases.Detalle_Factura;
import pantallas.Consulta_Productos;
import pantallas.Tabla_Clientes;
import pantallas.Ventana_Detalle_Factura;
import pantallas.Ventana_Ingreso_Factura;


public class Control_Ventana_Detalle_Factura implements ActionListener, MouseListener {

	Ventana_Detalle_Factura vista;
	Detalle_Factura detalle;
	
	
	public Control_Ventana_Detalle_Factura(Ventana_Detalle_Factura vista) 
	{
		super();
		this.vista = vista;
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object boton = e.getSource();
		
		if (boton == vista.btnlimpiar) {
			
			vista.txtproducto.setText("");
			vista.txtcantidad.setText("");
			vista.txtvalor.setText("");
			
		}
		
		
		if (boton == vista.btnregistrar) 
		{
			if (vista.txtproducto.getText().equals("") || vista.txtcantidad.getText().equals("")
					|| vista.txtvalor.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
			}
			
			if (vista.txtproducto.getText().length() >= 1 && vista.txtcantidad.getText().length() >= 1
					&& vista.txtvalor.getText().length() >= 1)
			{
				
				detalle = new Detalle_Factura (Integer.parseInt(vista.txtfactura.getText()), Integer.parseInt(vista.txtproducto.getText()), 
						Integer.parseInt(vista.txtcantidad.getText()), Integer.parseInt(vista.txtvalor.getText()));
				
				detalle.ingresarDetalle(detalle);
				
				JOptionPane.showMessageDialog(null, "Registro Exitoso");
				
			}
				
		}
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		
		Object boton = e.getSource();
		
		if (boton == vista.txtproducto)
		{
			Consulta_Productos ventana = new Consulta_Productos(vista);
			ventana.setVisible(true);
		}
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
