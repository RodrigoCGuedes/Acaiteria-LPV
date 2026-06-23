package padroescriacionais.builder;

import padroescomportamentais.observer.Cliente;
import padroescomportamentais.observer.ItemPedido;
import padroescomportamentais.observer.Pedido;
import padroesestruturais.decorator.Produto;
import padroescriacionais.factorymethod.IFormaPagamento;

public class PedidoBuilder {
    private Pedido pedido;

    public PedidoBuilder() {
        this.pedido = new Pedido();
    }

    public PedidoBuilder setCliente(Cliente cliente) {
        this.pedido.addObserver(cliente);
        return this;
    }

    public PedidoBuilder adicionarItem(Produto produto, int quantidade) {
        ItemPedido item = new ItemPedido(produto, quantidade, produto.getPrecoBase());
        this.pedido.adicionarItem(item);
        return this;
    }

    public PedidoBuilder setFormaPagamento(IFormaPagamento formaPagamento) {
        this.pedido.setFormaPagamento(formaPagamento);
        return this;
    }

    public PedidoBuilder setCupomDesconto(String cupom) {
        this.pedido.setCupomDesconto(cupom);
        return this;
    }

    public Pedido build() {
        return this.pedido;
    }
}
