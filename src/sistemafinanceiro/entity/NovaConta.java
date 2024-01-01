
package sistemafinanceiro.entity;

import java.util.Date;
import java.util.List;


public class NovaConta {
    private int id;
    private String nome;
    private double valor;
    private int qtdParcela;
    private Date vencimento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

  
    public int getQtdParcela() {
        return qtdParcela;
    }

    public void setQtdParcela(int qtdParcela) {
        this.qtdParcela = qtdParcela;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public void add(List<NovaConta> novaContas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
}
