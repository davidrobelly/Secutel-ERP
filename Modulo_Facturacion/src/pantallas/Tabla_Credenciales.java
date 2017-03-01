package pantallas;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelo_clases.Credenciales;
import modelo_clases.Empleado;

public class Tabla_Credenciales extends AbstractTableModel{

	private final String[] titulo= {"IdEmpleado","User","Key", "Estado"};
	
	ArrayList<Credenciales> lista = new ArrayList<>(); 
	
	public Tabla_Credenciales() {
		super();
	}

	public Tabla_Credenciales(ArrayList<Credenciales> lista) {
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
			return lista.get(x).getIdempleado();
		case 1:
			return lista.get(x).getUser();
		case 2:
			return lista.get(x).getKey();
		case 3:
			return lista.get(x).getEstado();
		default:
			return null;
		}
	}

}
