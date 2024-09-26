import java.util.*;

interface Investor {
    void update(String stock, double price);
}

class ConcreteInvestor implements Investor {
    private String name;

    public ConcreteInvestor(String name) {
        this.name = name;
    }

    public void update(String stock, double price) {
        System.out.println(name + " notified. " + stock + " stock price changed to $" + price);
    }
}

interface Stock {
    void addObserver(Investor investor);

    void removeObserver(Investor investor);

    void notifyObservers();
}

class ConcreteStock implements Stock {
    private String name;
    private double price;
    private List<Investor> investors = new ArrayList<>();

    public ConcreteStock(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void addObserver(Investor investor) {
        investors.add(investor);
    }

    public void removeObserver(Investor investor) {
        investors.remove(investor);
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    public void notifyObservers() {
        for (Investor investor : investors) {
            investor.update(name, price);
        }
    }
}

public class StockMarketMonitoring {
    public static void main(String[] args) {
        ConcreteStock apple = new ConcreteStock("Apple", 150);
        Investor john = new ConcreteInvestor("John");
        Investor jane = new ConcreteInvestor("Jane");

        apple.addObserver(john);
        apple.addObserver(jane);

        apple.setPrice(155);
        apple.setPrice(160); 
    }
}
