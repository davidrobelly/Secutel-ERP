package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo_clases.Empleado;
import modelo_clases.Sucursal;
import pantallas.Consultar_Locales;
import pantallas.Tabla_Empleados;
import pantallas.Tabla_Locales;
import pantallas.Ventana_Ingreso_Clientes;
import pantallas.Ventana_Ingreso_Sucursal;

public class Control_Consultar_Locales implements ActionListener, MouseListener, KeyListener{

	Consultar_Locales vista;
	final int limite = 10;
	String nombre;
	String numero;
	Sucursal local;
	Ventana_Ingreso_Sucursal modificar;
	
	public Control_Consultar_Locales(Consultar_Locales vista) {
		this.vista=vista;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object boton = e.getSource();
		 
		
		if(boton == vista.radiociudad)
		{
			vista.txtciudad.setEnabled(true);
			vista.btnciudad.setEnabled(true);
			vista.txtciudad.setText("");
			Tabla_Locales tLocales = new Tabla_Locales();
			vista.tableLocales.setModel(tLocales);
			vista.tableLocales.updateUI();
		}
		
		
		if (boton == vista.btnciudad) {
			nombre = vista.txtciudad.getText();
			if ("".equals(nombre)) {
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
				vista.txtciudad.setText("");
			}else{
				local = new Sucursal();
				ArrayList<Sucursal> lisLocal = local.listaLocalxCiudad(nombre);
				Tabla_Locales tlocal = new Tabla_Locales(lisLocal);
				vista.tableLocales.removeAll();
				vista.tableLocales.setModel(tlocal);
				vista.tableLocales.updateUI();
			}
		}
		
		if (boton == vista.btngenerar) 
			{
			local = new Sucursal();
			ArrayList<Sucursal> lisLocal = local.listaSucursales();
			Tabla_Locales tlocal = new Tabla_Locales(lisLocal);
			vista.tableLocales.removeAll();
			vista.tableLocales.setModel(tlocal);
			vista.tableLocales.updateUI();
			}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		modificar = new Ventana_Ingreso_Sucursal();
		int fila = vista.tableLocales.rowAtPoint(e.getPoint());
        modificar.txtnombre.setText(vista.tableLocales.getValueAt(fila, 0).toString());
        modificar.txtdireccion.setText(vista.tableLocales.getValueAt(fila, 1).toString());
        modificar.txtciudad.setText(vista.tableLocales.getValueAt(fila, 2).toString());
        
        String valor = vista.tableLocales.getValueAt(fila, 3).toString();
        
        if (valor.equals("i"))
        {
        	modificar.cmbestado.setSelectedItem("Inactivo");
        }
        else {
    		modificar.cmbestado.setSelectedItem("Activo");
    	}
        
       modificar.remove(modificar.PanelBotones);
       modificar.setTitle("Información del Local");
       modificar.txtdireccion.setEditable(false);
       modificar.txtnombre.setEditable(false);
       modificar.txtciudad.setEditable(false);
       modificar.cmbestado.setEnabled(false);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		if (limite == vista.txtciudad.getText().length()){
		     e.consume();
		}
		char caracter = e.getKeyChar();
		if(Character.isDigit(caracter)){
		}else{
			e.consume();
		}
	}

}
