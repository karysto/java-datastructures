import static org.junit.Assert.*;
import org.junit.*;

public class MinHeapTest {

  MinHeap heap;

  @Before
  public void setUp() {
    heap = new MinHeap(5);
  }

  @After
  public void tearDown() {
    heap = null;
  }

  @Test
  public void testHeapInitSize() {
    assertEquals(heap.size, 0);
  }

  @Test
  public void testInsertElement() {
    heap.insert(5);

    assertEquals(heap.getMin(), 5);
  }

}