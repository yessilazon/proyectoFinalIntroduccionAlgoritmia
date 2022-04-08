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

public class DlgConfigurarCantidadOptima extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCantidadesOptimasDeUnidadesVendidas;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			if ("ok".equalsIgnoreCase(FrmLogin.login)) {
				DlgConfigurarCantidadOptima dialog = new DlgConfigurarCantidadOptima();
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
	public DlgConfigurarCantidadOptima() {
		setTitle("Configurar cantidad \u00F3ptima");
		setBounds(100, 100, 514, 118);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCantidadesOptimasDeUnidadesVendidas = new JLabel("Cantidad \u00F3ptima de unidades vendidas ");
			lblCantidadesOptimasDeUnidadesVendidas.setBounds(10, 11, 248, 14);
			contentPanel.add(lblCantidadesOptimasDeUnidadesVendidas);
		}
		{
			txtCantidadesOptimasDeUnidadesVendidas = new JTextField();
			txtCantidadesOptimasDeUnidadesVendidas.setBounds(268, 8, 86, 20);
			contentPanel.add(txtCantidadesOptimasDeUnidadesVendidas);
			txtCantidadesOptimasDeUnidadesVendidas.setColumns(10);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(399, 7, 89, 23);
			contentPanel.add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(399, 41, 89, 23);
			contentPanel.add(btnCancelar);
		}
		// cargar valor por defecto
		cargarCantidadOptima();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}

	public void cargarCantidadOptima() {
		txtCantidadesOptimasDeUnidadesVendidas.setText("" + FrmPrincipal.cantidadOptima);
	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		setVisible(false);
	}

	protected void actionPerformedBtnAceptar(ActionEvent e) {
		FrmPrincipal.cantidadOptima = Utilitario.validarNumero(txtCantidadesOptimasDeUnidadesVendidas);
		if (FrmPrincipal.cantidadOptima == 0)
			Utilitario.limpiar(txtCantidadesOptimasDeUnidadesVendidas);
	}

	/*
	 * protected void actionPerformedBtnAceptar(ActionEvent e) { int resp, cant;
	 * 
	 * try { cant = getCant(); if (cant <= 0) {
	 * Alertas.mensajeError("Ingrese valores mayores a 0");
	 * txtCantidadesOptimasDeUnidadesVendidas.setText(""+
	 * FrmPrincipal.cantidadOptima); return; } } catch (NumberFormatException e1) {
	 * Alertas.mensajeError("Ingrese valores numéricos");
	 * txtCantidadesOptimasDeUnidadesVendidas.setText(""+
	 * FrmPrincipal.cantidadOptima); return; resp = Alertas.mensajeConfirmar(); if
	 * (resp == 0) FrmPrincipal.cantidadOptima = cant; this.dispose(); }
	 * this.dispose(); }
	 * 
	 * private int getCant(){ return txtCantidadesOptimasDeUnidadesVendidas; }
	 * 
	 * private int guardarCambios() { int resp; resp = Alertas.mensajeConfirmar();
	 * if (resp == 0) { ; } this.dispose(); }
	 */
}
