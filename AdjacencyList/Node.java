
/* Implements a node in a linked list for an adjacency list Graph. */

public class Node<T> {

  protected T data;
  protected Node<T> next;
  protected Node<T> down;

  public Node (T data) {
    this.data = data;
    this.next = null;
    this.down = null;
  }

  /* Append the tailNode to the linked list. */
  protected void appendHorizontal(Node<T> tailNode) {
    Node<T> curr = this;
    while(curr.next != null) {
      curr = curr.next;
    }

    /* Set the end node */
    curr.next = tailNode;
    return;
  }

  /* Add a new Node to the bottom of the linked list. */
  protected void appendVertical(Node<T> head) {
    Node<T> curr = this;
    while (curr.down != null) {
      curr = curr.down;
    }

    /* Set the end node */
    curr.down = head;
    return;
  }

  /* Remove the node with data and return the new head node. */
  protected Node<T> remove(Node<T> head, T data) {
    /* Deleting the first node, move the head over. */
    if (this.data == data) {
      return head.next;
    }

    /* If it's a head node */
    if (head.down == null) {
      // handle it
      // call transferDownLinks(head);
    }

    Node<T> curr = head;

    while(curr.next != null) {
      if (curr.next.data == data) {
        curr.next = curr.next.next;
        return curr;
      }
      curr = curr.next;
    }

    return head;
  }

  /* Return true if a node with data exists in the linked list
  with links that are horizontal (see diagram in Graph.java).*/
  protected boolean hasHorizontal(T data) {
    Node<T> curr = this;
    while (curr != null) {
      // System.out.println(curr.data);
      if (curr.data.equals(data)) {
        return true;
      }
      curr = curr.next;
    }
    return false;
  }

  /* Return true if a node with data exists in the linked list
  with links that are vertical (see diagram in Graph.java).*/
  protected boolean hasVertical(T data) {
    Node<T> curr = this;
    while (curr != null) {
      if (curr.data.equals(data)) {
        return true;
      }
      curr = curr.down;
    }
    return false;
  }

  /* Display the linked list. */
  protected void showTraverse() {
    Node<T> curr = this;
    System.out.print("[" + curr.data + "] -> [");
    while(curr.next != null) {
      curr = curr.next;
      System.out.print(curr.data + " ");
    }
    System.out.println("]");
  }

  /* Return the head node with data. */
  protected Node<T> getHeadNode(T data) {
    Node<T> curr = this;
    while (curr != null) {
      if (curr.data.equals(data)) {
        return curr;
      }
      curr = curr.down;
    }
    return null;
  }
}
