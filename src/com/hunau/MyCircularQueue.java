package com.hunau;

/**
 * @author cx
 * @Time 2020/4/21 23:54
 * @Description java 数据结构实现循环队列
 * 这种实现方式会浪费一个存储空间，tail指向队尾元素，front指向队首
 * 元素的下一个元素 当front == tail时队列为空
 * 当（tail + 1）% maxlength == front 时队列为满
 * 取出tail元素时候要判断如果当tail元素位置在0时那么队尾元素在最后一位即 data.length - 1;
 * 如果队尾元素不在最后一位时，队尾元素的下标为 tail - 1;
 */
public class MyCircularQueue {
        /**数据*/
        private int[] data;
        /**表示队列队首，始终指向队列中的第一个元素*/
        private int front;
        /**表示队列队尾，始终指向队列中的最后一个元素的下一个位置*/
        private int tail;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            data = new int[k + 1];
            front = 0;
            tail = 0;
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {
            if (!isFull()) {
                data[tail] = value;
                tail = (tail + 1) % data.length;
                return true;
            } else {
                return false;
            }
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {
            if (!isEmpty()) {
                front = (front + 1) % data.length;
                return true;
            } else {
                return false;
            }
        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            if (!isEmpty()) {
                return data[front];
            } else {
                return -1;
            }
        }

        /**
         * Get the last item from the queue.
         */
        public int Rear() {
            if (!isEmpty()) {
                return tail == 0 ? data[data.length -1] : data[tail - 1];
            } else {
                return -1;
            }
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return tail % data.length == front % data.length;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return (tail + 1) % data.length == (front) % data.length;
        }

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3);
        System.out.println(circularQueue.enQueue(1));
        System.out.println(circularQueue.enQueue(2));

    }
}
