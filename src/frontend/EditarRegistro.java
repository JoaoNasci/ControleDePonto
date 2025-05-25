package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class EditarRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private MaskFormatter mfdata;
	private MaskFormatter mfhorario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarRegistro frame = new EditarRegistro();
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
	public EditarRegistro() {
		
		try {
		    mfdata = new MaskFormatter("##/##/####");
		} catch (Exception e) {
			System.out.println("Erro ao criar máscara de CPF: " + e.getMessage());
		}
		
		try {
		    mfhorario = new MaskFormatter("##:##");
		} catch (Exception e) {
			System.out.println("Erro ao criar máscara de CPF: " + e.getMessage());
		}
		
		setMinimumSize(new Dimension(1243, 834));
		setMaximumSize(new Dimension(1243, 834));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1247, 694);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(1243, 834));
		contentPane.setMaximumSize(new Dimension(1243, 834));
		contentPane.setBackground(new Color(55, 55, 55));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(44, 44, 44));
		panel.setBounds(346, 155, 512, 447);
		contentPane.add(panel);
		
		textField = new JTextField();
		textField.setSelectionColor(new Color(0, 128, 192));
		textField.setForeground(Color.WHITE);
		textField.setFocusTraversalKeysEnabled(false);
		textField.setColumns(10);
		textField.setBackground(new Color(55, 55, 55));
		textField.setBounds(176, 125, 175, 27);
		panel.add(textField);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(174, 100, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblData = new JLabel("Data");
		lblData.setForeground(Color.WHITE);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblData.setBounds(174, 163, 46, 14);
		panel.add(lblData);
		
		JLabel lblHorarioAntigo = new JLabel("Horario Antigo");
		lblHorarioAntigo.setForeground(Color.WHITE);
		lblHorarioAntigo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHorarioAntigo.setBounds(176, 231, 133, 14);
		panel.add(lblHorarioAntigo);
		
		JLabel lblHorariaNovo = new JLabel("Horaria Novo");
		lblHorariaNovo.setForeground(Color.WHITE);
		lblHorariaNovo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHorariaNovo.setBounds(176, 294, 106, 14);
		panel.add(lblHorariaNovo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(59, 59, 59));
		panel_1.setBounds(0, 0, 583, 71);
		panel.add(panel_1);
		
		JLabel lblEditarRegistro = new JLabel("Editar Registro");
		lblEditarRegistro.setPreferredSize(new Dimension(40, 40));
		lblEditarRegistro.setMaximumSize(new Dimension(40, 40));
		lblEditarRegistro.setForeground(Color.WHITE);
		lblEditarRegistro.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblEditarRegistro.setBounds(140, 11, 294, 49);
		panel_1.add(lblEditarRegistro);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancelar.setFocusTraversalKeysEnabled(false);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBackground(new Color(255, 102, 51));
		btnCancelar.setBounds(277, 381, 162, 41);
		panel.add(btnCancelar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnConfirmar.setFocusTraversalKeysEnabled(false);
		btnConfirmar.setFocusPainted(false);
		btnConfirmar.setBorderPainted(false);
		btnConfirmar.setBackground(new Color(255, 102, 51));
		btnConfirmar.setBounds(86, 381, 162, 41);
		panel.add(btnConfirmar);
		
		JFormattedTextField formattedTextField = new JFormattedTextField(mfdata);
		formattedTextField.setForeground(Color.WHITE);
		formattedTextField.setBackground(new Color(55, 55, 55));
		formattedTextField.setBounds(176, 193, 175, 27);
		panel.add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField(mfhorario);
		formattedTextField_1.setForeground(Color.WHITE);
		formattedTextField_1.setBackground(new Color(55, 55, 55));
		formattedTextField_1.setBounds(176, 256, 175, 27);
		panel.add(formattedTextField_1);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField(mfhorario);
		formattedTextField_2.setForeground(Color.WHITE);
		formattedTextField_2.setBackground(new Color(55, 55, 55));
		formattedTextField_2.setBounds(176, 319, 175, 27);
		panel.add(formattedTextField_2);
		
	}
}
