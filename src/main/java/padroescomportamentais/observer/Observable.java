package padroescomportamentais.observer;

import java.util.ArrayList;
import java.util.List;
import padroescomportamentais.state.EstadoPedido;

public class Observable {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers(EstadoPedido estado) {
        for (Observer observer : this.observers) {
            observer.atualizar(estado);
        }
    }
}
