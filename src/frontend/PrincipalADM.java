package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.Eventos;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class PrincipalADM extends JFrame {

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
					PrincipalADM frame = new PrincipalADM();
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
	public PrincipalADM() {
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
		
		JLabel lblNewLabel = new JLabel("Visualizar Registros de ponto");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 30, 291, 28);
		panel.add(lblNewLabel);
		
		Eventos eventos = new Eventos();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 181, 1193, 467);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setSelectionForeground(Color.WHITE);
		table.setSelectionBackground(new Color(77, 77, 77));
		table.setForeground(Color.WHITE);
		table.setFocusable(false);
		table.setBackground(new Color(44, 44, 44));
		table.setModel(eventos.exibirDados());
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 146, 173, 26);
		contentPane.add(textField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(193, 146, 141, 26);
		contentPane.add(comboBox);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPesquisar.setFocusTraversalKeysEnabled(false);
		btnPesquisar.setFocusPainted(false);
		btnPesquisar.setBorderPainted(false);
		btnPesquisar.setBackground(new Color(255, 102, 51));
		btnPesquisar.setBounds(344, 145, 110, 26);
		contentPane.add(btnPesquisar);
	}
}
