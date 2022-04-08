package utils;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Alertas {
	
	//Mensaje Error
		public static void mensajeError(String msj) {
			JOptionPane.showMessageDialog(null,msj,"Error", 0);
		}
		public static void mensajeAlerta(String msj) {
			JOptionPane.showMessageDialog(null, msj, "Sistema", 1);
		}
		public static int mensajeConfirmar() {
			return JOptionPane.showConfirmDialog(null, "¿Seguro de guardar cambios?", "Sistema", JOptionPane.YES_NO_OPTION);
		}
		public static DecimalFormat df = new DecimalFormat("0.00");
		
		/*public static void relacionVentaOptimaMas() {
			JOptionPane.showMessageDialog(null, FrmPrincipal.cantVentMod0 + "(" + dif + " más que la cantidad óptima", "Sistema", 1);
		}*/
			
}
