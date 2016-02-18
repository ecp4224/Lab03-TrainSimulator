package com.company;

/**
 * Created by corpa on 2/9/2016.
 */
public class Queue<T> implements QueueInterface<T>{

    private T[] queue;
    private int frontIndex;
    private int backIndex;
    private int sizeOfQueue;
    private static final int DEFAULT_CAPACITY = 50;

    public Queue() {
        this(DEFAULT_CAPACITY);
    }

    public Queue(int capacity) {
        queue = (T[]) new Object[capacity+1];
        frontIndex = 0;
        backIndex = capacity;
        sizeOfQueue = 0;
    }

    @Override
    public void enqueue(T newEntry) {
        ensureCapacity();
        backIndex = (backIndex + 1) % queue.length;
        queue[backIndex] = newEntry;
        sizeOfQueue++;
    }

    @Override
    public T dequeue() {
        T front = null;
        if(!isEmpty()) {
            front = queue[frontIndex];
            queue[frontIndex] = null;
            frontIndex = (frontIndex + 1) %queue.length;
            sizeOfQueue--;
        }
        return front;
    }

    @Override
    public T getFront() {
        T front = null;
        if(!isEmpty())
            front = queue[frontIndex];
        return front;
    }

    @Override
    public boolean isEmpty() {
        return frontIndex == ((backIndex + 1) % queue.length);
    }

    @Override
    public void clear() {
        while(!isEmpty())
            dequeue();
    }

    public int getSizeOfQueue() {
        return sizeOfQueue;
    }

    private void ensureCapacity() {
        if(frontIndex == ((backIndex + 2) % queue.length)) {
            T[] oldQueue = queue;
            int oldSize = oldQueue.length;

            @SuppressWarnings("unchecked")
            T[] tempQueue = (T[]) new Object[2 * oldSize];
            queue = tempQueue;
            for(int i = 0; i <= oldSize; i++) {
                queue[i] = oldQueue[frontIndex];
                frontIndex = (frontIndex + 1) % oldSize;
            }
            frontIndex = 0;
            backIndex = oldSize -2;
        }
    }
}
