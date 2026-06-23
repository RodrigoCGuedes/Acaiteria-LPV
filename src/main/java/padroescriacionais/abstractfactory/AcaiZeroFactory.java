package padroescriacionais.abstractfactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import padroescomportamentais.strategy.DescontoFixo;
import padroesestruturais.adapter.TamanhoAdapter;
import padroesestruturais.adapter.TamanhoCopo;
import padroesestruturais.decorator.AcaiBase;
import padroesestruturais.decorator.AcaiDecorator;
import padroesestruturais.decorator.CaldaMorango;
import padroesestruturais.decorator.ZeroAcucar;

public class AcaiZeroFactory implements AbstractFactoryCombo {
    private boolean ativo;
    private LocalDateTime dataLimiteUso;

    public AcaiZeroFactory(boolean ativo, LocalDateTime dataLimiteUso) {
        this.ativo = ativo;
        this.dataLimiteUso = dataLimiteUso;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public LocalDateTime getDataLimiteUso() {
        return this.dataLimiteUso;
    }

    @Override
    public AcaiBase definirTipoAcaiBase() {
        return new ZeroAcucar(new BigDecimal("12.00"), new DescontoFixo(BigDecimal.ZERO), new TamanhoAdapter(new TamanhoCopo(300)));
    }

    @Override
    public CaldaMorango definirAdicional(AcaiDecorator acaiDecorator) {
        return new CaldaMorango(acaiDecorator);
    }
}
