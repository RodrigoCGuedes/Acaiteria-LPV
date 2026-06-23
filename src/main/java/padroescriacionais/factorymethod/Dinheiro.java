package padroescriacionais.factorymethod;

public class Dinheiro implements IFormaPagamento {
    @Override
    public String processarPagamento() {
        return "Pagamento em Dinheiro processado.";
    }
}
