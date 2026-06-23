package padroescomportamentais.visitor;

public class VisitorInfoEntrega implements Visitor {
    @Override
    public String visit(InLocoEntrega inLoco) {
        return "Entrega In Loco (Consumo no Estabelecimento). Sem taxa de entrega.";
    }

    @Override
    public String visit(DeliveryEntrega delivery) {
        return "Entrega via Delivery. Código: " + delivery.getCodigo() + ". Taxa: R$ " + delivery.calculaTaxaEntrega();
    }
}
