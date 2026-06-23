package padroesestruturais.decorator;

import java.math.BigDecimal;
import padroescomportamentais.strategy.Promocao;
import padroesestruturais.adapter.ITamanho;

public interface Produto {
    BigDecimal getPrecoBase();
    String getDescricao();
    Promocao getPromocao();
    ITamanho getTamanho();
}
