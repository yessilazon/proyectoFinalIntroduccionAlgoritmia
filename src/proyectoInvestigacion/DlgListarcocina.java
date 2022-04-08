package proyectoInvestigacion;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import utils.Alertas;

public class DlgListarcocina extends JDialog implements AncestorListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JButton btnCerrar;
	private JButton btnListar;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			if ("ok".equalsIgnoreCase(FrmLogin.login)) {
				DlgListarcocina dialog = new DlgListarcocina();
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
	public DlgListarcocina() {
		setTitle("Listado de cocinas");
		setBounds(100, 100, 492, 408);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 11, 456, 317);
		contentPanel.add(scrollPane);

		txtS = new JTextArea();
		txtS.addAncestorListener(this);
		scrollPane.setViewportView(txtS);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(95, 335, 89, 23);
		contentPanel.add(btnCerrar);

		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(272, 335, 89, 23);
		contentPanel.add(btnListar);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 476, 369);
		contentPanel.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(DlgListarcocina.class.getResource("/imagen/computo.jpg")));
		lblNewLabel_1.setBounds(0, 0, 476, 369);
		contentPanel.add(lblNewLabel_1);
	}

	public void ancestorAdded(AncestorEvent event) {
		if (event.getSource() == txtS) {
			ancestorAddedTxtS(event);
		}
	}

	public void ancestorMoved(AncestorEvent event) {
	}

	public void ancestorRemoved(AncestorEvent event) {
	}

	protected void ancestorAddedTxtS(AncestorEvent event) {
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
	}

	protected void actionPerformedBtnListar(ActionEvent e) {
		mostrarListado();

	}

	private void mostrarListado() {
		txtS.setText("LISTADO DE COCINAS \n\n");
		imprimir("Modelo           	: " + FrmPrincipal.modelo0);
		imprimir("Precio             	: " + FrmPrincipal.precio0);
		imprimir("Profundidad  	: " + FrmPrincipal.fondo0 + " cm");
		imprimir("Ancho            	: " + FrmPrincipal.ancho0 + " cm");
		imprimir("Alto                  	: " + FrmPrincipal.alto0 + " cm");
		imprimir("Quemadores	: " + FrmPrincipal.quemadores0);
		imprimir("");
		imprimir("Modelo           	: " + FrmPrincipal.modelo1);
		imprimir("Precio             	: " + FrmPrincipal.precio1);
		imprimir("Profundidad  	: " + FrmPrincipal.fondo1 + " cm");
		imprimir("Ancho            	: " + FrmPrincipal.ancho1 + " cm");
		imprimir("Alto                  	: " + FrmPrincipal.alto1 + " cm");
		imprimir("Quemadores	: " + FrmPrincipal.quemadores1);
		imprimir("");
		imprimir("Modelo           	: " + FrmPrincipal.modelo2);
		imprimir("Precio             	: " + FrmPrincipal.precio2);
		imprimir("Profundidad  	: " + FrmPrincipal.fondo2 + " cm");
		imprimir("Ancho            	: " + FrmPrincipal.ancho2 + " cm");
		imprimir("Alto                  	: " + FrmPrincipal.alto2 + " cm");
		imprimir("Quemadores	: " + FrmPrincipal.quemadores2);
		imprimir("");
		imprimir("Modelo           	: " + FrmPrincipal.modelo3);
		imprimir("Precio             	: " + FrmPrincipal.precio3);
		imprimir("Profundidad  	: " + FrmPrincipal.fondo3 + " cm");
		imprimir("Ancho            	: " + FrmPrincipal.ancho3 + " cm");
		imprimir("Alto                  	: " + FrmPrincipal.alto3 + " cm");
		imprimir("Quemadores	: " + FrmPrincipal.quemadores3);
		imprimir("");
		imprimir("Modelo           	: " + FrmPrincipal.modelo4);
		imprimir("Precio             	: " + FrmPrincipal.precio4);
		imprimir("Profundidad  	: " + FrmPrincipal.fondo4 + " cm");
		imprimir("Ancho            	: " + FrmPrincipal.ancho4 + " cm");
		imprimir("Alto                  	: " + FrmPrincipal.alto4 + " cm");
		imprimir("Quemadores	: " + FrmPrincipal.quemadores4);

	}

	private void imprimir(String cad) {
		txtS.append(cad + "\n");
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
