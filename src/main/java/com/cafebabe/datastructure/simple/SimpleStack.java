package com.cafebabe.datastructure.simple;

public class SimpleStack {

    private int[] data;
    private int top;

    public SimpleStack(int bound) {
        this.data = new int[bound];
        this.top = -1;
    }

    public boolean push(int node) {
        if (!isFull()) {
            top++;
            data[top] = node;
        } else {
            return false;
        }
        return true;
    }

    public int pop() {
        if (!isEmpty()) {
            int node = data[top];
            top--;
            return node;
        }
        throw new RuntimeException("栈空");
    }

    public int peek() {
        if (!isEmpty()) {
            return data[top];
        }
        throw new RuntimeException("栈空");
    }

    private boolean isFull() {
        if (top >= data.length - 1) {
            return true;
        }
        return false;
    }

    private boolean isEmpty() {
        if (-1 == top) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SimpleStack simpleStack = new SimpleStack(20);
        for (int i = 0; i < 21; i++) {
            simpleStack.push(i);
        }
        while (!simpleStack.isEmpty()) {
            System.out.println(simpleStack.pop());
        }
        System.out.println(simpleStack.pop());
    }
}
