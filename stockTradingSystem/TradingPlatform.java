package stockTradingSystem;
import java.util.Scanner;

public class TradingPlatform {
    private Portfolio portfolio;
    private MarketData marketData;

    public TradingPlatform() {
        this.portfolio = new Portfolio();
        this.marketData = new MarketData();
        populateMarketData();
    }

    public void startTrading() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Buy Stock");
            System.out.println("2. Sell Stock");
            System.out.println("3. View Portfolio");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    buyStock(scanner);
                    break;
                case 2:
                    sellStock(scanner);
                    break;
                case 3:
                    viewPortfolio();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }  
    }
   
    private void buyStock(Scanner scanner) {
        if (portfolio.getBalance() == 0.0) {
            System.out.println("Your balance is zero. You need to add funds to proceed.");
            addFunds(scanner);  // Prompt user to add funds
        }

        System.out.println("Enter stock symbol:");
        String symbol = scanner.next();

        Stock stock = marketData.getStocks().stream()
                .filter(s -> s.getSymbol().equals(symbol))
                .findFirst()
                .orElse(null);

        if (stock != null) {
            System.out.println("Enter quantity:");
            int quantity = scanner.nextInt();

            double totalCost = stock.getPrice() * quantity;

            if (portfolio.getBalance() >= totalCost) {
                portfolio.setBalance(portfolio.getBalance() - totalCost);
                portfolio.addStock(stock);
                System.out.println("Stock bought successfully");
            } else {
                System.out.println("Insufficient balance");
            }
        } else {
            System.out.println("Stock not found");
        }
    }

    private void sellStock(Scanner scanner) {
        System.out.println("Enter stock symbol:");
        String symbol = scanner.next();

        Stock stock = portfolio.getStocks().stream()
                .filter(s -> s.getSymbol().equals(symbol))
                .findFirst()
                .orElse(null);

        if (stock != null) {
            System.out.println("Enter quantity:");
            int quantity = scanner.nextInt();

            double totalRevenue = stock.getPrice() * quantity;

            portfolio.setBalance(portfolio.getBalance() + totalRevenue);
            portfolio.removeStock(stock);
            System.out.println("Stock sold successfully");
        } else {
            System.out.println("Stock not found in portfolio");
        }
    }

    private void viewPortfolio() {
        System.out.println("Portfolio Balance: " + portfolio.getBalance());
        portfolio.getStocks().forEach(stock -> 
            System.out.println(stock.getSymbol() + " - " + stock.getCompanyName() + " - " + stock.getPrice()));
    }
    private void addFunds(Scanner scanner) {
        System.out.println("Enter amount to add:");
        double amount = scanner.nextDouble();
        portfolio.setBalance(portfolio.getBalance() + amount);
        System.out.println("Funds added successfully.");
    }
    public void populateMarketData() {
        MarketData.addStock(new Stock("AAPL", "Apple Inc.", 150.00));
        MarketData.addStock(new Stock("MSFT", "Microsoft Corporation", 280.00));
        MarketData.addStock(new Stock("AMZN", "Amazon.com, Inc.", 3300.00));
        MarketData.addStock(new Stock("TSLA", "Tesla, Inc.", 700.00));
        MarketData.addStock(new Stock("GOOGL", "Alphabet Inc.", 2700.00));
    }

    public static void main(String[] args) {
        TradingPlatform platform = new TradingPlatform();
        platform.startTrading();
        platform.addFunds(null);
    }
}

