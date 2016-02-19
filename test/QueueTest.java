import com.company.Queue;

import static org.junit.Assert.*;

public class QueueTest {

    @org.junit.Test
    public void testEnqueue() throws Exception {
        Queue<String> queue = new Queue<>();
        queue.enqueue("a");
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");

        assertEquals("a", queue.dequeue());
    }

    @org.junit.Test
    public void testDequeue() throws Exception {
        Queue<String> queue = new Queue<>();
        queue.enqueue("a");
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");

        assertEquals("a", queue.dequeue());
        assertEquals("a", queue.dequeue());
        assertEquals("b", queue.dequeue());
        queue.enqueue("e");
        queue.enqueue("f");
        assertEquals("c", queue.dequeue());
        assertEquals("d", queue.dequeue());
        assertEquals("e", queue.dequeue());
        assertEquals("f", queue.dequeue());
    }

    @org.junit.Test
    public void testGetFront() throws Exception {
        Queue<String> queue = new Queue<>();
        queue.enqueue("a");
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");

        assertEquals("a", queue.getFront());
    }

    @org.junit.Test
    public void testIsEmpty() throws Exception {
        Queue<String> queue = new Queue<>();
        assertEquals(true, queue.isEmpty());

        queue.enqueue("a");
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");

        assertEquals(false, queue.isEmpty());

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        assertEquals(true, queue.isEmpty());
    }

    @org.junit.Test
    public void testClear() throws Exception {
        Queue<String> queue = new Queue<>();
        queue.clear();
        assertEquals(true, queue.isEmpty());

        queue.enqueue("a");
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");

        queue.clear();

        assertEquals(true, queue.isEmpty());
    }
}