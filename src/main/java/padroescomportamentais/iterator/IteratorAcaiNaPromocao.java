package padroescomportamentais.iterator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import padroesestruturais.decorator.Produto;

public class IteratorAcaiNaPromocao implements Iterator {
    private List<Produto> produtosValidos = new ArrayList<>();
    private int indice = 0;

    public IteratorAcaiNaPromocao(List<Produto> produtos) {
        if (produtos != null) {
            for (Produto p : produtos) {
                if (p.getPromocao() != null && p.getPromocao().calculaDesconto(p.getPrecoBase()).compareTo(BigDecimal.ZERO) > 0) {
                    this.produtosValidos.add(p);
                }
            }
        }
    }

    @Override
    public boolean temProximo() {
        return this.indice < this.produtosValidos.size();
    }

    @Override
    public Produto proximo() {
        if (!temProximo()) {
            return null;
        }
        return this.produtosValidos.get(this.indice++);
    }
}
