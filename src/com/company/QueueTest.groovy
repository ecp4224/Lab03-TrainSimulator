package com.company

class QueueTest extends GroovyTestCase {
    void testEnqueue() {
        Queue<String> test = new Queue<>();
        test.enqueue("a");
        test.enqueue("b");
        test.enqueue("c");
        test.enqueue("d");

        assertEquals("a", test.dequeue())
    }

    void testDequeue() {
        Queue<String> test = new Queue<>();
        test.enqueue("a");
        test.enqueue("b");
        test.enqueue("c");
        test.enqueue("d");

        assertEquals("a", test.dequeue())
        assertEquals("b", test.dequeue())
        assertEquals("c", test.dequeue())
        assertEquals("d", test.dequeue())
    }

    void testGetFront() {

    }

    void testIsEmpty() {

    }

    void testClear() {

    }
}
