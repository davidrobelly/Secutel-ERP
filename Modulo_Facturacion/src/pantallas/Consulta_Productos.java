package pantallas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controles.Control_Consulta_Clientes;
import controles.Control_Consulta_Productos;

public class Consulta_Productos extends JFrame{
	
	public JPanel panelNorte,panelCentro, panelSur;
	public JRadioButton radioNombre,radioMarca, radioModelo;
	public JTextField txtnombre,txtmarca, txtmodelo;
	public JButton btngenrep, btngenerar,
				btnnombre,btnmarca, btnmodelo;
	public ButtonGroup grupo, grupo2;
	public Tabla_Productos productos;
	public JTable tableProductos;
	public JScrollPane scrollPro;
	public Ventana_Detalle_Factura objeto;
	
	GridBagLayout grid;
	GridBagConstraints con;
	
	Control_Consulta_Productos control;
	
	public Consulta_Productos(Ventana_Detalle_Factura objeto){
		
		this.objeto = objeto;
		
		//esta es la parte de tabla
		productos = new Tabla_Productos ();
		tableProductos = new JTable (productos);
		tableProductos.getTableHeader().setReorderingAllowed(false);
		scrollPro = new JScrollPane(tableProductos);
		
		radioNombre = new JRadioButton("Nombre: ");
		radioMarca = new JRadioButton("Marca: ");
		radioModelo = new JRadioButton("Modelo: ");
		
		btnnombre = new JButton("Buscar");
		btnnombre.setEnabled(false);
		btnmarca = new JButton("Buscar");
		btnmarca.setEnabled(false);
		btnmodelo = new JButton ("Buscar");
		btnmodelo.setEnabled(false);
		
		initcomponents();
		ventana();
		
		control = new Control_Consulta_Productos(this);
		
		this.getContentPane().add(panelNorte, "North");
		this.getContentPane().add(panelCentro, "Center");
		this.getContentPane().add(panelSur, "South");
		
		
		panelNorte.setLayout(grid);
		con.weightx = 1;
		con.weighty = 1;
		con.anchor = GridBagConstraints.WEST;
		con.insets = new Insets(10, 5,10, 5);
		con.fill = GridBagConstraints.BOTH;
		
		buildConstraints(con, 0, 0, 1, 1);
		grid.setConstraints(radioNombre, con);
		buildConstraints(con, 1, 0, 1, 1);
		grid.setConstraints(txtnombre, con);
		buildConstraints(con, 2, 0, 1, 1);
		grid.setConstraints(btnnombre, con);
		
		buildConstraints(con, 0, 1, 1, 1);
		grid.setConstraints(radioMarca, con);
		buildConstraints(con, 1, 1, 1, 1);
		grid.setConstraints(txtmarca, con);
		buildConstraints(con, 2, 1, 1, 1);
		grid.setConstraints(btnmarca, con);
		
		buildConstraints(con, 0, 2, 1, 1);
		grid.setConstraints(radioModelo, con);
		buildConstraints(con, 1, 2, 1, 1);
		grid.setConstraints(txtmodelo, con);
		buildConstraints(con, 2, 2, 1, 1);
		grid.setConstraints(btnmodelo, con);
		
		
		panelNorte.add(radioNombre);
		panelNorte.add(txtnombre);
		panelNorte.add(btnnombre);
		panelNorte.add(radioMarca);
		panelNorte.add(txtmarca);
		panelNorte.add(btnmarca);
		panelNorte.add(radioModelo);
		panelNorte.add(txtmodelo);
		panelNorte.add(btnmodelo);
		
		grupo2 = new ButtonGroup();
		grupo2.add(radioNombre);
		grupo2.add(radioMarca);
		grupo2.add(radioModelo);
		
		panelCentro.setLayout(grid);
		con.anchor = GridBagConstraints.CENTER;
		con.insets = new Insets(5, 5, 5, 5);
		con.fill = GridBagConstraints.BOTH;
		buildConstraints(con, 0, 1, 1, 1);
		
		grid.setConstraints(panelCentro, con);
        tableProductos.getTableHeader().setReorderingAllowed(false) ;
		scrollPro = new JScrollPane(tableProductos);
		buildConstraints(con, 0, 0, 1, 1);
		grid.setConstraints(scrollPro, con);
		panelCentro.add(scrollPro);
		
		con.insets = new Insets(10, 10, 10, 10);
		panelSur.setLayout(grid);

		
		//eventos
		tableProductos.addMouseListener(control);
		radioNombre.addActionListener(control);
		radioMarca.addActionListener(control);
		radioModelo.addActionListener(control);
		btnnombre.addActionListener(control);
		btnmarca.addActionListener(control);
		btnmodelo.addActionListener(control);

	}
	
	
	private void initcomponents() {
		
		grid = new GridBagLayout();
		con = new GridBagConstraints();
		
		productos = new Tabla_Productos();
		panelNorte = new JPanel();
		panelCentro = new JPanel();
		panelSur = new JPanel();
		
		txtnombre = new JTextField("", 10);
		txtnombre.setEnabled(false);
		txtmarca = new JTextField("", 10);
		txtmarca.setEnabled(false);
		txtmodelo = new JTextField("", 10);
		txtmodelo.setEnabled(false);
		
		
		panelNorte.setBorder(new TitledBorder(null, "Opciones de Busqueda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCentro.setBorder(new TitledBorder(null, "Productos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSur.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		
	}

	private void ventana() {
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setTitle("Busqueda de Productos");
		this.setVisible(true);
		
		this.setBounds(100, 100, 600, 450);
		this.setResizable(false);
		
	}

	void buildConstraints (GridBagConstraints gbc, int gx, int gy, int gw, int gh) {
		gbc.gridx 					= gx;
		gbc.gridy 					= gy;
		gbc.gridwidth 				= gw;
		gbc.gridheight 				= gh;
	}


}
