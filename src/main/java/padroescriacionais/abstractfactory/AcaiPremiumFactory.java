package padroescriacionais.abstractfactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import padroescomportamentais.strategy.DescontoFixo;
import padroesestruturais.adapter.TamanhoAdapter;
import padroesestruturais.adapter.TamanhoCopo;
import padroesestruturais.decorator.AcaiBase;
import padroesestruturais.decorator.AcaiDecorator;
import padroesestruturais.decorator.Banana;
import padroesestruturais.decorator.Granola;

public class AcaiPremiumFactory implements AbstractFactoryCombo {
    private boolean ativo;
    private LocalDateTime dataLimiteUso;

    public AcaiPremiumFactory(boolean ativo, LocalDateTime dataLimiteUso) {
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
        return new Banana(new BigDecimal("15.00"), new DescontoFixo(BigDecimal.ZERO), new TamanhoAdapter(new TamanhoCopo(500)));
    }

    @Override
    public Granola definirAdicional(AcaiDecorator acaiDecorator) {
        return new Granola(acaiDecorator);
    }
}
