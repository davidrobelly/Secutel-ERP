package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo_clases.Sucursal;
import pantallas.Consultar_Local_Modificar;
import pantallas.Modificar_Locales;
import pantallas.Tabla_Locales;
import pantallas.Tabla_Locales_Id;
import pantallas.Ventana_Ingreso_Sucursal;

public class Control_Modif_Consultar_Locales implements ActionListener,KeyListener, MouseListener {
	
	Consultar_Local_Modificar vista;
	Modificar_Locales modificar;
	String nombre;
	String numero;
	Sucursal local;
	final int limite = 10;

	public Control_Modif_Consultar_Locales(Consultar_Local_Modificar vista) {
		
		this.vista= vista;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		modificar = new Modificar_Locales();
		int fila = vista.tableLocales.rowAtPoint(e.getPoint());
        modificar.txtid.setText(vista.tableLocales.getValueAt(fila, 0).toString());
        modificar.txtnombre.setText(vista.tableLocales.getValueAt(fila, 1).toString());
        modificar.txtdireccion.setText(vista.tableLocales.getValueAt(fila, 2).toString());
        modificar.txtciudad.setText(vista.tableLocales.getValueAt(fila, 3).toString());
        
        String valor = vista.tableLocales.getValueAt(fila, 4).toString();
        
        if (valor.equals("i"))
        {
        	modificar.cmbestado.setSelectedItem("Inactivo");
        }
        else {
    		modificar.cmbestado.setSelectedItem("Activo");
    	}
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
	public void actionPerformed(ActionEvent e) {
		
		Object boton = e.getSource();
		
		if(boton == vista.radioCiudad)
		{
			vista.txtCiudad.setEnabled(true);
			vista.btnCiudad.setEnabled(true);
			vista.txtCiudad.setText("");
			Tabla_Locales_Id tLocales = new Tabla_Locales_Id();
			vista.tableLocales.setModel(tLocales);
			vista.tableLocales.updateUI();
		}
	
		
		if (boton == vista.btnCiudad) {
			numero = vista.txtCiudad.getText();
			if ("".equals(numero)) {
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
				vista.txtCiudad.setText("");
			}else{
				local = new Sucursal();
				ArrayList<Sucursal> lisLocal = local.listaLocalxCiudadid(numero);
				Tabla_Locales_Id tlocal = new Tabla_Locales_Id(lisLocal);
				vista.tableLocales.removeAll();
				vista.tableLocales.setModel(tlocal);
				vista.tableLocales.updateUI();
			}
		}
		
		
	}

}
