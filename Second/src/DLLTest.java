import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DLLTest {

    @Test
    void testIsEmptyFromEmptyList() {
        DLL<String> list = new DLL<>();
        Assertions.assertEquals(true, list.isEmpty());
    }

    @Test
    void testIsEmptyFromnotEmptyList() {
        DLL<String> list = new DLL<>();
        list.add("1");
        Assertions.assertEquals(false, list.isEmpty());
    }


    @Test
    void testSizeFromEmptyList() {
        DLL<String> list = new DLL<>();
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void testSizeFromNotEmptyList() {
        DLL<String> list = new DLL<>();
        list.add("g");
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void testRemoveFromEmptyList() {
        DLL<String> list = new DLL<>();
        Assertions.assertEquals(null, list.remove(0));
    }

    @Test
    void testRemoveFromOneElemList() {
        DLL<String> list = new DLL<>();
        list.add("g");
        Assertions.assertEquals("g", list.remove(0));

    }

    @Test
    void testRemoveFromSeveralElemsList() {
        DLL<String> list = new DLL<>();
        list.add("1");
        list.add("2");
        list.remove(0);
        Assertions.assertEquals("2", list.remove(0));
    }

    @Test
    void testAddElemByIndex() {
        DLL<String> list = new DLL<>();
        list.add(0, "a");
        list.add(1, "b");
        list.add(1, "c");
        list.add(2, "d");
        Assertions.assertEquals("d", list.remove(2));
        Assertions.assertEquals("c", list.remove(1));
    }

    @Test
    void testGetElemByIndex() {
        DLL<String> list = new DLL<>();
        list.add("a");
        list.add("b");
        list.add(0, "c");
        list.add(2, "d");
        Assertions.assertEquals("a", list.get(1));
        Assertions.assertEquals("d", list.get(2));
    }

    @Test
    void testGetFromEmptyList() {
        DLL<String> list = new DLL<>();
        Assertions.assertEquals(null, list.get(0));
    }

    @Test
    void testContain() {
        DLL<String> list = new DLL<>();
        list.add("a");
        list.add("b");
        list.add(0, "c");
        list.add(2, "d");
        Assertions.assertEquals(true, list.contains("d"));
    }
}