package proyectoInvestigacion;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import utils.Alertas;
import utils.Utilitario;

public class DlgVenderCocina extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblModelo;
	private JLabel lblNewLabel_1;
	private JLabel lblCantidad;
	private JComboBox<Object> cboModelo;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnVender;
	private JButton btnCerrar;
	private JLabel lblNewLabel;

	// Formatear los Decimales
	DecimalFormat df = new DecimalFormat("0.00");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			if ("ok".equalsIgnoreCase(FrmLogin.login)) {
				DlgVenderCocina dialog = new DlgVenderCocina();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} else {
				Alertas.mensajeError("Usted no tiene permisos para acceder al modulo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgVenderCocina() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblModelo.setBounds(10, 11, 68, 14);
		contentPanel.add(lblModelo);

		lblNewLabel_1 = new JLabel("Precio (S/)");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 36, 68, 14);
		contentPanel.add(lblNewLabel_1);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCantidad.setBounds(10, 61, 68, 14);
		contentPanel.add(lblCantidad);

		cboModelo = new JComboBox<Object>();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota" }));
		cboModelo.setBounds(99, 8, 155, 22);
		contentPanel.add(cboModelo);

		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(99, 34, 155, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(99, 59, 155, 20);
		contentPanel.add(txtCantidad);
		txtCantidad.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 93, 414, 157);
		contentPanel.add(scrollPane);

		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);

		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setBounds(335, 8, 89, 23);
		contentPanel.add(btnVender);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(335, 36, 89, 23);
		contentPanel.add(btnCerrar);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\Jean Pierre\\Documents\\Java\\IA\\proyectoSistemaVentasCocina\\bin\\imagen\\computo.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 261);
		contentPanel.add(lblNewLabel);
		cargarData();
	}

	private void cargarData() {
		txtPrecio.setText("" + FrmPrincipal.precio0);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
		if (e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
		}
	}

//	private void actionPerformedBtnBorrar(ActionEvent e) {
//		txtCantidad.setText("");
//		txtS.setText("");
//		cboModelo.setSelectedIndex(0);
//		txtCantidad.requestFocus();
//	}

	protected void actionPerformedBtnVender(ActionEvent e) {
		int modelo, cant = 0;
		String obs;
		double precio, impPag, impDscto, impComp, aporteCoutDiara;
		// Imgreso de Datos
		modelo = cboModelo.getSelectedIndex();
		precio = getPrecio();
		cant = Utilitario.validarNumero(txtCantidad);
		if (cant == 0) {
			Utilitario.limpiar(txtCantidad);
			return;
		}
		// Proceso de calculo
		impComp = calcImpCompra(modelo, precio, cant);
		impDscto = calcImpDescuento(cant, impComp);
		impPag = calcImpPagar(impComp, impDscto);
		obs = calcObsequio(cant);
		aporteCoutDiara = aporteCoutDiaria(impPag);
		contVentMod(modelo, cant, impPag, aporteCoutDiara);
		contVentas(impPag);
		avanceVentas();
		// Salida de resultados
		mostrarResultados(impDscto, impComp, impPag, precio, cant, obs);
	}

	private double getPrecio() {
		return Double.parseDouble(txtPrecio.getText());
	}

	private double calcImpCompra(int modelo2, double precio, int cant) {
		switch (modelo2) {
		case 0:
			return cant * FrmPrincipal.precio0;
		case 1:
			return cant * FrmPrincipal.precio1;
		case 2:
			return cant * FrmPrincipal.precio2;
		case 3:
			return cant * FrmPrincipal.precio3;
		default:
			return cant * FrmPrincipal.precio4;
		}
	}

	private double calcImpDescuento(int cant, double impComp) {
		if (cant >= 1 && cant <= 5)
			return impComp * FrmPrincipal.porcentaje1 / 100;
		if (cant >= 6 && cant <= 10)
			return impComp * FrmPrincipal.porcentaje2 / 100;
		if (cant >= 11 && cant <= 15)
			return impComp * FrmPrincipal.porcentaje3 / 100;
		else
			return impComp * FrmPrincipal.porcentaje4 / 100;
	}

	private double calcImpPagar(double impComp, double impDscto) {
		return impComp - impDscto;
	}

	private String calcObsequio(int cant) {
		if (cant > 5)
			return FrmPrincipal.obsequio3;
		if (cant >= 2)
			return FrmPrincipal.obsequio2;
		else
			return FrmPrincipal.obsequio1;
	}

	private double aporteCoutDiaria(double impPag) {
		return (impPag * 100) / FrmPrincipal.cuotaDiaria;
	}

	private void contVentMod(int modelo, int cant, double impPag, double aporteCoutDiara) {
		switch (modelo) {
		case 0:
			FrmPrincipal.cantVentMod0++;
			FrmPrincipal.uniVendMod0 += cant;
			FrmPrincipal.impTotVendMod0 += impPag;
			FrmPrincipal.aprtCoutDiariaMod0 += aporteCoutDiara;
			break;
		case 1:
			FrmPrincipal.cantVentMod1++;
			FrmPrincipal.uniVendMod1 += cant;
			FrmPrincipal.impTotVendMod1 += impPag;
			FrmPrincipal.aprtCoutDiariaMod1 += aporteCoutDiara;
			break;
		case 2:
			FrmPrincipal.cantVentMod2++;
			FrmPrincipal.uniVendMod2 += cant;
			FrmPrincipal.impTotVendMod2 += impPag;
			FrmPrincipal.aprtCoutDiariaMod2 += aporteCoutDiara;
			break;
		case 3:
			FrmPrincipal.cantVentMod3++;
			FrmPrincipal.uniVendMod3 += cant;
			FrmPrincipal.impTotVendMod3 += impPag;
			FrmPrincipal.aprtCoutDiariaMod3 += aporteCoutDiara;
			break;
		default:
			FrmPrincipal.cantVentMod4++;
			FrmPrincipal.uniVendMod4 += cant;
			FrmPrincipal.impTotVendMod4 += impPag;
			FrmPrincipal.aprtCoutDiariaMod4 += aporteCoutDiara;
		}
	}

	private void contVentas(double impPag) {
		FrmPrincipal.contVent++;
		FrmPrincipal.impGeneral += impPag;
		FrmPrincipal.porcentajeCoutaDiaria = (FrmPrincipal.aprtCoutDiariaMod0 + FrmPrincipal.aprtCoutDiariaMod1
				+ FrmPrincipal.aprtCoutDiariaMod2 + FrmPrincipal.aprtCoutDiariaMod3 + FrmPrincipal.aprtCoutDiariaMod4);
	}

	private void avanceVentas() {
		if (FrmPrincipal.contVent == FrmPrincipal.acuVent) { // Cuando la cantidad de ventas actuales llegue a la unidad
																// requerida, se ejecutará el mensaje
			JOptionPane.showMessageDialog(null,
					"Venta Nro." + FrmPrincipal.contVent + "\n" + "Importe total general acumulado: S/"
							+ df.format(FrmPrincipal.impGeneral) + "\n" + "Porcentaje de la couta diaria: "
							+ df.format(FrmPrincipal.porcentajeCoutaDiaria) + "%",
					"Avance de Ventas", 1);
			FrmPrincipal.acuVent += 5; // Luego de mostrar el mensaje, el acumulador aumentará en 5
		} else
			return;
	}

	private void mostrarResultados(double impDscto, double impComp, double impPag, double precio, int cant,
			String obs) {
		txtS.setText("		BOLETA DE VENTA \n\n");
		txtS.append(" Precio		: S/." + df.format(FrmPrincipal.precio0) + "\n");
		txtS.append(" Cantidad		: " + cant + "\n");
		txtS.append(" Importe de compra	: S/." + df.format(impComp) + "\n");
		txtS.append(" Importe de descuento	: S/." + df.format(impDscto) + "\n");
		txtS.append(" Importe a pagar	: S/." + df.format(impPag) + "\n");
		txtS.append(" Obsequio		: " + obs + "\n");
	}

	protected void actionPerformedCboModelo(ActionEvent e) {
		int modelo;
		modelo = cboModelo.getSelectedIndex();
		switch (modelo) {
		case 0:
			txtPrecio.setText("" + FrmPrincipal.precio0);
			break;
		case 1:
			txtPrecio.setText("" + FrmPrincipal.precio1);
			break;
		case 2:
			txtPrecio.setText("" + FrmPrincipal.precio2);
			break;
		case 3:
			txtPrecio.setText("" + FrmPrincipal.precio3);
			break;
		default:
			txtPrecio.setText("" + FrmPrincipal.precio4);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
