package vistas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import controladores.ControladorContrato;
import controladores.ControladorUsuario;
import entidades.Contrato;
import entidades.Usuario;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class PanelUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private String color1 = "#FF00FF";
	private String color2 = "#9890A5";
	private String color3 = "#765456";
	private String color4 = "#879876";
	private JTextField jtfId;
	private JTextField jtfUser;
	private JPasswordField passwordField;
	private JTextField jtfEmail;
	private JComboBox jcbColor;

	/**
	 * Create the panel.
	 */
	public PanelUsuario() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.decode(color1));
		panel.setBounds(0, 0, 450, 310);

		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 120, 213, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblGestinUsuario = new JLabel("Gestión usuario");
		GridBagConstraints gbc_lblGestinUsuario = new GridBagConstraints();
		gbc_lblGestinUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_lblGestinUsuario.gridx = 1;
		gbc_lblGestinUsuario.gridy = 0;
		panel.add(lblGestinUsuario, gbc_lblGestinUsuario);

		JLabel lblId = new JLabel("Id:");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 2;
		panel.add(lblId, gbc_lblId);

		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 2;
		panel.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 3;
		panel.add(lblUsuario, gbc_lblUsuario);

		jtfUser = new JTextField();
		GridBagConstraints gbc_jtfUser = new GridBagConstraints();
		gbc_jtfUser.insets = new Insets(0, 0, 5, 0);
		gbc_jtfUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUser.gridx = 1;
		gbc_jtfUser.gridy = 3;
		panel.add(jtfUser, gbc_jtfUser);
		jtfUser.setColumns(10);

		JLabel lblContrasea = new JLabel("Contraseña:");
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 0;
		gbc_lblContrasea.gridy = 4;
		panel.add(lblContrasea, gbc_lblContrasea);

		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 4;
		panel.add(passwordField, gbc_passwordField);

		JLabel lblEmail = new JLabel("E-mail:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 5;
		panel.add(lblEmail, gbc_lblEmail);

		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 5;
		panel.add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);

		JLabel lblColorPreferido = new JLabel("Color:");
		GridBagConstraints gbc_lblColorPreferido = new GridBagConstraints();
		gbc_lblColorPreferido.anchor = GridBagConstraints.EAST;
		gbc_lblColorPreferido.insets = new Insets(0, 0, 5, 5);
		gbc_lblColorPreferido.gridx = 0;
		gbc_lblColorPreferido.gridy = 6;
		panel.add(lblColorPreferido, gbc_lblColorPreferido);

		jcbColor = new JComboBox();
		jcbColor.addItem(color1);
		jcbColor.addItem(color2);
		jcbColor.addItem(color3);
		jcbColor.addItem(color4);
		GridBagConstraints gbc_jcbColor = new GridBagConstraints();
		gbc_jcbColor.insets = new Insets(0, 0, 5, 0);
		gbc_jcbColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbColor.gridx = 1;
		gbc_jcbColor.gridy = 6;
		panel.add(jcbColor, gbc_jcbColor);
		jcbColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setBackground(Color.decode((String) jcbColor.getSelectedItem()));
			}
		});

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 9;
		panel.add(btnGuardar, gbc_btnGuardar);

		this.setLayout(new BorderLayout());
		add(panel, BorderLayout.CENTER);
	}
	
	/**
	 * Método que guarda user
	 */

	private void guardar() {
		
		//Comprobamos id, usuario, email
		if (!esEmailValido(this.jtfEmail.getText())) {
			JOptionPane.showMessageDialog(null,
					"Error. El email no es correcto.");
			return;
		}
		
		if(this.jtfId.getText() == null || this.jtfUser.getText() == null) {
			JOptionPane.showMessageDialog(null,
					"Error. Id o usuario nulos.");
			return;
		}
		
		
		//Guardamos
		ControladorUsuario cc = new ControladorUsuario();
		Usuario c = new Usuario();
		c.setId(Integer.parseInt(this.jtfId.getText()));
		c.setNombreUsuario(this.jtfUser.getText());
		c.setEmail(this.jtfEmail.getText());
		c.setColorPreferido((String) this.jcbColor.getSelectedItem());
		c.setPassword(this.passwordField.getSelectedText());
		cc.update(c);
	}
	
	/**
	 * Método que comprueba email
	 * @param email
	 * @return
	 */
	
	private boolean esEmailValido(String email) {
        if (email == null || email.trim().isEmpty()) return false;
        
        int arrobaIndex = email.indexOf('@');
        int puntoIndex = email.lastIndexOf('.');
        
        return arrobaIndex > 0 && puntoIndex > arrobaIndex && puntoIndex < email.length() - 1 && !email.contains("..");
    }

}
