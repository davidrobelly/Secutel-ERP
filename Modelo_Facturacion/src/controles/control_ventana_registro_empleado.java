package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JOptionPane;

import pantallas.ventana_ingreso_credenciales;
import pantallas.ventana_ingreso_empleado;
import modelo_clases.cliente;
import modelo_clases.credenciales;
import modelo_clases.empleado;
import modelo_clases.sucursal;

public class control_ventana_registro_empleado implements ActionListener {

	ventana_ingreso_empleado vista;
	empleado empleado;

	public control_ventana_registro_empleado(ventana_ingreso_empleado vista) {
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
			vista.txtfecha.setText("");
		}
		
		if (boton == vista.btnregistrar)
		{	
			
			
			if (vista.txtnombre.getText().equals("") || vista.txtdireccion.getText().equals("")
					|| vista.txttelefono.getText().equals("") || vista.txtcedula.getText().equals("")
					|| vista.txtfecha.getText().equals("")) 
			{
				
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
			
			}
			
			if (vista.txtfecha.getText().length() >=18 ){
				
			}
			
			String cadena = "15";
			
			if (vista.txtfecha.getText().length()>1)
			 {
				cadena = vista.txtfecha.getText();
			}
			
			int edad = 0;
			edad = Integer.parseInt(cadena);

			
			if (edad < 18 || edad > 45 )
			{
				JOptionPane.showMessageDialog(null, "edad no permitida");
				vista.txtfecha.setText("");
			}
			
			if (vista.txtnombre.getText().length() > 10 && vista.txtdireccion.getText().length() > 5
					&& vista.txttelefono.getText().length() > 9 && vista.txtcedula.getText().length() > 9
					&& vista.txtfecha.getText().length() > 1) 
			{
				empleado = new empleado (vista.txtnombre.getText(), vista.txtcedula.getText(), 
						vista.txttelefono.getText(), vista.txtdireccion.getText(), edad,
						(String) vista.cmbtipo.getSelectedItem());
				
				empleado.ingresarEmppleado(empleado);
			
				JOptionPane.showMessageDialog(null, "Registro Exitoso");
				
				ventana_ingreso_credenciales credencial = new ventana_ingreso_credenciales();
				credencial.txtempleado.setText(vista.txtcedula.getText());
				credencial.txtempleado.setEditable(false);
				
			}
			
		}
		
	}

	
	
}
