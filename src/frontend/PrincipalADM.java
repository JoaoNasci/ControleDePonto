package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JEditorPane;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import backend.Eventos;

import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

public class PrincipalADM {

	private JFrame frame;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalADM window = new PrincipalADM();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrincipalADM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setMaximumSize(new Dimension(1243, 834));
		frame.setMaximumSize(new Dimension(1243, 834));
		frame.getContentPane().setBackground(new Color(55, 55, 55));
		frame.setMinimumSize(new Dimension(1243, 834));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(44, 44, 44));
		panel.setBounds(0, 0, 1227, 88);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnExcluirRegistro = new JButton("Excluir registro");
		btnExcluirRegistro.setFocusTraversalKeysEnabled(false);
		btnExcluirRegistro.setFocusPainted(false);
		btnExcluirRegistro.setBorderPainted(false);
		btnExcluirRegistro.setBounds(882, 26, 145, 31);
		panel.add(btnExcluirRegistro);
		btnExcluirRegistro.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExcluirRegistro.setBackground(new Color(255, 102, 51));
		
		JButton btnEditarRegistro = new JButton("Editar registro");
		btnEditarRegistro.setFocusPainted(false);
		btnEditarRegistro.setFocusTraversalKeysEnabled(false);
		btnEditarRegistro.setBounds(1060, 26, 145, 32);
		panel.add(btnEditarRegistro);
		btnEditarRegistro.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEditarRegistro.setBorderPainted(false);
		btnEditarRegistro.setBackground(new Color(255, 102, 51));
		
		JLabel lblNewLabel = new JLabel("Visualizar Registros de ponto");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 30, 291, 28);
		panel.add(lblNewLabel);
		
		Eventos eventos = new Eventos();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 173, 1195, 480);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.WHITE);
		table.setFocusable(false);
		scrollPane.setViewportView(table);
		table.setSelectionForeground(new Color(255, 255, 255));
		table.setSelectionBackground(new Color(77, 77, 77));
		table.setBackground(new Color(44, 44, 44));
		table.setModel(eventos.exibirDados());
		
		textField = new JTextField();
		textField.setBounds(10, 136, 173, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFocusPainted(false);
		btnPesquisar.setFocusTraversalKeysEnabled(false);
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPesquisar.setBorderPainted(false);
		btnPesquisar.setBackground(new Color(255, 102, 51));
		btnPesquisar.setBounds(196, 136, 110, 26);
		frame.getContentPane().add(btnPesquisar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFocusTraversalKeysEnabled(false);
		btnAtualizar.setFocusPainted(false);
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAtualizar.setBorderPainted(false);
		btnAtualizar.setBackground(new Color(255, 102, 51));
		btnAtualizar.setBounds(1075, 136, 110, 26);
		frame.getContentPane().add(btnAtualizar);
		table.getColumnModel().getColumn(2).setMinWidth(16);
	}
}
