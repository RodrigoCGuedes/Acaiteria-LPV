package padroesestruturais.proxy;

import java.util.List;
import padroescomportamentais.observer.Pedido;
import padroescomportamentais.templatemethod.ExportadorRelatorioTemplate;

public class ProxyExportadorRelatorio extends ExportadorRelatorioTemplate {
    private ExportadorRelatorioTemplate realRelatorio;
    private Gerente gerente;

    public ProxyExportadorRelatorio(ExportadorRelatorioTemplate realRelatorio, Gerente gerente) {
        this.realRelatorio = realRelatorio;
        this.gerente = gerente;
    }

    @Override
    public String gerarCorpo(List<Pedido> pedidos) {
        if (this.gerente.isAutorizado()) {
            return this.realRelatorio.gerarCorpo(pedidos);
        }
        throw new SecurityException("Acesso negado");
    }

    @Override
    public String gerarRodape(List<Pedido> pedidos) {
        if (this.gerente.isAutorizado()) {
            return this.realRelatorio.gerarRodape(pedidos);
        }
        throw new SecurityException("Acesso negado");
    }
}
