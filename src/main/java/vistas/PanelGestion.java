package vistas;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import controladores.ControladorContrato;
import controladores.ControladorUsuario;
import entidades.Contrato;
import entidades.Usuario;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class PanelGestion extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfDescripcion;
	private JTextField jtfSaldo;
	private JTextField jtfLimite;
	private JTextField jtfFecha;
	private JComboBox<Usuario> jcbUser;
	private JRadioButton rdbPrestamo;
	private JRadioButton rdbCuentaBancaria;
	private JRadioButton rdbTarjetaCredito;
	private JRadioButton rdbTarjetaDebito;
	private JPanel panel;
	private ButtonGroup jBGroup;
	private JButton btnGuardar;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Create the frame.
	 */
	public PanelGestion() {
		setLayout(new BorderLayout(0, 0));
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_contentPane);

		JLabel lblGestinDeContratos = new JLabel("Gestión de contratos");
		GridBagConstraints gbc_lblGestinDeContratos = new GridBagConstraints();
		gbc_lblGestinDeContratos.insets = new Insets(0, 0, 5, 5);
		gbc_lblGestinDeContratos.gridx = 1;
		gbc_lblGestinDeContratos.gridy = 0;
		panel.add(lblGestinDeContratos, gbc_lblGestinDeContratos);

		JLabel lblId = new JLabel("ID:");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		panel.add(lblId, gbc_lblId);

		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.gridwidth = 2;
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		panel.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		JLabel lblNewLabel = new JLabel("Tipo de contrato:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		rdbCuentaBancaria = new JRadioButton("Cuenta bancaria");
		GridBagConstraints gbc_rdbCuentaBancaria = new GridBagConstraints();
		gbc_rdbCuentaBancaria.insets = new Insets(0, 0, 5, 5);
		gbc_rdbCuentaBancaria.gridx = 1;
		gbc_rdbCuentaBancaria.gridy = 2;
		panel.add(rdbCuentaBancaria, gbc_rdbCuentaBancaria);

		rdbTarjetaCredito = new JRadioButton("Tarjeta credito");
		GridBagConstraints gbc_rdbTarjetaCredito = new GridBagConstraints();
		gbc_rdbTarjetaCredito.insets = new Insets(0, 0, 5, 0);
		gbc_rdbTarjetaCredito.gridx = 2;
		gbc_rdbTarjetaCredito.gridy = 2;
		panel.add(rdbTarjetaCredito, gbc_rdbTarjetaCredito);

		rdbTarjetaDebito = new JRadioButton("Tarjeta debito");
		GridBagConstraints gbc_rdbTarjetaDebito = new GridBagConstraints();
		gbc_rdbTarjetaDebito.insets = new Insets(0, 0, 5, 5);
		gbc_rdbTarjetaDebito.gridx = 1;
		gbc_rdbTarjetaDebito.gridy = 3;
		panel.add(rdbTarjetaDebito, gbc_rdbTarjetaDebito);

		rdbPrestamo = new JRadioButton("Prestamo");
		GridBagConstraints gbc_rdbPrestamo = new GridBagConstraints();
		gbc_rdbPrestamo.insets = new Insets(0, 0, 5, 0);
		gbc_rdbPrestamo.gridx = 2;
		gbc_rdbPrestamo.gridy = 3;
		panel.add(rdbPrestamo, gbc_rdbPrestamo);

		JLabel lblDescripcin = new JLabel("Descripción:");
		GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
		gbc_lblDescripcin.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcin.gridx = 0;
		gbc_lblDescripcin.gridy = 5;
		panel.add(lblDescripcin, gbc_lblDescripcin);

		jtfDescripcion = new JTextField();
		GridBagConstraints gbc_jtdDescripcion = new GridBagConstraints();
		gbc_jtdDescripcion.gridwidth = 2;
		gbc_jtdDescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_jtdDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtdDescripcion.gridx = 1;
		gbc_jtdDescripcion.gridy = 5;
		panel.add(jtfDescripcion, gbc_jtdDescripcion);
		jtfDescripcion.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 6;
		panel.add(lblUsuario, gbc_lblUsuario);

		jcbUser = new JComboBox();
		GridBagConstraints gbc_jcbUser = new GridBagConstraints();
		gbc_jcbUser.insets = new Insets(0, 0, 5, 5);
		gbc_jcbUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbUser.gridx = 1;
		gbc_jcbUser.gridy = 6;
		panel.add(jcbUser, gbc_jcbUser);

		JButton btnGestionarUser = new JButton("Gestionar user");
		btnGestionarUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelUsuario userPanel = new PanelUsuario();
				recursos.Utils.abrirNuevoDialogo(userPanel, "Gestión de usuario");
			}
		});
		GridBagConstraints gbc_btnGestionarUser = new GridBagConstraints();
		gbc_btnGestionarUser.insets = new Insets(0, 0, 5, 0);
		gbc_btnGestionarUser.gridx = 2;
		gbc_btnGestionarUser.gridy = 6;
		panel.add(btnGestionarUser, gbc_btnGestionarUser);

		JLabel lblSaldo = new JLabel("Saldo(€):");
		GridBagConstraints gbc_lblSaldo = new GridBagConstraints();
		gbc_lblSaldo.anchor = GridBagConstraints.EAST;
		gbc_lblSaldo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSaldo.gridx = 0;
		gbc_lblSaldo.gridy = 7;
		panel.add(lblSaldo, gbc_lblSaldo);

		jtfSaldo = new JTextField();
		GridBagConstraints gbc_jtfSaldo = new GridBagConstraints();
		gbc_jtfSaldo.gridwidth = 2;
		gbc_jtfSaldo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfSaldo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSaldo.gridx = 1;
		gbc_jtfSaldo.gridy = 7;
		panel.add(jtfSaldo, gbc_jtfSaldo);
		jtfSaldo.setColumns(10);

		JLabel lblLmite = new JLabel("Límite(€):");
		GridBagConstraints gbc_lblLmite = new GridBagConstraints();
		gbc_lblLmite.anchor = GridBagConstraints.EAST;
		gbc_lblLmite.insets = new Insets(0, 0, 5, 5);
		gbc_lblLmite.gridx = 0;
		gbc_lblLmite.gridy = 8;
		panel.add(lblLmite, gbc_lblLmite);

		jtfLimite = new JTextField();
		GridBagConstraints gbc_jtfLimite = new GridBagConstraints();
		gbc_jtfLimite.gridwidth = 2;
		gbc_jtfLimite.insets = new Insets(0, 0, 5, 0);
		gbc_jtfLimite.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLimite.gridx = 1;
		gbc_jtfLimite.gridy = 8;
		panel.add(jtfLimite, gbc_jtfLimite);
		jtfLimite.setColumns(10);

		JLabel lblFechaFirma = new JLabel("Fecha firma:");
		GridBagConstraints gbc_lblFechaFirma = new GridBagConstraints();
		gbc_lblFechaFirma.anchor = GridBagConstraints.EAST;
		gbc_lblFechaFirma.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaFirma.gridx = 0;
		gbc_lblFechaFirma.gridy = 9;
		panel.add(lblFechaFirma, gbc_lblFechaFirma);

		jtfFecha = new JTextField();
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFecha.gridwidth = 2;
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 1;
		gbc_jtfFecha.gridy = 9;
		panel.add(jtfFecha, gbc_jtfFecha);
		jtfFecha.setColumns(10);

		// Creamos el ButtonGroup.
		jBGroup = new ButtonGroup();
		jBGroup.add(rdbPrestamo);
		jBGroup.add(rdbCuentaBancaria);
		jBGroup.add(rdbTarjetaDebito);
		jBGroup.add(rdbTarjetaCredito);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					guardar();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 11;
		panel.add(btnGuardar, gbc_btnGuardar);
		
		cargaUsuarios();
	}
	
	/**
	 * Método que carga los usuarios al combobox
	 */
	
	private void cargaUsuarios() {
		ControladorUsuario cu = new ControladorUsuario();
		List<Usuario> l = (List<Usuario>)cu.findAll();
		for(Usuario u : l) {
			this.jcbUser.addItem(u);
		}
	}
	
	/**
	 * Setters para los jtextfields etc
	 * @param e
	 */

	public void setId(String e) {
		this.jtfId.setText(e);
	}

	public void setDescripcion(String e) {
		this.jtfDescripcion.setText(e);
	}

	public void setSaldo(String e) {
		this.jtfSaldo.setText(e);
	}

	public void setLimite(String e) {
		this.jtfLimite.setText(e);
	}

	public void setFecha(String e) {
		this.jtfFecha.setText(e);
	}

	public void setUser(int e) {
		this.jcbUser.setSelectedIndex(e-1);
	}

	public void setTipoContrato(int e) {
		if (e == 1) {
			this.rdbCuentaBancaria.setSelected(true);
		}
		if (e == 2) {
			this.rdbTarjetaCredito.setSelected(true);
		}
		if (e == 3) {
			this.rdbTarjetaDebito.setSelected(true);
		}
		if (e == 4) {
			this.rdbPrestamo.setSelected(true);
		}
	}
	
	/**
	 * Método que guarda
	 * @throws ParseException
	 */
	
	private void guardar() throws ParseException {
		
		
		//Comprobamos la descripcion si es valida
		if (!isDescripcionValid()) {
			JOptionPane.showMessageDialog(null,
					"Error. La longitud de la descripcion debe ser minimo 4 caracteres.");
			return;
		}
		
		//Comprobamos si el saldo o el limite son doubles
		if (!isSaldoLimitDouble(this.jtfLimite.getText())) {
			JOptionPane.showMessageDialog(null,
					"Error. El límite no es double.");
			return;
		}
		
		if (!isSaldoLimitDouble(this.jtfSaldo.getText())) {
			JOptionPane.showMessageDialog(null,
					"Error. El saldo no es double.");
			return;
		}
		
		//Guardamos
		ControladorContrato cc = new ControladorContrato();
		Contrato c = new Contrato();
		c.setId(Integer.parseInt(this.jtfId.getText()));
		c.setDescripcion(this.jtfDescripcion.getText());
		int idTipo = 0;
		if(this.rdbCuentaBancaria.isSelected()) idTipo = 1;
		if(this.rdbTarjetaCredito.isSelected()) idTipo = 2;
		if(this.rdbTarjetaDebito.isSelected()) idTipo = 3;
		if(this.rdbPrestamo.isSelected()) idTipo = 4;
		c.setIdTipoContrato(idTipo);
		c.setIdUsuario(((Usuario)this.jcbUser.getSelectedItem()).getId());
		c.setSaldo(Double.parseDouble(this.jtfSaldo.getText()));
		c.setLimite(Double.parseDouble(this.jtfLimite.getText()));
		c.setFechaFirma(sdf.parse(this.jtfFecha.getText()));
		cc.update(c);
	}
	
	/**
	 * Método que comprueba si la descripcion es valida
	 * @return
	 */
	
	private Boolean isDescripcionValid() {
		if(this.jtfDescripcion.getText().length() < 4) return false;
		return true;
	}
	
	private Boolean isSaldoLimitDouble(String s) {
		if(s.contains(",") || s.contains(".")) return true;
		else return false;
	}
}
