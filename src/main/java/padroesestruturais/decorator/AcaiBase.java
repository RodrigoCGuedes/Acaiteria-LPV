package padroesestruturais.decorator;

import java.math.BigDecimal;
import padroescomportamentais.strategy.Promocao;
import padroesestruturais.adapter.ITamanho;

public abstract class AcaiBase extends Ingrediente {
    private String tipo;

    public AcaiBase(String descricao, BigDecimal precoBase, Promocao promocao, ITamanho tamanho, String tipo) {
        super(descricao, precoBase, promocao, tamanho);
        this.tipo = tipo;
    }

    public String getTipo() {
        return this.tipo;
    }
}
