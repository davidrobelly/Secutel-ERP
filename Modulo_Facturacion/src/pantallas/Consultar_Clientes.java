package pantallas;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Consultar_Clientes extends JFrame{
	
	JPanel panelNorte,panelCentro, panelSur;
	JRadioButton radioNombre,radioCedula;
	JTextField txtOpNom,txtOpRuc;
	JButton OpNom,OpCed;
	ButtonGroup grupo;
	Tabla_Clientes clientes;
	JTable tablePro;
	JScrollPane scrollPro;
	JLabel lbltexto;
	//ControladorBuscarProveedor controlBP;
	
	
	
	public Consultar_Clientes() {
		
		initcomponents();
		ventana();
		
		panelNorte.setLayout(new GridLayout(2,3));
		panelNorte.add(radioNombre);
		panelNorte.add(txtOpNom);
		panelNorte.add(OpNom);
		panelNorte.add(radioCedula);
		panelNorte.add(txtOpRuc);
		panelNorte.add(OpCed);
		
		
		panelSur.setLayout(new GridLayout(0,1));
		panelSur.add(scrollPro);
		
		
		
		
		this.getContentPane().add(panelNorte, "North");
		this.getContentPane().add(panelSur, "South");
	}
	
	private void initcomponents() {
		
		lbltexto = new JLabel("Registro de Clientes");
		
		panelNorte = new JPanel();
		panelCentro = new JPanel();
		panelSur = new JPanel();
		
		txtOpNom = new JTextField();
		txtOpRuc = new JTextField();
		
		radioNombre = new JRadioButton("Nombre: ");
		radioCedula = new JRadioButton("C�dula: ");
		
		OpNom = new JButton("Buscar");
		OpCed = new JButton("Buscar");
		
		//esta es la parte de tabla
		clientes = new Tabla_Clientes ();
		tablePro = new JTable (clientes);
		tablePro.getTableHeader().setReorderingAllowed(false);
		scrollPro = new JScrollPane(tablePro);
		
		panelNorte.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCentro.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSur.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		
	}

	private void ventana() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//controlBP = new ControladorBuscarProveedor(this);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setTitle("Consultar Clientes");
		this.setVisible(true);
		this.setLocation(500, 200);
		this.setSize(650, 450);
		
	}



}
