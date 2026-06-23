package padroescomportamentais.visitor;

import java.math.BigDecimal;

public class InLocoEntrega extends Entrega {
    @Override
    public BigDecimal calculaTaxaEntrega() {
        return BigDecimal.ZERO;
    }

    @Override
    public String exibirInfoEntrega(Visitor visitor) {
        return visitor.visit(this);
    }
}
