import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DoubleLinkedListTest {

    @Test
    void testIsEmptyFromEmptyList() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        Assertions.assertEquals(true, list.isEmpty());
    }

    @Test
    void testIsEmptyFromnotEmptyList() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("1");
        Assertions.assertEquals(false, list.isEmpty());
    }


    @Test
    void testSizeFromEmptyList() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void testSizeFromNotEmptyList() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("g");
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void testRemoveFromEmptyList() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        Assertions.assertEquals(null, list.remove(0));
    }

    @Test
    void testRemoveFromOneElemList() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("g");
        Assertions.assertEquals("g", list.remove(0));

    }

    @Test
    void testRemoveFromSeveralElemsList() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("1");
        list.add("2");
        list.remove(0);
        Assertions.assertEquals("2", list.remove(0));
    }

    @Test
    void testAddElemByIndex() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add(0, "a");
        list.add(1, "b");
        list.add(1, "c");
        list.add(2, "d");
        Assertions.assertEquals("d", list.remove(2));
        Assertions.assertEquals("c", list.remove(1));
    }

    @Test
    void testGetElemByIndex() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("a");
        list.add("b");
        list.add(0, "c");
        list.add(2, "d");
        Assertions.assertEquals("a", list.get(1));
        Assertions.assertEquals("d", list.get(2));
    }

    @Test
    void testGetFromEmptyList() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        Assertions.assertEquals(null, list.get(0));
    }

    @Test
    void testContain() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("a");
        list.add("b");
        list.add(0, "c");
        list.add(2, "d");
        Assertions.assertEquals(true, list.contains("d"));
    }
}