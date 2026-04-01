import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> MyStack;
    Queue<Integer> temp;
    public MyStack() {
        MyStack = new LinkedList<>();
        temp = new LinkedList<>();
    }
    
    public void push(int x) {
        while(!MyStack.isEmpty()){
            // add throws error and offer return specific value.
            // remove throws error while poll return null.
            // element throws error whereas peek return specific value.
            temp.add(MyStack.poll());
        }
        MyStack.add(x);
        while(!temp.isEmpty()){
            MyStack.add(temp.poll());
        }
    }
    
    public int pop() {
        return MyStack.poll();

    }
    
    public int top() {
        return MyStack.peek();
    }
    
    public boolean empty() {
        return MyStack.isEmpty();
    }
}
