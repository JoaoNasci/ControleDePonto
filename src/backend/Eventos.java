package backend;

import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Eventos extends JFrame {
    private ConecxaoBD bd;


    public DefaultTableModel exibirDados() {
        String sql = " call listar_registros_ponto();"; // <--- Ajuste o nome da tabela

        try {
        	bd = new ConecxaoBD();
        	bd.getConnection();
            if (!this.bd.getConnection()) {
            	
                System.out.println("Falha na conexão.");
                
            }

            PreparedStatement stmt = ((java.sql.Connection)bd.connection).prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            // Pegando metadados para criar colunas dinamicamente
            ResultSetMetaData meta = rs.getMetaData();
            int colunas = meta.getColumnCount();

            DefaultTableModel model = new DefaultTableModel();

            // Criando colunas no modelo
            for (int i = 1; i <= colunas; i++) {
                model.addColumn(meta.getColumnName(i));
            }

            // Adicionando linhas
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



}