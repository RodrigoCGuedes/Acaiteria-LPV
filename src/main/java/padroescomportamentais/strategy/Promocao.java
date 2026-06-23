package padroescomportamentais.strategy;

import java.math.BigDecimal;

public interface Promocao {
    BigDecimal calculaDesconto(BigDecimal precoBase);
}
