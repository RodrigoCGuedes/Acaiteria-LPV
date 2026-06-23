package padroesestruturais.facade;

import java.math.BigDecimal;
import padroescomportamentais.observer.Cliente;
import padroescomportamentais.observer.Pedido;
import padroescomportamentais.visitor.DeliveryEntrega;
import padroescomportamentais.visitor.Entrega;
import padroescomportamentais.visitor.Visitor;
import padroescomportamentais.visitor.VisitorInfoEntrega;
import padroescriacionais.builder.PedidoBuilder;
import padroescriacionais.factorymethod.FormaPagamentoFactory;
import padroescriacionais.factorymethod.IFormaPagamento;
import padroesestruturais.decorator.Produto;

public class AcaiteriaFacade {
    public static Pedido realizarPedidoCompleto(Cliente cliente, Produto produto, int quantidade, String formaPagamentoStr, String codigoEntrega, BigDecimal taxaEntrega) {
        FormaPagamentoFactory pagFactory = new FormaPagamentoFactory();
        IFormaPagamento pag = pagFactory.obterFormaPagamento(formaPagamentoStr);

        Pedido pedido = new PedidoBuilder()
                .setCliente(cliente)
                .adicionarItem(produto, quantidade)
                .setFormaPagamento(pag)
                .build();

        Entrega entrega = new DeliveryEntrega(codigoEntrega, taxaEntrega);
        Visitor visitor = new VisitorInfoEntrega();
        entrega.exibirInfoEntrega(visitor);

        pedido.prepararPedido();
        pedido.concluirPedido();

        return pedido;
    }
}
