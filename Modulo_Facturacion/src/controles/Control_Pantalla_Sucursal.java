package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo_clases.Cliente;
import modelo_clases.Empleado;
import modelo_clases.Sucursal;
import pantallas.Pantalla_Principal;
import pantallas.Pantalla_Sucursal;

public class Control_Pantalla_Sucursal implements ActionListener, MouseListener {

	Pantalla_Sucursal vista;
	
	
	public Control_Pantalla_Sucursal (Pantalla_Sucursal vista){
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object boton = e.getSource();
		
		//otras ventanas
		
		if (boton == vista.btnescoger)
			{
				Pantalla_Principal principal = new Pantalla_Principal();
				principal.setVisible(true);
				principal.txtempleado.setText(vista.getEmpleado());
				principal.txtlocal.setText((String)vista.cmbSucursal.getSelectedItem());
				principal.txtmodulo.setText(vista.getModulo());
				
				if(vista.getModulo().equals("Administrador"))
				{
					principal.menuLocal.setEnabled(true);
					principal.menuCliente.setEnabled(true);
					principal.menuEmpleado.setEnabled(true);
					principal.menuCompras.setEnabled(true);
					principal.menuVentas.setEnabled(true);
					principal.menuInventario.setEnabled(true);
					principal.menuCerrarSesion.setEnabled(true);
					principal.menuSalir.setEnabled(true);
				}
				
				if(vista.getModulo().equals("Compras"))
				{
					principal.menuLocal.setEnabled(false);
					principal.menuCliente.setEnabled(true);
					principal.menuEmpleado.setEnabled(false);
					principal.menuCompras.setEnabled(true);
					principal.menuVentas.setEnabled(false);
					principal.menuInventario.setEnabled(false);
					principal.menuCerrarSesion.setEnabled(true);
					principal.menuSalir.setEnabled(true);
				}
				
				if(vista.getModulo().equals("Ventas"))
				{
					principal.menuLocal.setEnabled(false);
					principal.menuCliente.setEnabled(true);
					principal.menuEmpleado.setEnabled(false);
					principal.menuCompras.setEnabled(false);
					principal.menuVentas.setEnabled(true);
					principal.menuInventario.setEnabled(false);
					principal.menuCerrarSesion.setEnabled(true);
					principal.menuSalir.setEnabled(true);
				}
				
				if(vista.getModulo().equals("Inventario"))
				{
					principal.menuLocal.setEnabled(false);
					principal.menuCliente.setEnabled(true);
					principal.menuEmpleado.setEnabled(false);
					principal.menuCompras.setEnabled(false);
					principal.menuVentas.setEnabled(false);
					principal.menuInventario.setEnabled(true);
					principal.menuCerrarSesion.setEnabled(true);
					principal.menuSalir.setEnabled(true);
				}
				
				vista.dispose();
			}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void mouseClicked(MouseEvent e) {
	
		Object boton = e.getSource();
		Sucursal sucursal = new Sucursal ();
		ArrayList<Sucursal> lisSucursal = sucursal.listaSucursalesId();
		
		for (int i = 0; i < lisSucursal.size(); i++) 
		{
			vista.cmbSucursal.addItem(lisSucursal.get(i).getNombre());
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
	
	

}
