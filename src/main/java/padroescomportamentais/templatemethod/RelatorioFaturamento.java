package padroescomportamentais.templatemethod;

import java.math.BigDecimal;
import java.util.List;
import padroescomportamentais.observer.Pedido;

public class RelatorioFaturamento extends ExportadorRelatorioTemplate {
    @Override
    public String gerarCorpo(List<Pedido> pedidos) {
        BigDecimal total = BigDecimal.ZERO;
        if (pedidos != null) {
            for (Pedido p : pedidos) {
                total = total.add(p.getValorTotal());
            }
        }
        return "Faturamento Total: R$ " + total;
    }

    @Override
    public String gerarRodape(List<Pedido> pedidos) {
        return "Fim do relatório de faturamento.";
    }
}
