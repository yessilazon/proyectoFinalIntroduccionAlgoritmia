package proyectoInvestigacion;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import utils.Alertas;

public class DlgConfiguracionObsequios extends JDialog implements ActionListener, FocusListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt1Unidad;
	private JTextField txt2A5Unidades;
	private JTextField txt6AMasUnidades;
	private JButton btnCancelar;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			if ("ok".equalsIgnoreCase(FrmLogin.login)) {
				DlgConfiguracionObsequios dialog = new DlgConfiguracionObsequios();
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
	public DlgConfiguracionObsequios() {
		setTitle("Configurar obsequios");
		setBounds(100, 100, 450, 145);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lbl1Unidad = new JLabel("1 unidad");
			lbl1Unidad.setBounds(10, 11, 63, 14);
			contentPanel.add(lbl1Unidad);
		}
		{
			txt1Unidad = new JTextField();
			txt1Unidad.addFocusListener(this);
			txt1Unidad.setBounds(176, 8, 86, 20);
			contentPanel.add(txt1Unidad);
			txt1Unidad.setColumns(10);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(335, 7, 89, 23);
			contentPanel.add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(335, 41, 89, 23);
			contentPanel.add(btnCancelar);
		}
		{
			txt2A5Unidades = new JTextField();
			txt2A5Unidades.addFocusListener(this);
			txt2A5Unidades.setBounds(176, 33, 86, 20);
			contentPanel.add(txt2A5Unidades);
			txt2A5Unidades.setColumns(10);
		}
		{
			txt6AMasUnidades = new JTextField();
			txt6AMasUnidades.addFocusListener(this);
			txt6AMasUnidades.setBounds(176, 64, 86, 20);
			contentPanel.add(txt6AMasUnidades);
			txt6AMasUnidades.setColumns(10);
		}
		{
			JLabel lbl2A5Unidad = new JLabel("2 a 5 Unidades");
			lbl2A5Unidad.setBounds(10, 36, 89, 14);
			contentPanel.add(lbl2A5Unidad);
		}
		{
			JLabel lbl6AMasUnidades = new JLabel("6 a m\u00E1s unidades");
			lbl6AMasUnidades.setBounds(10, 70, 105, 14);
			contentPanel.add(lbl6AMasUnidades);
		}
		// valores por defecto
		cargarObsequios();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}

	protected void actionPerformedBtnAceptar(ActionEvent e) {
		int resp = Alertas.mensajeConfirmar();
		if (resp == 0) {
			FrmPrincipal.obsequio1 = txt1Unidad.getText();
			FrmPrincipal.obsequio2 = txt2A5Unidades.getText();
			FrmPrincipal.obsequio3 = txt6AMasUnidades.getText();
			setVisible(false);
		}
	}

	private String validarObsequio(JTextField txt) {
		String rpta = txt.getText();
		if (rpta == null || "".equals(rpta)) {
			Alertas.mensajeError("El campo no puede estar vacío");
			txt.requestFocus();
			return null;
		}
		return rpta;
	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		setVisible(false);
	}

	public void cargarObsequios() {
		txt1Unidad.setText(FrmPrincipal.obsequio1);
		txt2A5Unidades.setText(FrmPrincipal.obsequio2);
		txt6AMasUnidades.setText(FrmPrincipal.obsequio3);
	}

	public void focusGained(FocusEvent e) {
	}

	public void focusLost(FocusEvent e) {
		if (e.getSource() == txt6AMasUnidades) {
			focusLostTxt6AMasUnidades(e);
		}
		if (e.getSource() == txt2A5Unidades) {
			focusLostTxt2A5Unidades(e);
		}
		if (e.getSource() == txt1Unidad) {
			focusLostTxt1Unidad(e);
		}
	}

	protected void focusLostTxt1Unidad(FocusEvent e) {
		validarObsequio(txt1Unidad);
	}

	protected void focusLostTxt2A5Unidades(FocusEvent e) {
		validarObsequio(txt2A5Unidades);
	}

	protected void focusLostTxt6AMasUnidades(FocusEvent e) {
		validarObsequio(txt6AMasUnidades);
	}
}
