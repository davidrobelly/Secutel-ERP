package Vista;

import java.awt.BorderLayout; 
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.DateListener;
import org.freixas.jcalendar.JCalendar;


@SuppressWarnings("serial")
public class Pantalla_Kardex extends JFrame implements ActionListener{
	
	public ImageIcon ico_aplicacion;
	public JPanel pnl_central, pnl_botones;
	public JLabel lbl_tipo, lbl_fecha, lbl_producto, lbl_cantidad, lbl_preCompra, lbl_detalle, lbl_calendario;
	public JComboBox<String> cbx_tipo;
	public JTextField txt_fecha, txt_producto, txt_cantidad, txt_preCompra;
	public JTextArea txta_detalle;;
	public JButton btn_agregar;
	public JScrollPane scroll;
	public JCalendar calendario;
	
	
	public Pantalla_Kardex (){
		
		super("Kardex - Entradas y Salidas");
		setSize(500, 450);
		setLocation(400, 25);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//Icono de la Aplicacion
		ico_aplicacion = new ImageIcon("src/Imagenes/icono.gif");
		setIconImage(ico_aplicacion.getImage());
		
		//PANEL CENTRAL
		pnl_central = new JPanel();
		getContentPane().add(pnl_central, BorderLayout.NORTH);
		
		GridBagLayout gridCentral = new GridBagLayout();
		pnl_central.setLayout(gridCentral);
		
		GridBagConstraints gridConCentral = new GridBagConstraints();
		gridConCentral.fill = GridBagConstraints.BOTH;
		gridConCentral.insets = new Insets(3, 3, 3, 3);
		
		gridConCentral.gridx = 0;
		gridConCentral.gridy = 0;
		gridConCentral.gridheight = 1;
		gridConCentral.gridwidth = 1;
		lbl_tipo = new JLabel("Tipo : ");
		pnl_central.add(lbl_tipo);
		gridCentral.setConstraints(lbl_tipo, gridConCentral);
		
		gridConCentral.gridx = 1;
		gridConCentral.gridy = 0;
		cbx_tipo = new JComboBox<String>();
		cbx_tipo.addItem("INGRESO");
		cbx_tipo.addItem("EGRESO");
		pnl_central.add(cbx_tipo);
		gridCentral.setConstraints(cbx_tipo, gridConCentral);
		
//		gridConCentral.gridx = 0;
//		gridConCentral.gridy = 1;
//		lbl_fecha = new JLabel("Fecha : ");
//		pnl_central.add(lbl_fecha);
//		gridCentral.setConstraints(lbl_fecha, gridConCentral);
//		
//		gridConCentral.gridx = 1;
//		gridConCentral.gridy = 1;
//		calendario = new JCalendar();		
//		pnl_central.add(calendario);
//		gridCentral.setConstraints(calendario, gridConCentral);
		
		gridConCentral.gridx = 0;
		gridConCentral.gridy = 2;
		lbl_producto = new JLabel("Producto : ");
		pnl_central.add(lbl_producto);
		gridCentral.setConstraints(lbl_producto, gridConCentral);
		
		gridConCentral.gridx = 1;
		gridConCentral.gridy = 2;
		txt_producto = new JTextField(20);
		pnl_central.add(txt_producto);
		gridCentral.setConstraints(txt_producto, gridConCentral);
		
		gridConCentral.gridx = 0;
		gridConCentral.gridy = 3;
		lbl_cantidad = new JLabel("Cantidad : ");
		pnl_central.add(lbl_cantidad);
		gridCentral.setConstraints(lbl_cantidad, gridConCentral);
		
		gridConCentral.gridx = 1;
		gridConCentral.gridy = 3;
		txt_cantidad = new JTextField(20);
		pnl_central.add(txt_cantidad);
		gridCentral.setConstraints(txt_cantidad, gridConCentral);
		
		gridConCentral.gridx = 0;
		gridConCentral.gridy = 4;
		lbl_preCompra = new JLabel("Precio de Compra : ");
		pnl_central.add(lbl_preCompra);
		gridCentral.setConstraints(lbl_preCompra, gridConCentral);
		
		gridConCentral.gridx = 1;
		gridConCentral.gridy = 4;
		txt_preCompra = new JTextField(20);
		pnl_central.add(txt_preCompra);
		gridCentral.setConstraints(txt_preCompra, gridConCentral);
		
		gridConCentral.gridx = 0;
		gridConCentral.gridy = 5;
		lbl_detalle = new JLabel("Detalle : ");
		pnl_central.add(lbl_detalle);
		gridCentral.setConstraints(lbl_detalle, gridConCentral);
		
		gridConCentral.gridx = 1;
		gridConCentral.gridy = 5;
		txta_detalle = new JTextArea(2, 5);
		txta_detalle.setLineWrap(true);
		txta_detalle.setWrapStyleWord(true);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(txta_detalle);		
		pnl_central.add(scroll);
		gridCentral.setConstraints(scroll, gridConCentral);
		
		gridConCentral.gridx = 0;
		gridConCentral.gridy = 6;
		lbl_calendario = new JLabel("Calendario : ");
		pnl_central.add(lbl_calendario);
		gridCentral.setConstraints(lbl_calendario, gridConCentral);
		
		gridConCentral.gridx = 1;
		gridConCentral.gridy = 6;
		calendario = new JCalendar();	
		pnl_central.add(calendario);
		gridCentral.setConstraints(calendario, gridConCentral);

		
		//PANEL BOTONES
		pnl_botones = new JPanel(new GridLayout(1, 1));
		
		btn_agregar = new JButton(new ImageIcon("src/Imagenes/agregar.jpeg"));
		btn_agregar.setBorder(null);
		btn_agregar.addActionListener(this);
		
		pnl_botones.add(btn_agregar);	
		
		getContentPane().add(pnl_central, BorderLayout.CENTER);
		getContentPane().add(pnl_botones, BorderLayout.SOUTH);
		
		((JComponent)getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	}
	
	public void limpiarPantalla(){
		
		txt_fecha.setText("");
		txt_producto.setText("");
		txt_cantidad.setText("");
		txt_preCompra.setText("");
		txta_detalle.setText("");
		
	}

	public void actionPerformed(ActionEvent evento) {
		
		if(evento.getSource() == btn_agregar){	
			
			String tipo, detalle;
			Date fecha;
			double valor;
			int producto, cantidad;
			
			tipo = (String) cbx_tipo.getSelectedItem();
			producto = Integer.parseInt(txt_producto.getText());
			cantidad = Integer.parseInt(txt_cantidad.getText());
			valor = Double.parseDouble(txt_preCompra.getText());
			detalle = txta_detalle.getText();			
			
//			Kardex kardexIE = new Kardex(tipo, producto, cantidad, valor, detalle);

//			kardexIE.ingresarKardex(kardexIE);
			JOptionPane.showMessageDialog(null, "Registro exitoso");			
			limpiarPantalla();
			
		}
		
	}
	
	@SuppressWarnings("unused")
	private class MyDateListener implements DateListener {

		@Override
		public void dateChanged(DateEvent evento) {

			Calendar c = evento.getSelectedDate();
			  if (c != null) {
				System.out.println(c.getTime());
			  }
			  else {
				System.out.println("No selecciono fecha");
			  }
			
		}

}


	

}



