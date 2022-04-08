package proyectoInvestigacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import utils.Alertas;

public class DlgGenerarReportes extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblTipoReporte;
	private JComboBox<Object> cboReporte;
	private JButton btnCerrar;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	DecimalFormat df = new DecimalFormat("0.00");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if ("ok".equalsIgnoreCase(FrmLogin.login)) {
						DlgGenerarReportes frame = new DlgGenerarReportes();
						frame.setVisible(true);
					} else {
						Alertas.mensajeError("Usted no tiene permisos para acceder al modulo");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DlgGenerarReportes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTipoReporte = new JLabel("Tipo de Reporte:");
		lblTipoReporte.setToolTipText("");
		lblTipoReporte.setBounds(31, 31, 110, 14);
		contentPane.add(lblTipoReporte);

		cboReporte = new JComboBox<Object>();
		cboReporte.addActionListener(this);
		cboReporte.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "Ventas por modelo", "Ventas en relaci\u00F3n a la venta \u00F3ptima",
						"Precios en relaci\u00F3n al precio promedio", "Promedios, menores y mayores" }));
		cboReporte.setBounds(140, 27, 400, 22);
		contentPane.add(cboReporte);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(620, 27, 89, 23);
		contentPane.add(btnCerrar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 70, 683, 344);
		contentPane.add(scrollPane);

		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboReporte) {
			actionPerformedCboReporte(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		setVisible(false);
	}

	private void imprimir(String cad) {
		txtS.append(cad + "\n");
	}

	protected void actionPerformedCboReporte(ActionEvent e) {
		int reporte;
		String comentario;
		reporte = cboReporte.getSelectedIndex();
		comentario = calcCondicion();

		switch (reporte) {
		case 0:
			ventasPorMod(); // Ventas por modelo
			break;
		case 1:
			relacionVentOptima(comentario); // Ventas en relación a la venta óptima
			break;
		case 2:
			precioPromedio(); // Precios en relación al precio promedio
			break;
		default:
			promdMenMay(); // Promedios, menores y mayores
		}

	}

	private String calcCondicion() { // EN PROCESO
		int dif;
		dif = FrmPrincipal.uniVendMod0 - FrmPrincipal.cantidadOptima;

		if (FrmPrincipal.uniVendMod0 > FrmPrincipal.cantidadOptima)
			return dif + " más que la cantidad óptima";
		else if (FrmPrincipal.uniVendMod0 == FrmPrincipal.cantidadOptima)
			return " igual de la cantidad óptima";
		else
			return (dif * -1) + " menos que la cantidad óptima";
	}

	private void ventasPorMod() {
		txtS.setText("VENTAS POR MODELO \n\n");

		imprimir("Modelo 			: " + FrmPrincipal.modelo0);
		imprimir("Cantidad de ventas		: " + FrmPrincipal.cantVentMod0);
		imprimir("Cantidad de unidades vendidas		: " + FrmPrincipal.uniVendMod0);
		imprimir("Importe total vendido		: S/ " + df.format(FrmPrincipal.impTotVendMod0));
		imprimir("Aporte a la cuota diaria 		: " + df.format(FrmPrincipal.aprtCoutDiariaMod0) + "%\n");

		imprimir("Modelo 			: " + FrmPrincipal.modelo1);
		imprimir("Cantidad de ventas		: " + FrmPrincipal.cantVentMod1);
		imprimir("Cantidad de unidades vendidas		: " + FrmPrincipal.uniVendMod1);
		imprimir("Importe total vendido		: S/ " + df.format(FrmPrincipal.impTotVendMod1));
		imprimir("Aporte a la cuota diaria 		: " + df.format(FrmPrincipal.aprtCoutDiariaMod1) + "%\n");

		imprimir("Modelo 			: " + FrmPrincipal.modelo2);
		imprimir("Cantidad de ventas		: " + FrmPrincipal.cantVentMod2);
		imprimir("Cantidad de unidades vendidas		: " + FrmPrincipal.uniVendMod2);
		imprimir("Importe total vendido		: S/ " + df.format(FrmPrincipal.impTotVendMod2));
		imprimir("Aporte a la cuota diaria 		: " + df.format(FrmPrincipal.aprtCoutDiariaMod2) + "%\n");

		imprimir("Modelo 			: " + FrmPrincipal.modelo3);
		imprimir("Cantidad de ventas		: " + FrmPrincipal.cantVentMod3);
		imprimir("Cantidad de unidades vendidas		: " + FrmPrincipal.uniVendMod3);
		imprimir("Importe total vendido		: S/ " + df.format(FrmPrincipal.impTotVendMod3));
		imprimir("Aporte a la cuota diaria 		: " + df.format(FrmPrincipal.aprtCoutDiariaMod3) + "%\n");

		imprimir("Modelo 			: " + FrmPrincipal.modelo4);
		imprimir("Cantidad de ventas		: " + FrmPrincipal.cantVentMod4);
		imprimir("Cantidad de unidades vendidas		: " + FrmPrincipal.uniVendMod4);
		imprimir("Importe total vendido		: S/ " + df.format(FrmPrincipal.impTotVendMod4));
		imprimir("Aporte a la cuota diaria 		: " + df.format(FrmPrincipal.aprtCoutDiariaMod4) + "%");

	}

	private void relacionVentOptima(String comentario) {

		txtS.setText("VENTAS EN RELACIÓN A LA VENTA ÓPTIMA \n\n");
		imprimir("Modelo 			: " + FrmPrincipal.modelo0);
		imprimir("Cantidad de unidades vendidas		: " + FrmPrincipal.uniVendMod0 + " ( " + comentario + " )\n");

		imprimir("Modelo 			: " + FrmPrincipal.modelo1);
		imprimir("Cantidad de unidades vendidas		: " + FrmPrincipal.uniVendMod1 + "\n");

		imprimir("Modelo 			: " + FrmPrincipal.modelo2);
		imprimir("Cantidad de unidades vendidas		: " + FrmPrincipal.uniVendMod2 + "\n");

		imprimir("Modelo 			: " + FrmPrincipal.modelo3);
		imprimir("Cantidad de unidades vendidas		: " + FrmPrincipal.uniVendMod3 + "\n");

		imprimir("Modelo 			: " + FrmPrincipal.modelo4);
		imprimir("Cantidad de unidades vendidas		: " + FrmPrincipal.uniVendMod4);
	}

	double precioPromedio = (FrmPrincipal.precio0 + FrmPrincipal.precio1+ FrmPrincipal.precio2+FrmPrincipal.precio3+FrmPrincipal.precio4)/5;
	double anchoPromedio = (FrmPrincipal.ancho0+FrmPrincipal.ancho1+FrmPrincipal.ancho2+FrmPrincipal.ancho3+FrmPrincipal.ancho4)/5;
	private void precioPromedio() {
		txtS.setText("PRECIOS EN REALCIÓN AL PRECIO PROMEDIO \n\n");
		imprimir("Modelo		: " + FrmPrincipal.modelo0);
		validarPrecioPromedio(FrmPrincipal.precio0,precioPromedio);

		imprimir("Modelo		: " + FrmPrincipal.modelo1);
		validarPrecioPromedio(FrmPrincipal.precio1,precioPromedio);

		imprimir("Modelo		: " + FrmPrincipal.modelo2);
		validarPrecioPromedio(FrmPrincipal.precio2,precioPromedio);

		imprimir("Modelo		: " + FrmPrincipal.modelo3);
		validarPrecioPromedio(FrmPrincipal.precio3,precioPromedio);

		imprimir("Modelo		: " + FrmPrincipal.modelo4);
		validarPrecioPromedio(FrmPrincipal.precio4,precioPromedio);

	}

	private void validarPrecioPromedio(double precio, double precioPromedio) {
		if (precio == precioPromedio) {
			imprimir("Precio		: S/." + precio + " (Igual al precio promedio)\n");
		} else if (precio > precioPromedio) {
			imprimir("Precio		: S/." + precio + " (Mayor al precio promedio)\n");
		} else {
			imprimir("Precio		: S/." + precio + " (Menor al precio promedio)\n");
		}

	}

	private void promdMenMay() {
		txtS.setText("PROMEDIOS, MENORES Y MAYORES \n\n");
		imprimir("Precio Promedio       : S/." + precioPromedio+ " \n");
		determinarPrecioMenor();
		determinarPrecioMayor();
		imprimir("Ancho Promedio       : " + anchoPromedio+ " cm \n");
		determinaAnchoMenor();
		determinaAnchoMayor();
	}
	
	private void determinarPrecioMenor() {
		if(FrmPrincipal.precio0<=FrmPrincipal.precio1 && FrmPrincipal.precio0<=FrmPrincipal.precio2 
				&& FrmPrincipal.precio0<=FrmPrincipal.precio3 && FrmPrincipal.precio0<=FrmPrincipal.precio4) {
			imprimir("Precio menor             : S/." + FrmPrincipal.precio0+ " \n");
		}else if(FrmPrincipal.precio1<=FrmPrincipal.precio0 && FrmPrincipal.precio1<=FrmPrincipal.precio2 
				&& FrmPrincipal.precio1<=FrmPrincipal.precio3 && FrmPrincipal.precio1<=FrmPrincipal.precio4) {
			imprimir("Precio menor             : S/." + FrmPrincipal.precio1+ " \n");
		}else if(FrmPrincipal.precio2<=FrmPrincipal.precio0 && FrmPrincipal.precio2<=FrmPrincipal.precio1 
				&& FrmPrincipal.precio2<=FrmPrincipal.precio3 && FrmPrincipal.precio2<=FrmPrincipal.precio4) {
			imprimir("Precio menor             : S/." + FrmPrincipal.precio2+ " \n");
		}else if(FrmPrincipal.precio3<=FrmPrincipal.precio0 && FrmPrincipal.precio3<=FrmPrincipal.precio1 
				&& FrmPrincipal.precio3<=FrmPrincipal.precio2 && FrmPrincipal.precio3<=FrmPrincipal.precio4) {
			imprimir("Precio menor             : S/." + FrmPrincipal.precio3+ " \n");
		}else {
			imprimir("Precio menor             : S/." + FrmPrincipal.precio4+ " \n");
		}
	}
	private void determinarPrecioMayor() {
		if(FrmPrincipal.precio0>=FrmPrincipal.precio1 && FrmPrincipal.precio0>=FrmPrincipal.precio2 
				&& FrmPrincipal.precio0>=FrmPrincipal.precio3 && FrmPrincipal.precio0>=FrmPrincipal.precio4) {
			imprimir("Precio mayor             : S/." + FrmPrincipal.precio0+ " \n");
		}else if(FrmPrincipal.precio1>=FrmPrincipal.precio0 && FrmPrincipal.precio1>=FrmPrincipal.precio2 
				&& FrmPrincipal.precio1>=FrmPrincipal.precio3 && FrmPrincipal.precio1>=FrmPrincipal.precio4) {
			imprimir("Precio mayor             : S/." + FrmPrincipal.precio1+ " \n");
		}else if(FrmPrincipal.precio2>=FrmPrincipal.precio0 && FrmPrincipal.precio2>=FrmPrincipal.precio1 
				&& FrmPrincipal.precio2>=FrmPrincipal.precio3 && FrmPrincipal.precio2>=FrmPrincipal.precio4) {
			imprimir("Precio mayor             : S/." + FrmPrincipal.precio2+ " \n");
		}else if(FrmPrincipal.precio3>=FrmPrincipal.precio0 && FrmPrincipal.precio3>=FrmPrincipal.precio1 
				&& FrmPrincipal.precio3>=FrmPrincipal.precio2 && FrmPrincipal.precio3>=FrmPrincipal.precio4) {
			imprimir("Precio mayor             : S/." + FrmPrincipal.precio3+ " \n");
		}else {
			imprimir("Precio mayor             : S/." + FrmPrincipal.precio4+ " \n");
		}
	}
	
	private void determinaAnchoMenor() {
		if(FrmPrincipal.ancho0<=FrmPrincipal.ancho1 && FrmPrincipal.ancho0<=FrmPrincipal.ancho2 
				&& FrmPrincipal.ancho0<FrmPrincipal.ancho3 && FrmPrincipal.ancho0<=FrmPrincipal.ancho4) {
			imprimir("Ancho menor             : " + FrmPrincipal.ancho0+ " cm \n");
		}else if(FrmPrincipal.ancho1<=FrmPrincipal.ancho0 && FrmPrincipal.ancho1<=FrmPrincipal.ancho2 
				&& FrmPrincipal.ancho1<=FrmPrincipal.ancho3 && FrmPrincipal.ancho1<=FrmPrincipal.ancho4) {
			imprimir("Ancho menor             : " + FrmPrincipal.ancho1+ " cm \n");
		}else if(FrmPrincipal.ancho2<=FrmPrincipal.ancho0 && FrmPrincipal.ancho2<=FrmPrincipal.ancho1 
				&& FrmPrincipal.ancho2<=FrmPrincipal.ancho3 && FrmPrincipal.ancho2<=FrmPrincipal.ancho4) {
			imprimir("Ancho menor             : " + FrmPrincipal.ancho2+ " cm \n");
		}else if(FrmPrincipal.ancho3<=FrmPrincipal.ancho0 && FrmPrincipal.ancho3<=FrmPrincipal.ancho1 
				&& FrmPrincipal.ancho3<=FrmPrincipal.ancho2 && FrmPrincipal.ancho3<=FrmPrincipal.ancho4) {
			imprimir("Ancho menor             : " + FrmPrincipal.ancho3+ " cm \n");
		}else {
			imprimir("Ancho menor             : " + FrmPrincipal.ancho4+ " cm \n");
		}
	}
	
	private void determinaAnchoMayor() {
		if(FrmPrincipal.ancho0>=FrmPrincipal.ancho1 && FrmPrincipal.ancho0>=FrmPrincipal.ancho2 
				&& FrmPrincipal.ancho0>=FrmPrincipal.ancho3 && FrmPrincipal.ancho0>=FrmPrincipal.ancho4) {
			imprimir("Ancho mayor             : " + FrmPrincipal.ancho0+ " cm \n");
		}else if(FrmPrincipal.ancho1>=FrmPrincipal.ancho0 && FrmPrincipal.ancho1>=FrmPrincipal.ancho2 
				&& FrmPrincipal.ancho1>=FrmPrincipal.ancho3 && FrmPrincipal.ancho1>=FrmPrincipal.ancho4) {
			imprimir("Ancho mayor             : " + FrmPrincipal.ancho1+ " cm \n");
		}else if(FrmPrincipal.ancho2>=FrmPrincipal.ancho0 && FrmPrincipal.ancho2>=FrmPrincipal.ancho1 
				&& FrmPrincipal.ancho2>=FrmPrincipal.ancho3 && FrmPrincipal.ancho2>=FrmPrincipal.ancho4) {
			imprimir("Ancho mayor             : " + FrmPrincipal.ancho2+ " cm \n");
		}else if(FrmPrincipal.ancho3>=FrmPrincipal.ancho0 && FrmPrincipal.ancho3>=FrmPrincipal.ancho1 
				&& FrmPrincipal.ancho3>=FrmPrincipal.ancho2 && FrmPrincipal.ancho3>=FrmPrincipal.ancho4) {
			imprimir("Ancho mayor             : " + FrmPrincipal.ancho3+ " cm \n");
		}else {
			imprimir("Ancho mayor             : " + FrmPrincipal.ancho4+ " cm \n");
		}
	}
}
