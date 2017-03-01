package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo_clases.Cliente;
import modelo_clases.Empleado;
import modelo_clases.Factura;
import modelo_clases.Sucursal;
import pantallas.Consultar_Clientes;
import pantallas.Tabla_Clientes;
import pantallas.Tabla_Clientes_Id;
import pantallas.Tabla_Empleados_Id;
import pantallas.Tabla_Locales_Id;
import pantallas.Ventana_Detalle_Factura;
import pantallas.Ventana_Ingreso_Clientes;
import pantallas.Ventana_Ingreso_Factura;

public class Control_Ventana_Factura implements ActionListener, KeyListener, MouseListener{

	Ventana_Ingreso_Factura vista;
	Factura factura;
	
	
	public Control_Ventana_Factura(Ventana_Ingreso_Factura vista) {
		super();
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		Object boton = e.getSource();
		
		if (boton == vista.btnregprod) 
		{
			Ventana_Detalle_Factura detalle = new Ventana_Detalle_Factura ();
			detalle.txtfactura.setText(vista.txtcodigo.getText());
		}
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		Object boton = e.getSource();
		
		if (boton == vista.txtcliente)
		{
			Consultar_Clientes cliente = new Consultar_Clientes (vista);
			cliente.setBounds(200, 200, 600, 450);
		}
	
	}

	
	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

