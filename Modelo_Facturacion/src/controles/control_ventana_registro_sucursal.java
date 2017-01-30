package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo_clases.cliente;
import modelo_clases.sucursal;
import pantallas.ventana_ingreso_sucursal;

public class control_ventana_registro_sucursal implements ActionListener {
	
	ventana_ingreso_sucursal vista;
	sucursal sucursal;
	
	public control_ventana_registro_sucursal(ventana_ingreso_sucursal vista) {
		super();
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object boton = e.getSource();
		
		if (boton == vista.btncancelar )
		{
			vista.dispose();
		}
	
		if (boton == vista.btnborrar)
			{
				vista.txtnombre.setText(""); 
				vista.txtdireccion.setText(""); 
			}
	
		if (boton == vista.btnregistrar)
		{	
			if (vista.txtnombre.getText().equals("") || vista.txtdireccion.getText().equals("")) 
			{
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
			}
			
			if (vista.txtnombre.getText().length() > 5 && vista.txtdireccion.getText().length() > 5) 
			{
				sucursal = new sucursal (vista.txtnombre.getText(), vista.txtdireccion.getText());
				
				sucursal.ingresarSucursal(sucursal);
				
				JOptionPane.showMessageDialog(null, "Registro Exitoso");
				
				vista.txtnombre.setText(""); 
				vista.txtdireccion.setText(""); 
			}
		}
	}

}
