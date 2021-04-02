import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class QueueListTest {

    @Test
    void testIsEmptyForEmptyQueue() {
        QueueList<String> queue = new QueueList<>();
        Assertions.assertEquals(true, queue.isEmpty());
    }

    @Test
    void testIsEmptyForNotEmptyQueue() {
        QueueList<String> queue = new QueueList<>();
        queue.add("g");
        Assertions.assertEquals(false, queue.isEmpty());
    }

    @Test
    void testSizeForEmptyQueue() {
        QueueList<String> queue = new QueueList<>();
        Assertions.assertEquals(0, queue.size());
    }

    @Test
    void testSizeForNotEmptyQueue() {
        QueueList<String> queue = new QueueList<>();
        queue.add("a");
        Assertions.assertEquals(1, queue.size());
    }

    @Test
    void testPeekForEmptyQueue() {
        QueueList<String> queue = new QueueList<>();
        Assertions.assertEquals(null, queue.peek());
    }

    @Test
    void testPeekForNotEmptyQueue() {
        QueueList<String> queue = new QueueList<>();
        queue.add("a");
        Assertions.assertEquals("a", queue.peek());
    }

    @Test
    void testPopForEmptyQueue() {
        QueueList<String> queue = new QueueList<>();
        Assertions.assertEquals(null, queue.pop());
    }

    @Test
    void testPopForNotEmptyQueue() {
        QueueList<String> queue = new QueueList<>();
        queue.add("a");
        Assertions.assertEquals("a", queue.pop());
    }

    @Test
    void testPopForNotEmptyQueue2() {
        QueueList<String> queue = new QueueList<>();
        queue.add("a");
        queue.add("b");
        queue.pop();
        Assertions.assertEquals("b", queue.peek());
        Assertions.assertEquals(1, queue.size());
    }

    @Test
    void testPeekForNotEmptyQueue2() {
        QueueList<String> queue = new QueueList<>();
        queue.add("a");
        queue.add("b");
        Assertions.assertEquals("a", queue.peek());
    }

    @Test
    void testAdd() {
        QueueList<String> queue = new QueueList<>();
        queue.add("a");
        queue.add("b");
        Assertions.assertEquals(2, queue.size());
        Assertions.assertEquals("a", queue.peek());
    }

}