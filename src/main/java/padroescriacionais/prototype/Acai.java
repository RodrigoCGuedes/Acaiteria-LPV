package padroescriacionais.prototype;

import java.math.BigDecimal;
import padroescomportamentais.strategy.Promocao;
import padroesestruturais.adapter.ITamanho;
import padroesestruturais.decorator.Produto;

public class Acai implements Produto, Prototype {
    private String descricao;
    private BigDecimal precoBase;
    private Promocao promocao;
    private ITamanho tamanho;
    private String tipoAcaiBase;

    public Acai(String descricao, BigDecimal precoBase, Promocao promocao, ITamanho tamanho, String tipoAcaiBase) {
        this.descricao = descricao;
        this.precoBase = precoBase;
        this.promocao = promocao;
        this.tamanho = tamanho;
        this.tipoAcaiBase = tipoAcaiBase;
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public BigDecimal getPrecoBase() {
        return this.precoBase;
    }

    @Override
    public Promocao getPromocao() {
        return this.promocao;
    }

    @Override
    public ITamanho getTamanho() {
        return this.tamanho;
    }

    public String getTipoAcaiBase() {
        return this.tipoAcaiBase;
    }

    public BigDecimal calculaPrecoNaPromocao() {
        if (this.promocao == null) {
            return this.precoBase;
        }
        BigDecimal desconto = this.promocao.calculaDesconto(this.precoBase);
        return this.precoBase.subtract(desconto).setScale(2, java.math.RoundingMode.HALF_UP);
    }

    public int getQtdMl() {
        if (this.tamanho == null) {
            return 0;
        }
        try {
            String t = this.tamanho.getTamanho();
            return Integer.parseInt(t.replace("ml", ""));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    @Override
    public Acai clone() {
        return new Acai(this.descricao, this.precoBase, this.promocao, this.tamanho, this.tipoAcaiBase);
    }
}
