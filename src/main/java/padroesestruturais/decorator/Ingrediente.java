package padroesestruturais.decorator;

import java.math.BigDecimal;
import padroescomportamentais.strategy.Promocao;
import padroesestruturais.adapter.ITamanho;

public abstract class Ingrediente implements Produto {
    private String descricao;
    private BigDecimal precoBase;
    private Promocao promocao;
    private ITamanho tamanho;

    public Ingrediente(String descricao, BigDecimal precoBase, Promocao promocao, ITamanho tamanho) {
        this.descricao = descricao;
        this.precoBase = precoBase;
        this.promocao = promocao;
        this.tamanho = tamanho;
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public BigDecimal getPrecoBase() {
        return this.precoBase;
    }

    @Override
    public Promocao getPromocao() {
        return this.promocao;
    }

    @Override
    public ITamanho getTamanho() {
        return this.tamanho;
    }
}
