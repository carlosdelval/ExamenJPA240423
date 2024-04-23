package vistas;

import java.awt.EventQueue;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tablas.MiTableModel;

import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private PanelGestion panelGestion;
	private MiTableModel tableModel;
	private JSplitPane splitPane;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		
		panelGestion = new PanelGestion();
		tableModel = new MiTableModel();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setResizeWeight(0.5);
		contentPane.add(splitPane);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		
		table = new JTable(tableModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				muestraDatos();
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panelGestion);
	}
	
	/**
	 * Método que guarda los datos
	 */
	
	private void muestraDatos() {
		int fila = this.table.getSelectedRow();
		this.panelGestion.setId(this.tableModel.getValueAt(fila,0).toString());
		this.panelGestion.setDescripcion((String)this.tableModel.getValueAt(fila,1));
		this.panelGestion.setSaldo("" + this.tableModel.getValueAt(fila,2));
		this.panelGestion.setLimite("" + this.tableModel.getValueAt(fila,3));
		this.panelGestion.setTipoContrato((int)this.tableModel.getValueAt(fila,4));
		this.panelGestion.setUser((int)this.tableModel.getValueAt(fila,5));
		String strFecha = (this.tableModel.getValueAt(fila,6) != null)? 
				sdf.format(this.tableModel.getValueAt(fila,6)) : "";
		this.panelGestion.setFecha(strFecha);
	}
}
