package proyectoInvestigacion;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
//import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import utils.Alertas;

public class DlgAcerdaDeTienda extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblTienda;
	private JSeparator separator;
	private JLabel lblAutores;
	private JLabel lblSantillan;
	private JLabel lblTorres;
	private JLabel lblMaguina;
	private JLabel lblBarrena;
	private JButton btnCerrar;
	private JLabel lblLazon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			if ("ok".equalsIgnoreCase(FrmLogin.login)) {
				DlgAcerdaDeTienda dialog = new DlgAcerdaDeTienda();
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
	public DlgAcerdaDeTienda() {
		setTitle("Acerca de Tienda");
		setBounds(100, 100, 501, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblTienda = new JLabel("Tienda 1.0");
		lblTienda.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTienda.setHorizontalAlignment(SwingConstants.CENTER);
		lblTienda.setBounds(182, 15, 121, 19);
		contentPanel.add(lblTienda);

		separator = new JSeparator();
		separator.setBounds(10, 45, 465, 2);
		contentPanel.add(separator);

		lblAutores = new JLabel("Autores");
		lblAutores.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAutores.setBounds(217, 60, 61, 14);
		contentPanel.add(lblAutores);

		lblSantillan = new JLabel("Klinsmann Santillan");
		lblSantillan.setHorizontalAlignment(SwingConstants.CENTER);
		lblSantillan.setBounds(182, 85, 121, 14);
		contentPanel.add(lblSantillan);

		lblTorres = new JLabel("Edinson Torres");
		lblTorres.setHorizontalAlignment(SwingConstants.CENTER);
		lblTorres.setBounds(182, 136, 121, 14);
		contentPanel.add(lblTorres);

		lblMaguina = new JLabel("Jean Pierre Magui\u00F1a");
		lblMaguina.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaguina.setBounds(182, 160, 121, 14);
		contentPanel.add(lblMaguina);

		lblBarrena = new JLabel("Augusto Barrena");
		lblBarrena.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarrena.setBounds(182, 189, 121, 14);
		contentPanel.add(lblBarrena);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(199, 227, 89, 23);
		contentPanel.add(btnCerrar);

		lblLazon = new JLabel("Marlene Lazon");
		lblLazon.setHorizontalAlignment(SwingConstants.CENTER);
		lblLazon.setBounds(182, 110, 121, 14);
		contentPanel.add(lblLazon);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
