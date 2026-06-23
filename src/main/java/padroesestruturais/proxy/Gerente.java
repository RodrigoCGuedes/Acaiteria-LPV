package padroesestruturais.proxy;

import java.math.BigDecimal;
import padroescomportamentais.strategy.Promocao;
import padroesestruturais.adapter.ITamanho;
import padroescriacionais.prototype.Acai;

public class Gerente {
    private String nome;
    private boolean autorizado;

    public Gerente(String nome, boolean autorizado) {
        this.nome = nome;
        this.autorizado = autorizado;
    }

    public String getNome() {
        return this.nome;
    }

    public boolean isAutorizado() {
        return this.autorizado;
    }

    public Acai cadastrarPrecoDoDesconto(String descricao, BigDecimal precoBase, Promocao promocao, ITamanho tamanho, String tipo) {
        return new Acai(descricao, precoBase, promocao, tamanho, tipo);
    }
}
