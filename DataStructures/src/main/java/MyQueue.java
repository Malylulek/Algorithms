import java.util.NoSuchElementException;

public class MyQueue <T>{
  private static class QueueNode<T>{
    private final T data;
    private QueueNode<T> next;
    public QueueNode(final T data) {
      this.data=data;
    }
  }

  private QueueNode<T> first;
  private QueueNode<T> last;

  public void add(T item){
    QueueNode<T> t = new QueueNode<>(item);
    if(last !=null) {
      last.next = t;
    }
      last=t;
    if(first == null) {
      first = last;
    }
  }

  public T remove() {
    if(first == null) throw new NoSuchElementException();
    T data = first.data;
    first = first.next;
    if(first == null) {
      last = null;
    }
    return data;
  }

  public T peek() {
    if (first == null) throw new NoSuchElementException();
    return first.data;
  }

  public boolean isEmpty(){
    return first == null;
  }

  public void print() {
    QueueNode<T> tmp = first;
    while(!isEmpty() && tmp != null) {
      System.out.println(tmp.data.toString());
      tmp = tmp.next;
    }
  }
}
