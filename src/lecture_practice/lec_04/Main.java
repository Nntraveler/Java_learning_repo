package lecture_practice.lec_04;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(4);
        System.out.println(stack.pop());
        stack.push(999);
        Stack.StackIterator it = stack.getIterator();
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        it.reset();
        System.out.println(it.next());
    }
}
