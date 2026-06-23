package padroescriacionais.factorymethod;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FormaPagamentoFactoryTest {
    @Test
    void deveCriarPagamentoCartaoComNumero() {
        FormaPagamentoFactory factory = new FormaPagamentoFactory();
        IFormaPagamento pagamento = factory.obterFormaPagamento("Cartao:1234-5678");

        assertTrue(pagamento instanceof CartaoCredito);
        CartaoCredito cartao = (CartaoCredito) pagamento;
        assertEquals("1234-5678", cartao.getNumero());
        assertEquals("Pagamento com Cartão de Crédito (1234-5678) processado.", pagamento.processarPagamento());
    }

    @Test
    void deveCriarPagamentoCartaoComNumeroPadrao() {
        FormaPagamentoFactory factory = new FormaPagamentoFactory();
        IFormaPagamento pagamento = factory.obterFormaPagamento("Cartao");

        assertTrue(pagamento instanceof CartaoCredito);
        CartaoCredito cartao = (CartaoCredito) pagamento;
        assertEquals("0000-0000-0000-0000", cartao.getNumero());
        assertEquals("Pagamento com Cartão de Crédito (0000-0000-0000-0000) processado.", pagamento.processarPagamento());
    }

    @Test
    void deveCriarPagamentoDinheiro() {
        FormaPagamentoFactory factory = new FormaPagamentoFactory();
        IFormaPagamento pagamento = factory.obterFormaPagamento("Dinheiro");

        assertTrue(pagamento instanceof Dinheiro);
        assertEquals("Pagamento em Dinheiro processado.", pagamento.processarPagamento());
    }

    @Test
    void deveRetornarExcecaoParaFormaPagamentoInvalida() {
        FormaPagamentoFactory factory = new FormaPagamentoFactory();
        try {
            factory.obterFormaPagamento("Cheque");
            fail("Deveria ter lançado IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Forma de pagamento inválida", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaFormaPagamentoNula() {
        FormaPagamentoFactory factory = new FormaPagamentoFactory();
        try {
            factory.obterFormaPagamento(null);
            fail("Deveria ter lançado IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Forma de pagamento não pode ser nula", e.getMessage());
        }
    }
}
