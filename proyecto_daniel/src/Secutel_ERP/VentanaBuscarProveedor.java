package Secutel_ERP;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class VentanaBuscarProveedor extends VentanaNuevoProveedor {
	
	JPanel panelElegir,panelPro;
	JRadioButton radioNombre,radioRuc;
	JTextField txtOpNom,txtOpRuc;
	JButton OpNom,OpRuc;
	ButtonGroup grupo;
	TablaProveedores proveedores;
	JTable tablePro;
	JScrollPane scrollPro;
	ControladorBuscarProveedor controlBP;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaBuscarProveedor frame = new VentanaBuscarProveedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public VentanaBuscarProveedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		setTitle("Busqueda Proveedor");
		controlBP = new ControladorBuscarProveedor(this);
		elementos();
	}
	public VentanaBuscarProveedor(ControladorBuscarProveedor cbp) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		setTitle("Busqueda Proveedor");
		controlBP = cbp;
		controlBP.venBP = this;
		elementos();
	}
	void elementos(){
		contentPane.removeAll();
		panelElegir = new JPanel();
		buildConstraints(con, 0, 0, 1, 1);
		grid.setConstraints(panelElegir, con);
		panelElegir.setLayout(grid);
		panelElegir.setBorder(new TitledBorder(null, "Opciones Proveedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		radioNombre = new JRadioButton("Nombre");
		radioNombre.addActionListener(controlBP);
		buildConstraints(con, 0, 0, 1, 1);
		con.fill = GridBagConstraints.HORIZONTAL;
		grid.setConstraints(radioNombre, con);
		panelElegir.add(radioNombre);
		txtOpNom = new JTextField("",10);
		txtOpNom.setEnabled(false);
		buildConstraints(con, 1, 0, 1, 1);
		grid.setConstraints(txtOpNom, con);
		panelElegir.add(txtOpNom);
		OpNom = new JButton("Buscar");
		OpNom.setEnabled(false);
		OpNom.addActionListener(controlBP);
		buildConstraints(con, 2, 0, 1, 1);
		grid.setConstraints(OpNom, con);
		panelElegir.add(OpNom);
		radioRuc = new JRadioButton("Ruc");
		radioRuc.addActionListener(controlBP);
		buildConstraints(con, 0, 1, 1, 1);
		grid.setConstraints(radioRuc, con);
		panelElegir.add(radioRuc);
		txtOpRuc = new JTextField("",10);
		txtOpRuc.setEnabled(false);
		txtOpRuc.addKeyListener(controlBP);
		buildConstraints(con, 1, 1, 1, 1);
		grid.setConstraints(txtOpRuc, con);
		panelElegir.add(txtOpRuc);
		
		OpRuc = new JButton("Buscar");
		OpRuc.setEnabled(false);
		OpRuc.addActionListener(controlBP);
		buildConstraints(con, 2, 1, 1, 1);
		grid.setConstraints(OpRuc, con);
		panelElegir.add(OpRuc);
		grupo = new ButtonGroup();
		grupo.add(radioNombre);
		grupo.add(radioRuc);
		panelPro = new JPanel();
		panelPro.setLayout(grid);
		panelPro.setBorder(new TitledBorder(null, "Proveedores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		buildConstraints(con, 0, 1, 1, 1);
		con.fill = GridBagConstraints.BOTH;
		grid.setConstraints(panelPro, con);
		proveedores = new TablaProveedores();
		tablePro  = new JTable(proveedores);
		tablePro.addMouseListener(controlBP);
        tablePro.getTableHeader().setReorderingAllowed(false) ;
		scrollPro = new JScrollPane(tablePro);
		buildConstraints(con, 0, 0, 1, 1);
		grid.setConstraints(scrollPro, con);
		panelPro.add(scrollPro);
		contentPane.add(panelElegir);
		contentPane.add(panelPro);
		buildConstraints(con, 0, 2, 1, 1);
		grid.setConstraints(botones, con);
		botones.remove(registrar);
		botones.remove(registrarCon);
		contentPane.add(botones);
	}
}
