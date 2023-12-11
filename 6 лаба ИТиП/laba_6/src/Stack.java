import java.util.EmptyStackException;

public class Stack<T> { //класс может работать с объектами любого типа
    private T[] data; //хранения элементов стека
    private int size; //отслеживания количества элементов в стеке

    public Stack(int capacity) { //конструктор
        data = (T[]) new Object[capacity]; //принимает целое число capacity в качестве вместимости стека
        size = 0;
    }

    public void push(T element) {
        if (size == data.length) {
            throw new StackOverflowError("Стек заполнен");
        }
        data[size++] = element; //элемент добавляется в стек
    }

    public T pop() { //удаляет и возвращает верхний элемент стека
        if (size == 0) {
            throw new EmptyStackException();
        }
        T element = data[--size];
        data[size] = null; // Освобождаем ссылку
        return element;
    }

    public T peek() { //возвращает верхний элемент стека без его удаления
        if (size == 0) {
            throw new EmptyStackException();
        }
        return data[size - 1];
    }
}