package stockTradingSystem;
import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private List<Stock> stocks;
    private double balance;

    public Portfolio() {
        this.stocks = new ArrayList<>();
        this.balance = 0.0;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void removeStock(Stock stock) {
        stocks.remove(stock);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Stock> getStocks() {
        return stocks;
    }
}
