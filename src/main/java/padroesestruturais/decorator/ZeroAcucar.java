package padroesestruturais.decorator;

import java.math.BigDecimal;
import padroescomportamentais.strategy.Promocao;
import padroesestruturais.adapter.ITamanho;

public class ZeroAcucar extends AcaiBase {
    public ZeroAcucar(BigDecimal precoBase, Promocao promocao, ITamanho tamanho) {
        super("Açaí Zero Açúcar", precoBase, promocao, tamanho, "Zero");
    }
}
