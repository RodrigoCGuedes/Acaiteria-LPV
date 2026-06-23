package padroesestruturais.composite;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import padroescomportamentais.strategy.Promocao;
import padroesestruturais.adapter.ITamanho;
import padroesestruturais.decorator.AcaiBase;
import padroesestruturais.decorator.Produto;

public class Combo extends AcaiBase {
    private String nome;
    private List<Produto> produtos = new ArrayList<>();

    public Combo(String nome, BigDecimal precoBase, Promocao promocao, ITamanho tamanho) {
        super(nome, precoBase, promocao, tamanho, "Combo");
        this.nome = nome;
    }

    public void adicionar(Produto produto) {
        this.produtos.add(produto);
    }

    public void remover(Produto produto) {
        this.produtos.remove(produto);
    }

    public List<Produto> getProdutos() {
        return this.produtos;
    }

    @Override
    public BigDecimal getPrecoBase() {
        BigDecimal total = super.getPrecoBase();
        for (Produto p : this.produtos) {
            total = total.add(p.getPrecoBase());
        }
        return total;
    }

    @Override
    public String getDescricao() {
        StringBuilder sb = new StringBuilder(this.nome);
        if (!this.produtos.isEmpty()) {
            sb.append(" (");
            for (int i = 0; i < this.produtos.size(); i++) {
                sb.append(this.produtos.get(i).getDescricao());
                if (i < this.produtos.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }
}
