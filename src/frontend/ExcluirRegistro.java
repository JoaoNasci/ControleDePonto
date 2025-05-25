package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ExcluirRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExcluirRegistro frame = new ExcluirRegistro();
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
	public ExcluirRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		panel.setBounds(346, 153, 512, 416);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setSelectionColor(new Color(0, 128, 192));
		textField.setForeground(new Color(255, 255, 255));
		textField.setFocusTraversalKeysEnabled(false);
		textField.setBackground(new Color(55, 55, 55));
		textField.setBounds(176, 125, 175, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(255, 255, 255));
		textField_1.setFocusTraversalKeysEnabled(false);
		textField_1.setBackground(new Color(55, 55, 55));
		textField_1.setColumns(10);
		textField_1.setBounds(176, 188, 175, 27);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(255, 255, 255));
		textField_2.setFocusTraversalKeysEnabled(false);
		textField_2.setBackground(new Color(55, 55, 55));
		textField_2.setColumns(10);
		textField_2.setBounds(176, 256, 175, 27);
		panel.add(textField_2);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(174, 100, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblData = new JLabel("Data");
		lblData.setForeground(Color.WHITE);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblData.setBounds(174, 163, 46, 14);
		panel.add(lblData);
		
		JLabel lblHorarioDeEntrada = new JLabel("Horario ");
		lblHorarioDeEntrada.setForeground(Color.WHITE);
		lblHorarioDeEntrada.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHorarioDeEntrada.setBounds(176, 231, 133, 14);
		panel.add(lblHorarioDeEntrada);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(59, 59, 59));
		panel_1.setBounds(0, 0, 583, 71);
		panel.add(panel_1);
		
		JLabel lblSolicitarReajuste = new JLabel("Excluir Registro");
		lblSolicitarReajuste.setPreferredSize(new Dimension(40, 40));
		lblSolicitarReajuste.setMaximumSize(new Dimension(40, 40));
		lblSolicitarReajuste.setForeground(Color.WHITE);
		lblSolicitarReajuste.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblSolicitarReajuste.setBounds(130, 11, 294, 49);
		panel_1.add(lblSolicitarReajuste);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancelar.setFocusTraversalKeysEnabled(false);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBackground(new Color(255, 102, 51));
		btnCancelar.setBounds(268, 322, 162, 41);
		panel.add(btnCancelar);
		
		JButton btnEnviar = new JButton("Excluir");
		btnEnviar.setForeground(new Color(255, 255, 255));
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEnviar.setFocusTraversalKeysEnabled(false);
		btnEnviar.setFocusPainted(false);
		btnEnviar.setBorderPainted(false);
		btnEnviar.setBackground(new Color(255, 102, 51));
		btnEnviar.setBounds(84, 322, 162, 41);
		panel.add(btnEnviar);
	}

}
