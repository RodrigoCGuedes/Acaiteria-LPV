package padroescomportamentais.strategy;

import java.math.BigDecimal;

public class DescontoFixo implements Promocao {
    private BigDecimal valorDesconto;

    public DescontoFixo(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    @Override
    public BigDecimal calculaDesconto(BigDecimal precoBase) {
        return this.valorDesconto;
    }
}
