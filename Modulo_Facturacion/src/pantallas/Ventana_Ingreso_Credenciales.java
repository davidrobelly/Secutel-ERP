package pantallas;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controles.Control_Ventana_Registro_Credenciales;

public class Ventana_Ingreso_Credenciales extends JFrame{

	Control_Ventana_Registro_Credenciales control; 
	
	public JPanel PanelCentral, PanelBotones;
	public JButton btnregistrar, btncancelar, btnborrar;
	public JLabel lblempleado, lbluser, lblkey, lblestado;  
	public JTextField txtempleado, txtuser, txtkey;
	public JComboBox cmbestado;
	
public Ventana_Ingreso_Credenciales () {
	
	initcomponents();
	ventana();
	control = new Control_Ventana_Registro_Credenciales(this);
	
	PanelCentral.setLayout(new GridLayout(4,2));
	PanelBotones.setLayout(new GridLayout(0,3));
	
	//panel de Botones
	PanelBotones.add(btnregistrar);
	PanelBotones.add(btnborrar);
	PanelBotones.add(btncancelar);
	
	//panel de formulario
	PanelCentral.add(lblempleado);
	PanelCentral.add(txtempleado);
	PanelCentral.add(lbluser);
	PanelCentral.add(txtuser);
	PanelCentral.add(lblkey);
	PanelCentral.add(txtkey);
	PanelCentral.add(lblestado);
	PanelCentral.add(cmbestado);
	
	this.getContentPane().add(PanelCentral, "Center");
	this.getContentPane().add(PanelBotones, "South");
	
	//eventos
	btnregistrar.addActionListener(control);
	btncancelar.addActionListener(control);
	btnborrar.addActionListener(control);
}
	
private void ventana() {
		
		this.setLocationRelativeTo(null);
		this.pack();
		this.setTitle("Credenciales de Usuario");
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(500, 200);
		this.setLocation(500, 200);
		this.setResizable(false);
		
	}

private void initcomponents () {
	
	PanelCentral = new JPanel();
	PanelBotones = new JPanel();
	
	Border bordejpanel = new TitledBorder(new EtchedBorder(), "Ingrese las Credenciales ");
	PanelCentral.setBorder(bordejpanel);
	
	Border bordejpane2 = new TitledBorder(new EtchedBorder(), "");
	PanelBotones.setBorder(bordejpane2);
	
	this.setBackground(Color.white);
	
	btnregistrar = new JButton("Registrar");
	btncancelar = new JButton("Cancelar");
	btnborrar = new JButton("Borrar");
	
	txtuser = new JTextField("");
	txtkey = new JTextField("");
	txtempleado = new JTextField("");
	
	
	cmbestado = new JComboBox ();
	cmbestado.addItem("Activo");
	cmbestado.addItem("Inactivo");
	cmbestado.setEditable(false);
	
	
	lblempleado = new JLabel("Empleado: ");
	lbluser = new JLabel("Usuario: ");
	lblkey = new JLabel("Clave: ");
	lblestado = new JLabel ("Estado: ");
	
}
}
