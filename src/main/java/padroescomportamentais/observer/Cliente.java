package padroescomportamentais.observer;

import java.util.ArrayList;
import java.util.List;
import padroescomportamentais.state.EstadoPedido;
import padroesestruturais.flyweight.Endereco;

public class Cliente implements Observer {
    private String nome;
    private List<Endereco> enderecos = new ArrayList<>();
    private Carrinho carrinho;
    private EstadoPedido ultimoEstadoNotificado;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void addEndereco(Endereco endereco) {
        this.enderecos.add(endereco);
    }

    public List<Endereco> getEnderecos() {
        return this.enderecos;
    }

    public Carrinho getCarrinho() {
        return this.carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public EstadoPedido realizaPedido() {
        if (this.carrinho == null) {
            throw new IllegalStateException("Cliente não possui carrinho");
        }
        return this.carrinho.realizarPedido();
    }

    public EstadoPedido getUltimoEstadoNotificado() {
        return this.ultimoEstadoNotificado;
    }

    @Override
    public void atualizar(EstadoPedido estado) {
        this.ultimoEstadoNotificado = estado;
    }
}
