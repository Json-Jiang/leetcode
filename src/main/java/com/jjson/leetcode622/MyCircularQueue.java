package com.jjson.leetcode622;

/**
 * @author jiangjunshen
 * @date 7:28 下午 2020/3/21
 */
public class MyCircularQueue {

    int[] array;

    int size;

    int head;

    int tail;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        head = 0;
        tail = 0;
        size = 0;
        array = new int[k];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (size == array.length) {
            return false;
        }
        array[tail++] = value;
        if (tail >= array.length) {
            tail = 0;
        }
        size++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (size == 0) {
            return false;
        }
        array[head++] = 0;
        if (head >= array.length) {
            head = 0;
        }
        size--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (size == 0) {
            return -1;
        }
        return array[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (size == 0) {
            return -1;
        }
        int temp = tail - 1;
        if (temp < 0) {
            temp = array.length - 1;
        }
        return array[temp];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == array.length;
    }
}
