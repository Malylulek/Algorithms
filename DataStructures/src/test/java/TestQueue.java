public class TestQueue {
  public static void main(String [] args){
    MyQueue<String> queue = new MyQueue<>();
    queue.add("First");
    queue.add("Second");
    queue.add("Third");
    queue.add("Fourth");
    queue.add("Fifth");


    System.out.println("remove:" + queue.remove());
    System.out.println("peek:" + queue.peek());

    queue.print();

  }
}
