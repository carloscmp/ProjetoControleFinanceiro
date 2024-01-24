package Util;

import Model.PreenchimentoCamposException;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Utilitario {

    public static String formatarData(Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(data);
    }

    public static void limparCampos(javax.swing.JTextField campoNome, javax.swing.JTextField campoValor, com.toedter.calendar.JDateChooser campoData, javax.swing.JComboBox campoCategoria) {
        campoNome.setText("");
        campoValor.setText("");
        campoData.setDate(null);
        campoCategoria.setSelectedItem(null);
    }

    // Método para limpar campos específicos na classe TelaCadastroContaVariavel
    public static void limparCampos(javax.swing.JTextField campoNome, javax.swing.JTextField campoValor, com.toedter.calendar.JDateChooser campoData, javax.swing.JSlider campoQtdParcelas, javax.swing.JComboBox campoCategoria) {
        campoNome.setText("");
        campoValor.setText("");
        campoData.setDate(null);
        campoQtdParcelas.setValue(1);
        campoCategoria.setSelectedItem(null);
    }
    public static void validarCamposObrigatorios(JTextField campoTexto1, JTextField campoTexto2, JDateChooser dcData, JComboBox jcb)
            throws PreenchimentoCamposException {
        if (campoTexto1.getText().isEmpty() || campoTexto2.getText().isEmpty() || dcData.getDate() == null || jcb.getSelectedItem() == null) {
            throw new PreenchimentoCamposException("Por favor, preencha todos os campos obrigatórios.");
        }
    }

   

}


