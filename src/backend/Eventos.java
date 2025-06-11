package backend;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Eventos extends JFrame {
    private ConecxaoBD bd = null;
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

   public MouseAdapter mouseAdapter(JTextField Nome, JTextField data, JTextField entrada, JTextField entradaIntevalo, JTextField saidaIntervalo, JTextField saida) {
		
		return new MouseAdapter () {
			@Override
			public void mouseClicked(MouseEvent e) {
				bd = new ConecxaoBD();
				if(!bd.getConnection()) {
					System.out.println("Falha na conexão.");
				}
				else {
				
					    try {
					        
					        String horaEntrada = entrada.getText().trim();
					        String horaEntradaIntervalo = entradaIntevalo.getText().trim();
					        String horaSaidaIntervalo = saidaIntervalo.getText().trim();
					        String horaSaida = saida.getText().trim();
					        if (horaEntrada.isEmpty() || horaEntradaIntervalo.isEmpty() || horaSaidaIntervalo.isEmpty() || horaSaida.isEmpty()) {
					            System.out.println("Erro: um ou mais campos de horário estão vazios!");
					            
					        }else if (horaEntrada.matches("\\d{2}:\\d{2}") && horaEntradaIntervalo.matches("\\d{2}:\\d{2}") &&
					        		horaSaidaIntervalo.matches("\\d{2}:\\d{2}") && horaSaida.matches("\\d{2}:\\d{2}")) {
					        		horaEntrada += ":00";
					        		horaEntradaIntervalo += ":00";
					        		horaSaidaIntervalo += ":00";
					        		horaSaida += ":00";
					        	
					        } else {
					            System.out.println("Erro: um ou mais campos de horário estão no formato incorreto! Use o formato HH:mm.");
					            
					        	
					        }
					        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
					        formato.setLenient(false);
					 	   	SimpleDateFormat formatoSQL = new SimpleDateFormat("yyyy-MM-dd");
					        
					 	   	Date dataFormatada = formato.parse(data.getText().trim());
					 	   	String dataSQL = formatoSQL.format(dataFormatada);
					 
					       
					        Ponto ponto = new Ponto();
							usuarioDAO = new UsuarioDAO();
							usuarioDAO.EditarRegistro(Nome.getText().trim(), dataSQL, horaEntrada , horaEntradaIntervalo, horaSaidaIntervalo, horaSaida);
							
					        System.out.println("Dados recebidos: " + Nome.getText().trim() + ", " + dataSQL + ", " + horaEntrada + ", " + horaEntradaIntervalo + ", " + horaSaidaIntervalo + ", " + horaSaida);
							
						
					    } catch ( ParseException  et) {
					        System.out.println("Erro: valor inválido! Não é um número: " );
					    }
					
				
				
				}

				
			}
		};
		
	}
		
   

}