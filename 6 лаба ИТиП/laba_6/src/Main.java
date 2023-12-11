import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// Класс для представления продукта
class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

// Класс для отслеживания продаж
class SalesTracker {
    private LinkedList<Product> sales;
    private Map<String, Integer> productCount;

    public SalesTracker() {
        sales = new LinkedList<>();
        productCount = new HashMap<>();
    }

    // Добавление продукта в список продаж
    public void addSale(Product product) {
        sales.add(product);

        productCount.put(product.name, productCount.getOrDefault(product.name, 0) + 1);
    }

    // Вывод списка проданных товаров
    public void listSales() {
        System.out.println("Проданные товары:");
        for (Product product : sales) {
            System.out.println(product.name + " по цене " + product.price);
        }
    }

    // Расчет общей суммы продаж
    public double totalSales() {
        double total = 0.0;
        for (Product product : sales) {
            total += product.price;
        }
        return total;
    }

    // Нахождение наиболее популярного товара
    public String mostPopularProduct() {
        String popularProduct = null;
        int maxCount = 0;
        for (String name : productCount.keySet()) {
            int count = productCount.get(name);
            if (count > maxCount) {
                maxCount = count;
                popularProduct = name;
            }
        }
        return popularProduct;
    }
}

// Демонстрация использования классов
public class Main {
    public static void main(String[] args) {
        SalesTracker tracker = new SalesTracker();

        tracker.addSale(new Product("Молоко", 50.0));
        tracker.addSale(new Product("Хлеб", 30.0));
        tracker.addSale(new Product("Молоко", 50.0));

        tracker.listSales();
        System.out.println("Общая сумма продаж: " + tracker.totalSales());
        System.out.println("Наиболее популярный товар: " + tracker.mostPopularProduct());
    }
}