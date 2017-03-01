package pantallas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controles.Control_Facturas;
import controles.Control_PPrincipal;

public class Pantalla_Facturas extends JFrame{
	
	JPanel panelBotones, panelgrafico;
	public JButton btnreg, btnmodif, btnconsul;
	GridBagLayout grid;
	GridBagConstraints con;
	Control_Facturas control;
	
	public Pantalla_Principal objeto;
	
	public Pantalla_Facturas (Pantalla_Principal objeto) {
		
		this.objeto = objeto;
		
		ventana();
		initcomponents();
		
		control = new Control_Facturas (this);
		
		this.getContentPane().add(panelBotones, "West");
		this.getContentPane().add(panelgrafico, "Center");
		
		panelBotones.setLayout(grid);
		con.weightx = 1;
		con.weighty = 1;
		con.anchor = GridBagConstraints.WEST;
		con.insets = new Insets(10, 5, 10, 5);
		con.fill = GridBagConstraints.BOTH;
		
		buildConstraints(con, 0, 0, 1, 1);
		grid.setConstraints(btnreg, con);
		buildConstraints(con, 0, 1, 1, 1);
		grid.setConstraints(btnconsul, con);
		buildConstraints(con, 0, 2, 1, 1);
		grid.setConstraints(btnmodif, con);
		
		panelBotones.add(btnreg);
		panelBotones.add(btnconsul);
		panelBotones.add(btnmodif);
		
		panelgrafico.setLayout(grid);
		con.anchor = GridBagConstraints.CENTER;
		con.insets = new Insets(5, 5, 5, 5);
		con.fill = GridBagConstraints.BOTH;
		
		//eventos
		
		btnreg.addActionListener(control);
		btnconsul.addActionListener(control);
		btnmodif.addActionListener(control);
		
	}
	
	private void ventana() {
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setTitle("Control de Facturas");
		this.setVisible(true);
		
		this.setBounds(100, 100, 400, 250);
		this.setResizable(false);
		
	}
	
	private void initcomponents () {
		
		grid = new GridBagLayout();
		con = new GridBagConstraints();
		
		panelBotones = new JPanel ();
		panelgrafico = new JPanel ();
		btnreg = new JButton("Registrar Factura");
		btnconsul = new JButton ("Consultar Facturas");
		btnmodif = new JButton ("Modificar Facturas");
		
		panelBotones.setBorder(new TitledBorder(null, "Control de Facturas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}

	void buildConstraints (GridBagConstraints gbc, int gx, int gy, int gw, int gh) {
		gbc.gridx 					= gx;
		gbc.gridy 					= gy;
		gbc.gridwidth 				= gw;
		gbc.gridheight 				= gh;
	}
	
}
