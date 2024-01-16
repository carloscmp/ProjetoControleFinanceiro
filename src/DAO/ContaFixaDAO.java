package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import DAO.Conexao.ConexaoJDBC;
import java.sql.SQLException;
import java.util.List;
import Model.Conta;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static DAO.Conexao.ConexaoJDBC.conn;

public class ContaFixaDAO {

    public void adicinonar(Conta nc) {

        String sql = "INSERT INTO CONTA_FIXA(NOME, VALOR, VENCIMENTO)VALUES(?,?,?)";
        PreparedStatement ps = null;

        try {
            ps = ConexaoJDBC.getconexao().prepareStatement(sql);
            ps.setString(1, nc.getNome());
            ps.setDouble(2, nc.getValor());
            ps.setDate(3, (Date) nc.getVencimento());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    public List<Conta> read() throws SQLException {

        ConexaoJDBC.getconexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Conta> novaContas = new ArrayList<>();

        try {

            stmt = conn.prepareStatement("SELECT * FROM conta_fixa");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Conta novaConta = new Conta();
                novaConta.setNome(rs.getString("nome"));
                novaConta.setValor(rs.getDouble("valor"));
                novaConta.setVencimento(rs.getDate("vencimento"));
                novaContas.add(novaConta);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ContaFixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            conn.close();
            stmt.close();
            if (rs != null) {
                rs.close();
            }

        }
        return novaContas;
    }

}
