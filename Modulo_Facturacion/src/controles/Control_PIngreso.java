package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DBClases.HashTextTest;
import modelo_clases.Credenciales;
import modelo_clases.Empleado;
import pantallas.Pantalla_Ingreso;
import pantallas.Pantalla_Principal;
import pantallas.Pantalla_Sucursal;
import pantallas.Tabla_Clientes;
import pantallas.Tabla_Credenciales;

public class Control_PIngreso implements ActionListener{

	Pantalla_Ingreso vista;
	Credenciales credencial;
	Pantalla_Principal nuevaVentana;
	
	
	public Control_PIngreso (Pantalla_Ingreso vista)
	{
		this.vista = vista;
		credencial = new Credenciales();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		Object boton = e.getSource();
		
		if (boton == vista.btn_cancelar) 
		{
			vista.dispose();
		}
		
		if(boton == vista.btn_ingresar)
		{
			
			String user = vista.txt_usuario.getText();
			String key = null;
			
			HashTextTest sh1 = new HashTextTest ();
			
			try {
				key = sh1.sha1(vista.txt_contrase�a.getText());
			} catch (NoSuchAlgorithmException e1) {
				
				e1.printStackTrace();
			}
			
			if (vista.txt_usuario.getText().equals("") || 
					vista.txt_contrase�a.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
			}
			
			
			if (vista.txt_usuario.getText().length() >=1 && 
					vista.txt_contrase�a.getText().length() >= 1)
			{
				Credenciales credenciales = new Credenciales();
				ArrayList<Credenciales> lisCredenciales = credenciales.listaCredenciales();
				
				boolean estado = false;
				
				for (int i = 0; i < lisCredenciales.size(); i++) 
				{
					if (vista.txt_usuario.getText().equals("Administrador") && 
							vista.txt_contrase�a.getText().equals("secutelespol"))
					{
						Pantalla_Principal principal = new Pantalla_Principal();
						principal.setVisible(true);
						principal.txtempleado.setText("Administrador del Sistema");
						principal.txtmodulo.setText("Administrador");
						principal.txtlocal.setText("null");
						vista.dispose();
						JOptionPane.showMessageDialog(null, "Usted ha ingresado como T�cnico Administrador");
						estado = true;
					}
					
					if(lisCredenciales.get(i).getUser().equals(user) && 
							lisCredenciales.get(i).getKey().equals(key) &&
							lisCredenciales.get(i).getEstado().equals("a"))
					{
						JOptionPane.showMessageDialog(null, "Acceso Exitoso");
						int id = lisCredenciales.get(i).getIdempleado();
						Pantalla_Sucursal principal = new Pantalla_Sucursal();
						vista.dispose();
						estado = true;
						Empleado empleado = new Empleado ();
						ArrayList<Empleado> lisEmpleado = empleado.empleadoxid(id);
						principal.setEmpleado(lisEmpleado.get(0).getNombre());
						principal.setModulo(lisCredenciales.get(i).getModulo());
						
						principal.setIdempleado(id);
						
						break;
					}
				}
				
				if(estado == false)
				{
					JOptionPane.showMessageDialog(null, "Usuario y/o contrase�a incorrectos");
					vista.txt_usuario.setText("");
					vista.txt_contrase�a.setText("");
				}
		    }
		}

	}
}
