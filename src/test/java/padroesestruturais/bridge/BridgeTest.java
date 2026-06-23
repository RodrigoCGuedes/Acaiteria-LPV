package padroesestruturais.bridge;

import org.junit.jupiter.api.Test;
import padroescomportamentais.observer.Carrinho;
import padroescomportamentais.observer.Cliente;
import padroescomportamentais.observer.Pedido;
import padroescriacionais.factorymethod.CartaoCredito;
import padroescriacionais.factorymethod.Dinheiro;
import padroescriacionais.factorymethod.IFormaPagamento;

import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {
    @Test
    void deveProcessarDiferentesFormasPagamentoUsandoBridge() {
        Cliente cliente = new Cliente("Gustavo");
        Carrinho carrinho = new Carrinho(cliente);
        Pedido pedido = new Pedido(carrinho);

        IFormaPagamento cartao = new CartaoCredito("1111-2222-3333-4444");
        pedido.setFormaPagamento(cartao);
        assertEquals("Pagamento com Cartão de Crédito (1111-2222-3333-4444) processado.", pedido.getFormaPagamento().processarPagamento());

        IFormaPagamento dinheiro = new Dinheiro();
        pedido.setFormaPagamento(dinheiro);
        assertEquals("Pagamento em Dinheiro processado.", pedido.getFormaPagamento().processarPagamento());
    }
}
