package padroescomportamentais.visitor;

public interface Visitor {
    String visit(InLocoEntrega inLoco);
    String visit(DeliveryEntrega delivery);
}
