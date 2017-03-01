package pantallas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controles.Control_Consulta_Clientes;
import controles.Control_Ventana_Factura;


@SuppressWarnings({ "serial", "unused" })
public class Ventana_Ingreso_Factura extends JFrame {
	
	public JPanel panelNorte,panelCentro, panelSur;
	public JTextField txtcodigo,txtcliente, txtfecha, txtlocal, txtcantidad, txtiva,
						txtvendedor, txtvigencia, txtsubtotal, txttotal, txtruc, txttelefono;
	public JLabel lblcodigo, lblcliente, lblfecha, lbllocal, lblcantidad, lbliva,
						lblvendedor, lblvigencia, lblsubtotal, lbltotal,
						lblestado, lblmetodo, lbltelefono, lblruc;
	@SuppressWarnings("rawtypes")
	public JComboBox cmbestado, cmbmetodo;
	public JButton btnregprod, btngenerar, btnguardar, btncliente, btnvendedor, btnlocal;
	public Tabla_Detalle_Factura clientes;
	public JTable tableCliente;
	public JScrollPane scrollPro;
	int cliente, vendedor, local;
	String cedulaCliente, telefonoCliente;
	
	
	
	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public int getVendedor() {
		return vendedor;
	}

	public void setVendedor(int vendedor) {
		this.vendedor = vendedor;
	}

	public int getLocal() {
		return local;
	}

	public void setLocal(int local) {
		this.local = local;
	}

	GridBagLayout grid;
	GridBagConstraints con;
	
	Control_Ventana_Factura control;
	
	public Ventana_Ingreso_Factura() {
		
		initcomponents();
		ventana();
		
		control = new Control_Ventana_Factura(this);
		
		this.getContentPane().add(panelNorte, "North");
		this.getContentPane().add(panelCentro, "Center");
		this.getContentPane().add(panelSur, "South");
		
		
		panelNorte.setLayout(grid);
		con.weightx = 1;
		con.weighty = 1;
		con.anchor = GridBagConstraints.WEST;
		con.insets = new Insets(5, 5, 5, 5);
		con.fill = GridBagConstraints.BOTH;
		
		buildConstraints(con, 0, 0, 1, 1);
		grid.setConstraints(lblcodigo, con);
		buildConstraints(con, 1, 0, 1, 1);
		grid.setConstraints(txtcodigo, con);
		buildConstraints(con, 2, 0, 1, 1);
		grid.setConstraints(lblestado, con);
		buildConstraints(con, 3, 0, 1, 1);
		grid.setConstraints(cmbestado, con);
		
		buildConstraints(con, 0, 1, 1, 1);
		grid.setConstraints(lblcliente, con);
		buildConstraints(con, 1, 1, 1, 1);
		grid.setConstraints(txtcliente, con);
		buildConstraints(con, 2, 1, 1, 1);
		grid.setConstraints(lblvendedor, con);
		buildConstraints(con, 3, 1, 1, 1);
		grid.setConstraints(txtvendedor, con);
		
		buildConstraints(con, 0, 2, 1, 1);
		grid.setConstraints(lblruc, con);
		buildConstraints(con, 1, 2, 1, 1);
		grid.setConstraints(txtruc, con);
		buildConstraints(con, 2, 2, 1, 1);
		grid.setConstraints(lbltelefono, con);
		buildConstraints(con, 3, 2, 1, 1);
		grid.setConstraints(txttelefono, con);
		
		buildConstraints(con, 0, 3, 1, 1);
		grid.setConstraints(lblfecha, con);
		buildConstraints(con, 1, 3, 1, 1);
		grid.setConstraints(txtfecha, con);
		buildConstraints(con, 2, 3, 1, 1);
		grid.setConstraints(lblvigencia, con);
		buildConstraints(con, 3, 3, 1, 1);
		grid.setConstraints(txtvigencia, con);
		
		buildConstraints(con, 0, 4, 1, 1);
		grid.setConstraints(lbllocal, con);
		buildConstraints(con, 1, 4, 1, 1);
		grid.setConstraints(txtlocal, con);
		buildConstraints(con, 2, 4, 1, 1);
		grid.setConstraints(lblmetodo, con);
		buildConstraints(con, 3, 4, 1, 1);
		grid.setConstraints(cmbmetodo, con);
		
		buildConstraints(con, 0, 5, 1, 1);
		grid.setConstraints(lblcantidad, con);
		buildConstraints(con, 1, 5, 1, 1);
		grid.setConstraints(txtcantidad, con);
		buildConstraints(con, 2, 5, 1, 1);
		grid.setConstraints(lblsubtotal, con);
		buildConstraints(con, 3, 5, 1, 1);
		grid.setConstraints(txtsubtotal, con);
		
		buildConstraints(con, 0, 6, 1, 1);
		grid.setConstraints(lbliva, con);
		buildConstraints(con, 1, 6, 1, 1);
		grid.setConstraints(txtiva, con);
		buildConstraints(con, 2, 6, 1, 1);
		grid.setConstraints(lbltotal, con);
		buildConstraints(con, 3, 6, 1, 1);
		grid.setConstraints(txttotal, con);
		
		panelNorte.add(lblcantidad);
		panelNorte.add(lblcodigo);
		panelNorte.add(lblcliente);
		panelNorte.add(lbliva);
		panelNorte.add(lblsubtotal);
		panelNorte.add(lbltotal);
		panelNorte.add(lbllocal);
		panelNorte.add(lblfecha);
		panelNorte.add(lblestado);
		panelNorte.add(lblmetodo);
		panelNorte.add(lblvigencia);
		panelNorte.add(lblvendedor);
		panelNorte.add(lbltelefono);
		panelNorte.add(lblruc);

		
		panelNorte.add(txtcantidad);
		panelNorte.add(txtcodigo);
		panelNorte.add(txtcliente);
		panelNorte.add(txtiva);
		panelNorte.add(txtsubtotal);
		panelNorte.add(txttotal);
		panelNorte.add(txtlocal);
		panelNorte.add(txtfecha);
		panelNorte.add(cmbestado);
		panelNorte.add(cmbmetodo);
		panelNorte.add(txtvigencia);
		panelNorte.add(txtvendedor);
		panelNorte.add(txttelefono);
		panelNorte.add(txtruc);
		
		panelCentro.setLayout(grid);
		con.anchor = GridBagConstraints.CENTER;
		con.insets = new Insets(5, 5, 5, 5);
		con.fill = GridBagConstraints.BOTH;
		buildConstraints(con, 0, 1, 1, 1);
		
		grid.setConstraints(panelCentro, con);
        tableCliente.getTableHeader().setReorderingAllowed(false) ;
		scrollPro = new JScrollPane(tableCliente);
		buildConstraints(con, 0, 0, 1, 1);
		grid.setConstraints(scrollPro, con);
		panelCentro.add(scrollPro);
		
		con.insets = new Insets(10, 10, 10, 10);
		panelSur.setLayout(grid);
		
		
		buildConstraints(con, 0, 0, 1, 1);
		grid.setConstraints(btnregprod, con);
		buildConstraints(con, 1, 0, 1, 1);
		grid.setConstraints(btnguardar, con);
		buildConstraints(con, 2, 0, 1, 1);
		grid.setConstraints(btngenerar, con);
		
		
		panelSur.add(btngenerar);
		panelSur.add(btnregprod);
		panelSur.add(btnguardar);
		
		//eventos

		txtcliente.addMouseListener(control);
		txtvendedor.addMouseListener(control);
		txtlocal.addMouseListener(control);
		btngenerar.addActionListener(control);
		btnregprod.addActionListener(control);
		btnguardar.addActionListener(control);
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initcomponents() {
		
		grid = new GridBagLayout();
		con = new GridBagConstraints();
		
		btnregprod = new JButton ("Agregar Productos");
		btnguardar = new JButton ("Registrar Factura");
		btngenerar = new JButton ("Generar Factura");
		
		clientes = new Tabla_Detalle_Factura();
		panelNorte = new JPanel();
		panelCentro = new JPanel();
		panelSur = new JPanel();
		
		txtcodigo = new JTextField ("");
		txtcliente = new JTextField ("");
		txtlocal = new JTextField ("");
		txtfecha = new JTextField ("");
		txtfecha.setToolTipText("AAAA/MM/DD");
		txtcantidad = new JTextField ("");
		txtiva = new JTextField ("");
		txtvendedor = new JTextField ("");
		txtvigencia = new JTextField ("");
		txtvigencia.setToolTipText("AAAA/MM/DD");
		txtsubtotal = new JTextField ("");
		txttotal = new JTextField ("");
		txtruc = new JTextField ("");
		txttelefono = new JTextField ("");
		
		txttotal.setEditable(false);
		txtsubtotal.setEditable(false);
		txtiva.setEditable(false);
		txtcantidad.setEditable(false);
		
		txtcliente.setEditable(false);
		txttelefono.setEditable(false);
		txtruc.setEditable(false);
		txtvendedor.setEditable(false);
		txtlocal.setEditable(false);
		
		lblcodigo = new JLabel ("C�digo: ");
		lblcliente = new JLabel ("Cliente: ");
		lbllocal = new JLabel ("Sucursal: ");
		lblfecha = new JLabel ("Fecha: ");
		lblcantidad = new JLabel ("Cantidad: ");
		lbliva = new JLabel ("IVA: ");
		lblvendedor = new JLabel ("Vendedor: ");
		lblvigencia = new JLabel ("Vigencia: ");
		lblsubtotal = new JLabel ("Sub-Total: ");
		lbltotal = new JLabel ("Total: ");
		lblestado = new JLabel ("Estado: ");
		lblmetodo = new JLabel ("M�t. Pago: ");
		lbltelefono = new JLabel ("Tel�fono: ");
		lblruc = new JLabel ("Ruc/C�dula: ");
		
		cmbestado = new JComboBox ();
		cmbestado.addItem("Pendiente");
		cmbestado.addItem("Cancelada");
		cmbestado.addItem("Anulada");
		
		cmbmetodo = new JComboBox();
		cmbmetodo.addItem("Contado");
		cmbmetodo.addItem("Cr�dito");
		cmbmetodo.addItem("Cheque");
		
		//esta es la parte de tabla
		clientes = new Tabla_Detalle_Factura ();
		tableCliente = new JTable (clientes);
		tableCliente.getTableHeader().setReorderingAllowed(false);
		scrollPro = new JScrollPane(tableCliente);
		
		panelNorte.setBorder(new TitledBorder(null, "Datos factura", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCentro.setBorder(new TitledBorder(null, "Detalle de Productos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSur.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		
	}

	private void ventana() {
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setTitle("Consultar Clientes");
		this.setVisible(true);
		
		this.setBounds(300, 100, 600, 450);
		this.setResizable(false);
		
	}

	void buildConstraints (GridBagConstraints gbc, int gx, int gy, int gw, int gh) {
		gbc.gridx 					= gx;
		gbc.gridy 					= gy;
		gbc.gridwidth 				= gw;
		gbc.gridheight 				= gh;
	}



		
	

}