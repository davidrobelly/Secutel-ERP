package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import modelo_clases.Cliente;
import modelo_clases.Credenciales;
import pantallas.Pantalla_Principal;
import pantallas.Ventana_Ingreso_Clientes;

public class Control_Ventana_Registro_Cliente implements ActionListener, KeyListener {
	
	Ventana_Ingreso_Clientes vista;
	Cliente cliente;

	public Control_Ventana_Registro_Cliente(Ventana_Ingreso_Clientes vista) {
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
			vista.txtapellido.setText(""); 
			vista.txttelefono.setText(""); 
			vista.txtdireccion.setText(""); 
			vista.txtcedula.setText(""); 
			vista.txtcorreo.setText(""); 
		}
		
		if (boton == vista.btnregistrar)
		{
			boolean estado = false;
			cliente = new Cliente();
			ArrayList<Cliente> lisCliente = cliente.listaClientes();
			
			for (int i = 0; i < lisCliente.size(); i++) 
			{
				if (vista.txtcedula.getText().equals(lisCliente.get(i).getCedula()))
				{
					estado = true;
					
					JOptionPane.showMessageDialog(null, "Cliente, ya est� registrado");
					vista.txtcedula.setText(lisCliente.get(i).getCedula());
					vista.txtnombre.setText(lisCliente.get(i).getNombre());
					vista.txtapellido.setText(lisCliente.get(i).getApellido());
					vista.txttelefono.setText(lisCliente.get(i).getTelefono());
					vista.txtdireccion.setText(lisCliente.get(i).getDireccion());
					vista.txtcorreo.setText(lisCliente.get(i).getCorreo());
					
					if (lisCliente.get(i).getEstado().equals("Activo"))
					{
						vista.cmbestado.setSelectedItem("Activo");
					}
						else
						{
							vista.cmbestado.setSelectedItem("Inactivo");
						}
				
				if (lisCliente.get(i).getTipo().equals("Mayorista"))
				{
					vista.cmbtipo.setSelectedItem("Mayorista");
				}
					else
					{
						vista.cmbtipo.setSelectedItem("Minorista");
					}
				}
			}
			
			
			if (vista.txtnombre.getText().equals("") || vista.txtapellido.getText().equals("") || 
					vista.txtdireccion.getText().equals("")
					|| vista.txttelefono.getText().equals("") || vista.txtcedula.getText().equals("")
					|| vista.txtcorreo.getText().equals("")) 
			{
				
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
			}
			
			if (vista.txtnombre.getText().length() >= 1 && vista.txtapellido.getText().length() >= 1 &&
					vista.txtdireccion.getText().length() >= 1
					&& vista.txttelefono.getText().length() <= 10 && vista.txtcedula.getText().length() == 10
					&& vista.txtcorreo.getText().length() >= 1 && estado == false) 
			{
				
				cliente = new Cliente (vista.txtnombre.getText(), vista.txtapellido.getText(), vista.txtcedula.getText()
						,vista.txttelefono.getText() ,vista.txtcorreo.getText() ,
						vista.txtdireccion.getText(),(String) vista.cmbtipo.getSelectedItem());
				
				cliente.ingresarCliente(cliente);
				
				JOptionPane.showMessageDialog(null, "Registro Exitoso");
				
				vista.txtnombre.setText(""); 
				vista.txttelefono.setText(""); 
				vista.txtdireccion.setText(""); 
				vista.txtcedula.setText(""); 
				vista.txtcorreo.setText(""); 
				vista.txtapellido.setText("");
			}
	
		}
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		

		
	}

}
