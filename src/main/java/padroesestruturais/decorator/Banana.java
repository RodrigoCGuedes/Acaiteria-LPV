package padroesestruturais.decorator;

import java.math.BigDecimal;
import padroescomportamentais.strategy.Promocao;
import padroesestruturais.adapter.ITamanho;

public class Banana extends AcaiBase {
    public Banana(BigDecimal precoBase, Promocao promocao, ITamanho tamanho) {
        super("Açaí de Banana", precoBase, promocao, tamanho, "Banana");
    }
}
