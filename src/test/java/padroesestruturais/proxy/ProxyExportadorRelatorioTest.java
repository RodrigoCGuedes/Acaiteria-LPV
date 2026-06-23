package padroesestruturais.proxy;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import padroescomportamentais.observer.Pedido;
import padroescomportamentais.templatemethod.ExportadorRelatorioTemplate;
import padroescomportamentais.templatemethod.RelatorioFaturamento;

import static org.junit.jupiter.api.Assertions.*;

class ProxyExportadorRelatorioTest {
    @Test
    void devePermitirAcessoGerenteAutorizado() {
        Gerente gerente = new Gerente("Marcos", true);
        List<Pedido> pedidos = new ArrayList<>();

        ExportadorRelatorioTemplate realRelatorio = new RelatorioFaturamento();
        ProxyExportadorRelatorio proxy = new ProxyExportadorRelatorio(realRelatorio, gerente);

        String relatorio = proxy.exportar(pedidos);
        String esperado = "Cabeçalho\nFaturamento Total: R$ 0\nFim do relatório de faturamento.";
        assertEquals(esperado, relatorio);
    }

    @Test
    void deveNegarAcessoGerenteNaoAutorizado() {
        Gerente gerente = new Gerente("Marcos", false);
        List<Pedido> pedidos = new ArrayList<>();

        ExportadorRelatorioTemplate realRelatorio = new RelatorioFaturamento();
        ProxyExportadorRelatorio proxy = new ProxyExportadorRelatorio(realRelatorio, gerente);

        try {
            proxy.exportar(pedidos);
            fail("Deveria ter lançado SecurityException");
        } catch (SecurityException e) {
            assertEquals("Acesso negado", e.getMessage());
        }
    }
}
