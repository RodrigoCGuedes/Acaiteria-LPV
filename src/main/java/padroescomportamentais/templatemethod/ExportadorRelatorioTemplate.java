package padroescomportamentais.templatemethod;

import java.util.List;
import padroescomportamentais.observer.Pedido;

public abstract class ExportadorRelatorioTemplate {
    public final String exportar(List<Pedido> pedidos) {
        return "Cabeçalho\n" + gerarCorpo(pedidos) + "\n" + gerarRodape(pedidos);
    }

    public abstract String gerarCorpo(List<Pedido> pedidos);
    public abstract String gerarRodape(List<Pedido> pedidos);
}
