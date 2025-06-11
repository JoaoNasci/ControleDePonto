package frontend;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import backend.Funcionario;
import backend.UsuarioDAO;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import java.awt.Component;
import java.awt.TextField;
import javax.swing.JLabel;
import java.awt.Font;

public class Login  extends JFrame {

	private JFrame frmLoginNoSistema;
	private JTextField textField;
	private final JPanel panel = new JPanel();
	private JTextField textField_1;
	private String email;
	private String senha;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLoginNoSistema.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginNoSistema = new JFrame();
		frmLoginNoSistema.getContentPane().setBackground(new Color(55, 55, 55));
		frmLoginNoSistema.setMinimumSize(new Dimension(1243, 834));
		frmLoginNoSistema.setForeground(new Color(255, 255, 255));
		frmLoginNoSistema.setTitle("Login no sistema");
		frmLoginNoSistema.getContentPane().setName("Login");
		frmLoginNoSistema.setBounds(100, 100, 1142, 785);
		frmLoginNoSistema.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginNoSistema.getContentPane().setLayout(null);
		panel.setBackground(new Color(44, 44, 44));
		panel.setBounds(412, 135, 360, 390);
		frmLoginNoSistema.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(new Color(95, 95, 95));
		textField.setBounds(86, 132, 174, 26);
		panel.add(textField);
		textField.setName("Login");
		textField.setAlignmentX(Component.LEFT_ALIGNMENT);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFocusTraversalKeysEnabled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setIcon(null);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(86, 274, 174, 39);
		panel.add(btnNewButton);
		btnNewButton.setBackground(new Color(255, 102, 51));
		
		
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            String Email = textField.getText().trim();
		            String senha = textField_1.getText().trim();
		       
		            UsuarioDAO usuarioDao = new UsuarioDAO();
		            ResultSet rs = usuarioDao.autenticarUsuario(Email, senha);
		         

		            if (rs.next()) {
		                int tipo = rs.getInt("Tipo");

		                if (tipo == 1) {
		                    PrincipalColaborador pc = new PrincipalColaborador(Email);
		                    pc.setVisible(true);
		                    
		                    ((JFrame) SwingUtilities.getWindowAncestor(btnNewButton)).dispose();
		                } else if (tipo == 2) {
		                    PrincipalADM pa = new PrincipalADM();
		                    pa.setVisible(true);
		                    ((JFrame) SwingUtilities.getWindowAncestor(btnNewButton)).dispose();
		                } else {
		                    JOptionPane.showMessageDialog(null, "Tipo de usuário inválido.");
		                }
		            } else {
		                JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos");
		            }

		        } catch (Exception erro) {
		            JOptionPane.showMessageDialog(null, "Erro ao fazer login: " + erro.getMessage());
		            erro.printStackTrace(); 
		        }
		    }
		});

		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(59, 59, 59));
		panel_1.setBounds(0, 0, 360, 68);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(145, 11, 123, 47);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setPreferredSize(new Dimension(40, 40));
		lblNewLabel.setMaximumSize(new Dimension(40, 40));
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(86, 113, 67, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(86, 179, 67, 16);
		panel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setName("Login");
		textField_1.setForeground(Color.WHITE);
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(95, 95, 95));
		textField_1.setAlignmentX(0.0f);
		textField_1.setBounds(86, 205, 174, 26);
		panel.add(textField_1);
		
		 
		   }
	}

