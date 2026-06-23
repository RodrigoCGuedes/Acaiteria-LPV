package padroescomportamentais.visitor;

import java.math.BigDecimal;

public abstract class Entrega {
    public abstract BigDecimal calculaTaxaEntrega();
    public abstract String exibirInfoEntrega(Visitor visitor);
}
