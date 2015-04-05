
/* Implements the Queue data structure. */

public class Queue<T> {

  private int size;
  private Node<T> head;
  private Node<T> tail;

  public Queue() {
    this.size = 0;
    this.head = null;
    this.tail = null;
  }

  /* Add the item to the top of the queue.
  Return true if the item was successfully added.*/
  protected void enqueue(T data) {

    Node<T> newTail = new Node<T>(data);

    /* Empty enqueue */
    if (this.head == null) {
      this.head = newTail;
      this.tail = this.head;
      ++this.size;
      return;
    }

    this.tail.next = newTail;
    this.tail = newTail;
    ++this.size;
    return;
  }

  /* Remove the item from the bottom of the queue.
  Return the node that was removed.*/
  protected Node<T> dequeue() {
    if (this.isEmpty()) {
      return null;
    }

    Node<T> dequeuedNode = this.head;
    this.head = this.head.resetHead();
    --this.size;
    return dequeuedNode;
  }

  protected boolean isEmpty() {
    return this.getSize() == 0;
  }

  protected void show() {
    Node<T> curr = this.head;
    while (curr != null) {
      System.out.print(curr.data + " ");
      curr = curr.next;
    }
    return;
  }

  protected int getSize() {
    return this.size;
  }

  protected Node<T> getHead() {
    return this.head;
  }

  protected Node<T> getTail() {
    return this.tail;
  }
}
