
package Util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Utilitario {
    
    public static String formatarData(Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(data);
    }
    
    public static void limparCampos(javax.swing.JTextField campoNome, javax.swing.JTextField campoValor, com.toedter.calendar.JDateChooser campoData) {
        campoNome.setText("");
        campoValor.setText("");
        campoData.setDate(null);
    }

    // Método para limpar campos específicos na classe TelaCadastroContaVariavel
    public static void limparCampos(javax.swing.JTextField campoNome, javax.swing.JTextField campoValor, com.toedter.calendar.JDateChooser campoData, javax.swing.JSlider campoQtdParcelas) {
        campoNome.setText("");
        campoValor.setText("");
        campoData.setDate(null);
        campoQtdParcelas.setValue(1);
    }
}
