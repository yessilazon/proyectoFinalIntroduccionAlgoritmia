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

public class DlgConfigurarCuotaDiaria extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCuotaDiaria;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			if ("ok".equalsIgnoreCase(FrmLogin.login)) {
				DlgConfigurarCuotaDiaria dialog = new DlgConfigurarCuotaDiaria();
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
	public DlgConfigurarCuotaDiaria() {
		setTitle("Configurar cuota diaria ");
		setBounds(100, 100, 450, 100);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCuotaDiariaEsperada = new JLabel("Cuota diaria esperada (s/.)");
			lblCuotaDiariaEsperada.setBounds(10, 11, 166, 14);
			contentPanel.add(lblCuotaDiariaEsperada);
		}
		{
			txtCuotaDiaria = new JTextField();
			txtCuotaDiaria.setBounds(199, 8, 86, 20);
			contentPanel.add(txtCuotaDiaria);
			txtCuotaDiaria.setColumns(10);
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
			btnCancelar.setBounds(335, 32, 89, 23);
			contentPanel.add(btnCancelar);
		}
		cargarCuotaDiaria();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}

	}

	// ***********************************************************
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		FrmPrincipal.cuotaDiaria = Utilitario.validarNumero(txtCuotaDiaria);
		if (FrmPrincipal.cuotaDiaria == 0)
			Utilitario.limpiar(txtCuotaDiaria);
	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		setVisible(false);
	}

	public void cargarCuotaDiaria() {
		txtCuotaDiaria.setText(String.valueOf(FrmPrincipal.cuotaDiaria));
	}

	/*
	 * protected void actionPerformedBtnAceptar(ActionEvent e) { int resp; double
	 * cuota;
	 * 
	 * try { cuota = getcuota(); if (cuota <= 0) {
	 * Alertas.mensajeError("Ingrese valores mayores a 0");
	 * txtCuotaDiaria.setText(""+ FrmPrincipal.cuotaDiaria); return; } } catch
	 * (NumberFormatException e1) {
	 * Alertas.mensajeError("Ingrese valores numéricos"); txtCuotaDiaria.setText(""+
	 * FrmPrincipal.cuotaDiaria); return; }
	 * 
	 * resp = Alertas.mensajeConfirmar(); if (resp == 0) { FrmPrincipal.cuotaDiaria
	 * = cuota; } this.dispose(); }
	 * 
	 * private double getcuota() { return
	 * Double.parseDouble(txtCuotaDiaria.getText()); }
	 */
}
