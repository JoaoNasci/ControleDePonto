package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class SolicitarReajuste extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;

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
		panel.setBounds(286, 71, 583, 639);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setSelectionColor(new Color(0, 128, 192));
		textField.setForeground(new Color(255, 255, 255));
		textField.setFocusTraversalKeysEnabled(false);
		textField.setBackground(new Color(55, 55, 55));
		textField.setBounds(110, 135, 171, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(255, 255, 255));
		textField_1.setFocusTraversalKeysEnabled(false);
		textField_1.setBackground(new Color(55, 55, 55));
		textField_1.setColumns(10);
		textField_1.setBounds(110, 189, 171, 27);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(255, 255, 255));
		textField_2.setFocusTraversalKeysEnabled(false);
		textField_2.setBackground(new Color(55, 55, 55));
		textField_2.setColumns(10);
		textField_2.setBounds(110, 245, 171, 27);
		panel.add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setSelectionColor(new Color(0, 128, 192));
		textField_4.setDisabledTextColor(new Color(255, 255, 255));
		textField_4.setForeground(new Color(255, 255, 255));
		textField_4.setFocusTraversalKeysEnabled(false);
		textField_4.setBackground(new Color(55, 55, 55));
		textField_4.setBounds(110, 302, 171, 27);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
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
		lblHorariaDeSada.setBounds(110, 277, 106, 14);
		panel.add(lblHorariaDeSada);
		
		JLabel lblMotivo = new JLabel("Motivo");
		lblMotivo.setForeground(Color.WHITE);
		lblMotivo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMotivo.setBounds(110, 340, 46, 14);
		panel.add(lblMotivo);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(255, 255, 255));
		textArea.setBackground(new Color(55, 55, 55));
		textArea.setBounds(110, 374, 342, 149);
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
		btnEnviar.setForeground(new Color(255, 255, 255));
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEnviar.setFocusTraversalKeysEnabled(false);
		btnEnviar.setFocusPainted(false);
		btnEnviar.setBorderPainted(false);
		btnEnviar.setBackground(new Color(255, 102, 51));
		btnEnviar.setBounds(239, 576, 162, 41);
		panel.add(btnEnviar);
	}
}
