package padroescomportamentais.observer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import padroescomportamentais.memento.PedidoMemento;
import padroescomportamentais.state.EstadoPedido;
import padroescomportamentais.state.PedidoRealizado;
import padroescriacionais.factorymethod.IFormaPagamento;

public class Pedido extends Observable {
    private BigDecimal valorTotal;
    private String cupomDesconto;
    private EstadoPedido estadoPedido;
    private IFormaPagamento formaPagamento;
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(Carrinho carrinho) {
        this.itens = new ArrayList<>(carrinho.getItens());
        this.valorTotal = calcularValorTotal();
        this.cupomDesconto = "";
        this.estadoPedido = new PedidoRealizado();
    }

    public Pedido() {
        this.estadoPedido = new PedidoRealizado();
        this.valorTotal = BigDecimal.ZERO;
        this.cupomDesconto = "";
    }

    public BigDecimal calcularValorTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemPedido item : this.itens) {
            total = total.add(item.getSubTotal());
        }
        return total;
    }

    public BigDecimal getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getCupomDesconto() {
        return this.cupomDesconto;
    }

    public void setCupomDesconto(String cupomDesconto) {
        this.cupomDesconto = cupomDesconto;
    }

    public EstadoPedido getEstadoPedido() {
        return this.estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
        notifyObservers(estadoPedido);
    }

    public IFormaPagamento getFormaPagamento() {
        return this.formaPagamento;
    }

    public void setFormaPagamento(IFormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public List<ItemPedido> getItens() {
        return this.itens;
    }

    public void adicionarItem(ItemPedido item) {
        this.itens.add(item);
        this.valorTotal = calcularValorTotal();
    }

    public String realizarPedido() {
        return this.estadoPedido.realizarPedido(this);
    }

    public String prepararPedido() {
        return this.estadoPedido.prepararPedido(this);
    }

    public String concluirPedido() {
        return this.estadoPedido.concluirPedido(this);
    }

    public String cancelarPedido() {
        return this.estadoPedido.cancelarPedido(this);
    }

    public PedidoMemento salvar() {
        return new PedidoMemento(this.valorTotal.intValue(), this.cupomDesconto);
    }

    public void restaurar(PedidoMemento memento) {
        if (memento != null) {
            this.valorTotal = new BigDecimal(memento.getValorTotal()).setScale(2, java.math.RoundingMode.HALF_UP);
            this.cupomDesconto = memento.getCupomDesconto();
        }
    }
}
