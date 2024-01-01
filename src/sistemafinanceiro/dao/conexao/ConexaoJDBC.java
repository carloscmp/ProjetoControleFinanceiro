package sistemafinanceiro.dao.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoJDBC {

    //conexão com o BD(enviar login e senha para a correção da atividade)
    private static final String URL = "jdbc:mysql://localhost:3306/dbsistemafinanceiro";
    private static final String USER = "root";
    private static final String PASSWORD = "Senhamysql10";

    public static Connection conn;

    public static Connection getconexao() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            }
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Houve um erro ao tentar conectar ao banco de dados");
            return null;
        }
    }

    public static void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
