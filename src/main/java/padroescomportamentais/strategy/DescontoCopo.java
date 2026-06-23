package padroescomportamentais.strategy;

import java.math.BigDecimal;

public class DescontoCopo implements Promocao {
    private BigDecimal percentualDesconto;

    public DescontoCopo(BigDecimal percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    @Override
    public BigDecimal calculaDesconto(BigDecimal precoBase) {
        return precoBase.multiply(this.percentualDesconto);
    }
}
