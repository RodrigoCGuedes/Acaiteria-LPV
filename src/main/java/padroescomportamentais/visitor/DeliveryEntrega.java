package padroescomportamentais.visitor;

import java.math.BigDecimal;

public class DeliveryEntrega extends Entrega {
    private String codigo;
    private BigDecimal taxa;

    public DeliveryEntrega(String codigo, BigDecimal taxa) {
        this.codigo = codigo;
        this.taxa = taxa;
    }

    public String getCodigo() {
        return this.codigo;
    }

    @Override
    public BigDecimal calculaTaxaEntrega() {
        return this.taxa;
    }

    @Override
    public String exibirInfoEntrega(Visitor visitor) {
        return visitor.visit(this);
    }
}
