import static org.junit.Assert.*;
import org.junit.*;

public class DynamicArrayTest {

  DynamicArray da;

  @Before
  public void setUp() {
    /* Create an array that doubles in size when its capacity is reached. */
    da = new DynamicArray(3, 2);
  }

  @After
  public void tearDown() {
    da = null;
  }

  @Test
  public void testDynamicArrayConstructor() {
    assertNotNull(da);
    assertEquals(da.getSize(), 0);
  }

  @Test
  public void testArrayResizesToFactor() {
    da.insert(10);
    da.insert(100);
    da.insert(1000);
    int oldCapacity = da.getCapacity();

    /* This insert will expand the array */
    da.insert(10000);
    int newCapacity = da.getCapacity();

    assertEquals(newCapacity, da.getResizeFactor() * oldCapacity);
    assertEquals(da.getCapacity(), 6);
  }

  @Test
  public void testArrayDoesNotResize() {
    da.insert(10);
    da.insert(100);
    assertEquals(da.getCapacity(), 3);
  }

  @Test
  public void testArrayDoesNotResizeTwice() {
    /* Resize the array once by overflowing it. */
    da.insert(10);
    da.insert(100);
    da.insert(1000);
    da.insert(10000);

    /* Remove elements to decrease to its previous size. */
    da.removeAtIndex(2);
    da.removeAtIndex(1);

    /* Insert again to attempt to prompt resize. */
    da.insert(1000);
    da.insert(100);

    assertEquals(da.getCapacity(), 6);
    assertEquals(da.getSize(), 4);
  }


  @Test
  public void testInsertUpdatesSize() {
    da.insert(10);
    da.insert(100);
    assertEquals(da.getSize(), 2);
    assertEquals(da.getCapacity(), 3);
  }

  @Test
  public void testInsertFirstElement() {
    da.insert(10);

    assertTrue(da.hasElement(10));
    assertEquals(da.getSize(), 1);
    assertEquals(da.getCapacity(), 3);
  }

  @Test
  public void testInsertAddsElementToArray() {
    da.insert(10);
    da.insert(100);

    assertTrue(da.hasElement(10));
    assertTrue(da.hasElement(100));
    assertEquals(da.getSize(), 2);
    assertEquals(da.getCapacity(), 3);
  }

  @Test
  public void testRemoveUpdatesSize() {
    da.insert(10);
    da.insert(100);

    da.removeAtIndex(1);
    assertEquals(da.getSize(), 1);
    assertEquals(da.getCapacity(), 3);
  }

  @Test
  public void testRemoveDeletesElementFromArray() {
    da.insert(10);
    da.insert(100);

    int elementRemoved = da.removeAtIndex(1);
    assertEquals(elementRemoved, 100);
    assertEquals(da.getSize(), 1);
    assertEquals(da.getCapacity(), 3);
    assertFalse(da.hasElement(100));
  }

  @Test
  public void testGetSizeOnSingleElementArray() {
    da.insert(10);

    assertEquals(da.getElementByIndex(da.getSize() - 1), 10);
    assertEquals(da.getElementByIndex(0), 10);
  }

  @Test
  public void testGetSizeDetectsLastElement() {
    da.insert(10);
    da.insert(100);
    da.insert(1000);
    da.insert(10000);
    da.insert(100000);

    assertEquals(da.getElementByIndex(da.getSize() - 1), 100000);
  }

  @Test
  public void testGetSizeDetectsArbitraryElement() {
    da.insert(10);
    da.insert(100);
    da.insert(1000);
    da.insert(10000);

    assertEquals(da.getElementByIndex(2), 1000);
  }

  @Test
  public void testHasElementOnNonExistingItem() {
    da.insert(10);
    da.insert(100);
    da.insert(1000);
    da.insert(10000);

    assertFalse(da.hasElement(500));
  }

  @Test
  public void testHasElementOnExistingItem() {
    da.insert(10);
    da.insert(100);
    da.insert(1000);
    da.insert(10000);

    assertTrue(da.hasElement(1000));
  }

  @Test
  public void testHasElementOnEmptyArray() {

    assertFalse(da.hasElement(1000));
  }
}
