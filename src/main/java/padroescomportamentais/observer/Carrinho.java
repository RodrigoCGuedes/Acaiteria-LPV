package padroescomportamentais.observer;

import java.util.ArrayList;
import java.util.List;
import padroescomportamentais.state.EstadoPedido;
import padroesestruturais.decorator.Produto;

public class Carrinho {
    private Cliente cliente;
    private List<ItemPedido> itens = new ArrayList<>();

    public Carrinho(Cliente cliente) {
        this.cliente = cliente;
        cliente.setCarrinho(this);
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        this.itens.add(new ItemPedido(produto, quantidade, produto.getPrecoBase()));
    }

    public List<ItemPedido> getItens() {
        return this.itens;
    }

    public EstadoPedido realizarPedido() {
        Pedido pedido = new Pedido(this);
        pedido.addObserver(this.cliente);
        pedido.realizarPedido();
        return pedido.getEstadoPedido();
    }
}
