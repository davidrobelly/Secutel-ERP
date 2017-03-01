package Secutel_ERP;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TablaContactos extends AbstractTableModel{

	private final String[] titulo= {"Nombre","Apellido","Nro Cedula"};
	ArrayList<ContactoProveedor> lista = new ArrayList<>();
	
	public TablaContactos() {
		super();
	}

	public TablaContactos(ArrayList<ContactoProveedor> lista) {
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
			return lista.get(x).getNombre();
		case 1:
			return lista.get(x).getApellido();
		case 2:
			return lista.get(x).getCedula();
		default:
			return null;
		}
	}
}
