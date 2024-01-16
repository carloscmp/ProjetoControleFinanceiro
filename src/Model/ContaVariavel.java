package Model;

import java.util.Date;

public class ContaVariavel extends Conta {

    private int qtdParcela;
    
    private Date DataVencimento;

    public int getQtdParcela() {
        return qtdParcela;
    }

    public void setQtdParcela(int qtdParcela) {
        this.qtdParcela = qtdParcela;
    }

    public Date getDataVencimento() {
        return DataVencimento;
    }

    public void setDataVencimento(Date DataVencimento) {
        this.DataVencimento = DataVencimento;
    }
    
}
