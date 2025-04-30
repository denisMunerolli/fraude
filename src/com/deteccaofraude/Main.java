package com.deteccaofraude;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/fraude_transacoes";
        String username = "root"; // seu usuário do MySQL
        String password = "";     // sua senha do MySQL

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Conexão com banco de dados realizada com sucesso!");

            // Dados de exemplo
            String id = "T123";
            String userId = "U001";
            double valor = 15000.00;
            String local = "São Paulo";
            boolean internacional = true;
            boolean fraude = FraudeDetector.isFraudulent(valor, internacional);

            // Inserir no banco
            String sql = "INSERT INTO transacoes (id, user_id, valor, localizacao, internacional, fraude_detectada) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, userId);
            ps.setDouble(3, valor);
            ps.setString(4, local);
            ps.setBoolean(5, internacional);
            ps.setBoolean(6, fraude);
            ps.executeUpdate();

            System.out.println("Transação inserida com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
