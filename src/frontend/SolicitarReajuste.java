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
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



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
		    mfdata = new MaskFormatter("##/##/#####");
		} catch (Exception e) {
			System.out.println("Erro ao criar máscara de CPF: " + e.getMessage());
		}
		
		try {
		    mfhorario = new MaskFormatter("##:##");
		} catch (Exception e) {
			System.out.println("Erro ao criar máscara de CPF: " + e.getMessage());
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
		panel.setBounds(285, 74, 583, 639);
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
		
		JLabel lblHorarioDeEntrada = new JLabel("Horario de entrada");
		lblHorarioDeEntrada.setForeground(Color.WHITE);
		lblHorarioDeEntrada.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHorarioDeEntrada.setBounds(110, 220, 133, 14);
		panel.add(lblHorarioDeEntrada);
		
		JLabel lblHorariaDeSada = new JLabel("Horaria de saída");
		lblHorariaDeSada.setForeground(Color.WHITE);
		lblHorariaDeSada.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHorariaDeSada.setBounds(106, 333, 147, 14);
		panel.add(lblHorariaDeSada);
		
		JLabel lblMotivo = new JLabel("Motivo");
		lblMotivo.setForeground(Color.WHITE);
		lblMotivo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMotivo.setBounds(110, 394, 46, 14);
		panel.add(lblMotivo);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(255, 255, 255));
		textArea.setBackground(new Color(55, 55, 55));
		textArea.setBounds(106, 418, 342, 117);
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
		btnCancelar.setBounds(411, 576, 162, 41);
		panel.add(btnCancelar);
		
		JButton btnEnviar = new JButton("Enviar");
		Eventos eventos = new Eventos();
		
		btnEnviar.setForeground(new Color(255, 255, 255));
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEnviar.setFocusTraversalKeysEnabled(false);
		btnEnviar.setFocusPainted(false);
		btnEnviar.setBorderPainted(false);
		btnEnviar.setBackground(new Color(255, 102, 51));
		btnEnviar.setBounds(239, 576, 162, 41);
		panel.add(btnEnviar);
		
		JFormattedTextField dataFormattedTextField = new JFormattedTextField(mfdata);
		dataFormattedTextField.setForeground(Color.WHITE);
		dataFormattedTextField.setBackground(new Color(55, 55, 55));
		dataFormattedTextField.setBounds(106, 189, 175, 27);
		panel.add(dataFormattedTextField);
		
		JFormattedTextField entradaFormattedTextField_1 = new JFormattedTextField(mfhorario);
		entradaFormattedTextField_1.setForeground(Color.WHITE);
		entradaFormattedTextField_1.setBackground(new Color(55, 55, 55));
		entradaFormattedTextField_1.setBounds(106, 245, 175, 27);
		panel.add(entradaFormattedTextField_1);
		
		JFormattedTextField entradaInterFormattedTextField_2 = new JFormattedTextField(mfhorario);
		entradaInterFormattedTextField_2.setForeground(Color.WHITE);
		entradaInterFormattedTextField_2.setBackground(new Color(55, 55, 55));
		entradaInterFormattedTextField_2.setBounds(106, 296, 175, 27);
		panel.add(entradaInterFormattedTextField_2);
		
		JFormattedTextField saidaFormattedTextField_1_1 = new JFormattedTextField(mfhorario);
		saidaFormattedTextField_1_1.setForeground(Color.WHITE);
		saidaFormattedTextField_1_1.setBackground(new Color(55, 55, 55));
		saidaFormattedTextField_1_1.setBounds(106, 357, 175, 27);
		panel.add(saidaFormattedTextField_1_1);
		
		JFormattedTextField saidaInterFormattedTextField_2_1 = new JFormattedTextField(mfhorario);
		saidaInterFormattedTextField_2_1.setForeground(Color.WHITE);
		saidaInterFormattedTextField_2_1.setBackground(new Color(55, 55, 55));
		saidaInterFormattedTextField_2_1.setBounds(291, 296, 175, 27);
		panel.add(saidaInterFormattedTextField_2_1);
		
		JLabel lblHorarioDeIntervalo = new JLabel("Horario de Intervalo");
		lblHorarioDeIntervalo.setForeground(Color.WHITE);
		lblHorarioDeIntervalo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHorarioDeIntervalo.setBounds(106, 272, 147, 14);
		panel.add(lblHorarioDeIntervalo);
		
		
		
		btnEnviar.addMouseListener(eventos.mouseAdapter(nomeTextField, dataFormattedTextField, entradaFormattedTextField_1, entradaInterFormattedTextField_2, saidaInterFormattedTextField_2_1, saidaFormattedTextField_1_1));
		
		
	}
}
