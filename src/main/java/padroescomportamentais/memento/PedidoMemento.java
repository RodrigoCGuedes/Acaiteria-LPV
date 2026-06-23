package padroescomportamentais.memento;

public class PedidoMemento {
    private int valorTotal;
    private String cupomDesconto;

    public PedidoMemento(int valorTotal, String cupomDesconto) {
        this.valorTotal = valorTotal;
        this.cupomDesconto = cupomDesconto;
    }

    public int getValorTotal() {
        return this.valorTotal;
    }

    public String getCupomDesconto() {
        return this.cupomDesconto;
    }
}
