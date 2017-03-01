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
import pantallas.Consultar_Clientes;
import pantallas.Modificar_Clientes;
import pantallas.Tabla_Clientes;
import pantallas.Tabla_Clientes_Id;
import pantallas.Ventana_Ingreso_Clientes;

public class Control_Consulta_Clientes implements ActionListener,KeyListener,MouseListener{

	final int limite = 10;
	Consultar_Clientes vista;
	Ventana_Ingreso_Clientes modificar;
	Cliente cliente;
	String nombre;
	String numero;
	
	public Control_Consulta_Clientes (Consultar_Clientes vista)
	{
		this.vista=vista;
	} 
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object boton = e.getSource();
		 
		if(boton == vista.radioApellido)
		{
			vista.txtnombre.setEnabled(false);
			vista.txtnombre.setText("");
			vista.txtcedula.setEnabled(false);
			vista.txtcedula.setText("");
			vista.btncedula.setEnabled(false);
			vista.btnnombre.setEnabled(false);
			vista.txtapellido.setEnabled(true);
			vista.btnapellido.setEnabled(true);
			vista.txtapellido.setText("");
			Tabla_Clientes tCliente = new Tabla_Clientes();
			vista.tableCliente.setModel(tCliente);
			vista.tableCliente.updateUI();
		}
		
		if(boton == vista.radioNombre)
		{
			vista.txtapellido.setEnabled(false);
			vista.txtapellido.setText("");
			vista.btnapellido.setEnabled(false);
			vista.txtcedula.setEnabled(false);
			vista.txtcedula.setText("");
			vista.btncedula.setEnabled(false);
			vista.txtnombre.setEnabled(true);
			vista.btnnombre.setEnabled(true);
			vista.txtnombre.setText("");
			Tabla_Clientes tCliente = new Tabla_Clientes();
			vista.tableCliente.setModel(tCliente);
			vista.tableCliente.updateUI();
		}
		
		if(boton == vista.radioCedula)
		{
			vista.txtnombre.setEnabled(false);
			vista.txtnombre.setText("");
			vista.txtcedula.setEnabled(true);
			vista.txtcedula.setText("");
			vista.btncedula.setEnabled(true);
			vista.btnnombre.setEnabled(false);
			vista.txtapellido.setEnabled(false);
			vista.btnapellido.setEnabled(false);
			vista.txtapellido.setText("");
			Tabla_Clientes tCliente = new Tabla_Clientes();
			vista.tableCliente.setModel(tCliente);
			vista.tableCliente.updateUI();
		}
		
		if (boton == vista.btnnombre) {
			nombre = vista.txtnombre.getText();
			if ("".equals(nombre)) {
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
				vista.txtnombre.setText("");
			}else{
				cliente = new Cliente();
				ArrayList<Cliente> lisCliente = cliente.listaClientexNombre(nombre);
				Tabla_Clientes tcliente = new Tabla_Clientes(lisCliente);
				vista.tableCliente.removeAll();
				vista.tableCliente.setModel(tcliente);
				vista.tableCliente.updateUI();
			}
		}
		
		if (boton == vista.btncedula) {
			numero = vista.txtcedula.getText();
			if ("".equals(numero)) {
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
				vista.txtcedula.setText("");
			}else{
				cliente = new Cliente();
				ArrayList<Cliente> lisCliente = cliente.listaClientesxCedula(numero);
				Tabla_Clientes tcliente = new Tabla_Clientes(lisCliente);
				vista.tableCliente.removeAll();
				vista.tableCliente.setModel(tcliente);
				vista.tableCliente.updateUI();
			}
		}
		
		if (boton == vista.btnapellido) {
			nombre = vista.txtapellido.getText();
			if ("".equals(nombre)) {
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
				vista.txtapellido.setText("");
			}else{
				cliente = new Cliente();
				ArrayList<Cliente> lisCliente = cliente.listaClientesxApellido(nombre);
				Tabla_Clientes tcliente = new Tabla_Clientes(lisCliente);
				vista.tableCliente.removeAll();
				vista.tableCliente.setModel(tcliente);
				vista.tableCliente.updateUI();
			}
		}
		
		if (boton == vista.btngenerar) 
			{
				cliente = new Cliente();
				ArrayList<Cliente> lisCliente = cliente.listaClientes();
				Tabla_Clientes tcliente = new Tabla_Clientes(lisCliente);
				vista.tableCliente.removeAll();
				vista.tableCliente.setModel(tcliente);
				vista.tableCliente.updateUI();
			}
		
		//consulta clientes para facturas
		
		if(boton == vista.radioApellido2)
		{
			vista.txtnombre.setEnabled(false);
			vista.txtnombre.setText("");
			vista.txtcedula.setEnabled(false);
			vista.txtcedula.setText("");
			vista.btncedula2.setEnabled(false);
			vista.btnnombre2.setEnabled(false);
			vista.txtapellido.setEnabled(true);
			vista.btnapellido2.setEnabled(true);
			vista.txtapellido.setText("");
			Tabla_Clientes_Id tCliente = new Tabla_Clientes_Id();
			vista.tableCliente2.setModel(tCliente);
			vista.tableCliente2.updateUI();
		}
		
		if(boton == vista.radioNombre2)
		{
			vista.txtapellido.setEnabled(false);
			vista.txtapellido.setText("");
			vista.btnapellido2.setEnabled(false);
			vista.txtcedula.setEnabled(false);
			vista.txtcedula.setText("");
			vista.btncedula2.setEnabled(false);
			vista.txtnombre.setEnabled(true);
			vista.btnnombre2.setEnabled(true);
			vista.txtnombre.setText("");
			Tabla_Clientes_Id tCliente = new Tabla_Clientes_Id();
			vista.tableCliente2.setModel(tCliente);
			vista.tableCliente2.updateUI();
		}
		
		if(boton == vista.radioCedula2)
		{
			vista.txtnombre.setEnabled(false);
			vista.txtnombre.setText("");
			vista.txtcedula.setEnabled(true);
			vista.txtcedula.setText("");
			vista.btncedula2.setEnabled(true);
			vista.btnnombre2.setEnabled(false);
			vista.txtapellido.setEnabled(false);
			vista.btnapellido2.setEnabled(false);
			vista.txtapellido.setText("");
			Tabla_Clientes_Id tCliente = new Tabla_Clientes_Id();
			vista.tableCliente2.setModel(tCliente);
			vista.tableCliente2.updateUI();
		}
		
		if (boton == vista.btnnombre2) {
			nombre = vista.txtnombre.getText();
			if ("".equals(nombre)) {
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
				vista.txtnombre.setText("");
			}else{
				cliente = new Cliente();
				ArrayList<Cliente> lisCliente = cliente.listaClientexNombreid(nombre);
				Tabla_Clientes_Id tcliente = new Tabla_Clientes_Id(lisCliente);
				vista.tableCliente2.removeAll();
				vista.tableCliente2.setModel(tcliente);
				vista.tableCliente2.updateUI();
			}
		}
		
		if (boton == vista.btncedula2) {
			numero = vista.txtcedula.getText();
			if ("".equals(numero)) {
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
				vista.txtcedula.setText("");
			}else{
				cliente = new Cliente();
				ArrayList<Cliente> lisCliente = cliente.listaClientesxCedulaid(numero);
				Tabla_Clientes_Id tcliente = new Tabla_Clientes_Id(lisCliente);
				vista.tableCliente2.removeAll();
				vista.tableCliente2.setModel(tcliente);
				vista.tableCliente2.updateUI();
			}
		}
		
		if (boton == vista.btnapellido2) {
			nombre = vista.txtapellido.getText();
			if ("".equals(nombre)) {
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
				vista.txtapellido.setText("");
			}else{
				cliente = new Cliente();
				ArrayList<Cliente> lisCliente = cliente.listaClientesxApellidoid(nombre);
				Tabla_Clientes_Id tcliente = new Tabla_Clientes_Id(lisCliente);
				vista.tableCliente2.removeAll();
				vista.tableCliente2.setModel(tcliente);
				vista.tableCliente2.updateUI();
			}
		}
		
		if (boton == vista.btngenerar2) 
			{
				cliente = new Cliente();
				ArrayList<Cliente> lisCliente = cliente.listaClientesId();
				Tabla_Clientes_Id tcliente = new Tabla_Clientes_Id(lisCliente);
				vista.tableCliente2.removeAll();
				vista.tableCliente2.setModel(tcliente);
				vista.tableCliente2.updateUI();
			}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		Object boton = e.getSource();
		
		if (boton == vista.tableCliente) 
		{
			modificar = new Ventana_Ingreso_Clientes();
			int fila = vista.tableCliente.rowAtPoint(e.getPoint());
	        modificar.txtnombre.setText(vista.tableCliente.getValueAt(fila, 0).toString());
	        modificar.txtapellido.setText(vista.tableCliente.getValueAt(fila, 1).toString());
	        modificar.txtcedula.setText(vista.tableCliente.getValueAt(fila, 2).toString());
	        modificar.txttelefono.setText(vista.tableCliente.getValueAt(fila, 3).toString());
	        modificar.txtcorreo.setText(vista.tableCliente.getValueAt(fila, 4).toString());
	        modificar.txtdireccion.setText(vista.tableCliente.getValueAt(fila, 5).toString());
	        modificar.cmbtipo.setSelectedItem(vista.tableCliente.getValueAt(fila, 6).toString());
	        
	        String valor = vista.tableCliente.getValueAt(fila, 7).toString();
	        
	        if (valor.equals("i"))
	        {
	        	modificar.cmbestado.setSelectedItem("Inactivo");
	        }
	        else {
	    		modificar.cmbestado.setSelectedItem("Activo");
	    	}
	        
	        modificar.setTitle("Información del Cliente");
	        modificar.txtapellido.setEditable(false);
	        modificar.txtnombre.setEditable(false);
	        modificar.txtcedula.setEditable(false);
	        modificar.txttelefono.setEditable(false);
	        modificar.txtdireccion.setEditable(false);
	        modificar.txtcorreo.setEditable(false);
	        modificar.cmbestado.setEnabled(false);
	        modificar.cmbtipo.setEnabled(false);
	        
	        modificar.PanelBotones.removeAll();
		}
		
		if (boton == vista.tableCliente2)
		{
			int fila = vista.tableCliente2.rowAtPoint(e.getPoint());
	        String h = vista.tableCliente2.getValueAt(fila, 1).toString();
	        vista.objeto.txtcliente.setText(h);
	        vista.objeto.txttelefono.setText(vista.tableCliente2.getValueAt(fila, 3).toString());
	        vista.objeto.txtruc.setText(vista.tableCliente2.getValueAt(fila, 4).toString());
	        //aqui guardo el id del cliente para almacenarlo en la factura
	        vista.objeto.setCliente(Integer.parseInt(vista.tableCliente2.getValueAt(fila, 0).toString()));
		}
       
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		
		
	}



	@Override
	public void mouseExited(MouseEvent arg0) {
		
		
	}



	@Override
	public void mousePressed(MouseEvent arg0) {
		
		
	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		
	}



	@Override
	public void keyPressed(KeyEvent arg0) {
		
		
	}



	@Override
	public void keyReleased(KeyEvent arg0) {
		
		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		if (limite == vista.txtcedula.getText().length()){
		     e.consume();
		}
		char caracter = e.getKeyChar();
		if(Character.isDigit(caracter)){
		}else{
			e.consume();
		}
		
	}

}
