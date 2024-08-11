package stockTradingSystem;
import java.util.ArrayList;
import java.util.List;

public class MarketData {
    private static List<Stock> stocks;

    public MarketData() {
        stocks = new ArrayList<>();
    }

    public static void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void removeStock(Stock stock) {
        stocks.remove(stock);
    }

    public List<Stock> getStocks() {
        return stocks;
    }
    
    
}

