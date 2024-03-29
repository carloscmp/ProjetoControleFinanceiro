package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import DAO.Conexao.ConexaoJDBC;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static DAO.Conexao.ConexaoJDBC.conn;
import Model.ContaFixa;

public class ContaFixaDAO {

    public void adicinonar(ContaFixa nc) {

        String sql = "INSERT INTO CONTA_FIXA(NOME, VALOR, VENCIMENTO, CATEGORIA)VALUES(?,?,?,?)";
        PreparedStatement ps = null;

        try {
            ps = ConexaoJDBC.getconexao().prepareStatement(sql);
            ps.setString(1, nc.getNome());            
            ps.setDouble(2, nc.getValor());
            ps.setDate(3, (Date) nc.getVencimento());
            ps.setString(4, nc.getCategoria());
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

    public List<ContaFixa> read() throws SQLException {

        ConexaoJDBC.getconexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ContaFixa> novaContas = new ArrayList<>();

        try {

            stmt = conn.prepareStatement("SELECT * FROM conta_fixa");
            rs = stmt.executeQuery();

            while (rs.next()) {
                ContaFixa novaConta = new ContaFixa();
                novaConta.setNome(rs.getString("nome"));
                novaConta.setCategoria(rs.getString("categoria"));
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
