package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import modelo_clases.cliente;
import pantallas.ventana_ingreso_clientes;

public class control_ventana_registro_cliente implements ActionListener {
	
	ventana_ingreso_clientes vista;
	cliente cliente;

	public control_ventana_registro_cliente(ventana_ingreso_clientes vista) {
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
			vista.txttelefono.setText(""); 
			vista.txtdireccion.setText(""); 
			vista.txtcedula.setText(""); 
			vista.txtcorreo.setText(""); 
		}
		
		if (boton == vista.btnregistrar)
		{
			
			
			if (vista.txtnombre.getText().equals("") || vista.txtdireccion.getText().equals("")
					|| vista.txttelefono.getText().equals("") || vista.txtcedula.getText().equals("")
					|| vista.txtcorreo.getText().equals("")) 
			{
				
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
			}
			
			if (vista.txtnombre.getText().length() > 10 && vista.txtdireccion.getText().length() > 5
					&& vista.txttelefono.getText().length() > 9 && vista.txtcedula.getText().length() > 9
					&& vista.txtcorreo.getText().length() > 5) 
			{
				cliente = new cliente (vista.txtnombre.getText(),vista.txtcedula.getText()
						,vista.txttelefono.getText() ,vista.txtcorreo.getText() ,
						vista.txtdireccion.getText(),(String) vista.cmbtipo.getSelectedItem());
				
				cliente.ingresarCliente(cliente);
				
				JOptionPane.showMessageDialog(null, "Registro Exitoso");
				
				vista.txtnombre.setText(""); 
				vista.txttelefono.setText(""); 
				vista.txtdireccion.setText(""); 
				vista.txtcedula.setText(""); 
				vista.txtcorreo.setText(""); 
			}
			
			
			
			
		}
		
	}
	
	
	
	

}
