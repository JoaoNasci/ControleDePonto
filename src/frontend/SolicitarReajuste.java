package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import backend.Eventos;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;




public class SolicitarReajuste extends JFrame {

	
	private JPanel contentPane;
	private JTextField nomeTextField;
	private MaskFormatter mfdata;
	private MaskFormatter mfhorario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SolicitarReajuste frame = new SolicitarReajuste();
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
	public SolicitarReajuste() {
		
		
		try {
	
		    mfdata = new MaskFormatter("##/##/####");
		    mfdata.setPlaceholderCharacter(' ');
		    mfdata.setAllowsInvalid(false);
		    mfdata.setCommitsOnValidEdit(true);
		    
		} catch (Exception e) {
			System.out.println("Erro ao criar máscara de data: " + e.getMessage());
		}
		
		try {
		    mfhorario = new MaskFormatter("##:##");
		} catch (Exception e) {
			System.out.println("Erro ao criar máscara de hora: " + e.getMessage());
		}
		
		
		setMinimumSize(new Dimension(1243, 834));
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
		panel.setBackground(new Color(44, 44, 44));
		panel.setBounds(285, 74, 583, 576);
		contentPane.add(panel);
		panel.setLayout(null);
		
		nomeTextField = new JTextField();
		nomeTextField.setSelectionColor(new Color(0, 128, 192));
		nomeTextField.setForeground(new Color(255, 255, 255));
		nomeTextField.setFocusTraversalKeysEnabled(false);
		nomeTextField.setBackground(new Color(55, 55, 55));
		nomeTextField.setBounds(106, 135, 175, 27);
		panel.add(nomeTextField);
		nomeTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(110, 110, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblData = new JLabel("Data");
		lblData.setForeground(Color.WHITE);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblData.setBounds(110, 164, 46, 14);
		panel.add(lblData);
		
		JLabel lblHorarioDeEntrada = new JLabel("Horario ");
		lblHorarioDeEntrada.setForeground(Color.WHITE);
		lblHorarioDeEntrada.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHorarioDeEntrada.setBounds(110, 220, 133, 14);
		panel.add(lblHorarioDeEntrada);
		
		JLabel lblMotivo = new JLabel("Motivo");
		lblMotivo.setForeground(Color.WHITE);
		lblMotivo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMotivo.setBounds(110, 283, 46, 14);
		panel.add(lblMotivo);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(255, 255, 255));
		textArea.setBackground(new Color(55, 55, 55));
		textArea.setBounds(106, 308, 342, 117);
		panel.add(textArea);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(59, 59, 59));
		panel_1.setBounds(0, 0, 583, 71);
		panel.add(panel_1);
		
		JLabel lblSolicitarReajuste = new JLabel("Solicitar Reajuste");
		lblSolicitarReajuste.setPreferredSize(new Dimension(40, 40));
		lblSolicitarReajuste.setMaximumSize(new Dimension(40, 40));
		lblSolicitarReajuste.setForeground(Color.WHITE);
		lblSolicitarReajuste.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblSolicitarReajuste.setBounds(154, 11, 294, 49);
		panel_1.add(lblSolicitarReajuste);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancelar.setFocusTraversalKeysEnabled(false);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBackground(new Color(255, 102, 51));
		btnCancelar.setBounds(409, 511, 162, 41);
		panel.add(btnCancelar);
		
		JButton btnEnviar = new JButton("Enviar");
		Eventos eventos = new Eventos();
		
		btnEnviar.setForeground(new Color(255, 255, 255));
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEnviar.setFocusTraversalKeysEnabled(false);
		btnEnviar.setFocusPainted(false);
		btnEnviar.setBorderPainted(false);
		btnEnviar.setBackground(new Color(255, 102, 51));
		btnEnviar.setBounds(237, 511, 162, 41);
		panel.add(btnEnviar);
		
		JFormattedTextField dataFormattedTextField = new JFormattedTextField(mfdata);
		dataFormattedTextField.setText(" / / ");
		dataFormattedTextField.setForeground(Color.WHITE);
		dataFormattedTextField.setBackground(new Color(55, 55, 55));
		dataFormattedTextField.setBounds(106, 189, 175, 27);
		panel.add(dataFormattedTextField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(55, 55, 55));
		comboBox.setBounds(106, 250, 175, 22);
		panel.add(comboBox);
		
		
	}
}
