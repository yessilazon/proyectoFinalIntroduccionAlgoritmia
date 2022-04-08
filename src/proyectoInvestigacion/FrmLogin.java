package proyectoInvestigacion;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import utils.Alertas;

public class FrmLogin extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JLabel lblPass;
	private JPasswordField jPass;
	private JButton btnIngresar;
	private JButton btnCancelar;

	public static String userAdmin = "admin";
	public static String passAdmin = "123";
	public static String login = "no ok";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 436);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBounds(102, 136, 74, 14);
		contentPane.add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(200, 133, 109, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		lblPass = new JLabel("Contrase\u00F1a:");
		lblPass.setForeground(Color.WHITE);
		lblPass.setBounds(102, 172, 74, 14);
		contentPane.add(lblPass);

		jPass = new JPasswordField();
		jPass.setBounds(200, 169, 109, 20);
		contentPane.add(jPass);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(75, 250, 89, 23);
		contentPane.add(btnIngresar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(256, 250, 89, 23);
		contentPane.add(btnCancelar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
	}

	protected void actionPerformedBtnIngresar(ActionEvent e) {
		String user, pass;
		user = getUser();
		pass = getPass();

		if (user.equals(userAdmin) && pass.equals(passAdmin)) {
			Alertas.mensajeAlerta("Bienvenido");
			FrmPrincipal prin = new FrmPrincipal();
			prin.setVisible(true);
			prin.setLocationRelativeTo(this);
			login = "ok";
			// cerrar ventana actual
			this.dispose();
		} else {
			Alertas.mensajeError("Usuario y/o password incorrecto");
		}

	}

	private String getUser() {
		return txtUsuario.getText().trim();
	}

	private String getPass() {
		return String.valueOf(jPass.getPassword());
	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		this.dispose();
	}
}
