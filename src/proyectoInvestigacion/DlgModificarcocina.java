package proyectoInvestigacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import utils.Alertas;
import utils.Utilitario;

public class DlgModificarcocina extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblModelo;
	private JComboBox<Object> cboModelo;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblAncho;
	private JTextField txtAncho;
	private JLabel lblAlto;
	private JTextField txtAlto;
	private JLabel lblFondo;
	private JTextField txtFondo;
	private JLabel lblQuemadores;
	private JTextField txtQuemadores;
	private JButton btnCerrar;
	private JButton btnGrabar;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			if ("ok".equalsIgnoreCase(FrmLogin.login)) {
				DlgModificarcocina dialog = new DlgModificarcocina();
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
	public DlgModificarcocina() {
		setTitle("Modificar Cocina");
		setBounds(100, 100, 463, 238);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblModelo.setForeground(new Color(0, 0, 0));
		lblModelo.setBounds(10, 11, 46, 14);
		contentPanel.add(lblModelo);

		cboModelo = new JComboBox<Object>();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota" }));
		cboModelo.setBounds(96, 7, 141, 22);
		contentPanel.add(cboModelo);

		lblPrecio = new JLabel("Precio (S/.)");
		lblPrecio.setForeground(new Color(0, 0, 0));
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrecio.setBounds(10, 42, 76, 14);
		contentPanel.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(96, 39, 141, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);

		lblAncho = new JLabel("Ancho (cm)");
		lblAncho.setForeground(new Color(0, 0, 0));
		lblAncho.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAncho.setBounds(10, 76, 76, 14);
		contentPanel.add(lblAncho);

		txtAncho = new JTextField();
		txtAncho.setBounds(96, 70, 141, 20);
		contentPanel.add(txtAncho);
		txtAncho.setColumns(10);

		lblAlto = new JLabel("Alto (cm)");
		lblAlto.setForeground(new Color(0, 0, 0));
		lblAlto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAlto.setBounds(10, 101, 76, 14);
		contentPanel.add(lblAlto);

		txtAlto = new JTextField();
		txtAlto.setBounds(96, 98, 141, 20);
		contentPanel.add(txtAlto);
		txtAlto.setColumns(10);

		lblFondo = new JLabel("Fondo");
		lblFondo.setForeground(new Color(0, 0, 0));
		lblFondo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFondo.setBounds(10, 135, 76, 14);
		contentPanel.add(lblFondo);

		txtFondo = new JTextField();
		txtFondo.setBounds(96, 132, 141, 20);
		contentPanel.add(txtFondo);
		txtFondo.setColumns(10);

		lblQuemadores = new JLabel("Quemadores");
		lblQuemadores.setForeground(new Color(0, 0, 0));
		lblQuemadores.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuemadores.setBounds(10, 167, 102, 14);
		contentPanel.add(lblQuemadores);

		txtQuemadores = new JTextField();
		txtQuemadores.setBounds(96, 163, 141, 20);
		contentPanel.add(txtQuemadores);
		txtQuemadores.setColumns(10);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(346, 7, 89, 23);
		contentPanel.add(btnCerrar);

		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(346, 38, 89, 23);
		contentPanel.add(btnGrabar);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(DlgModificarcocina.class.getResource("/imagen/computo.jpg")));
		lblNewLabel.setBounds(0, 0, 447, 199);
		contentPanel.add(lblNewLabel);
		cargarData();

	}

	private void cargarData() {
		txtPrecio.setText("949.0");
		txtAncho.setText("" + FrmPrincipal.ancho0);
		txtAlto.setText("" + FrmPrincipal.alto0);
		txtFondo.setText("" + FrmPrincipal.fondo0);
		txtQuemadores.setText("" + FrmPrincipal.quemadores0);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();

	}

	protected void actionPerformedCboModelo(ActionEvent e) {
		int modelo;
		modelo = cboModelo.getSelectedIndex();
		switch (modelo) {
		case 0:
			txtPrecio.setText("" + FrmPrincipal.precio0);
			txtAncho.setText("" + FrmPrincipal.ancho0);
			txtAlto.setText("" + FrmPrincipal.alto0);
			txtFondo.setText("" + FrmPrincipal.fondo0);
			txtQuemadores.setText("" + FrmPrincipal.quemadores0);
			break;
		case 1:
			txtPrecio.setText("" + FrmPrincipal.precio1);
			txtAncho.setText("" + FrmPrincipal.ancho1);
			txtAlto.setText("" + FrmPrincipal.alto1);
			txtFondo.setText("" + FrmPrincipal.fondo1);
			txtQuemadores.setText("" + FrmPrincipal.quemadores1);
			break;
		case 2:
			txtPrecio.setText("" + FrmPrincipal.precio2);
			txtAncho.setText("" + FrmPrincipal.ancho2);
			txtAlto.setText("" + FrmPrincipal.alto2);
			txtFondo.setText("" + FrmPrincipal.fondo2);
			txtQuemadores.setText("" + FrmPrincipal.quemadores2);
			break;
		case 3:
			txtPrecio.setText("" + FrmPrincipal.precio3);
			txtAncho.setText("" + FrmPrincipal.ancho3);
			txtAlto.setText("" + FrmPrincipal.alto3);
			txtFondo.setText("" + FrmPrincipal.fondo3);
			txtQuemadores.setText("" + FrmPrincipal.quemadores3);
			break;
		default:
			txtPrecio.setText("" + FrmPrincipal.precio4);
			txtAncho.setText("" + FrmPrincipal.ancho4);
			txtAlto.setText("" + FrmPrincipal.alto4);
			txtFondo.setText("" + FrmPrincipal.fondo4);
			txtQuemadores.setText("" + FrmPrincipal.quemadores4);
			break;
		}
	}

	protected void actionPerformedBtnGrabar(ActionEvent e) {
		int modelo, resp;
		modelo = cboModelo.getSelectedIndex();
		// VENTANA DE CONFIRMACION
		resp = JOptionPane.showConfirmDialog(this, "Seguro de guardar Cambios", "Sistema", JOptionPane.YES_NO_OPTION);
		// VALIDAR LA RESPUESTA DE LA VENTAN DE CONFIRMACION
		if (resp == 0) {// YES ---> SI ---> 0
			// metodo para guardar los cambios
			guardarCambios(modelo);
		}

	}

	private void guardarCambios(int modelo) {
		switch (modelo) {
		case 0:
			FrmPrincipal.precio0 = Utilitario.validarNumeroDouble(txtPrecio);
			if (FrmPrincipal.precio0 == 0) {
				Utilitario.limpiar(txtPrecio);
				return;
			}
			// CERRAR VENTANA ACTUAL
			this.dispose();

			FrmPrincipal.ancho0 = Utilitario.validarNumeroDouble(txtAncho);
			if (FrmPrincipal.ancho0 == 0) {
				Utilitario.limpiar(txtAncho);
				return;
			}
			// CERRAR VENTANA ACTUAL
			this.dispose();

			FrmPrincipal.alto0 = Utilitario.validarNumeroDouble(txtAlto);
			if (FrmPrincipal.alto0 == 0) {
				Utilitario.limpiar(txtAlto);
				return;
			}
			// CERRAR VENTANA ACTUAL
			this.dispose();

			FrmPrincipal.fondo0 = Utilitario.validarNumeroDouble(txtFondo);
			if (FrmPrincipal.fondo0 == 0) {
				Utilitario.limpiar(txtFondo);
				return;
			}
			// CERRAR VENTANA ACTUAL
			this.dispose();

			FrmPrincipal.quemadores0 = Utilitario.validarNumero(txtQuemadores);
			if (FrmPrincipal.quemadores0 == 0) {
				Utilitario.limpiar(txtQuemadores);
				return;
			}
			// CERRAR VENTANA ACTUAL
			this.dispose();
			break;
		case 1:
			FrmPrincipal.precio1 = Utilitario.validarNumeroDouble(txtPrecio);
			if (FrmPrincipal.precio1 == 0) {
				Utilitario.limpiar(txtPrecio);
				return;
			}
			// CERRAR VENTANA ACTUAL
			this.dispose();

			FrmPrincipal.ancho1 = Utilitario.validarNumeroDouble(txtAncho);
			if (FrmPrincipal.ancho1 == 0) {
				Utilitario.limpiar(txtAncho);
				return;
			}
			// CERRAR VENTANA ACTUAL
			this.dispose();

			FrmPrincipal.alto1 = Utilitario.validarNumeroDouble(txtAlto);
			if (FrmPrincipal.alto1 == 0) {
				Utilitario.limpiar(txtAlto);
				return;
			}
			// CERRAR VENTANA ACTUAL
			this.dispose();

			FrmPrincipal.fondo1 = Utilitario.validarNumeroDouble(txtFondo);
			if (FrmPrincipal.fondo1 == 0) {
				Utilitario.limpiar(txtFondo);
				return;
			}
			// CERRAR VENTANA ACTUAL
			this.dispose();

			FrmPrincipal.quemadores1 = Utilitario.validarNumero(txtQuemadores);
			if (FrmPrincipal.quemadores1 == 0) {
				Utilitario.limpiar(txtQuemadores);
				return;
			}
			// CERRAR VENTANA ACTUAL
			this.dispose();
			break;
		case 2:
			FrmPrincipal.precio2 = Utilitario.validarNumeroDouble(txtPrecio);
			if (FrmPrincipal.precio2 == 0) {
				Utilitario.limpiar(txtPrecio);
				return;
			}
			// CERRAR VENTANA ACTUAL
			this.dispose();

			FrmPrincipal.ancho2 = Utilitario.validarNumeroDouble(txtAncho);
			if (FrmPrincipal.ancho2 == 0) {
				Utilitario.limpiar(txtAncho);
				return;
			}
			// CERRAR VENTANA ACTUAL
			this.dispose();

			FrmPrincipal.alto2 = Utilitario.validarNumeroDouble(txtAlto);
			if (FrmPrincipal.alto2 == 0) {
				Utilitario.limpiar(txtAlto);
				return;
			}
			// CERRAR VENTANA ACTUAL
			this.dispose();

			FrmPrincipal.fondo2 = Utilitario.validarNumeroDouble(txtFondo);
			if (FrmPrincipal.fondo2 == 0) {
				Utilitario.limpiar(txtFondo);
				return;
			}
			// CERRAR VENTANA ACTUAL
			this.dispose();

			FrmPrincipal.quemadores2 = Utilitario.validarNumero(txtQuemadores);
			if (FrmPrincipal.quemadores2 == 0) {
				Utilitario.limpiar(txtQuemadores);
				return;
			}
			// CERRAR VENTANA ACTUAL
			this.dispose();

			break;
		case 3:
			FrmPrincipal.precio3 = Utilitario.validarNumeroDouble(txtPrecio);
			if (FrmPrincipal.precio3 == 0) {
				Utilitario.limpiar(txtPrecio);
				return;
			}
			// CERRAR VENTANA ACTUAL
			this.dispose();

			FrmPrincipal.ancho3 = Utilitario.validarNumeroDouble(txtAncho);
			if (FrmPrincipal.ancho3 == 0) {
				Utilitario.limpiar(txtAncho);
				return;
			}
			// CERRAR VENTANA ACTUAL
			this.dispose();

			FrmPrincipal.alto3 = Utilitario.validarNumeroDouble(txtAlto);
			if (FrmPrincipal.alto3 == 0) {
				Utilitario.limpiar(txtAlto);
				return;
			}
			// CERRAR VENTANA ACTUAL
			this.dispose();

			FrmPrincipal.fondo3 = Utilitario.validarNumeroDouble(txtFondo);
			if (FrmPrincipal.fondo3 == 0) {
				Utilitario.limpiar(txtFondo);
				return;
			}
			// CERRAR VENTANA ACTUAL
			this.dispose();

			FrmPrincipal.quemadores3 = Utilitario.validarNumero(txtQuemadores);
			if (FrmPrincipal.quemadores3 == 0) {
				Utilitario.limpiar(txtQuemadores);
				return;
			}
			// CERRAR VENTANA ACTUAL
			this.dispose();
			break;
		default:
			FrmPrincipal.precio4 = Utilitario.validarNumeroDouble(txtPrecio);
			if (FrmPrincipal.precio4 == 0) {
				Utilitario.limpiar(txtPrecio);
				return;
			}
			// CERRAR VENTANA ACTUAL
			this.dispose();

			FrmPrincipal.ancho4 = Utilitario.validarNumeroDouble(txtAncho);
			if (FrmPrincipal.ancho4 == 0) {
				Utilitario.limpiar(txtAncho);
				return;
			}
			// CERRAR VENTANA ACTUAL
			this.dispose();

			FrmPrincipal.alto4 = Utilitario.validarNumeroDouble(txtAlto);
			if (FrmPrincipal.alto4 == 0) {
				Utilitario.limpiar(txtAlto);
				return;
			}
			// CERRAR VENTANA ACTUAL
			this.dispose();

			FrmPrincipal.fondo4 = Utilitario.validarNumeroDouble(txtFondo);
			if (FrmPrincipal.fondo4 == 0) {
				Utilitario.limpiar(txtFondo);
				return;
			}
			// CERRAR VENTANA ACTUAL
			this.dispose();

			FrmPrincipal.quemadores4 = Utilitario.validarNumero(txtQuemadores);
			if (FrmPrincipal.quemadores4 == 0) {
				Utilitario.limpiar(txtQuemadores);
				return;
			}
			// CERRAR VENTANA ACTUAL
			this.dispose();
			break;
		}

	}
}
