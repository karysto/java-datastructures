/*
  Implements a node for a Queue.
*/

public class Node<T> {

  protected T data;
  protected Node<T> next;

  public Node(T data) {
    this.data = data;
    this.next = null;
  }

  /* Add tailNode to the end of the linked list. */
  /* Time Complexity: O(n) */
  protected void appendToTail(Node<T> tailNode) {
    Node<T> curr = this;

    while (curr.next != null) {
      curr = curr.next;
    }

    /* Set the end node */
    curr.next = tailNode;
    return;
  }

  /* Return the next node. */
  /* Time Complexity: O(1) */
  protected Node<T> resetHead() {
    return this.next;
  }
}
