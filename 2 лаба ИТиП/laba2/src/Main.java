import java.sql.SQLOutput;

// Абстрактный класс Компьютерная периферия
abstract class ComputerPeripheral {
    private String brand;
    private String model;
    private double price;
    private static int schetchik=0;

    public ComputerPeripheral(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    public ComputerPeripheral(){
        String brand;
        String model;
        double price;
    }

    // Геттеры и сеттеры
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Абстрактные методы для описания поведения периферийного устройства
    public abstract void connect();

    public abstract void disconnect();
}

// Класс Клавиатура, наследуется от Компьютерная периферия
class Keyboard extends ComputerPeripheral {
    private boolean backlit;
    private String layout;

    public Keyboard(String brand, String model, double price, boolean backlit, String layout) {
        super(brand, model, price);
        this.backlit = backlit;
        this.layout = layout;
    }

    public boolean isBacklit() {
        return backlit;
    }

    public String getLayout() {
        return layout;
    }

    public void setBacklit(boolean backlit) {
        this.backlit = backlit;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    @Override
    public void connect() {
        System.out.println(getBrand() + " " + getModel());
        System.out.println("Price: "+getPrice());
        System.out.println("Backlit: "+isBacklit());
        System.out.println("Layout: "+getLayout());
        System.out.println("Keybord is connected.");
    }

    @Override
    public void disconnect() {
        System.out.println(getBrand() + " " + getModel());
        System.out.println("Price: "+getPrice());
        System.out.println("Backlit: "+isBacklit());
        System.out.println("Layout: "+getLayout());
        System.out.println("Keybord is disconnected.");
    }
}

// Класс Наушники, наследуется от Компьютерная периферия
class Headphones extends ComputerPeripheral {
    private int impedance;
    private String microphoneType;

    public Headphones(String brand, String model, double price, int impedance, String microphoneType) {
        super(brand, model, price);
        this.impedance = impedance;
        this.microphoneType = microphoneType;
    }

    public int getImpedance() {
        return impedance;
    }

    public String getMicrophoneType() {
        return microphoneType;
    }

    public void setImpedance(int impedance) {
        this.impedance = impedance;
    }

    public void setMicrophoneType(String microphoneType) {
        this.microphoneType = microphoneType;
    }

    @Override
    public void connect() {
        System.out.println(getBrand() + " " + getModel());
        System.out.println("Price: "+getPrice());
        System.out.println("Impedance: "+getImpedance());
        System.out.println("MicrophoneType: "+getMicrophoneType());
        System.out.println("Keybord are connected.");
    }

    @Override
    public void disconnect() {
        System.out.println(getBrand() + " " + getModel());
        System.out.println("Price: "+getPrice());
        System.out.println("Impedance: "+getImpedance());
        System.out.println("MicrophoneType: "+getMicrophoneType());
        System.out.println("Keybord are disconnected.");
    }
}

// Класс Графический планшет, наследуется от Компьютерная периферия
class GraphicsTablet extends ComputerPeripheral {
    private double width;
    private double height;

    private static int numberOfGraphicsTablets = 0; // Счетчик созданных объектов GraphicsTablet

    public GraphicsTablet(String brand, String model, double price, double width, double height) {
        super(brand, model, price);
        this.width = width;
        this.height = height;
        numberOfGraphicsTablets++; // Увеличиваем счетчик при создании объекта
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void connect() {
        System.out.println(getBrand() + " " + getModel());
        System.out.println("Price: "+getPrice());
        System.out.println("Height: "+getHeight());
        System.out.println("Width: "+getWidth());
        System.out.println("CraphicTablet is connected.");
    }

    @Override
    public void disconnect() {
        System.out.println(getBrand() + " " + getModel());
        System.out.println("Price: "+getPrice());
        System.out.println("Height: "+getHeight());
        System.out.println("Width: "+getWidth());
        System.out.println("CraphicTablet is disconnected.");
    }
}
class Main{
    public static void main(String[] args){
        Keyboard ZETGaming= new Keyboard("ZETGaming","Blade",5000.0,true,"100%");
        Headphones Edifier=new Headphones("Edifier","G33BT",6300.0,32,"Condenser/electret");
        GraphicsTablet Huion=new GraphicsTablet("Huion","Kamvas pro 13",31050.0,219.0,388.0);
        GraphicsTablet XPpen=new GraphicsTablet("XPpen","XP-Pen Artist 22",50425.0,230.0,460.0);
        System.out.println("Клавиатура:");
        ZETGaming.connect();
        System.out.println();
        System.out.println("Наушники:");
        Edifier.connect();
        System.out.println();
        System.out.println("Графический планшет:");
        Huion.connect();
        System.out.println();
        XPpen.disconnect();
        System.out.println();
        System.out.println("Total ComputerPeripheral:" + ComputerPeripheral.class);
    }
}