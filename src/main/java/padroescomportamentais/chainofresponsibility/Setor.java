package padroescomportamentais.chainofresponsibility;

import java.util.ArrayList;
import padroescomportamentais.state.EstadoPedido;

public abstract class Setor {
    private ArrayList<EstadoPedido> responsabilidade = new ArrayList<>();
    private Setor sucessor;

    public Setor getSucessor() {
        return this.sucessor;
    }

    public void setSucessor(Setor sucessor) {
        this.sucessor = sucessor;
    }

    public ArrayList<EstadoPedido> getResponsabilidade() {
        return this.responsabilidade;
    }

    public void adicionarResponsabilidade(EstadoPedido estado) {
        this.responsabilidade.add(estado);
    }

    public String processarEtapa(EstadoPedido estado) {
        for (EstadoPedido ep : this.responsabilidade) {
            if (ep.getClass().equals(estado.getClass())) {
                return this.getDescricaoSetor() + " tratou a etapa " + estado.getNomeEstado() + ".";
            }
        }
        if (this.sucessor != null) {
            return this.sucessor.processarEtapa(estado);
        }
        return "Nenhum setor disponível para tratar a etapa " + estado.getNomeEstado() + ".";
    }

    public abstract String getDescricaoSetor();
}
