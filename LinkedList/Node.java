public class Node {

  Node next = null;
  int data;

  public Node(int d) {
    data = d;
  }

  /* Appends newNode to the end of the linked list */
  protected void appendToTail(Node tailNode) {
    Node curr = this;

    while (curr.next != null) {
      curr = curr.next;
    }

    /* Set the end node */
    curr.next = tailNode;
    return;
  }

  protected boolean isCircular() {
    Node hopOnce  = this;
    Node hopTwice = this;

    /* Accounts for non-circular linked lists of length < 3 */
    try {
      hopTwice = hopTwice.next.next;
    } catch (NullPointerException e) { return false; }

    while (hopOnce != hopTwice) {

      /* The list has an end Node */
      if (hopTwice == null || hopOnce == null) {
        return false;
      }

      else {
        hopOnce = hopOnce.next;

        /* Account for non-circular */
        try {
          hopTwice = hopTwice.next.next;
        } catch (NullPointerException e) { return false; }

      }
    }

    return true;
  }

  /* Iterate and display the nodes of the linked list.
  Returns the number of elements in the linked list. */
  protected void traverseList() {
    Node curr = this;
    Node head = this;

    do {
      System.out.println(
        "Node: "    + curr +
        "\tValue: " + curr.data
      );
      curr = curr.next;
    /* Accounts for circular linked list traversal */
    } while (curr != null && curr != head);
    return;
  }

  /* Iterate and display the nodes of the linked list.
  Returns the number of elements in the linked list. */
  protected int getLength() {
    Node curr = this;
    Node head = this;
    int listLength = 0;

    do {
      ++listLength;
      curr = curr.next;
    /* Accounts for circular linked list traversal */
    } while (curr != null && curr != head);

    return listLength;
  }

  // Delete the node from linked list n with data
  protected Node delete(Node head, int data) {
    Node n = head;

    if(n.data == data) {
      return head.next;
    }

    while(n.next != null) {
      if(n.next.data == data) {
        n.next = n.next.next;
        return head;
      }
      n = n.next;
    }
   return head;
  }

  /* Reverse the first half of the linked list. */
  private int[] _reverseIntArray(int[] intArray) {
    int valuesMedian = (int) Math.floor(intArray.length / 2);
    for (int i = 0; i < valuesMedian; ++i) {
      intArray[i]                       ^= intArray[intArray.length - 1 - i];
      intArray[intArray.length - 1 - i] ^= intArray[i];
      intArray[i]                       ^= intArray[intArray.length - 1 - i];
    }
    return intArray;
  }

  /* Determines if the linked list's values form a palindrome */
  protected boolean isPalindrome() {
    int counter      = 0;
    Node head        = this;
    int listLength   = head.getLength();

    /* We will store the values in the first half here */
    int[] nodeValues = new int[listLength / 2];

    /* Copy the first half of the linked list into nodeValues */
    while(counter < listLength / 2 && head != null) {
      nodeValues[counter] = head.data;
      head = head.next;
      ++counter;
    }

    /* Reverse the first half's values*/
    nodeValues = _reverseIntArray(nodeValues);

    /* Skip the middle odd element to enforce a same-length
    comparison on the second half of the linked list.*/
    if (listLength % 2 != 0 && listLength > 1) {
      head = head.next;
    }

    /* Start comparing values from the second half to the reversed first half.*/
    if (counter == (listLength / 2)) {
      counter = 0;

      while(head.next != null) {
        if (head.data != nodeValues[counter]) {
          return false;
        }
        head = head.next;
        ++counter;
      }

    }
    return true;
  }

  /* Find the median element in the linked list */
  protected Node findMedianElement() {
    Node hopOnce  = this;
    Node hopTwice = this;

    while(true) {

      /* Weve reached the end of the list, hopOnce is the median. */
      if (hopTwice.next == null) {
        return hopOnce;
      }

      /* hopTwice is one Node from the end, go to the end */
      else if (hopTwice.next.next == null) {
        hopTwice = hopTwice.next;
      }

      else {
        hopOnce  = hopOnce.next;
        hopTwice = hopTwice.next.next;
      }
    }
  }

}
