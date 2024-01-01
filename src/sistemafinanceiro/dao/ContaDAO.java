package sistemafinanceiro.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import sistemafinanceiro.dao.conexao.ConexaoJDBC;
import java.sql.SQLException;
import java.util.List;
import sistemafinanceiro.entity.NovaConta;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static sistemafinanceiro.dao.conexao.ConexaoJDBC.conn;

public class ContaDAO {

    public void adicinonar(NovaConta nc) {

        String sql = "INSERT INTO NOVA_CONTA(NOME, VALOR, VENCIMENTO, QTDPARCELA)VALUES(?,?,?,?)";
        PreparedStatement ps = null;

        try {
            ps = ConexaoJDBC.getconexao().prepareStatement(sql);
            ps.setString(1, nc.getNome());
            ps.setDouble(2, nc.getValor());
            ps.setDate(3, (Date) nc.getVencimento());
            ps.setInt(4, nc.getQtdParcela());
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

    public List<NovaConta> read() throws SQLException {

        ConexaoJDBC.getconexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<NovaConta> novaContas = new ArrayList<>();

        try {

            stmt = conn.prepareStatement("SELECT * FROM nova_conta");
            rs = stmt.executeQuery();

            while (rs.next()) {
                NovaConta novaConta = new NovaConta();
                novaConta.setNome(rs.getString("nome"));
                novaConta.setValor(rs.getDouble("valor"));
                novaConta.setVencimento(rs.getDate("vencimento"));
                novaConta.setQtdParcela(rs.getInt("qtdparcela"));
                novaContas.add(novaConta);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
