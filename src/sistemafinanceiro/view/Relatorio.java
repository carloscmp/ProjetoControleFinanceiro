package sistemafinanceiro.view;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import sistemafinanceiro.dao.ContaDAO;
import sistemafinanceiro.entity.NovaConta;

/**
 *
 * @author carlo
 */
public class Relatorio extends javax.swing.JFrame {

    private double totalValor;

    public Relatorio() throws SQLException {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jtRelatorio.getModel();
        jtRelatorio.setRowSorter(new TableRowSorter(modelo));
        readJTable();
        updateSomaLabel();
    }

    private void updateSomaLabel() {
        // Defina a soma acumulada no JLabel
        jlSoma.setText(String.format("Total: R$ %.2f", totalValor));
    }

    public void readJTable() throws SQLException {

        DefaultTableModel modelo = (DefaultTableModel) jtRelatorio.getModel();
        modelo.setRowCount(0);
        ContaDAO cdao = new ContaDAO();

        // Criar um formatador de números para formatar o valor
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        for (NovaConta nc : cdao.read()) {
            // Formatar o valor como uma String antes de adicionar à tabela
            String valorFormatado = numberFormat.format(nc.getValor());
            modelo.addRow(new Object[]{
                nc.getNome().toUpperCase(),
                valorFormatado,
                nc.getVencimento(),
                nc.getQtdParcela()                    
            });
            totalValor += nc.getValor();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtRelatorio = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jlSoma = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório");
        setAlwaysOnTop(true);
        setPreferredSize(new java.awt.Dimension(800, 400));
        setResizable(false);

        jtRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Valor", "Vencimento", "Quantidade de Parcelas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtRelatorio);
        if (jtRelatorio.getColumnModel().getColumnCount() > 0) {
            jtRelatorio.getColumnModel().getColumn(0).setResizable(false);
            jtRelatorio.getColumnModel().getColumn(1).setResizable(false);
            jtRelatorio.getColumnModel().getColumn(2).setResizable(false);
            jtRelatorio.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jlSoma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlSoma.setText("soma");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlSoma, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlSoma, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Relatorio().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlSoma;
    private javax.swing.JTable jtRelatorio;
    // End of variables declaration//GEN-END:variables
}
