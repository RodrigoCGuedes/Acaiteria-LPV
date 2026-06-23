package padroesestruturais.decorator;

import java.math.BigDecimal;

public class CaldaMorango extends AcaiDecorator {
    public CaldaMorango(Produto produto) {
        super(produto);
    }

    @Override
    public BigDecimal getValorAcrescido() {
        return new BigDecimal("2.50");
    }

    @Override
    public String getDescricaoDecorator() {
        return "Calda de Morango";
    }
}
