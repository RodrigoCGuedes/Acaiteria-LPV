package padroescriacionais.factorymethod;

public class CartaoCredito implements IFormaPagamento {
    private String numero;

    public CartaoCredito(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return this.numero;
    }

    @Override
    public String processarPagamento() {
        return "Pagamento com Cartão de Crédito (" + this.numero + ") processado.";
    }
}
