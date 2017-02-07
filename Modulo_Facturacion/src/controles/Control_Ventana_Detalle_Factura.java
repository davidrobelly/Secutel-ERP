package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo_clases.Detalle_Cotizacion;
import modelo_clases.Detalle_Factura;
import pantallas.Ventana_Detalle_Cotizacion;
import pantallas.Ventana_Detalle_Factura;
import pantallas.Ventana_Ingreso_Cotizacion;

public class Control_Ventana_Detalle_Factura implements ActionListener {

	Ventana_Detalle_Factura vista;
	Detalle_Factura detalle;
	Ventana_Ingreso_Cotizacion cotizacion;
	
	public Control_Ventana_Detalle_Factura(Ventana_Detalle_Factura vista) {
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
			
			if (vista.txtproducto.getText().length() > 1 && vista.txtcantidad.getText().length() > 1
					&& vista.txtvalor.getText().length() > 1)
			{
				
				detalle = new Detalle_Factura (Integer.parseInt(vista.txtfactura.getText()), Integer.parseInt(vista.txtproducto.getText()), 
						Integer.parseInt(vista.txtcantidad.getText()), Integer.parseInt(vista.txtvalor.getText()));
				
				detalle.ingresarDetalle(detalle);
				
				JOptionPane.showMessageDialog(null, "Registro Exitoso");
				
			}
				
		}
		
	}

}
