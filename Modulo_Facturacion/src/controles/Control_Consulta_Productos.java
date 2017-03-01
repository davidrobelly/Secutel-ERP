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
import modelo_clases.Producto;
import pantallas.Consulta_Productos;
import pantallas.Tabla_Clientes;
import pantallas.Tabla_Productos;

public class Control_Consulta_Productos implements ActionListener, MouseListener, KeyListener{
	
	private Consulta_Productos vista;
	Producto producto;
	String nombre;

	public Control_Consulta_Productos (Consulta_Productos vista)
	{
		this.vista = vista;
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

	@Override
	public void mouseClicked(MouseEvent e) {
		
		Object boton = e.getSource();
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
	public void actionPerformed(ActionEvent e) {

		Object boton = e.getSource();
		
		if(boton == vista.radioMarca)
		{
			vista.txtnombre.setEnabled(false);
			vista.txtnombre.setText("");
			vista.txtmodelo.setEnabled(false);
			vista.txtmodelo.setText("");
			vista.btnmodelo.setEnabled(false);
			vista.btnnombre.setEnabled(false);
			vista.txtmarca.setEnabled(true);
			vista.btnmarca.setEnabled(true);
			vista.txtmarca.setText("");
			Tabla_Productos tCliente = new Tabla_Productos();
			vista.tableProductos.setModel(tCliente);
			vista.tableProductos.updateUI();
		}
		
		if(boton == vista.radioNombre)
		{
			vista.txtmarca.setEnabled(false);
			vista.txtmarca.setText("");
			vista.btnmarca.setEnabled(false);
			vista.txtmodelo.setEnabled(false);
			vista.txtmodelo.setText("");
			vista.btnmodelo.setEnabled(false);
			vista.txtnombre.setEnabled(true);
			vista.btnnombre.setEnabled(true);
			vista.txtnombre.setText("");
			Tabla_Productos tCliente = new Tabla_Productos();
			vista.tableProductos.setModel(tCliente);
			vista.tableProductos.updateUI();
		}
		
		if(boton == vista.radioModelo)
		{
			vista.txtnombre.setEnabled(false);
			vista.txtnombre.setText("");
			vista.txtmodelo.setEnabled(true);
			vista.txtmodelo.setText("");
			vista.btnmodelo.setEnabled(true);
			vista.btnnombre.setEnabled(false);
			vista.txtmarca.setEnabled(false);
			vista.btnmarca.setEnabled(false);
			vista.txtmarca.setText("");
			Tabla_Productos tCliente = new Tabla_Productos();
			vista.tableProductos.setModel(tCliente);
			vista.tableProductos.updateUI();
		}
		
		if (boton == vista.btnnombre) {
			nombre = vista.txtnombre.getText();
			if ("".equals(nombre)) {
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
				vista.txtnombre.setText("");
			}else{
				producto = new Producto();
				ArrayList<Producto> lisCliente = producto.listaProductosxNombre(nombre);
				Tabla_Productos tcliente = new Tabla_Productos(lisCliente);
				vista.tableProductos.removeAll();
				vista.tableProductos.setModel(tcliente);
				vista.tableProductos.updateUI();
			}
		}
		
		if (boton == vista.btnmarca) {
			nombre = vista.txtmarca.getText();
			if ("".equals(nombre)) {
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
				vista.txtmarca.setText("");
			}else{
				producto= new Producto();
				ArrayList<Producto> lisCliente = producto.listaProductosxMarca(nombre);
				Tabla_Productos tcliente = new Tabla_Productos(lisCliente);
				vista.tableProductos.removeAll();
				vista.tableProductos.setModel(tcliente);
				vista.tableProductos.updateUI();
			}
		}
		
		if (boton == vista.btnmodelo) {
			nombre = vista.txtmodelo.getText();
			if ("".equals(nombre)) {
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
				vista.txtmodelo.setText("");
			}else{
				producto= new Producto();
				ArrayList<Producto> lisCliente = producto.listaProductosxModelo(nombre);
				Tabla_Productos tcliente = new Tabla_Productos(lisCliente);
				vista.tableProductos.removeAll();
				vista.tableProductos.setModel(tcliente);
				vista.tableProductos.updateUI();
			}
		}
		
	}

}
