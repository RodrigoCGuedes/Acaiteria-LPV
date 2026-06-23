package padroescomportamentais.templatemethod;

import java.util.List;
import padroescomportamentais.observer.ItemPedido;
import padroescomportamentais.observer.Pedido;

public class RelatorioEstoque extends ExportadorRelatorioTemplate {
    @Override
    public String gerarCorpo(List<Pedido> pedidos) {
        int totalItens = 0;
        if (pedidos != null) {
            for (Pedido p : pedidos) {
                for (ItemPedido item : p.getItens()) {
                    totalItens += item.getQuantidade();
                }
            }
        }
        return "Total de itens açaí produzidos: " + totalItens;
    }

    @Override
    public String gerarRodape(List<Pedido> pedidos) {
        return "Fim do relatório de estoque.";
    }
}
