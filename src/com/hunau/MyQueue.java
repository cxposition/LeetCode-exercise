package com.hunau;

import java.util.Stack;

/**
 * @author cx
 * @Time 2020/4/19 22:34
 * @Description 用栈实现队列
 */
public class MyQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    /**
     * @description 将一个元素放入队列的尾部
     *
     * @param
     * @return
     */
    public void push(int x)
    {
        stack1.push(x);
    }

    /**
     * @description 从队列首部删除元素
     *
     * @param
     * @return
     */
    public int pop()
    {
        while (!stack1.isEmpty())
        {
            stack2.push(stack1.pop());
        }
        int temp = stack2.pop();
        while (!stack2.isEmpty())
        {
            stack1.push(stack2.pop());
        }
        return temp;
    }
    /**
     * @description 返回队列首部的元素
     *
     * @param
     * @return value of stack top
     */
    public int peek()
    {
        int i = 0;
        while (i < stack1.size())
        {
            stack2.push(stack1.pop());
        }
        int temp = stack2.pop();
        stack2.push(temp);
        while (!stack2.isEmpty())
        {
            stack1.push(stack2.pop());
        }
        return temp;
    }
    /**
     * @description 判断栈里的元素是否为空
     *
     * @param
     * @return true or false
     */
    public boolean empty()
    {
        return stack1.size() == 0;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}
