package padroescomportamentais.chainofresponsibility;

import org.junit.jupiter.api.Test;
import padroescomportamentais.state.PedidoEmPreparo;
import padroescomportamentais.state.PedidoRealizado;
import padroescomportamentais.state.PedidoConcluido;

import static org.junit.jupiter.api.Assertions.*;

class ChainOfResponsibilityTest {
    @Test
    void deveProcessarEtapaPelaCozinha() {
        Cozinha cozinha = new Cozinha();
        DeliverySetor delivery = new DeliverySetor();

        cozinha.setSucessor(delivery);
        cozinha.adicionarResponsabilidade(new PedidoRealizado());
        cozinha.adicionarResponsabilidade(new PedidoEmPreparo());

        String resultado = cozinha.processarEtapa(new PedidoEmPreparo());
        assertEquals("Cozinha tratou a etapa Em Preparo.", resultado);
    }

    @Test
    void deveProcessarEtapaPeloDeliveryComoSucessor() {
        Cozinha cozinha = new Cozinha();
        DeliverySetor delivery = new DeliverySetor();

        cozinha.setSucessor(delivery);
        cozinha.adicionarResponsabilidade(new PedidoRealizado());
        delivery.adicionarResponsabilidade(new PedidoConcluido());

        String resultado = cozinha.processarEtapa(new PedidoConcluido());
        assertEquals("Delivery tratou a etapa Concluído.", resultado);
    }

    @Test
    void deveRetornarErroParaEtapaNaoTratada() {
        Cozinha cozinha = new Cozinha();
        DeliverySetor delivery = new DeliverySetor();

        cozinha.setSucessor(delivery);
        cozinha.adicionarResponsabilidade(new PedidoRealizado());

        String resultado = cozinha.processarEtapa(new PedidoConcluido());
        assertEquals("Nenhum setor disponível para tratar a etapa Concluído.", resultado);
    }
}
