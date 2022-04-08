package utils;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Utilitario {
	public static int validarNumero(JTextField txt) {
		int cant = 0;
		try {
			cant = Integer.parseInt(txt.getText());
			if (cant <= 0) {
				Alertas.mensajeError("Ingresar valores mayores a 0");
				return 0;
			}
		} catch (NumberFormatException e1) {
			Alertas.mensajeError("Ingresar valores numéricos");
		}
		return cant;

	}

	public static double validarNumeroDouble(JTextField txt) {
		double cant = 0.0;
		try {
			cant = Double.parseDouble(txt.getText());
			if (cant <= 0) {
				Alertas.mensajeError("Ingresar valores mayores a 0");
				return 0;
			}
		} catch (NumberFormatException e1) {
			Alertas.mensajeError("Ingresar valores numéricos");
		}
		return cant;

	}

	public static void limpiar(JTextField txt) {
		txt.setText("");
		txt.requestFocus();
	}

//consultar a profesora porque cuando quiero poner un return en un metodo para reutiliza no hace 
//	public static void validaDoubleIgualCero(double d, JTextField txt) {
//		if (d == 0) {
//			limpiar(txt);
//			return;
//		}
//	}
//
//	public static void validaIntIgualCero(int d, JTextField txt) {
//		if (d == 0) {
//			limpiar(txt);
//			return;
//		}
//	}

	@SuppressWarnings("rawtypes")
	public static void limpiar(JTextArea txtS, JTextField txtCantidad, JComboBox cboProducto) {
		txtS.setText("");
		txtCantidad.setText("");
		cboProducto.setSelectedIndex(0);
		txtCantidad.requestFocus();
	}

}
