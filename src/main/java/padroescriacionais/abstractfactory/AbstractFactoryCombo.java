package padroescriacionais.abstractfactory;

import padroesestruturais.decorator.AcaiBase;
import padroesestruturais.decorator.AcaiDecorator;

public interface AbstractFactoryCombo {
    AcaiBase definirTipoAcaiBase();
    Adicional definirAdicional(AcaiDecorator acaiDecorator);
}
