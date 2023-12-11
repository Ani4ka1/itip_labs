import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

class Products{
    String name;
    double price;

    public Products(String name, double price) { //конструктор класса для продукс
        this.name = name;
        this.price = price;
    }
}

class SalesTrack {
    private HashMap<Products, Integer> sales; //для отслеживания количества проданных единиц каждого продукта.
    private double totalSales; //сумма продаж

    public SalesTrack() { //конструктор инициализирует салес как хэш
        sales = new HashMap<>();
        totalSales = 0.0;
    }

    public void addSale(Products product, int quantity) {
        sales.put(product, sales.getOrDefault(product, 0) + quantity); //метод getOrDefault для получения текущего количества проданного товара
        totalSales += product.price * quantity; //добавляет новое количество и обновляет общую сумму продаж
    }

    public void listSales() {
        System.out.println("Проданные товары:");
        for (Map.Entry<Products, Integer> entry : sales.entrySet()) {
            System.out.println(entry.getKey().name + " - Количество: " + entry.getValue());
        }
    }

    public double getTotalSales() { //возращает общую сумму продаж
        return totalSales;
    }

    public String getMostPopularProduct() {
        return Collections.max(sales.entrySet(), Map.Entry.comparingByValue()) //нахождения продукта с максимальным количеством продаж
                .getKey().name;
    }
}

public class nta {
    public static void main(String[] args) {
        SalesTrack tracker = new SalesTrack();

        Products milk = new Products("Молоко", 50.0);
        Products bread = new Products("Хлеб", 30.0);

        tracker.addSale(milk, 10);
        tracker.addSale(bread, 5);
        tracker.addSale(milk, 3);

        tracker.listSales();
        System.out.println("Общая сумма продаж: " + tracker.getTotalSales());
        System.out.println("Наиболее популярный товар: " + tracker.getMostPopularProduct());
    }
}