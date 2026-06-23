package padroescriacionais.factorymethod;

public class FormaPagamentoFactory {
    public IFormaPagamento obterFormaPagamento(String formaPagamento) {
        if (formaPagamento == null) {
            throw new IllegalArgumentException("Forma de pagamento não pode ser nula");
        }
        if (formaPagamento.startsWith("Cartao")) {
            String[] partes = formaPagamento.split(":");
            String numero = partes.length > 1 ? partes[1] : "0000-0000-0000-0000";
            return new CartaoCredito(numero);
        } else if ("Dinheiro".equalsIgnoreCase(formaPagamento)) {
            return new Dinheiro();
        }
        throw new IllegalArgumentException("Forma de pagamento inválida");
    }
}
