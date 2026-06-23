package padroescomportamentais.visitor;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class VisitorEntregaTest {
    @Test
    void deveRetornarInfoEntregaInLoco() {
        Entrega entrega = new InLocoEntrega();
        Visitor visitor = new VisitorInfoEntrega();

        assertEquals("Entrega In Loco (Consumo no Estabelecimento). Sem taxa de entrega.", entrega.exibirInfoEntrega(visitor));
        assertEquals(BigDecimal.ZERO, entrega.calculaTaxaEntrega());
    }

    @Test
    void deveRetornarInfoEntregaDelivery() {
        DeliveryEntrega entrega = new DeliveryEntrega("DEL-12345", new BigDecimal("7.50"));
        Visitor visitor = new VisitorInfoEntrega();

        assertEquals("DEL-12345", entrega.getCodigo());
        assertEquals("Entrega via Delivery. Código: DEL-12345. Taxa: R$ 7.50", entrega.exibirInfoEntrega(visitor));
        assertEquals(new BigDecimal("7.50"), entrega.calculaTaxaEntrega());
    }

    @Test
    void deveInvocarMetodosVisitDiretamente() {
        Visitor visitor = new VisitorInfoEntrega();
        InLocoEntrega inLoco = new InLocoEntrega();
        DeliveryEntrega delivery = new DeliveryEntrega("DEL-99", new BigDecimal("10.00"));

        assertEquals("Entrega In Loco (Consumo no Estabelecimento). Sem taxa de entrega.", visitor.visit(inLoco));
        assertEquals("Entrega via Delivery. Código: DEL-99. Taxa: R$ 10.00", visitor.visit(delivery));
    }
}
