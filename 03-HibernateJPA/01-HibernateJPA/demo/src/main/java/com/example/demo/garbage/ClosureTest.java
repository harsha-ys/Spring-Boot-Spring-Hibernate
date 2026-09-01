package com.example.demo.garbage;

import java.util.function.Supplier;

public class ClosureTest {

    public Supplier<Integer> createClosure() {
        int count = 10; // Stored on the stack
        return () -> count * 2; // Lambda object is returned and stored on the heap
    } // 'count' on the stack is DESTROYED when createClosure() finishes executing!

    public static void main(String[] args) {
        ClosureTest test = new ClosureTest();
        Supplier<Integer> closure = test.createClosure();

        Integer result = closure.get();
        System.out.println("Result from closure.get(): " + result);
    }
}
