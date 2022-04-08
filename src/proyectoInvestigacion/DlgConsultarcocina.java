package proyectoInvestigacion;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import utils.Alertas;

public class DlgConsultarcocina extends JDialog implements ActionListener {

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
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			if ("ok".equalsIgnoreCase(FrmLogin.login)) {
				DlgConsultarcocina dialog = new DlgConsultarcocina();
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
	public DlgConsultarcocina() {
		setTitle("Consultar Cocina");
		setBounds(100, 100, 463, 238);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 11, 46, 14);
		contentPanel.add(lblModelo);

		cboModelo = new JComboBox<Object>();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota" }));
		cboModelo.setBounds(96, 7, 141, 22);
		contentPanel.add(cboModelo);

		lblPrecio = new JLabel("Precio (S/.)");
		lblPrecio.setBounds(10, 42, 76, 14);
		contentPanel.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(96, 39, 141, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);

		lblAncho = new JLabel("Ancho (cm)");
		lblAncho.setBounds(10, 76, 76, 14);
		contentPanel.add(lblAncho);

		txtAncho = new JTextField();
		txtAncho.setEditable(false);
		txtAncho.setBounds(96, 70, 141, 20);
		contentPanel.add(txtAncho);
		txtAncho.setColumns(10);

		lblAlto = new JLabel("Alto (cm)");
		lblAlto.setBounds(10, 101, 76, 14);
		contentPanel.add(lblAlto);

		txtAlto = new JTextField();
		txtAlto.setEditable(false);
		txtAlto.setBounds(96, 98, 141, 20);
		contentPanel.add(txtAlto);
		txtAlto.setColumns(10);

		lblFondo = new JLabel("Fondo");
		lblFondo.setBounds(10, 135, 76, 14);
		contentPanel.add(lblFondo);

		txtFondo = new JTextField();
		txtFondo.setEditable(false);
		txtFondo.setBounds(96, 132, 141, 20);
		contentPanel.add(txtFondo);
		txtFondo.setColumns(10);

		lblQuemadores = new JLabel("Quemadores");
		lblQuemadores.setBounds(10, 167, 111, 14);
		contentPanel.add(lblQuemadores);

		txtQuemadores = new JTextField();
		txtQuemadores.setEditable(false);
		txtQuemadores.setBounds(96, 164, 141, 20);
		contentPanel.add(txtQuemadores);
		txtQuemadores.setColumns(10);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(346, 7, 89, 23);
		contentPanel.add(btnCerrar);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(DlgConsultarcocina.class.getResource("/imagen/computo.jpg")));
		lblNewLabel.setBounds(0, 0, 447, 199);
		contentPanel.add(lblNewLabel);
		// metodo cargar datos
		cargarData();
	}

	private void cargarData() {
		txtPrecio.setText("" + FrmPrincipal.precio0);
		txtAncho.setText("" + FrmPrincipal.ancho0);
		txtAlto.setText("" + FrmPrincipal.alto0);
		txtFondo.setText("" + FrmPrincipal.fondo0);
		txtQuemadores.setText("" + FrmPrincipal.quemadores0);

	}

	public void actionPerformed(ActionEvent e) {
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
}
