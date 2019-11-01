package com.test;

public enum StageTest {
    A {
        @Override
        public void mm() {
            System.err.println("------");
        }
    };
    public abstract void mm();
}
class TT {
    public static void main(String[] args) {
        StageTest.A.mm();
    }
}
