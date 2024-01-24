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
import Model.ContaVariavel;

public class ContaVariavelDAO{

    public void adicinonar(ContaVariavel nc) {

        String sql = "INSERT INTO CONTA_VARIAVEL(NOME, VALOR, VENCIMENTO, QTDPARCELA, CATEGORIA)VALUES(?,?,?,?,?)";
        PreparedStatement ps = null;

        try {
            ps = ConexaoJDBC.getconexao().prepareStatement(sql);
            ps.setString(1, nc.getNome());
            ps.setDouble(2, nc.getValor());
            ps.setDate(3, (Date) nc.getVencimento());
            ps.setInt(4, nc.getQtdParcela());
            ps.setString(5, nc.getCategoria());
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

    public List<ContaVariavel> read() throws SQLException {

        ConexaoJDBC.getconexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ContaVariavel> novaContas = new ArrayList<>();

        try {

            stmt = conn.prepareStatement("SELECT * FROM conta_variavel");
            rs = stmt.executeQuery();

            while (rs.next()) {
                ContaVariavel novaConta = new ContaVariavel();
                novaConta.setNome(rs.getString("nome"));
                novaConta.setCategoria(rs.getString("categoria"));
                novaConta.setValor(rs.getDouble("valor"));
                novaConta.setVencimento(rs.getDate("vencimento"));
                novaConta.setQtdParcela(rs.getInt("qtdparcela"));
                novaContas.add(novaConta);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ContaVariavelDAO.class.getName()).log(Level.SEVERE, null, ex);
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
