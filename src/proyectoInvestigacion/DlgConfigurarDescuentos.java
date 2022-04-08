package proyectoInvestigacion;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import utils.Alertas;
import utils.Utilitario;

public class DlgConfigurarDescuentos extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lbl1a5Unidades;
	private JTextField txt1a5Unidades;
	private JLabel lblNewLabel_1;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblA;
	private JTextField txt6a10Unidades;
	private JLabel lblNewLabel;
	private JLabel lblA_1;
	private JTextField txt11a15Unidades;
	private JLabel lblNewLabel_2;
	private JLabel lblMasDe15Unidades;
	private JTextField txtMasDe15Unidades;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			if ("ok".equalsIgnoreCase(FrmLogin.login)) {
				DlgConfigurarDescuentos dialog = new DlgConfigurarDescuentos();
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
	public DlgConfigurarDescuentos() {
		setTitle("Configurar porcentaje de descuentos");
		setBounds(100, 100, 450, 162);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lbl1a5Unidades = new JLabel("1 a 5 unidades");
		lbl1a5Unidades.setBounds(10, 11, 110, 14);
		contentPanel.add(lbl1a5Unidades);

		txt1a5Unidades = new JTextField();
		txt1a5Unidades.setBounds(146, 5, 86, 20);
		contentPanel.add(txt1a5Unidades);
		txt1a5Unidades.setColumns(10);

		lblNewLabel_1 = new JLabel("%");
		lblNewLabel_1.setBounds(236, 11, 46, 14);
		contentPanel.add(lblNewLabel_1);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(322, 7, 89, 23);
		contentPanel.add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(322, 36, 89, 23);
		contentPanel.add(btnCancelar);

		lblA = new JLabel("6 a 10 unidades");
		lblA.setBounds(10, 39, 110, 14);
		contentPanel.add(lblA);

		txt6a10Unidades = new JTextField();
		txt6a10Unidades.setColumns(10);
		txt6a10Unidades.setBounds(146, 34, 86, 20);
		contentPanel.add(txt6a10Unidades);

		lblNewLabel = new JLabel("%");
		lblNewLabel.setBounds(236, 40, 46, 14);
		contentPanel.add(lblNewLabel);

		lblA_1 = new JLabel("11 a 15 unidades");
		lblA_1.setBounds(10, 67, 110, 14);
		contentPanel.add(lblA_1);

		txt11a15Unidades = new JTextField();
		txt11a15Unidades.setColumns(10);
		txt11a15Unidades.setBounds(146, 65, 86, 20);
		contentPanel.add(txt11a15Unidades);

		lblNewLabel_2 = new JLabel("%");
		lblNewLabel_2.setBounds(236, 65, 46, 14);
		contentPanel.add(lblNewLabel_2);

		lblMasDe15Unidades = new JLabel("M\u00E1s de 15 unidades");
		lblMasDe15Unidades.setBounds(10, 95, 126, 14);
		contentPanel.add(lblMasDe15Unidades);

		txtMasDe15Unidades = new JTextField();
		txtMasDe15Unidades.setColumns(10);
		txtMasDe15Unidades.setBounds(146, 89, 86, 20);
		contentPanel.add(txtMasDe15Unidades);

		lblNewLabel_3 = new JLabel("%");
		lblNewLabel_3.setBounds(236, 95, 46, 14);
		contentPanel.add(lblNewLabel_3);
		cargarPorcentaje();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}

	protected void actionPerformedBtnAceptar(ActionEvent e) {

		FrmPrincipal.porcentaje1 = Utilitario.validarNumeroDouble(txt1a5Unidades);
		if (FrmPrincipal.porcentaje1 == 0)
			Utilitario.limpiar(txt1a5Unidades);
		FrmPrincipal.porcentaje2 = Utilitario.validarNumeroDouble(txt6a10Unidades);
		if (FrmPrincipal.porcentaje2 == 0)
			Utilitario.limpiar(txt6a10Unidades);
		FrmPrincipal.porcentaje3 = Utilitario.validarNumeroDouble(txt11a15Unidades);
		if (FrmPrincipal.porcentaje3 == 0)
			Utilitario.limpiar(txt11a15Unidades);
		FrmPrincipal.porcentaje4 = Utilitario.validarNumeroDouble(txtMasDe15Unidades);
		if (FrmPrincipal.porcentaje4 == 0)
			Utilitario.limpiar(txtMasDe15Unidades);

	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		setVisible(false);
	}

	public void cargarPorcentaje() {
		txt1a5Unidades.setText(String.valueOf(FrmPrincipal.porcentaje1));
		txt6a10Unidades.setText(String.valueOf(FrmPrincipal.porcentaje2));
		txt11a15Unidades.setText(String.valueOf(FrmPrincipal.porcentaje3));
		txtMasDe15Unidades.setText(String.valueOf(FrmPrincipal.porcentaje4));
	}

}
