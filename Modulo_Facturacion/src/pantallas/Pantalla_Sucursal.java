package pantallas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controles.Control_PPrincipal;
import controles.Control_Pantalla_Sucursal;

public class Pantalla_Sucursal extends JFrame{
	
	public JPanel panelNorte, panelSur, panelCentral;
	public JLabel lblSucursal;
	public JComboBox cmbSucursal;
	public JButton btnescoger;
	
	public String empleado;
	public String modulo;
	public int idempleado;
	
	
	public int getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(int idempleado) {
		this.idempleado = idempleado;
	}

	public String getEmpleado() {
		return empleado;
	}

	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	Control_Pantalla_Sucursal control;
	
	public Pantalla_Sucursal (){
		
		ventana();
		initcomponents();
		
		control = new Control_Pantalla_Sucursal(this);
	
		this.getContentPane().add(panelCentral, BorderLayout.CENTER);
		this.getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		panelCentral.setLayout(new GridLayout(0 ,2 , 5, 5));
		panelCentral.add(lblSucursal);
		panelCentral.add(cmbSucursal);
		
		panelSur.setLayout(new GridLayout(0, 1, 5, 5));
		panelSur.add(btnescoger);
		
		btnescoger.addActionListener(control);
		cmbSucursal.addMouseListener((MouseListener) control);
	}

	private void initcomponents() {
		
		panelNorte = new JPanel();
		panelSur = new JPanel();
		panelCentral = new JPanel();
		
		lblSucursal = new JLabel ("Sucursal: ");
		
		cmbSucursal = new JComboBox();
		
		btnescoger = new JButton ("Escoger");
		
		panelNorte.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 5));
		panelCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 5));
	}

	private void ventana() {
		this.setLocationRelativeTo(null);
		this.pack();
		this.setTitle("Seleccione Local");
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(300, 100);
		this.setLocation(500, 200);
		this.setResizable(false);
		
	}

}
