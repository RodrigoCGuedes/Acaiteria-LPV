package padroesestruturais.facade;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import padroescomportamentais.observer.Cliente;
import padroescomportamentais.observer.Pedido;
import padroescomportamentais.state.PedidoConcluido;
import padroescomportamentais.strategy.DescontoFixo;
import padroesestruturais.adapter.TamanhoAdapter;
import padroesestruturais.adapter.TamanhoCopo;
import padroesestruturais.decorator.Banana;

import static org.junit.jupiter.api.Assertions.*;

class AcaiteriaFacadeTest {
    @Test
    void deveRealizarPedidoCompletoPorFacade() {
        Cliente cliente = new Cliente("Helena");
        TamanhoAdapter tamanho = new TamanhoAdapter(new TamanhoCopo(500));
        DescontoFixo semDesconto = new DescontoFixo(BigDecimal.ZERO);
        Banana banana = new Banana(new BigDecimal("15.00"), semDesconto, tamanho);

        Pedido pedido = AcaiteriaFacade.realizarPedidoCompleto(
                cliente,
                banana,
                2,
                "Cartao:1111-2222",
                "ENTREGUE-44",
                new BigDecimal("5.00")
        );

        assertEquals(new BigDecimal("30.00"), pedido.getValorTotal());
        assertTrue(pedido.getEstadoPedido() instanceof PedidoConcluido);
        assertEquals("Concluído", cliente.getUltimoEstadoNotificado().getNomeEstado());
    }
}
