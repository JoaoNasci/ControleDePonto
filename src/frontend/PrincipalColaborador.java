package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import backend.Eventos;

import javax.swing.JTextField;

public class PrincipalColaborador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalColaborador frame = new PrincipalColaborador();
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
	/**
	 * 
	 */
	public PrincipalColaborador() {
		setMinimumSize(new Dimension(1243, 834));
		setMaximumSize(new Dimension(1243, 834));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(55, 55, 55));
		contentPane.setMinimumSize(new Dimension(1243, 834));
		contentPane.setMaximumSize(new Dimension(1243, 834));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(44, 44, 44));
		panel.setBounds(0, 0, 1227, 88);
		contentPane.add(panel);
		
		JButton btnEditarRegistro = new JButton("Solicitar Reajuste");
		btnEditarRegistro.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditarRegistro.setFocusTraversalKeysEnabled(false);
		btnEditarRegistro.setFocusPainted(false);
		btnEditarRegistro.setBorderPainted(false);
		btnEditarRegistro.setBackground(new Color(255, 102, 51));
		btnEditarRegistro.setBounds(1072, 30, 145, 32);
		panel.add(btnEditarRegistro);
		
		JLabel lblNewLabel = new JLabel("Visualizar Registros de ponto");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 30, 291, 28);
		panel.add(lblNewLabel);
		
		Eventos eventos = new Eventos();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 173, 1189, 480);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
		
		table.setModel(eventos.exibirDados());
		table.setSelectionForeground(Color.WHITE);
		table.setSelectionBackground(new Color(77, 77, 77));
		table.setFocusable(false);
		table.setBackground(new Color(44, 44, 44)); 
		
		
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 140, 173, 26);
		contentPane.add(textField); 
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPesquisar.setFocusTraversalKeysEnabled(false);
		btnPesquisar.setFocusPainted(false);
		btnPesquisar.setBorderPainted(false);
		btnPesquisar.setBackground(new Color(255, 102, 51));
		btnPesquisar.setBounds(199, 140, 110, 26);
		contentPane.add(btnPesquisar);
	}
}
