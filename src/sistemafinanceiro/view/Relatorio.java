package sistemafinanceiro.view;

import java.awt.Component;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import static java.util.Locale.getDefault;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import sistemafinanceiro.dao.ContaDAO;
import sistemafinanceiro.entity.NovaConta;

public class Relatorio extends javax.swing.JFrame {

    private double totalValor;

    public Relatorio() throws SQLException {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jtRelatorio.getModel();
        jtRelatorio.setRowSorter(new TableRowSorter(modelo));
        readJTable();
        updateSomaLabel();
        setarMes();
        //Codigo para alinhar conteudo de texto das colunas da jtable
        ((DefaultTableCellRenderer) jtRelatorio.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
////
        // Adicione um TableModelListener ao DefaultTableModel
        modelo.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                // Verifique se a alteração ocorreu na coluna das caixas de seleção (coluna índice 4)
                if (e.getColumn() == 4 && e.getType() == TableModelEvent.UPDATE) {
                    int rowIndex = e.getFirstRow();
                    boolean isChecked = (Boolean) modelo.getValueAt(rowIndex, 4);

                    // Execute sua ação desejada na linha toda aqui com base em se a caixa de seleção está marcada ou não
                    if (isChecked) {
                        // Checkbox marcada, exibe uma mensagem na linha 1
                        realizarAcaoNaLinha(rowIndex);
                    } else {
                        // Checkbox desmarcada, desfaz a ação na linha toda
                        desfazerAcaoNaLinha(rowIndex);
                    }
                }
            }
        });
////
    }

    // Método para realizar ação na linha toda quando o checkbox é marcado
    private void realizarAcaoNaLinha(int rowIndex) {
        // Exibe uma mensagem em JOptionPane
        JOptionPane.showMessageDialog(this, "Checkbox da linha " + (rowIndex + 1) + " marcado");
    }

    // Método para desfazer ação na linha toda quando o checkbox é desmarcado
    private void desfazerAcaoNaLinha(int rowIndex) {
        JOptionPane.showMessageDialog(this, "Checkbox da linha " + (rowIndex + 1) + " desmarcado");
    }

    private void setarMes() {
        Date mes = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("MMMM");
        String nomeMes = formatador.format(mes);
        lblMes.setHorizontalAlignment(SwingConstants.CENTER);
        lblMes.setText("CONTAS DO MÊS DE " + nomeMes.toUpperCase());
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
        lblMes = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jlSoma = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório");
        setAlwaysOnTop(true);
        setResizable(false);

        jtRelatorio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtRelatorio.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jtRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "Valor", "Vencimento", "Quantidade de Parcelas", "Pago"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtRelatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtRelatorio.setGridColor(new java.awt.Color(0, 0, 0));
        jtRelatorio.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jtRelatorio.setShowGrid(false);
        jtRelatorio.setShowHorizontalLines(true);
        jtRelatorio.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtRelatorio);
        if (jtRelatorio.getColumnModel().getColumnCount() > 0) {
            jtRelatorio.getColumnModel().getColumn(0).setResizable(false);
            jtRelatorio.getColumnModel().getColumn(1).setResizable(false);
            jtRelatorio.getColumnModel().getColumn(1).setPreferredWidth(50);
            jtRelatorio.getColumnModel().getColumn(2).setResizable(false);
            jtRelatorio.getColumnModel().getColumn(2).setPreferredWidth(50);
            jtRelatorio.getColumnModel().getColumn(3).setResizable(false);
            jtRelatorio.getColumnModel().getColumn(3).setPreferredWidth(125);
            jtRelatorio.getColumnModel().getColumn(4).setResizable(false);
        }

        lblMes.setFont(new java.awt.Font("Sitka Banner", 0, 24)); // NOI18N
        lblMes.setText("Conta Mes");
        lblMes.setToolTipText("");
        lblMes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblMes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblMes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlSoma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlSoma.setText("soma");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlSoma, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlSoma, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMes, javax.swing.GroupLayout.PREFERRED_SIZE, 29, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
    private javax.swing.JLabel lblMes;
    // End of variables declaration//GEN-END:variables
}
