package main.java.org.tp.implementation;

public class GenericStackUtils {

    public static <T> void invertStack(GenericStack<T> stack) {
        GenericStack<T> tempStack = new GenericStack<>();

        // Transfer all elements from the original stack to the temp stack
        while (!stack.isEmpty()) {
            tempStack.add(stack.getTop());
            stack.remove();
        }

        // Transfer all elements back from the temp stack to the original stack
        while (!tempStack.isEmpty()) {
            stack.add(tempStack.getTop());
            tempStack.remove();
        }
    }
}
