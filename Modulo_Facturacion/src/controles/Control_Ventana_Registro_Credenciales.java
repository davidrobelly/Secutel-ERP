package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DBClases.HashTextTest;
import modelo_clases.Cliente;
import modelo_clases.Credenciales;
import modelo_clases.Sucursal;
import pantallas.Ventana_Ingreso_Credenciales;
import pantallas.Ventana_Ingreso_Empleado;
import pantallas.Ventana_Ingreso_Sucursal;

public class Control_Ventana_Registro_Credenciales  implements ActionListener{

	Ventana_Ingreso_Credenciales vista;
	Credenciales credencial;
	
	public Control_Ventana_Registro_Credenciales(Ventana_Ingreso_Credenciales vista) {
		super();
		this.vista = vista;
	}
	
	
	@SuppressWarnings("static-access")
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
			boolean estado = false;
			credencial = new Credenciales();
			ArrayList<Credenciales> lisCliente = credencial.listaCredenciales();
			
			for (int i = 0; i < lisCliente.size(); i++) {
				
				if (vista.txtempleado.getText().equals(String.valueOf(lisCliente.get(i).getIdempleado())))
				{
					JOptionPane.showMessageDialog(null, "Usuario, ya tiene credenciales");
					vista.txtkey.setText(lisCliente.get(i).getUser());
					vista.txtkey.setText(lisCliente.get(i).getKey());
					estado = true;
					break;
				}
			}
			
			
			if (vista.txtuser.getText() == "" || vista.txtkey.getText() == "")
			{
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
				vista.txtuser.setText("");
				vista.txtkey.setText("");
			}
			
			if(vista.txtuser.getText().length() > 1 && vista.txtkey.getText().length() > 1 
					&& estado == false) 
			{
				HashTextTest sh1 = new HashTextTest();
				String clave = null;
				
				try {
					clave = sh1.sha1(vista.txtkey.getText());
				} catch (NoSuchAlgorithmException e1) {
	
					e1.printStackTrace();
				}
				
				credencial = new Credenciales (Integer.parseInt(vista.txtempleado.getText()), 
												vista.txtuser.getText(), clave, (String) vista.cmbmodulo.getSelectedItem());
				
				credencial.ingresarCredenciales(credencial);
				JOptionPane.showMessageDialog(null, "Registro Exitoso");
				
				vista.txtuser.setText("");
				vista.txtkey.setText("");
				vista.dispose();
			}
		}
	}

}
