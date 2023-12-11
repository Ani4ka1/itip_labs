public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop()); // Выведет 3
        System.out.println(stack.peek()); // Выведет 2
        stack.push(4);
        System.out.println(stack.pop()); // Выведет 4
    }
}