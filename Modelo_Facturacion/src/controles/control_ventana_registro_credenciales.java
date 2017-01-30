package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo_clases.credenciales;
import modelo_clases.sucursal;
import pantallas.ventana_ingreso_credenciales;
import pantallas.ventana_ingreso_empleado;
import pantallas.ventana_ingreso_sucursal;

public class control_ventana_registro_credenciales  implements ActionListener{

	ventana_ingreso_credenciales vista;
	credenciales credencial;
	
	public control_ventana_registro_credenciales(ventana_ingreso_credenciales vista) {
		super();
		this.vista = vista;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
	Object boton = e.getSource();
		
		if (boton == vista.btncancelar )
		{
			vista.dispose();
		}
	
		if (boton == vista.btnborrar)
			{
				vista.txtuser.setText(""); 
				vista.txtkey.setText(""); 
			}
		
		if (boton == vista.btnregistrar)
		{
			if (vista.txtuser.getText() == "" || vista.txtkey.getText() == "")
			{
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
				vista.txtuser.setText("");
				vista.txtkey.setText("");
			}
			
			if(vista.txtuser.getText().length() > 1 && vista.txtkey.getText().length() > 1) 
			{
				credencial = new credenciales (Integer.parseInt(vista.txtempleado.getText()), 
												vista.txtuser.getText(), 
												vista.txtkey.getText());
				
				credencial.ingresarCredenciales(credencial);
				JOptionPane.showMessageDialog(null, "Registro Exitoso");
				
				vista.txtuser.setText("");
				vista.txtkey.setText("");
				vista.dispose();
			}
		}
	}

}
