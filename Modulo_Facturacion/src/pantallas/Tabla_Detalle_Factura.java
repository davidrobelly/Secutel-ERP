package pantallas;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelo_clases.Detalle_Factura;

public class Tabla_Detalle_Factura extends AbstractTableModel{

	private final String[] titulo= {"Nro. Factura","Producto","Cantidad", 
			"Valor"};
	
	ArrayList<Detalle_Factura> lista = new ArrayList<>(); 
	
	public Tabla_Detalle_Factura() {
		super();
	}

	public Tabla_Detalle_Factura(ArrayList<Detalle_Factura> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public int getColumnCount() {
		return titulo.length;
	}
	@Override
	public String getColumnName(int column) {
		return titulo[column];
	}
	@Override
	public int getRowCount() {
		return lista.size();
	}
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}

	@Override
	public Object getValueAt(int x, int y) {
		switch (y) {
		case 0:
			return lista.get(x).getIdfactura();
		case 1:
			return lista.get(x).getIdproducto();
		case 2:
			return lista.get(x).getCantidad();
		case 3:
			return lista.get(x).getValor();
		default:
			return null;
		}
	}

}
