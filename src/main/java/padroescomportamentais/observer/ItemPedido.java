package padroescomportamentais.observer;

import java.math.BigDecimal;
import padroesestruturais.decorator.Produto;

public class ItemPedido {
    private int quantidade;
    private BigDecimal valor;
    private Produto produto;

    public ItemPedido(Produto produto, int quantidade, BigDecimal valor) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public BigDecimal getSubTotal() {
        return this.valor.multiply(new BigDecimal(this.quantidade));
    }
}
