package padroesestruturais.decorator;

import java.math.BigDecimal;
import padroescomportamentais.strategy.Promocao;
import padroesestruturais.adapter.ITamanho;

public abstract class AcaiDecorator extends Ingrediente implements padroescriacionais.abstractfactory.Adicional {
    private Produto produto;

    public AcaiDecorator(Produto produto) {
        super(produto.getDescricao(), produto.getPrecoBase(), produto.getPromocao(), produto.getTamanho());
        this.produto = produto;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public abstract BigDecimal getValorAcrescido();
    public abstract String getDescricaoDecorator();

    @Override
    public BigDecimal getPrecoBase() {
        return this.produto.getPrecoBase().add(this.getValorAcrescido());
    }

    @Override
    public String getDescricao() {
        return this.produto.getDescricao() + ", " + this.getDescricaoDecorator();
    }

    @Override
    public Promocao getPromocao() {
        return this.produto.getPromocao();
    }

    @Override
    public ITamanho getTamanho() {
        return this.produto.getTamanho();
    }
}
