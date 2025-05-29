package backend;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Eventos extends JFrame {
    private ConecxaoBD bd = new ConecxaoBD();
    private UsuarioDAO usuarioDAO;

    public DefaultTableModel exibirDados() {
        String sql = "call listar_registros_ponto();"; 

        try {
        	bd = new ConecxaoBD();
            if (!this.bd.getConnection()) {
            	
                System.out.println("Falha na conexão.");
                
            } else {
            	bd.getConnection();
				System.out.println("Conexão estabelecida com sucesso.");
            }

            PreparedStatement stmt = ((java.sql.Connection)bd.connection).prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            
            ResultSetMetaData meta = rs.getMetaData();
            int colunas = meta.getColumnCount();

            DefaultTableModel model = new DefaultTableModel();

            
            for (int i = 1; i <= colunas; i++) {
                model.addColumn(meta.getColumnName(i));
            }

           
            while (rs.next()) {
                Object[] linha = new Object[colunas];
                for (int i = 1; i <= colunas; i++) {
                    linha[i - 1] = rs.getObject(i);
                }
                model.addRow(linha);
            }

            rs.close();
            stmt.close();
            bd.closeConnection();
            return model;

        } catch (SQLException e) {
        	System.out.println("Erro ao executar a consulta: " + e.getMessage());
            
        	return null;
        }
    }

   public MouseAdapter mouseAdapter(JTextField cpf, JTextField data, JTextField entrada, JTextField entradaIntevalo, JTextField saidaIntervalo, JTextField saida) {
		
		return new MouseAdapter () {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!bd.getConnection()) {
					System.out.println("Falha na conexão.");
				}
				else {
					bd.getConnection();
					System.out.println("Conexão estabelecida com sucesso.");
					String texto = cpf.getText();

					if (texto != null && !texto.trim().isEmpty()) {
					    try {
					        long valor = Long.parseLong(texto);
					        SimpleDateFormat formatoSQL = new SimpleDateFormat("yyyy/MM/dd");
					        String dataFormatada = formatoSQL.format(formatoSQL.parse(data.getText()));
					        Ponto ponto = new Ponto();
							usuarioDAO = new UsuarioDAO();
							usuarioDAO.Alterar(valor, dataFormatada, entrada.getText(), entradaIntevalo.getText(), saidaIntervalo.getText(), saida.getText());
							ponto.alterarPonto(valor, entrada.getText(), entradaIntevalo.getText(), saidaIntervalo.getText(), saida.getText());
							
					        
					    } catch (NumberFormatException  et) {
					        System.out.println("Erro: valor inválido! Não é um número: " + texto);
					    } catch (Exception ex) {
					        System.out.println("Erro ao formatar data: " + ex.getMessage());
					    }
					} else {
					    System.out.println("Erro: o campo está vazio!");
					}
				
				
				}

				
			}
		};
		
	}
		


}