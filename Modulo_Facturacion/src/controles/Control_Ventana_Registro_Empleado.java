package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import pantallas.Ventana_Ingreso_Empleado;
import modelo_clases.Cliente;
import modelo_clases.Empleado;


public class Control_Ventana_Registro_Empleado implements ActionListener {

	Ventana_Ingreso_Empleado vista;
	Empleado empleado;

	public Control_Ventana_Registro_Empleado(Ventana_Ingreso_Empleado vista) {
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
			vista.txtedad.setText("");
			vista.txtapellido.setText("");
		}
		
		if (boton == vista.btnregistrar)
		{	
			boolean estado = false;
			empleado = new Empleado();
			ArrayList<Empleado> lisCliente = empleado.listaEmpleados();
			
			for (int i = 0; i < lisCliente.size(); i++) 
			{
				if (vista.txtcedula.getText().equals(lisCliente.get(i).getCedula()))
				{
					estado = true;
					
					JOptionPane.showMessageDialog(null, "Empleado, ya est� registrado");
					vista.txtcedula.setText(lisCliente.get(i).getCedula());
					vista.txtnombre.setText(lisCliente.get(i).getNombre());
					vista.txtapellido.setText(lisCliente.get(i).getApellido());
					vista.txttelefono.setText(lisCliente.get(i).getTelefono());
					vista.txtdireccion.setText(lisCliente.get(i).getDireccion());
					vista.txtedad.setText(String.valueOf(lisCliente.get(i).getEdad()));
					
					if (lisCliente.get(i).getEstado().equals("Activo"))
					{
						vista.cmbestado.setSelectedItem("Activo");
					}
						else
						{
							vista.cmbestado.setSelectedItem("Inactivo");
						}
				
				if (lisCliente.get(i).getTipo().equals("Administrador"))
				{
					vista.cmbtipo.setSelectedItem("Vendedor");
				}
					else
					{
						vista.cmbtipo.setSelectedItem("Minorista");
					}
				}

			if (vista.txtnombre.getText().equals("") || vista.txtdireccion.getText().equals("")
					|| vista.txttelefono.getText().equals("") || vista.txtcedula.getText().equals("")
					|| vista.txtedad.getText().equals("") || vista.txtapellido.equals("")) 
			{
				
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
			
			}
			
			if (vista.txtnombre.getText().length() >= 1 && vista.txtapellido.getText().length() >= 1
					&& vista.txtcedula.getText().length() == 10 && vista.txttelefono.getText().length() <= 10 &&
					vista.txtdireccion.getText().length() >= 1 && estado == false) 
			{
				if (Integer.parseInt(vista.txtedad.getText()) >= 18)
				{
				
				empleado = new Empleado (vista.txtnombre.getText(), vista.txtapellido.getText(), 
						vista.txtcedula.getText(), vista.txttelefono.getText(), vista.txtdireccion.getText(), 
						Integer.parseInt(vista.txtedad.getText()),(String) vista.cmbtipo.getSelectedItem());
				
				empleado.ingresarEmpleado(empleado);
			
				JOptionPane.showMessageDialog(null, "Registro Exitoso");
				
				vista.txtnombre.setText(""); 
				vista.txttelefono.setText(""); 
				vista.txtdireccion.setText(""); 
				vista.txtcedula.setText(""); 
				vista.txtedad.setText("");
				vista.txtapellido.setText("");
				}
				
				else {
					
					JOptionPane.showMessageDialog(null, "debe ser mayor de edad");
					vista.txtedad.setText("");
			}
			
			
			}
			
		}
		
	}
	}
}
