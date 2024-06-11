package module3.c3;

public class StackImplementation {
    public static void main(String[] args) {

        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);

        System.out.println(stack.pop()); // Output: 20
        System.out.println(stack.isEmpty()); // Output: false

        stack.push(30);
        stack.pop();
        stack.pop();

        System.out.println(stack.isEmpty()); // Output: true

    }
}

