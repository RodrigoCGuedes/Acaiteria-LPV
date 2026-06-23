package padroesestruturais.decorator;

import java.math.BigDecimal;

public class Granola extends AcaiDecorator {
    public Granola(Produto produto) {
        super(produto);
    }

    @Override
    public BigDecimal getValorAcrescido() {
        return new BigDecimal("1.80");
    }

    @Override
    public String getDescricaoDecorator() {
        return "Granola";
    }
}
